import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrimitiveServlet implements Servlet {
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}
	public void service(ServletRequest request, ServletResponse response)
				throws ServletException, IOException {
		System.out.println("from service");
		System.out.println("responseName"+response.getClass().getName());
		PrintWriter out = response.getWriter();
		out.println("HTTP/1.1 200 OK\n");
		//out.println("Content-Type: text/html\n");
		out.println("Hello. Roses are red.");
		out.print("Violets are blue.");
		System.out.println("out print done..........");
	}
	public void destroy() {
		System.out.println("destroy");
	}
	public String getServletInfo() {
		return null;
	}
	
	public ServletConfig getServletConfig() {
		return null;
	}
}
