package algs.xuef201806.chap03;

import algs.base.SequentialSearchST;

/**
 * �㷨3.5 ������������ɢ�б�
 * ���������ˡ�c����������ԡ��е� �ַ�������
 * @author moveb
 *
 */
public class SeparateChainingHashST<Key, Value> {
	private int N; // ��ֵ������
	private int M; // ɢ�б�Ĵ�С
	private SequentialSearchST<Key, Value>[] st; // ���������������
	public SeparateChainingHashST(){
		
	}
	public SeparateChainingHashST(int M){
		// ���� M ������
		this.M = M;
		st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
		// ��ʼ��ÿ������
		for(int i=0; i<M; i++){
			st[i] = new SequentialSearchST();
		}
	}
	
	private int hash(Key key){
		return (key.hashCode() &0x7fffffff) % M;
	}
	public Value get(Key key){
		return (Value)st[hash(key)].get(key);
	}
	public void put(Key k, Value v){
		st[hash(k)].put(k, v);
	}
	// TODO
	public Iterable<Key> keys(){
		return null;
	}
}
