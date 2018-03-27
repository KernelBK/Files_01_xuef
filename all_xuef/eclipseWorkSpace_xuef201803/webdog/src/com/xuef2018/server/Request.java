package com.xuef2018.server;

import java.io.IOException;
import java.io.InputStream;
/**
 * ��ʾһ�� HTTP����
 * @author moveb
 *
 */
public class Request {
	// ��һ�룬������α�ʾһ���������
	private InputStream input;
	private String uri;
	
	public Request(InputStream inputStream) {
		this.input = inputStream;
	}

	// ���� HTTP �����е�ԭʼ����
	/**
	 * Ϊ����parse()����ι����ģ�������Ҫ��HTTP����Ľṹ�Ƚ��˽⡣
	 */
	public void parse() {
		// read a set of characters from the socket
		StringBuffer request = new StringBuffer();
		byte[] buffer = new byte[2048];
		int i;
		try{
			i = input.read(buffer);
		}catch(IOException e){
			e.printStackTrace();
			i = -1;
		}
		for(int j=0; j<i; j++){
			request.append((char)buffer[j]);
		}
		
		uri = parseUri(request.toString());
		System.out.println("------Uri�� " + uri);
	}
	/**
	 * GET /index.html HTTP/1.1 ===> һ��������
	 * ���������н����� URI--->/index.html
	 * @param requestString
	 * @return
	 */
	private String parseUri(String requestString){
		int index1, index2;
		index1 = requestString.indexOf(' ');
		System.out.println("index1: " + index1);
		if(index1 != -1){
			index2 = requestString.indexOf(' ', index1 + 1);
			System.out.println("index2: " + index2);
			if(index2 > index1){
				return requestString.substring(index1 + 1, index2);
			}
		}
		return null;
	}
	public String getUri() {
		return this.uri;
	}

}