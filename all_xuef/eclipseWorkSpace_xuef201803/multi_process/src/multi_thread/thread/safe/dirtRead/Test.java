package multi_thread.thread.safe.dirtRead;

public class Test {
	public static void main(String[] args) {
		try {
			PublicVar pv = new PublicVar();
			ThreadA ta = new ThreadA(pv);
			ta.start();
			Thread.sleep(200);
			pv.getValue();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
