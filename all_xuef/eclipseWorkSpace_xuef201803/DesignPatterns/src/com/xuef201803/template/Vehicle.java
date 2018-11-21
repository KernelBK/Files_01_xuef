package com.xuef201803.template;

public abstract class Vehicle {
	// ģ�巽��
	public final void drive(){
		startTheEngine();
		putIntoGear();
		looseHandBrake();
		stepOnTheGasAndGo();
	}
	protected abstract void putIntoGear();
	private void stepOnTheGasAndGo() {
		
	}

	private void looseHandBrake() {
		
	}

	private void startTheEngine() {
		
	}
}
