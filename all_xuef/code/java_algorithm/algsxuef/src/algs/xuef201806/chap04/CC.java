package algs.xuef201806.chap04;
/**
 * ʹ��������������ҳ�ͼ�е�������ͨ����
 * @author moveb
 *
 */
public class CC {
	private boolean[] marked;
	// �Զ�����Ϊ����������, ��ͬһ����ͨ�����еĶ�������ͨ�����ı�ʶ��(intֵ)��������
	// ��ʹ��connected()������ʵ�ֱ��ʮ�ּ�(ֻ�����ʶ���Ƿ���ͬ)
	private int[] id; 
	private int count; // ��ͨ������ʶ��
	
	public CC(UndirectGraph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		/**
		 * ��һ�ε��� dfs(G, 0)
		 * ����������0��ͨ�Ķ���
		 */
		for(int s=0; s<G.V(); s++){ // �������ж���
			if(!marked[s]){
				dfs(G, s);
				count++;
			}
		}
	}
	private void dfs(UndirectGraph G, int v){
		marked[v] = true;
		id[v] = count;
		for(int w:G.adj(v)){
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	public boolean connected(int v, int w){
		return id[v] == id[w];
	}
	public int id(int v){
		return id[v];
	}
	public int count(){
		return count;
	}
}
