package algs.implebyme;

import algs.base.StdOut;

public class RingBufefrTest {
	public static void main(String[] args) {
		RingBuffer<String> rb = new RingBuffer<>(5);
		//StdOut.println(rb.dequeue());
		rb.enqueue("aa");
		rb.enqueue("bb");
		rb.enqueue("cc");
		StdOut.println(rb.dequeue());
		rb.enqueue("dd");
		rb.enqueue("ff");
		//�˴��ǵ��̣߳���Ϊ�������ˣ������������ݾͶ�ʧ�ˡ�
		//����ʵ�У�Ӧ�Ƕ��̡߳������߼����������ˣ�Ӧ�õȴ����������ѵ�һ���ֻ�����Ԫ�غ��ٴ��롣
		rb.enqueue("yy");
		rb.enqueue("11");
		rb.enqueue("22");
		rb.enqueue("33");
		rb.enqueue("44");
		rb.enqueue("55");
		rb.enqueue("66");
		StdOut.println(rb.dequeue());
		StdOut.println(rb.dequeue());
		StdOut.println(rb.dequeue());
		StdOut.println(rb.dequeue());
		rb.enqueue("77");
		rb.enqueue("88");
		rb.enqueue("99");
		StdOut.println(rb.dequeue());
		StdOut.println(rb.dequeue());
		StdOut.println(rb.dequeue());
		StdOut.println(rb.dequeue());
	}
}
