package com.atguigu.test;

public class Demo {

	public static void main(String[] args) {
		TestDemo t = new TestDemo();

		/*new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {

					t.add();
				}
			}
		}, "线程1-add组别1").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {

					t.add();
				}
			}
		}, "线程2-add组别2").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {

					t.dev();
				}
			}
		}, "线程2 -Dev 组别1 ").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {

					t.dev();
				}
			}
		}, "线程2 -Dev 组别2").start();
*/
		// 操作函数式接口  接口中只有一个抽象方法
		new Thread( () -> { 	
			for (int i = 1; i <= 10; i++) {
				t.add();
			}
		},"加操作 ").start(); 
		
		
		new Thread( () -> {
			for (int i = 1; i <= 10; i++) {
				t.dev();
			}
		},"减操作").start(); 
	}
}
