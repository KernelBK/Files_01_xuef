package multi_thread.thread.runnable.strategy;

public interface TaxCalcStrategy {
	// ����ʹ�÷��ͺ�Object... ���Ľ�
	/**
	 * ���ݹ��ʺͽ��� �������������˰
	 * @param salary ����
	 * @param bonus ����
	 * @return
	 */
	double calcTax(double salary, double bonus);
}
