package books.concurrency_core.chap2.t10_volatile;

public class Run {
	public static void main(String[] args) {
		PrintString printStringService = new PrintString();
		new Thread(printStringService).start();
		
		System.out.println("��Ҫֹͣ��! stopThread=" + Thread.currentThread().getName());
		printStringService.setContinuePrint(false);
	}
}
