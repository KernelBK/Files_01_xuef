package multi_thread.thread.safe.extobject;

public class ThreadB extends Thread {
	private MyObject obj;

	public ThreadB(MyObject obj) {
		super();
		this.obj = obj;
	}
	@Override
	public void run(){
		super.run();
		obj.methodB();
	}
}
