package algs.xuef201806.chap04.weighted;

import algs.base.Bag;
import algs.base.In;

/**
 * ��Ȩ����ͼ
 * @author moveb
 *
 */
public class EdgeWeightedDigraph {
	private int V; // ��������
	private int E; // �ߵ�����
	private Bag<DirectedEdge>[] adj; // �ڽӱ�
	
	// ����һ������V������Ŀ�ͼ
	public EdgeWeightedDigraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<DirectedEdge>[])new Bag[V];
		for(int v=0;v<V; v++){
			adj[v] = new Bag<DirectedEdge>();
		}
	}
	public EdgeWeightedDigraph(In in){
	}
	public int V() { return V; }
	public int E() { return E; }
	public void addEdge(DirectedEdge e){
		adj[e.from()].add(e);
		E++;
	}
	public Iterable<DirectedEdge> adj(int v){ 
		return adj[v]; 
	}
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
		for(int v=0; v<V; v++){
			for(DirectedEdge e:adj[v])
				bag.add(e);
		}
		return bag;
	}
}
