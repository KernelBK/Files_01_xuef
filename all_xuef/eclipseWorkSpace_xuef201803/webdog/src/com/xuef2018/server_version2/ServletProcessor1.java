package com.xuef2018.server_version2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletProcessor1 {

	public void process(Request1 request, Response1 response) {
		String uri = request.getUri(); // /servlet/servletName
		String servletName = uri.substring(uri.lastIndexOf("/") + 1);
		System.out.println("++++++++++servletname: " + servletName);
		URLClassLoader loader = null;
		try {
			// create a URLClassLoader
			URL[] urls = new URL[1];
			URLStreamHandler streamHandler = null;
			System.out.println("Constants.WEB_ROOT: " + Constants.WEB_ROOT);
			File classPath = new File(Constants.WEB_ROOT);
			
			// the forming of repository is taken from the
			// createClassLoader method in
			// org.apache.catalina.startup.ClassLoaderFactory
			String repository = (new URL("file", null, 
					classPath.getCanonicalPath() + File.separator)).toString() ;
			// the code for forming the URL is taken from
			// the addRepository method in
			// org.apache.catalina.loader.StandardClassLoader.
			System.out.println("repository: " + repository);
			urls[0] = new URL(null, repository, streamHandler);
			loader = new URLClassLoader(urls);
		} catch (IOException e) {
			System.out.println(e.toString() );
		}
		Class myClass = null;
		try {
			myClass = loader.loadClass(servletName);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		Servlet servlet = null;
		try {
			servlet = (Servlet) myClass.newInstance();
			//System.out.println("sevlet " + servlet.getClass().getName());
			servlet.service((ServletRequest) request, (ServletResponse) response);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		catch (Throwable e) {
			System.out.println(e.toString());
		}
	}
}
