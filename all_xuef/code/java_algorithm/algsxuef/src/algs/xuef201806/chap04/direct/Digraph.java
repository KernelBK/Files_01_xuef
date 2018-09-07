package algs.xuef201806.chap04.direct;

import algs.base.In;
import algs.xuef201806.chap01.Bag;

/**
 * ����ͼ
 * @author moveb
 *
 */
public class Digraph {
	private int V; // ������Ŀ
	private int E; // �ߵ���Ŀ
	private Bag<Integer>[] adj; // �ڽӱ�
	
	public Digraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V]; // �����ڽӱ�
		// �����������ʼ��
		for(int v=0; v<V; v++){
			adj[v] = new Bag<Integer>();
		}
	}

	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	public void addEdge(int v, int w){
		adj[v].add(w);
		E++;
	}
	/**
	 * ����vָ���ı������ӵ����ж���
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public Digraph reverse(){
		Digraph R = new Digraph(V);
		for(int v=0; v<V; v++){
			for(int w:adj[v]){
				R.addEdge(w, v);
			}
		}
		return R;
	}
}
