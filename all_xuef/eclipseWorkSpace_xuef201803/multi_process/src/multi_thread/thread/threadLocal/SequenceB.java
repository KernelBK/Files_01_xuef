package multi_thread.thread.threadLocal;

/**
 * 使用 ThreadLocal(可以理解为一个容器，用于存放线程的局部变量)
 * 
 * @author moveb
 */
public class SequenceB implements Sequence {
	// 每个线程可拥有自己的 static 变量
	private static ThreadLocal<Integer> numContainer =
						new ThreadLocal<Integer>(){
							@Override
							protected Integer initialValue(){
								return 0;
							}
						};
	
	@Override
	public int getNumber() {
		numContainer.set(numContainer.get() + 1);
		return numContainer.get();
	}
}
