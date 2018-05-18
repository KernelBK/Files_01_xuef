package books.concurrency_core.chap2.volatileTestThread;

public class MyThread extends Thread {
	/**
	 * volatile �������������ݵ�ԭ���ԣ�����ǿ�ƶ����ݵĶ�д��ʱӰ������ڴ�ġ�
	 */
	volatile public static int count;
	// Ϊ class ����
	synchronized private static void addCount(){
		for (int i = 0; i < 100; i++) {
			count++;
		}
		System.out.println("count=" + count);
	}
	@Override
	public void run() {
		addCount();
	}
}
