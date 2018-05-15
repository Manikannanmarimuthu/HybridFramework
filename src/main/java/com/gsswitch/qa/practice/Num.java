package com.gsswitch.qa.practice;

public class Num {

	public static void main(String[] args) {
		int n = 456;
		final int orgNum = n;
		int newNum = 0;
		while (n > 0) {
			int a = n % 10;
			newNum = newNum * 10 + a;
			n = n / 10;
		}
		if (newNum == orgNum) {
			System.out.println("Same");
		} else {
			System.out.println("Not same");
		}
	}

}
