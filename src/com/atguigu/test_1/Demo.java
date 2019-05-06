package com.atguigu.test_1;

public class Demo {

	public static void main(String[] args) {
		Ticket t = new Ticket();

		new Thread(() -> {
			for(int i = 1; i <= 40; i++) {
				t.sale();
			}
		},"窗口A ").start();
		
		
		new Thread( () ->{
			for(int i = 1;i <= 40; i++) {
				t.sale();
			}
		},"窗口B ").start();
		
		
		new Thread( () ->{
			for(int i = 1;i <= 40; i++) {
				t.sale();
			}
		},"窗口C ").start();
		
	}

}
