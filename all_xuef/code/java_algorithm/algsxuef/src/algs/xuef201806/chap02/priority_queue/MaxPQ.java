package algs.xuef201806.chap02.priority_queue;

import algs.xuef201806.chap02.sort.SortBase;

/**
 * ������ȫ�����������ȶ���
 * @author moveb 
 * 20180609
 *
 */
public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;// pq[1..N]�洢Ԫ��
	private int N;   //Ԫ�ظ���(ͬʱҲ��βԪ���±�)
	// ����һ���������Ϊ max �����ȶ���
	public MaxPQ(int max){
		pq = (Key[]) new Comparable[max+1];
		N = 0;
	}
	/**
	 * ����Ԫ��
	 * @param v
	 */
	public void insert(Key v){
		N++;
		// TODO ����Խ����
		// ����Ԫ�ط��ڶ���ĩβ
		pq[N] = v;
		// �ϸ�
		swim(N);
	}
	/**
	 * ɾ�����������Ԫ��
	 * @return
	 */
	public Key deleteMax(){
		Key max = pq[1];
		pq[1] = pq[N];
		pq[N] = null;
		N--;
		sink(1);
		return max;
	}
	void sink(int i){
		while(i*2 <= N){
			// �ҳ�i�����������������Ǹ�
			int j = i*2;
			if(j<N && SortBase.less(pq[j], pq[j+1])) j++;
			// ���pq[i]���������Ӷ���,����ѭ��
			if(!SortBase.less(pq[i], pq[j])) break;
			SortBase.exch(pq, i, j);
			i = j;
		}
	}
	void swim(int i){
		while(i/2 > 0 && SortBase.less(pq[i/2], i)){ // ����ȸ��ڵ�󣬾��ϸ�
			SortBase.exch(pq, i/2, i);
			i = i/2;
		}
	}
}
