package algs.xuef201806.chap05;

import algs.xuef201806.chap01.Queue;

/**
 * ���ڵ��ʲ������ķ��ű�
 * @author moveb
 *
 * @param <Value>
 */
public class TrieST<Value> {
	private static int R = 256; // ����
	private Node root; //
	
	private static class Node{
		private Object val;
		private Node[] next = new Node[R];
	}
	// ���put, �������get
	public Value get(String key){
		Node x = get(root, key, 0);
		if(x == null) return null;
		return (Value)x.val;
	}
	private Node get(Node x, String key, int d){
		// ������x��Ϊ�������ӵ��ʲ���������key�������ֵ
		if(x == null) return null;
		if(d == key.length()) return x;
		char c = key.charAt(d); // �ҵ���d���ַ�����Ӧ���ӵ��ʲ�����
		return get(x.next[c], key, d+1);
	}
	public void put(String key, Value val){
		root = put(root, key, val, 0);
	}
	private Node put(Node x, String key, Value val, int d){
		// ���key��������xΪ�������ӵ�����������������������ֵ
		if(x == null) return new Node();
		if(d == key.length()){
			x.val = val;
			return x;
		}
		char c = key.charAt(d); // �ҵ���d���ַ�����Ӧ���ӵ��ʲ�����
		// ���c��s, next[c]���Ƚ�'s'תΪ��Ӧ��intֵ, ord('s')-->115
		// x.next[c]-->���x�ĵ�ord(c)������
		x.next[c] = put(x.next[c], key, val, d+1);
		return x;
	}
	public int size(){
		return size(root);
	}
	/**
	 * ��x��Ϊ���ڵ���ӵ��ʲ������ļ�������
	 * ѧϰ�ݹ�ĺ�����
	 * @param x
	 * @return
	 */
	public int size(Node x){
		// �ս����Ȼû�м�
		if(x == null) return 0;
		int cnt = 0;
		// ����ý���val��Ϊ��, ��ô������һ����
		if(x.val != null) cnt++;
		for(char c=0; c<R; c++){
			cnt += size(x.next[c]);
		}
		return cnt++;
	}
	public Iterable<String> keys(){
		return keysWithPrefix("");
	}
	public Iterable<String> keysWithPrefix(String pre){
		Queue<String> q = new Queue<String>();
		collect(get(root, pre, 0), pre, q);
		return q;
	}
	/**
	 * �� ��xΪ�������ӵ��ʲ������� �ռ���pre��ͷ�ļ�
	 * @param x
	 * @param pre
	 * @param q
	 */
	private void collect(Node x, String pre, Queue<String> q){
		if(x == null) return;
		if(x.val != null) q.enqueue(pre);
		for(char c=0; c<R; c++){
			collect(x.next[c], pre + c, q);
		}
	}
}
