package algs.xuef201806.chap01;
/**
 * ����ʵ�ֵ�ջ
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
	private Node first; // ָ�������ӵ�Ԫ��
	private int N;
	private class Node{
		Item i;
		Node next;
	}
	public Stack(){
		N=0;
		first=null;//?
	}
	public int size(){ return N; }
	public boolean isEmpty(){ return first==null;}
	public void push(Item item){
		Node node=new Node();
		/**
		 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
			at algs.xuef201806.chap01.Stack.push(Stack.java:22)
		 */
		node.i = item;
		node.next=first;
		first=node;
		N++;
	}
	public Item pop(){
		Item item=null;
		if(!isEmpty()){ //���ջΪ�գ�����Ĵ���ܲ��ã���Ϊ�û���ȫ��֪���������ġ�
			item = first.i;
			first = first.next;
		}
		N--;
		return item;
	}
	public Item peek(){
		return first.i;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
	private class StackIterator implements Iterator<Item>{
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			Item i = current.i;
			current = current.next;
			return i;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
}
