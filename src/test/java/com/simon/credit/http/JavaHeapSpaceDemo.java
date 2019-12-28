package com.simon.credit.http;

public class JavaHeapSpaceDemo {

	public static void main(String[] args) {
		stackOverflowError();
	}

	private static void stackOverflowError() {
		stackOverflowError();
	}

}
