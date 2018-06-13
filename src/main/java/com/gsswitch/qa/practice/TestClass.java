package com.gsswitch.qa.practice;

public class TestClass {
	public static void main(String[] args) {
		String a = "Manikannan";
		String b = a.substring(0, 2);
		String c = a.substring(0, 3);
		String d = a.substring(4);
		System.out.println(b);// Ma
		System.out.println(c);// Man
		System.out.println(d);// Kannan
	}
}