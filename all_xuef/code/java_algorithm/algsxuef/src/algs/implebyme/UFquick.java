package algs.implebyme;

import algs.base.StdIn;
import algs.base.StdOut;

public class UFquick {
	private int[] id; // access to component id (site indexed)
	private int[] sz; //��¼ÿ�����ڵ�����Ӧ�ķ����Ĵ�С(added)
	private int count; // number of components
	public UFquick(int N)
	{ // Initialize component id array.
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++) sz[i] = 1;
	}
	public int count()
	{ return count; }
	public boolean connected(int p, int q)
	{ return find(p) == find(q); }
	public int find(int p){ //find the root
		if(id[p] != p){
			return find(id[p]);
		}
		return p;
	}
	public void union(int p, int q){
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot) return;
		//��С�����ڴ����ϣ�С���ĸ��ڵ����ӵ������ĸ��ڵ㣩
		if(sz[pRoot]<=sz[qRoot]) { 
			id[pRoot] = qRoot; 
			sz[qRoot]+=sz[pRoot];
		}
		else {
			id[qRoot] = pRoot; 
			sz[pRoot]+=sz[qRoot];
		}
		count--;
		/*id[pRoot] = qRoot; //�ı� p ������ͨ�����ĸ�*/
	}
	// See page 222 (quick-find),page 224 (quick-union) andpage 228 (weighted).
	public static void main(String[] args)
	{ // Solve dynamic connectivity problem on StdIn.
		int N = StdIn.readInt(); // Read number of sites.
		UFquick uf = new UFquick(N); // Initialize N components.
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt(); // Read pair to connect.
			//if (uf.connected(p, q)) continue; // Ignore if connected.
			uf.union(p, q); // Combine components
			//StdOut.println(p + " " + q); // and print connection.
		}
		StdOut.println(uf.count() + " components");
	}
}
