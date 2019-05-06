package com.atguigu.test_4;

public class Demo {
	public static void main(String[] args) {

		Resource r = new Resource();
		
		
		new Thread(() ->{ 
			r.print();
		}).start();
		
		new Thread(() ->{ 
			r.printAZ();
		}).start();
		
	}
}
