package algs.xuef201806.chap02.sort;

import algs.base.StdDraw;
import algs.base.StdOut;

public class SortBase {

	public static void sort(Comparable[] a){}
	// �Ƚ�����Ԫ�صĴ�С���Ƿ� v < w
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	// ���� a[i] a[j]
	public static void exch(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		// ��ɫԪ��Ϊ���ڽ�����Ԫ��
		draw(a, j, i, j);
	}
	
	public static void show(Comparable[] a){
		for(Comparable c : a){
			StdOut.print(c + ", ");
		}
	}
	/**
	 * @param a
	 * @param sink �����³���Ԫ��
	 * @param swapA �ڽ�����Ԫ��
	 * @param swapB
	 */
	public static void draw(Comparable[] a, int sink, int swapA, int swapB){
		StdDraw.clear();
		
		int N = a.length;
		for(int i=0; i<N; i++){
			StdDraw.setPenColor(StdDraw.GRAY);
			if(i == swapA || i == swapB) StdDraw.setPenColor(StdDraw.BLACK);
			if(i == sink) StdDraw.setPenColor(StdDraw.RED);
			double x = 2.0*i;
			double y = (Integer)a[i]/2.0;
			double rw = 8.0/N;
			double rh = (Integer)a[i]/2.0;
			
			StdDraw.filledRectangle(x, y, rw, rh);
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void draw(Comparable[] a, int swapA, int swapB){
		StdDraw.clear();
		
		int N = a.length;
		for(int i=0; i<N; i++){
			StdDraw.setPenColor(StdDraw.GRAY);
			if(i == swapA || i == swapB) StdDraw.setPenColor(StdDraw.BLACK);
			
			double x = 2.0*i;
			double y = (Integer)a[i]/2.0;
			double rw = 8.0/N;
			double rh = (Integer)a[i]/2.0;
			
			StdDraw.filledRectangle(x, y, rw, rh);
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void draw(Comparable[] a, int tar){
		StdDraw.clear();
		
		int N = a.length;
		for(int i=0; i<N; i++){
			StdDraw.setPenColor(StdDraw.GRAY);
			if(i == tar) StdDraw.setPenColor(StdDraw.RED);
			
			double x = 2.0*i;
			double y = (Integer)a[i]/2.0;
			double rw = 8.0/N;
			double rh = (Integer)a[i]/2.0;
			
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
	
	public static void draw(Comparable[] a){
		StdDraw.clear();
		
		int N = a.length;
		for(int i=0; i<N; i++){
			StdDraw.setPenColor(StdDraw.GRAY);
			//if(i == tar) StdDraw.setPenColor(StdDraw.RED);
			
			double x = 2.0*i;
			double y = (Integer)a[i]/2.0;
			double rw = 8.0/N;
			double rh = (Integer)a[i]/2.0;
			
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
}
