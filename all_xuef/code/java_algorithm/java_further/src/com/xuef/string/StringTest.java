package com.xuef.string;
/**
 * �ַ�����ά����һ���ַ���������
 * 
 * 
 * 
 * 
 * @author moveb
 *
 */
public class StringTest {

	public static void main(String[] args) {
		// s1�õ���ֱ������������ַ new String("hello").intern()
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s1 == s2); // true
		// �����ڻ��ڶ��д���һ���ַ������󣬶��ַ��������������ַ����������У�
		// s3����ջ�У���ֵ�Ƕ����ַ�����������ã�== �Ƚϵ��Ƕ��еĵ�ַ��equals�Ƚϵ���������
		String s3 = new String("world");
		String s4 = new String("world");
		System.out.println(s3 == s4); // �Ƚ϶��е����� 
		System.out.println(s3.equals(s4)); // �Ƚ�������
	}
}
