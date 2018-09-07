package algs.xuef201806.chap02.sort;

import algs.base.StdDraw;

public class HeapSort {
	public static void sort(Comparable[] a){
		// �����ʼ��
		setXY();
		// a[0]��ʹ��,����N = a.length-1
		int N = a.length-1;
		// �����
		for(int k=N/2; k>=1; k--){
			sink(a, k, N);
		}
		/**
		 * ���ѵ����Ԫ��a[1]���βԪ��a[N]����;
		 * sink(1) �Եõ������;
		 */
		while(N>=1){
			exch(a, 1, N--);
			sink(a, 1, N);
		}
		// ��ʱ, a[1]~a[N] �������;(����)
	}
	// ��ʼ������
	public static void setXY(){
		int N = 100;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N);
		StdDraw.setPenRadius(.01);
		StdDraw.setPenColor(StdDraw.GRAY);
	}
	static void sink(Comparable[] pq, int i, int N){
		
		while(i*2 <= N){
			// �ҳ�i�����������������Ǹ�
			int j = i*2;
			if(j<N && less(pq[j], pq[j+1])) j++;
			// ���pq[i]���������Ӷ���,����ѭ��
			if(!less(pq[i], pq[j])) break;
			exch(pq, i, j);
			//???
			draw(pq, i, i, j);
			i = j;
		}
		draw(pq);
	}
	static void swim(Comparable[] pq, int i, int N){
		while(i/2 > 0 && less(pq[i/2], i)){ // ����ȸ��ڵ�󣬾��ϸ�
			exch(pq, i/2, i);
			i = i/2;
		}
	}
	
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	// ���� a[i] a[j]
	public static void exch(Comparable[] a, int i, int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		// ��ɫ��Ԫ�����ڽ��н���
		//draw(a, i, i, j);
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
		/**
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
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
