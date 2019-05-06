package com.atguigu.test_2;

public class Demo {
	

	public static void main(String[] args) {
		Resource r = new Resource();
		
		new Thread( () -> {
			for(int i = 1 ; i<= 10; i++) {
				
				r.add(i);
			}
		},"add 线程 1") .start();
		
		new Thread( () -> {
			for(int i = 1 ; i<= 10; i++) {
				
				r.add(i);
			}
		},"add 线程 2") .start();
		
		
		
		new Thread( () -> {
			for(int i = 1 ; i<= 10; i++) {
				
				r.dev(i);
			}
		},"dev 线程 1") .start();
		
		new Thread( () -> {
			for(int i = 1 ; i<= 10; i++) {
				
				r.dev(i);
			}
		},"dev 线程 2") .start();
	}

}
