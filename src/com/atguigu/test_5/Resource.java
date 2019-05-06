package com.atguigu.test_5;

import java.util.concurrent.Callable;

public class Resource implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		
		Thread.sleep(4000);
		return 23333;
	}

	
	
	
}
