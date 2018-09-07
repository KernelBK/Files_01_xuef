package algs.xuef201806.chap04.direct;
/**
 * ��������
 * @author moveb
 *
 */
public class Topological {
	private Iterable<Integer> order; // �������������
	
	public Topological(Digraph G){
		DirectedCycle cyclefinder = new DirectedCycle(G);
		// �������޻�ͼ
		if(!cyclefinder.hasCycle()){
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}
	/**
	 * ������������ж���
	 * @return
	 */
	public Iterable<Integer> order(){
		return order;
	}
	/**
	 * G �������޻�ͼ��
	 * @return
	 */
	public boolean isDAG(){
		return order != null;
	}
}
