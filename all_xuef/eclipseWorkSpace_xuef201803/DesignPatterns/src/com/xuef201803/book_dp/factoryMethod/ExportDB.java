package com.xuef201803.book_dp.factoryMethod;

public class ExportDB implements ExportFileApi {

	@Override
	public boolean export(String data) {
		System.out.println("��������" + data + "�����ݿⱸ���ļ�");
		return true;
	}

}
