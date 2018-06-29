package com.gsswitch.qa.practice;

import org.testng.annotations.Test;

public class Testng {

	@Test(threadPoolSize = 7, invocationCount = 5)
	public void test2() {
		int i=1;
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("Thread name=" + name);
		System.out.println("Test : "+i);
		i++;
	}
}
