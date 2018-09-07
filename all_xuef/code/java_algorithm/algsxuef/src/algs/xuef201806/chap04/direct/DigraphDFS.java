package algs.xuef201806.chap04.direct;
/**
 * ����ͼ�Ŀɴ���
 * @author moveb
 * �������������������һ�������ڴ�������ͼ���㷨?!
 */
public class DigraphDFS {
	private boolean[] marked;
	
	/**
	 * ��G���ҵ���s�ɴ�����ж���
	 * @param G
	 * @param s
	 */
	public DigraphDFS(Digraph G, int s){
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	private void dfs(Digraph G, int v){
		marked[v] = true;
		for(int w:G.adj(v)){
			if(!marked[w])
				dfs(G, w);
		}
	}
	
	/**
	 * ��G���ҵ���sources�е����ж���ɴ�����ж���
	 * @param G
	 * @param sources
	 */
	public DigraphDFS(Digraph G, Iterable<Integer> sources){
		marked = new boolean[G.V()];
		for(int s:sources){
			if(!marked[s])
				dfs(G, s);
		}
	}
}
