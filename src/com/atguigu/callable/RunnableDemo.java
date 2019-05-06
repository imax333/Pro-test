package com.atguigu.callable;

public class RunnableDemo implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() +  "hello  every one ");
		
	}

}
