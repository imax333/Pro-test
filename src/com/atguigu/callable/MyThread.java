package com.atguigu.callable;

import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		Thread.sleep(4000);
		return 1234;
	}

}
