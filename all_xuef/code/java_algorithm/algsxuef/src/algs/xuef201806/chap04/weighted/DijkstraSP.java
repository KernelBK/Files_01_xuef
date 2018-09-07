package algs.xuef201806.chap04.weighted;

import algs.base.priorityQueue.IndexMinPQ;
import algs.xuef201806.chap01.Stack;

public class DijkstraSP {
	private DirectedEdge[] edgeTo;
	private double[] distTo; // source�����нڵ����̾���
	/**
	 * ������Ҫ�����ɵĶ��㲢ȷ����һ�������ɵĶ���
	 */
	private IndexMinPQ<Double> pq;
	
	public DijkstraSP(EdgeWeightedDigraph G, int s){
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		/**
		 * �� distTo[]������Ԫ�س�ʼ��������
		 * distTo[s]��ʼ��Ϊ0
		 */
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		
		distTo[s] = 0.0;
		
		pq.insert(s, 0.0);
		while (!pq.isEmpty())
			// Removes a minimum key and returns its associated index.
			// ɾ��key��С��, ���ع���������
			relax(G, pq.delMin());
	}
	private void relax(EdgeWeightedDigraph G, int v){
		for(DirectedEdge e : G.adj(v)){
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()){
				// ˵��, s-->v-->w ��֮ǰ�洢��s-->w����; Ҫ���� distTo[w]
				distTo[w] = distTo[v] + e.weight();
				// �� v-->w �������·����
				edgeTo[w] = e;
				// ���ڵ�vָ������нڵ����pq��
				if (pq.contains(w)) 
					pq.change(w, distTo[w]);
				else 
					pq.insert(w, distTo[w]);
			}
		}
	}
	public double distTo(int v){
		// standard client query methods
		return distTo[v];
	}
	public boolean hasPathTo(int v){
		// for SPT implementatations
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	public Iterable<DirectedEdge> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack();
		for(DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]){
			path.push(e);
		}
		return path;
	}
}
