package books.concurrency_core.chap2.t9_volatile;

public class Run {
	public static void main(String[] args) {
		PrintString printStringService = new PrintString();
		printStringService.printStringMethod();
		// ���߳� main ��æ��ִ�� printStringMethod, ���Բ�������ִ��
		System.out.println("��Ҫֹͣ��! stopThread=" + Thread.currentThread().getName());
		printStringService.setContinuePrint(false);
	}
}
