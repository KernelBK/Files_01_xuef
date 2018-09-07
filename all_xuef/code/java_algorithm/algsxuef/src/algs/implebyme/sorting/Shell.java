package algs.implebyme.sorting;

import algs.base.StdRandom;

public class Shell extends Sort {
	//��������
	public static void sort(Comparable[] a){
		int N = a.length;
		int h = 1;
		while(h < N/3) h = h*3 + 1;// 1 4 13 40 ...
		while(h>=1){
			//�������Ϊh����
			for(int i=h; i<N; i++){
				//a[i] ��ΪĩԪ�ص�һ��h�������(... a[i-2h] a[i-h] a[i])
				for(int j=i; j>=h && less(a[j], a[j-h]); j-=h)
					exch(a, j, j-h);
			}
			h /= 3;
		}
	}
	public static void main(String[] args) {
		Double[] arr= new Double[300];
		for(int i=0; i<300; i++){
			arr[i]=StdRandom.uniform(50.0,800.0);
		}
		sort(arr);
		show(arr);
	}
}
