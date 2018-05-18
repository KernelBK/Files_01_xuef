package com.xuef201803.book_dp.factoryMethod;
/**
 * ʵ�ֵ������ݵ�ҵ���ܶ���
 * @author moveb
 *
 */
public abstract class ExportOperate {
	/**
	 * ʹ�ò�Ʒ������ʵ�ֵ�������
	 * @param data
	 * @return
	 */
	public boolean export(String data){
		// api �ɾ�����������ṩ(ͨ����������)
		ExportFileApi api = factoryMethod();
		
		return api.export(data);
	}

	/**
	 * ��������Ϊ�����ṩ�˹ҹ�
	 * �������Լ����������һ��ע������;��
	 * @return
	 */
	protected abstract ExportFileApi factoryMethod();
}
