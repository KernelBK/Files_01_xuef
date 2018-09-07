package algs.implebyme;

import java.util.Iterator;
import java.util.NoSuchElementException;

// ���� ����ͷ�ڵ�first ��β��� last
public class LinkedList<Item> implements Iterable<Item>{
	private Node first; //ָ���һ���ڵ� ��˵�������һ���ڵ�ĵ�ַ��
	private Node last;
	public void addNode(Item i){
		Node node = new Node();
		node.item=i;
		node.next=null;
		if(first==null){
			first=node;
			last=node;
		}else{
			last.next=node;
			last=node;
		}
	}
	public boolean find(Item key){
		for(Item i:this){
			if(i.equals(key)) return true; //ʲô����ȣ����Ǹ����⣨������Ӧ����client�����壩
		}
		return false;
	}
	// Ѱ�����Ԫ�� �ݹ�ʵ�� ex 1.3.18
	
	private class Node{
		Item item;
		Node next;
	}

	@Override
	public Iterator<Item> iterator() {
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements Iterator<Item>{
		private Node current=first;
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			Item i = current.item;
			current = current.next;
			return i;
		}

		@Override
		public void remove() {
			
		}
		
	}
}
