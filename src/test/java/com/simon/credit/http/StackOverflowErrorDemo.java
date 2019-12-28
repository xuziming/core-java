package com.simon.credit.http;

import java.util.Random;

public class StackOverflowErrorDemo {

	public static void main(String[] args) {
		String str = "atguigu";
		while (true) {
			str += str + new Random().nextInt(11111111) + new Random().nextInt(22222222);
			str.intern();
		}
	}

}
