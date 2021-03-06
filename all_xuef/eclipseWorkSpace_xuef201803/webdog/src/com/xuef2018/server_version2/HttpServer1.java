package com.xuef2018.server_version2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer1 {
	//shutdown command
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	// the shutdown command recieved
	private boolean shutdown = false;
	
	public static void main(String[] args) {
		HttpServer1 server = new HttpServer1();
		server.await();
	}
	public void await(){
		ServerSocket serverSocket = null;
		int port = 8080;
		try{
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("localhost"));
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		// looping waiting for a request
		while(!shutdown){
			Socket socket = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			try{
				socket = serverSocket.accept();
				inputStream = socket.getInputStream();
				outputStream = socket.getOutputStream();
				// Create Request object and parse
				Request1 request = new Request1(inputStream);
				request.parse();
				
				// Create Response object
				Response1 response = new Response1(outputStream);
				response.setRequest(request);
				System.out.println("********"+request.getUri());
				// check if this is a request for a servlet or
				// a static resource
				// a request for a servlet begins with "/servlet/"
				if (request.getUri().startsWith("/servlet/")) {
					// 如果请求的是 servlet, 交给 Servlet处理器处理
					System.out.println("交给 Servlet处理器处理");
					ServletProcessor1 processor = new ServletProcessor1();
					processor.process(request, response);
				}
				else {
					// 如果请求的是静态资源, 交给静态资源处理器去处理
					System.out.println("交给静态资源处理器去处理");
					StaticResoureProcessor processor = new StaticResoureProcessor();
					processor.process(request, response);
				}
				
				// Close the socket
				socket.close();
				
				//check if the prevoius URI is a shutdown command
				shutdown = SHUTDOWN_COMMAND.equals(request.getUri());
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
		}
	}
}
