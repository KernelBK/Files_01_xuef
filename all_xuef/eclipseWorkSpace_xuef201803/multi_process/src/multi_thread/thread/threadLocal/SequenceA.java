package multi_thread.thread.threadLocal;

/**
 * �Ȳ�ʹ�� ThreadLocal
 * @author moveb
 */
public class SequenceA implements Sequence {
	private int sequenceNum= 0;
	@Override
	public int getNumber() {
		sequenceNum++;
		return sequenceNum;
	}
}
