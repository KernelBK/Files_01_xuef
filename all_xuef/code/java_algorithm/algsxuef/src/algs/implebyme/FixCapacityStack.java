package algs.implebyme;

import java.util.Iterator;

public class FixCapacityStack<Item> implements Iterable<Item>{
	private Item[] a;
	private int N;
	public FixCapacityStack(int capacity){
		a=(Item[])new Object[capacity];
		N=0;
	}
	public boolean isEmpty(){
		return N==0;
	}
	public void push(Item i){
		// if the stack is full, resize
		if(N==a.length){resize(2*N+1);}
		a[N]=i;
		N++;
	}	
	public Item pop(){
		if(a.length/4 > N) resize(a.length/2);
		if(!isEmpty()){
			N--;
			Item item = a[N];
			a[N]=null;//�����������
			return item;
		}else return null;
		
	}
	public int size(){
		return N;
	}
	public void resize(int cap){
		Item[] temp=(Item[]) new Object[cap];
		for(int i=0; i<N; i++) temp[i]=a[i];
		a=temp;
		temp=null;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<Item>{
		int i=N;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i>0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			i--;
			return a[i];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}




