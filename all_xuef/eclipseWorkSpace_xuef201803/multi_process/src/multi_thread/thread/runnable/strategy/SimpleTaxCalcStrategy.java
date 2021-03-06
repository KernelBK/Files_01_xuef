package multi_thread.thread.runnable.strategy;

public class SimpleTaxCalcStrategy implements TaxCalcStrategy {

	@Override
	public double calcTax(double salary, double bonus) {
		return 0.15 * salary + bonus * 0.2;
	}
}
