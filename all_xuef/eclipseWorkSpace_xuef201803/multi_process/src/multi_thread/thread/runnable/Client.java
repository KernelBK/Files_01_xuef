package multi_thread.thread.runnable;

public class Client {
	public static void main(String[] args) {
		GenerateTicket gt = new GenerateTicket();
		
		Thread ticketWindow1 = new Thread(gt, "一号窗口");
		Thread ticketWindow2 = new Thread(gt, "二号窗口");
		Thread ticketWindow3 = new Thread(gt, "三号窗口");
		ticketWindow1.start();
		ticketWindow2.start();
		ticketWindow3.start();
		
	}
}
