package com.atguigu.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {

	private int num = 30;

	Lock lock = new ReentrantLock(); // 重入锁
	
	public void sale() {
		lock.lock();
		
		
		try {
			if(num > 0) {
				System.out.println("窗口号 " + Thread.currentThread().getName() + " 票号 : " + (num--) + "剩余票数为 :" + num + "张");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
		
	
	
		

}
