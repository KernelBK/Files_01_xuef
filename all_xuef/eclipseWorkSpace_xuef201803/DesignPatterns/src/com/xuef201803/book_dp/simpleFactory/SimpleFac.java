package com.xuef201803.book_dp.simpleFactory;

public class SimpleFac {
	public static Api getInstance(int flag){
		/**
		 * ���������Լ����������ֻ�Ǹ�����������ѡ��
		 * ��Ȼ�Ǹ����������߲�����ѡ��
		 * ������Դ�ڣ�
		 * 1. �ͻ���
		 * 2. �����ļ�
		 * 3. ���������ڵ�ĳ��ֵ������ӻ����л�ȡĳ��ֵ��
		 */
		if(1==flag){ // ����������Ǳ�¶�˹����Ĳ����ڲ�ϸ��
			return new ApiImplA();
		}else if(2==flag){
			return new ApiImplB();
		}
		// ȱ�㣺�������һ��ʵ���࣬����Ĵ�����Ҫ�Ķ���
		else{
			return null;
		}
	}
}
