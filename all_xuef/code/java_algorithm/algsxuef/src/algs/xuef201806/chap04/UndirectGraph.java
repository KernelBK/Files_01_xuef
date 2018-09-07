package algs.xuef201806.chap04;

import algs.base.In;
import algs.xuef201806.chap01.Bag;

/**
 * �ڽӾ����ʾ������ͼ
 * @author moveb
 *
 */
public class UndirectGraph {
	private int V; // ������Ŀ
	private int E; // �ߵ���Ŀ
	private Bag<Integer>[] adj; // �ڽӱ�
	
	public UndirectGraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V]; // �����ڽӱ�
		// �����������ʼ��
		for(int v=0; v<V; v++){
			adj[v] = new Bag<Integer>();
		}
	}
	public UndirectGraph(In in){
		this(in.readInt()); // ��ȡ V ����ͼ��ʼ��
		int E = in.readInt(); // ��ȡ E
		for(int i=0; i<E; i++){
			// ���һ����
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	public UndirectGraph(In in, int V, int E){
		this(V); // ��ȡ V ����ͼ��ʼ��
		for(int i=0; i<E; i++){
			// ���һ����
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
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
		adj[w].add(v);
		E++;
	}
	/**
	 * ���ؽڵ�v���������ڽڵ�
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
}
