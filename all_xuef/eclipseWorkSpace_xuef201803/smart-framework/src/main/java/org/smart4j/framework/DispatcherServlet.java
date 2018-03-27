package org.smart4j.framework;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.Request;
import org.smart4j.framework.bean.View;
import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.framework.utils.CodecUtil;
import org.smart4j.framework.utils.ConfigHelper;
import org.smart4j.framework.utils.JsonUtil;
import org.smart4j.framework.utils.ReflectionUtil;
import org.smart4j.framework.utils.StreamUtil;

/**
 * ����ת����
 * @author moveb
 *
 */
// ͨ��ע������ ��Ŀ����ʱ������; ������������ ??? ע����Ч
@WebServlet(urlPatterns="/*", loadOnStartup=0)
public class DispatcherServlet extends HttpServlet {
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("DispatcherServlet init...");
		// ��ʼ����� Helper ��
		HelperLoader.init();
		// ��ȡ ServletContext ��������ע�� Servlet��
		ServletContext servletContext = servletConfig.getServletContext();
		// ע�ᴦ��JSP��Servlet
		ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
		jspServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
		
		// ע�ᴦ����̬��Դ��Ĭ�� Servlet
		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
		defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ���󷽷�������·��
		String requestMethod = request.getMethod().toLowerCase();
		String requestPath = request.getPathInfo();
		// ��ȡ Action ������
		Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
		if(handler != null){
			// ��ȡ Controller �༰�� Bean ʵ��
			Class<?> controllerClass = handler.getControllerClass();
			Object controllerBean = BeanHelper.getBean(controllerClass);
			// ���������������
			Map<String, Object> paramMap = new HashMap<String, Object>();
			Enumeration<String> paramNames = request.getParameterNames();
			while(paramNames.hasMoreElements()){
				String paramName = paramNames.nextElement();
				String paramValue = request.getParameter(paramName);
				System.out.println("paramName: paramVal--" + paramName + paramValue);
				paramMap.put(paramName, paramValue);
			}
			String body = CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
			System.out.println("inputstream body string: " + body);
			if(!body.isEmpty()){
				String[] params = body.split("&");
				if(ArrayUtils.isNotEmpty(params)){
					for(String param:params){
						String[] array = param.split("=");
						if(ArrayUtils.isNotEmpty(array) && array.length==2){
							String paramName = array[0];
							String paramValue = array[1];
							paramMap.put(paramName, paramValue);
						}
					}
				}
				
			}
			Param param = new Param(paramMap);
			// ����Action����
			Method actionMethod = handler.getActionMethod();
			Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
			// ����Action ��������ֵ
			if(result instanceof View){
				// ���� JSP ҳ��
				View view = (View)result;
				String path = view.getPath();
				if(!path.isEmpty()){
					if(path.startsWith("/")){
						response.sendRedirect(request.getContextPath() + path);
					} else{
						Map<String, Object> model = view.getModel();
						// ת��ʱ�������ݷŵ� request ��
						for(Map.Entry<String, Object> entry:model.entrySet()){
							request.setAttribute(entry.getKey(), entry.getValue());
						}
						System.out.println("forward path: " + ConfigHelper.getJspPath() + path);
						// ת���� ָ��ҳ��(jsp)
						request.getRequestDispatcher(ConfigHelper.getJspPath() + path).
											forward(request, response);
					}
				}else if(result instanceof Data){
					// ���� JSON ����; ֱ����ͻ��� write ������;
					Data data = (Data)result;
					Object model = data.getModel();
					if(model != null){
						response.setContentType("application/json");
						response.setCharacterEncoding("UTF-8");
						PrintWriter writer = response.getWriter();
						String json = JsonUtil.toJson(model);
						writer.write(json);
						writer.flush();
						writer.close();
					}
				}
			}
		}
	}
}