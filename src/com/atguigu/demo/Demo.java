package com.atguigu.demo;

public class Demo {

	
	public static void main(String[] args) {
		
		Resource r = new Resource();
		
		new Thread(() ->{
			r.print();
		},"AAAA") .start();
		
		
		new Thread(() ->{
			r.printAZ();
		},"BBBB") .start();
	}
}
