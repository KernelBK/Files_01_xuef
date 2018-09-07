package algs.xuef201806.chap02.sort;

import algs.base.StdDraw;

/**
 * �Զ����µĹ鲢����
 * �鲢����������ݹ�˼��ͷ���˼����а���
 * 
 * �Ľ���
 * 1. ʹ�ò���������С��ģ�������飨���糤��С��15��,
 * 	     һ���ܹ����鲢���������ʱ������10%-15%
 * 2. ���������Ƿ�����
 * 	  ���ǿ������һ���ж�����,���a[mid]С��a[mid+1],��ô˵�������Ѿ���������merge������
 * 
 * @author moveb
 *
 */
public class Merge extends SortBase {
	// �鲢����ĸ�������
	private static Comparable[] aux;
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	public static void sort(Comparable[] a, int lo, int hi){
		setXY();
		
		// ��Ԫ���������
		if(lo >= hi) return;
		int mid = lo + (hi-lo)/2;
		// ��������
		sort(a, lo, mid);
		// �����Ұ��
		sort(a, mid+1, hi);
		// �鲢
		merge(a, lo, mid, hi);
		draw(a);
	}
	/**
	 * ����midΪ��(���Ұ�߶��Ƿֱ������)������a����ԭ�ع鲢
	 * mid: ����β��Ԫ�ص��±�
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi){
		int i = lo, j = mid + 1;
		// ??? a.clone()��������ʲô
		// �������� 
		// Comparable[] aux = a.clone();
		
		for(int k=lo; k<=hi; k++){
			aux[k] = a[k];
		}
		
		/**
		 * ���ߣ��Ұ�߸�һ��ָ�룻����ɨ��
		 */
		for(int k=lo; k<=hi; k++){
			if(i > mid)  		// �����þ�
				a[k] = aux[j++];
			else if(j > hi)		// �Ұ���þ�
				a[k] = aux[i++];
			else if(less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
	/**
	 * ����
	 * ��Ϊ��˵����ε��� merge
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] a = new Integer[]{1,3,7,18, 2, 4, 5, 6, 15};
		merge(a, 0, 3, a.length-1);
		show(a);
	}
	
	public static void setXY(){
		int N = 100;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N);
		StdDraw.setPenRadius(.01);
		StdDraw.setPenColor(StdDraw.GRAY);
	}
}
