package algs.xuef201806.chap02.sort;

import algs.base.StdOut;
import algs.base.StdRandom;

public class TestHeapSort {
	public static void main(String[] args) {
		Integer[] a = new Integer[50];
		a[0] = 0; // ��ʹ��a[0]
		for(int i=1; i<a.length; i++){
			a[i] = StdRandom.uniform(100);
		}
		SortBase.show(a);
		//Insertion.sort(a);
		//Merge.sort(a);
		// ��a[1..50]����
		HeapSort.sort(a);
		StdOut.println("\n-----------------------");
		SortBase.show(a);
	}
}
