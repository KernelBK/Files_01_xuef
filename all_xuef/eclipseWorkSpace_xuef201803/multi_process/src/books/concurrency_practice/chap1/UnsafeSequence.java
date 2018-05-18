package books.concurrency_practice.chap1;
// not thread safe
public class UnsafeSequence {
	private int value;
	/** Returns a unique value. */
	public int getNext() {
		/**
		 * ��Ҫ���ǻ�����ִ��ϸ��
		 * 1. get value
		 * 2. value++
		 * 3. put value
		 */
		return value++;
	}
}
