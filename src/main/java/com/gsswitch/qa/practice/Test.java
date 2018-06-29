package com.gsswitch.qa.practice;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		String reverse = "";
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter the Word want to check ");
		String str = sc.nextLine();
		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			reverse = reverse + String.valueOf(ch);
		}
		if (reverse.equalsIgnoreCase(str)) {
			System.out.println("Both are Same");
		} else {
			System.out.println("Not Same");
		}
	}
}