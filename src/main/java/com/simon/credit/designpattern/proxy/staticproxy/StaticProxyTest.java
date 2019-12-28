package com.simon.credit.designpattern.proxy.staticproxy;

public class StaticProxyTest {

	public static void main(String[] args) {
		Star realStar = new RealStar();

		Star proxy = new ProxyStar(realStar);
		proxy.confer();
		proxy.signContract();
		proxy.bookTicket();
		proxy.sing();
		proxy.collectMoney();
	}

}
