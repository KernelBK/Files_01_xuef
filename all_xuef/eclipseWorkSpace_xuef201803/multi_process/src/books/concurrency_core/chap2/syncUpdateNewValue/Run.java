package books.concurrency_core.chap2.syncUpdateNewValue;

/**
 * JVM -server ģʽ������
 * @author moveb
 */
public class Run {
	public static void main(String[] args) {
		try {
			Service service = new Service();
			ThreadA a = new ThreadA(service);
			a.start();
			Thread.sleep(1000);
			ThreadB b = new ThreadB(service);
			b.start();
			System.out.println("�Ѿ�����ֹͣ��������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
