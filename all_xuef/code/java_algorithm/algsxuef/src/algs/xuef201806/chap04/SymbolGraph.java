package algs.xuef201806.chap04;

import algs.base.In;
import algs.base.ST;

/**
 * ����ͼ����������
 * @author moveb
 *
 */
public class SymbolGraph {
	private ST<String, Integer> st; // ������-->����
	private String[] keys; // ����-->������
	private UndirectGraph G; // ͼ
	/**
	 * @param stream
	 * @param sp �ָ���
	 */
	public SymbolGraph(String stream, String sp){
		st = new ST();
		In in = new In(stream);
		while(in.hasNextLine()){ // ��������
			String[] a = in.readLine().split(sp); // ��ȡ�ַ���
			// Ϊÿ����ͬ���ַ�������һ������
			for(int i=0; i<a.length; i++){
				if(!st.contains(a[i])){
					st.put(a[i], st.size());
				}
			}
		}
		keys = new String[st.size()];
		for(String name:st.keys()){
			keys[st.get(name)] = name;
		}
		G = new UndirectGraph(st.size());
		in = new In(stream);
		while(in.hasNextLine()){
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for(int i=1; i<a.length; i++){
				G.addEdge(v, st.get(a[i]));
			}
		}
	}
}
