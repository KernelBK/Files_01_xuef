package com.xuef2018.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 * ��ʾһ�� HTTP��Ӧ
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
	Request request; // һ����ϣ�Ϊ�˴����õ� Uri,��ȷ���ͻ����������Դ·��
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
			// ����������Դ����,�Ͷ�ȡȻ����ͻ���д��(��̬��Դ��Ϊԭʼ���ݷ��͵��ͻ���--���������)
			if (file.exists()) {
				System.out.println("�ļ�����");
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