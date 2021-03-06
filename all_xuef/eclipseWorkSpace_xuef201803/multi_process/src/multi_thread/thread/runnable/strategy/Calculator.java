package multi_thread.thread.runnable.strategy;
// 测试
public class Calculator {
	public static void main(String[] args) {
		// 具体计算策略
		TaxCalcStrategy taxCalcS = new SimpleTaxCalcStrategy();
		// 生成纳税人
		Target t = new Target(10000d, 4000d);

		// 注入计算策略
		t.setTaxCalcStrategy(taxCalcS);
		
		System.out.println(t.calcTax());
	}
}
