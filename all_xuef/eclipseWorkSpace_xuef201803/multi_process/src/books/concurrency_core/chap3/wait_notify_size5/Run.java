package books.concurrency_core.chap3.wait_notify_size5;

public class Run {
	public static void main(String[] args) {
		try {
			/**
			 * �߳� a b ����ͬһ����
			 */
			Object lock = new Object();
			ThreadA a = new ThreadA(lock);
			a.setName("thread-a");
			a.start();
			
			Thread.sleep(50);
			ThreadB b = new ThreadB(lock);
			b.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
