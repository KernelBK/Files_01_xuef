package multiprocess_core.service;

public class Main {
	public static void main(String[] args) {
		// ������2��ҵ�������ϵͳ�в�����2����
		HasSelfPrivateNum o1 = new HasSelfPrivateNum();
		HasSelfPrivateNum o2 = new HasSelfPrivateNum();
		
		ThreadA th1 = new ThreadA(o1);
		th1.start();
		ThreadB th2 = new ThreadB(o2);
		th2.start();
	}
}
