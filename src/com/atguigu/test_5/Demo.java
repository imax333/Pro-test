package com.atguigu.test_5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		new Thread(new RunnableTest(),"线程Runnable").start();
		
		Resource resource = new Resource();
		
		FutureTask<Integer> futureTask = new FutureTask<>(resource);
		
		new Thread(futureTask,"A线程").start();
		
		System.out.println(Thread.currentThread().getName());
		
		Integer integer = futureTask.get();
		
		System.out.println(integer);
		
		
	}
}
