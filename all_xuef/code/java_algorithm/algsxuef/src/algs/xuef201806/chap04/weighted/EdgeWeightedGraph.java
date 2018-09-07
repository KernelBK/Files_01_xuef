package algs.xuef201806.chap04.weighted;

import algs.base.Bag;
import algs.base.In;

public class EdgeWeightedGraph {
	private int V; // ��������
	private int E; // �ߵ�����
	private Bag<Edge>[] adj; // �ڽӱ�
	
	// ����һ������V������Ŀ�ͼ
	public EdgeWeightedGraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[])new Bag[V];
		for(int v=0;v<V; v++){
			adj[v] = new Bag<Edge>();
		}
	}
	public EdgeWeightedGraph(In in){
		this(in.readInt()); // ��ȡ V ����ͼ��ʼ��
		int E = in.readInt(); // ��ȡ E
		for(int i=0; i<E; i++){
			// ���һ����
			int v = in.readInt();
			int w = in.readInt();
			double weight = in.readDouble();
			addEdge(new Edge(v, w, weight));
		}
	}
	public int V() { return V; }
	public int E() { return E; }
	public void addEdge(Edge e){
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public Iterable<Edge> adj(int v){ 
		return adj[v]; 
	}
	public Iterable<Edge> edges(){
		return null;
	}
}
