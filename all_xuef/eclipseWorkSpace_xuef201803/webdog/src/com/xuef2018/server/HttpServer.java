package com.xuef2018.server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	/**
	 * WEB_ROOT 是我们的HTML和其他文件存放的目录； 
	 */
	public static final String WEB_ROOT = 
			System.getProperty("user.dir") + File.separator + "webroot";
	//shutdown command
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	// the shutdown command recieved
	private boolean shutdown = false;
	
	public static void main(String[] args) {
		HttpServer server = new HttpServer();
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
				Request request = new Request(inputStream);
				request.parse();
				
				// Create Response object
				Response response = new Response(outputStream);
				response.setRequest(request);
				response.sendStaticResource();
				
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






