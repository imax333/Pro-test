package com.atguigu.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// new Thread(new RunnableDemo(),"线程1").start();
		
		MyThread mt = new MyThread();
		
		FutureTask<Integer> futureTask = new FutureTask<>(mt);
		
		new Thread(futureTask,"线程1").start();
		new Thread(futureTask,"线程2").start();
		new Thread(futureTask,"线程3").start();
		
		// .get()这个方法的调用只能放到最后调用,只要困难线程没有执行完毕,就无法调用get方法
		Integer integer = futureTask.get();
		System.out.println(Thread.currentThread().getName());
		
		
		
		System.out.println(integer);
		
		
		
	}

}
