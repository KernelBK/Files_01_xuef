package multi_thread.thread.runnable.strategy;
/**
 * 用个人所得税计算器的设计来说明Runnable接口的设计
 * Target: 纳税人 
 * @author moveb
 */
public class Target {
	private double salary;
	private double bonus;
	
	// 计算所得税的策略 需要设计成静态方法或单例???
	private TaxCalcStrategy taxCalcStrategy;
	public Target(double salary, double bonus) {
		this.salary = salary;
		this.bonus = bonus;
	}
	// 注入具体的计算策略
	public void setTaxCalcStrategy(TaxCalcStrategy taxCalcStrategy) {
		this.taxCalcStrategy = taxCalcStrategy;
	}
	/**
	 * 计算的任务交给子类来实现
	 * 就如同，线程逻辑通过重写run()方法来重写
	 * @return
	 */
	public double calcTax(){
		return this.taxCalcStrategy.calcTax(salary, bonus);
	}
}
