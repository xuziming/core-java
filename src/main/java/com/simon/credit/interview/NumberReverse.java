package com.simon.credit.interview;

public class NumberReverse {

	public static void main(String[] args) {
		System.out.println(reverse(12394678L));
	}

	public static long reverse(long num) {
		long positiveOut = 0;
		// 是否负数(negative-负数, positive-正数)
		boolean isNegative = num < 0;
		if (isNegative) {
			num = -num;
		}
		while (num > 0) {
			positiveOut = positiveOut * 10 + num % 10;
			num /= 10;
		}
		return isNegative ? -positiveOut : positiveOut;
	}

}