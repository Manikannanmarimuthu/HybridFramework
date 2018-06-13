package com.gsswitch.qa.practice;

public class Compare {
	public static void main(String[] args) {
		String a = "Manikannan";
		String b = "M"; 
		String f = "";
		String g = "K";
		int c = a.compareTo(b);
		int d = b.compareTo(a);
		int m = f.compareTo(g);
		int y = g.compareTo(f);
		System.out.println(c);
		System.out.println(d);
		System.out.println(m);
		System.out.println(y);
	}
}
