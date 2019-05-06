package com.atguigu.test_3;

public class Demo {
	
	public static void main(String[] args) {
		Resource r = new Resource();
		
		
		new Thread(() ->{
			for(int i = 1;i<=10;i++) {
				r.print5(i);
			}
		}," A 线程 ") .start();
		
		new Thread(() ->{
			for(int i = 1;i<=10;i++) {
				r.print10(i);
			}
		}," B 线程 ") .start();
		
		
		new Thread(() ->{
			for(int i = 1;i<=10;i++) {
				r.print15(i);
			}
		}," C 线程 ") .start();
	}

}
