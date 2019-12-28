package com.simon.credit.designpattern.proxy.dynamicproxy.jdk0;

/**
 * 电车类，实现Rechargable，Vehicle接口
 */
public class ElectricCar implements Rechargable, Vehicle {

	public void drive() {
		System.out.println("Electric Car is Moving silently...");
	}

	public void recharge() {
		System.out.println("Electric Car is Recharging...");
	}

}