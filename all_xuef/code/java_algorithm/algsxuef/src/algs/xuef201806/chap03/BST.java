package algs.xuef201806.chap03;

import algs.base.StdOut;
import algs.xuef201806.chap01.Queue;

/**
 * ���������
 * @author moveb
 *
 */
public class BST<Key extends Comparable<Key>, Value> {
	private Node root; // ����������ĸ��ڵ�
	private class Node{
		private Key key;
		private Value val;
		private Node left, right; // ָ������������
		private int N; // �Ըýڵ�Ϊ���������еĽڵ�����
		
		public Node(Key key, Value val, int N){
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	public int size(){
		return size(root);
	}
	public int size(Node x){
		if(x == null) return 0;
		else return x.N;
	}
	
	public Value get(Key k){
		return get(root, k);
	}
	public Value get(Node x, Key k){
		if(x == null) return null;
		// x ��Ϊ null
		int cmp = k.compareTo(x.key);
		if(cmp > 0) return get(x.right, k);
		if(cmp < 0) return get(x.left, k);
		else return x.val;
	}
	
	public void put(Key k, Value v){
		// ����key, �ҵ����������ֵ, ����Ϊ������һ���µĽڵ�
		root = put(root, k, v);
	}
	/**
	 * ��(k,v)���뵽�� x Ϊ���ڵ�������С��ҷ��ؽڵ� x 
	 * @param x
	 * @param k
	 * @param v
	 * @return
	 */
	public Node put(Node x, Key k, Value v){
		if(x == null) return new Node(k, v, 1);
		int cmp = k.compareTo(x.key);
		if(cmp < 0) // kС��x.key, ����x��������
			x.left = put(x.left, k, v); // ������εݹ�!
		else if(cmp > 0)
			x.right = put(x.right, k, v);
		else
			x.val = v;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	/**
	 * ɾ������СԪ��
	 */
	public void deleteMin(){
		deleteMin(root);
	}
	/**ɾ�� ��xΪ������������С�ڵ�
	 * 
	 * ���ǲ���̫�����ڵݹ��ִ��ϸ��;
	 * һ���ݹ�����Ч�ģ�ֻҪ���ܴ������������
	 * �����У�
	 * 1. ���������Ϊ��
	 * 2. ��������Ϊ��
	 * @param x
	 * @return
	 */
	private Node deleteMin(Node x){
		// ���ϼ��������,ֱ��������Ϊ�գ���ʱ��x��Ϊ����С�Ľڵ㡣��������������
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1; // ���x.N�ļ��㷽����ͨ�õ�
		return x; // �������ֵ����Ҫ, Ҫ����һ���ԡ�
	}
	
	public void delete(Key k){
		root = delete(root, k);
	}
	
	public Node delete(Node x, Key k){
		if(x == null) return null;
		// Ѱ��Ҫɾ���Ľڵ�
		int cmp = k.compareTo(x.key);
		if(cmp < 0) x.left = delete(x.left, k);
		else if(cmp > 0) x.right = delete(x.right, k);
		else{
			/**
			 * 1. ��ָ�򼴽���ɾ���Ľڵ�����ӱ���Ϊ t
			 * 2. ��xָ�����ĺ�̽ڵ�min(t.right)
			 * 3. ��x��������ָ�� deleteMin(t.right)
			 * 4. ��x����������Ϊt.left
			 */
			if(x.right == null) return x.left;
			if(x.left == null) return x.right;
			Node t = x;
			x = min(t.right); // ԭ x �ڵ㱻ɾ����
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	/**
	 * ������xΪ������������С�ڵ�
	 * @param x
	 * @return
	 */
	public Node min(Node x){
		if(x.left == null) return x;
		return min(x.left);
	}
	
	/**
	 * �������
	 */
	public void infix(Node x){
		if(x == null) return;
		// �������������
		infix(x.left);
		// ������ڵ�
		StdOut.print(x.key + ", ");
		// �������������
		infix(x.right);
	}

	public Iterable<Key> keys(){
		//keys(min(), max());
		return null;
	}
	public Iterable<Key> keys(Key lo, Key hi){
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}
	public void keys(Node x, Queue<Key> queue, Key lo, Key hi){
		if(x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		// lo < x.key
		if(cmplo < 0) keys(x.left, queue, lo, hi);
		if(cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
		if(cmphi > 0) keys(x.right, queue, lo, hi);
	}
	
	public static void main(String[] args) {
		BST<String, Integer> bst = new BST();
		bst.put("b1", 1);
		bst.put("a1", 1);
		bst.put("a2", 1);
		bst.put("c3", 1);
		bst.infix(bst.root);
	}
}

