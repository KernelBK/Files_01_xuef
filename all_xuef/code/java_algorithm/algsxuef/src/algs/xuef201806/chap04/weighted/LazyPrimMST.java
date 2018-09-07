package algs.xuef201806.chap04.weighted;

import algs.base.priorityQueue.MinPQ;
import algs.xuef201806.chap01.Queue;

/**
 * ��С�������� Prim �㷨����ʱʵ��
 * @author moveb
 *
 */
public class LazyPrimMST {
	private boolean[] marked; // MST vertices
	private Queue<Edge> mst; // MST edges
	private MinPQ<Edge> pq; // ���б�(����ʧЧ��)
	
	public LazyPrimMST(EdgeWeightedGraph G){
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		visit(G, 0); // assumes G is connected (see Exercise 4.3.22)
		while (!pq.isEmpty())
		{
			Edge e = pq.delMin(); // Get lowest-weight
			int v = e.either(), w = e.other(v); // edge from pq.
			if (marked[v] && marked[w]) // ����ʧЧ�ı�
				continue;
			mst.enqueue(e); // Add edge to tree.
			if (!marked[v]) 
				visit(G, v); // Add vertex to tree
			if (!marked[w]) 
				visit(G, w); // (either v or w).
		}
	}
	private void visit(EdgeWeightedGraph G, int v){ 
		// ��Ƕ���v, ������������v��δ��Ƕ���ı߼���pq
		marked[v] = true;
		for (Edge e : G.adj(v))
		if (!marked[e.other(v)]) 
			pq.insert(e);
	}
	public Iterable<Edge> edges(){ 
		return mst; 
	}
	public double weight(){ 
		// See Exercise 4.3.31.
		return 0.0;
	}
}
