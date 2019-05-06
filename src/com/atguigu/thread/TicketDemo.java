package com.atguigu.thread;


// 线程 操作 资源 
public class TicketDemo {

	
	public static void main(String[] args) {
		Ticket t = new Ticket();
		
		
		new Thread(() ->{ 
			for(int i = 1; i<= 40;i++) {
				t.sale();
			}
		} ,"线程1"  ).start();
		
		new Thread( () ->{
			for(int i = 1; i<= 40;i++) {
				t.sale();
			}
		},"线程2").start(); 
		
		new Thread(() ->{
			for(int i = 1; i<= 40;i++) {
				t.sale();
			}
		},"线程3") .start();
		
		
		new Thread(() ->{
			for(int i = 1; i<= 40;i++) {
				t.sale();
			}
			
		},"线程4 ") .start();
		
	}
}
