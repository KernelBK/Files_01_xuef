package multi_thread.thread.runnable;

public class GenerateTicket implements Runnable {

	private static int MAX_NUM = 100;
	private int cur_idx = 1;
	
	@Override
	public void run() {
		while(cur_idx <= MAX_NUM){
			System.out.println(Thread.currentThread() + 
					"���ڣ�Ϊ: " + cur_idx++ + "����");
		}
	}

}
