package books.concurrency_core.chap2.t16;

public class RunThread extends Thread {
	/**
	 * volatile
	 * ��Ҫ���þ��ǵ��̷߳���isRunning �������ʱ��ǿ���Դӹ�����ջ��ȡֵ
	 */
	volatile private boolean isRunning = true;
	
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	@Override
	public void run() {
		System.out.println("���� run ��");
		while(isRunning){
			
		}
		System.out.println("�̱߳�ֹͣ�ˣ�");
	}
}
