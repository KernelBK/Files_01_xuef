package com.xuef.effectiveJava.concurrency;

import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		ObservableSet<Integer> set = 
				new ObservableSet<>(new HashSet<Integer>());
		set.addOberver(new SetObserver<Integer>(){
			public void added(ObservableSet<Integer> s, Integer e){
				System.out.println(e);
				/**
				 * ��ͼ�ڱ����б�Ĺ����У���һ��Ԫ�ش��б���ɾ�������ǷǷ��ģ�
				 */
				if(e == 23){
					s.rmObserver(this);
				}
			}
		});
		
		for(int i=0; i<100; i++){
			set.add(i);
		}
	}
}
