package com.xuef201803.book_dp.bridge.abstract_desc;

/**
 * 扩充由Abstraction定义的接口功能
 * @author moveb
 *
 */
public class RefinedAbstraction extends Abstraction {

	public RefinedAbstraction(Implementor impl) {
		super(impl);
	}

	public void otherOperation(){
		
	}
}
