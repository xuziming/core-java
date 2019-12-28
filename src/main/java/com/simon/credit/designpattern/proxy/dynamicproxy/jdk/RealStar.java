package com.simon.credit.designpattern.proxy.dynamicproxy.jdk;

public class RealStar implements Star {

	public void confer() {
		System.out.println("RealStar confer...");
	}

	public void signContract() {
		System.out.println("RealStar signContract...");
	}

	public void bookTicket() {
		System.out.println("RealStar bookTicket...");
	}

	public void sing() {
		System.out.println("RealStar(周杰伦) sing...");
	}

	public void collectMoney() {
		System.out.println("RealStar collectMoney");
	}

}
