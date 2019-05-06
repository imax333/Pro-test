package com.atguigu.resource;

public class Demo {

	/**
	 * 多个线程之间按顺序调用 实现 A->B->C 三个线程启动,要求如下: AA打印5次,BB打印10次,CC打印15次 接着
	 * AA打印5次,BB打印10次,CC打印15次 .....循环10轮
	 * 
	 * @param args
	 */
	// 线程 操作 资源
	public static void main(String[] args) {
		Resourse r = new Resourse();

		new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				r.print5(i);
			}
		}, "AA").start();

		new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				r.print10(i);
			}
		}, "BB").start();

		new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				r.print15(i);
			}
		}, "CC").start();

	}
}
