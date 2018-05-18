package books.concurrency_core.chap3.produce_consumer;
// ������
public class Produce {
	private String lock;
	public Produce(String lock){
		super();
		this.lock = lock;
	}
	public void setValue(){
		try{
			synchronized (lock) {
				/**
				 * ValueObject ���зǿ�ֵʱ�͵ȴ���û��ʱ������
				 */
				if(!ValueObject.value.equals("")){
					lock.wait();
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println("set ��ֵ�� " + value);
				ValueObject.value = value;
				lock.notify();
			}
		} catch(InterruptedException e){
			
		}
	}
}
