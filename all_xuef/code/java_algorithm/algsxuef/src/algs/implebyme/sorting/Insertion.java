package algs.implebyme.sorting;

import algs.base.StdDraw;
import algs.base.StdRandom;

// ��������Բ���������������Ч
public class Insertion extends Sort{
	//��������
	public static void sort(Comparable[] a){
		
		int N = a.length;
		for(int i=1; i < N; i++)
		{
			//��a[i]���뵽ǰ���Ԫ��֮��
			for(int j = i; j>0 && (less(a[j], a[j-1])); j--){ //once a[j]<a[j-1] ѭ��ֹͣ
				draw(a, j);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				exch(a, j, j-1);
				draw(a, j);
			}
		}
	}
	
	public static void main(String[] args)
	{ // Read strings from standard input, sort them, and print.
		/*
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
		*/
		//Integer[] a={45, 56, 23, 12, 60, 8, 35, 29, 88, 78, 18, 125, 270, 52, 66, 196, 70, 95, 210};
		//sort(a);
		Double[] arr= new Double[30];
		for(int i=0; i<30; i++){
			arr[i]=StdRandom.uniform(10.0,300.0);
		}
		sort(arr);
	}
}
