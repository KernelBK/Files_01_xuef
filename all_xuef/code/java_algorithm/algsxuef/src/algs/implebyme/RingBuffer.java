package algs.implebyme;

public class RingBuffer<Item> {
	Item[] circlequeue;
	int QUEUE_SIZE =1000;
	int header = 0; //��( �� ����)λ��
	int tailer = 0; // д(�����)λ�� 
	
	public RingBuffer(int size){
		QUEUE_SIZE = size;
		circlequeue = (Item[]) new Object[size];
	}
	public boolean isEmpty(){
		return header==tailer;
	}
	public boolean isFull(){
		return (tailer+1)%QUEUE_SIZE == header;
	}
	public void enqueue(Item i){
		if(isFull()) return; //Ӧ���׳��쳣��
		circlequeue[tailer%QUEUE_SIZE] = i;
		tailer++;
		//�ж�tailer�Ƿ�Խ��
		if(tailer>QUEUE_SIZE) tailer=tailer%QUEUE_SIZE;
	}
	public Item dequeue(){
		if(isEmpty()) return null;
		Item i = circlequeue[header%QUEUE_SIZE];
		header++;
		if(header > QUEUE_SIZE) header = header % QUEUE_SIZE;
		return i;
	}
}
