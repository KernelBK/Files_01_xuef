package com.xuef201803.book_dp.factoryMethod;

public class ExportTxtFile implements ExportFileApi {

	@Override
	public boolean export(String data) {
		System.out.println("��������" + data + "���ı��ļ�");
		return true;
	}

}
