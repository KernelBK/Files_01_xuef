package algs.xuef201806.chap02.sort;

import algs.base.StdDraw;

/**
 * ��������
 * ���ڲ�������������ر���Ч
 * 1. ������ÿ��Ԫ�ؾ�����������λ�ö���Զ
 * 2. һ������Ĵ������һ��С����
 * 3. ������ֻ�м���Ԫ�ص�λ�ò���ȷ
 * 
 * �Ľ���
 * Ҫ�����߲���������ٶȲ����ѣ�ֻ��Ҫ����ѭ���н��ϴ��Ԫ��
 * �������ƶ����������ǽ�������Ԫ�أ�������������Ĵ������ܼ��룩
 * �μ���ϰ 2.1.25
 * @author moveb
 *
 */
public class Insertion extends SortBase {
	public static void sort(Comparable[] a){
		setXY();
		
		int N = a.length;
		// ����Ҫɨ�������� a
		for(int i=0; i<N; i++){
			// ��a[i]���뵽 a[0]...a[i-1],���մ�С����
			for(int j=i; j>0 && less(a[j], a[j-1]); j--){
				// ���a[j]С��a[j-1],��������
				exch(a, j, j-1);
				//draw(a, j);
			}
		}
	}
	public static void sort_better(Comparable[] a){
		setXY();
		
		int N = a.length;
		// ����Ҫɨ�������� a
		for(int i=0; i<N; i++){
			// ��a[i]���뵽 a[0]...a[i-1],���մ�С����
			Comparable t = a[i];
			int j=i;
			for(; j>0 && less(t, a[j-1]); j--){
				// ���a[j-1]��a[j]�����a[j-1] ����
				
				a[j] = a[j-1];
			}
			// �ҵ���t�ĺ���λ��
			a[j] = t;
			//draw(a, j);
		}
	}
	
	// ��ʼ������
	public static void setXY(){
		int N = 100;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N);
		StdDraw.setPenRadius(.01);
		StdDraw.setPenColor(StdDraw.GRAY);
	}
}
