package multi_thread.thread.runnable;

public class Client {
	public static void main(String[] args) {
		GenerateTicket gt = new GenerateTicket();
		
		Thread ticketWindow1 = new Thread(gt, "һ�Ŵ���");
		Thread ticketWindow2 = new Thread(gt, "���Ŵ���");
		Thread ticketWindow3 = new Thread(gt, "���Ŵ���");
		ticketWindow1.start();
		ticketWindow2.start();
		ticketWindow3.start();
		
	}
}