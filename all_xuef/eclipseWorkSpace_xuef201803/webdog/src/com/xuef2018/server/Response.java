package com.xuef2018.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 * 表示一个 HTTP响应
	HTTP Response = Status-Line
	(( general-header | response-header | entity-header ) CRLF)
	CRLF
	[ message-body ]
	Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
 * @author moveb
 *
 */
public class Response {
	private static final int BUFFER_SIZE = 1024;
	Request request; // 一种组合；为了从中拿到 Uri,以确定客户端请求的资源路径
	OutputStream output;
	
	public Response(OutputStream outputStream) {
		this.output = outputStream;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public void sendStaticResource() throws IOException {
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			System.out.println("--------------HttpServer.WEB_ROOT " + HttpServer.WEB_ROOT);
			File file = new File(HttpServer.WEB_ROOT, request.getUri());
			// 如果请求的资源存在,就读取然后向客户端写。(静态资源作为原始数据发送到客户端--浏览器可能)
			if (file.exists()) {
				System.out.println("文件存在");
				fis = new FileInputStream(file);
				int ch = fis.read(bytes, 0, BUFFER_SIZE);
				while (ch!=-1) {
					output.write(bytes, 0, ch);
					ch = fis.read(bytes, 0, BUFFER_SIZE);
				}
				output.flush();
			}
			else {
				// file not found
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
										"Content-Type: text/html\r\n" +
										"Content-Length: 23\r\n" +
										"\r\n" +
										"<h1>File Not Found</h1>";
				output.write(errorMessage.getBytes());
			}
		} catch (Exception e) {
			// thrown if cannot instantiate a File object
			System.out.println(e.toString() );
		}
		finally {
			output.close();
			if (fis!=null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
}
