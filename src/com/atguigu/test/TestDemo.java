package com.atguigu.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo {
	// 线程  操作 资源  
	
	
	private int num = 0;
	
	Lock lock = new ReentrantLock();
	Condition addLock  = lock.newCondition(); 
	Condition devLock = lock.newCondition();


	
	
//	public synchronized void add() throws InterruptedException {
//		// 判断
//		while(num != 0) {
//			this.wait();
//		}
//		// 操作 
//		num++ ;
//		System.out.println(Thread.currentThread().getName() + "加操作  数值为 ：" + num);
//		
//		// 通知 
//		this.notifyAll();
//		
//	}
//	
//	
//	public synchronized void dev() throws InterruptedException {
//		while(num != 1) {
//			this.wait();
//		}
//		
//		--num;
//		System.out.println(Thread.currentThread().getName() + "减操作 数值为 ：" + num);
//		
//		this.notifyAll();
//		
//	}
	
	public  void add() {
		lock.lock(); // 上锁
		// 判断
		try {
			// 使用if 会出现虚假唤醒 问题
			while(num != 0) {
				addLock.await(); // 当前线程沉睡 
			}
			
			// 操作 
			num++ ;
			System.out.println(Thread.currentThread().getName() + "加操作  数值为 ：" + num);
		
			devLock.signal();// 唤醒devLock 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();// 解锁 
		}
		
	}
	
	
	public  void dev()  {
		lock.lock();
		
		try {
			while(num != 1) {
				devLock.await();
			}
			
			--num;
			System.out.println(Thread.currentThread().getName() + "减操作 数值为 ：" + num);
			
			
			addLock.signal();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}

	
	
	
	

}
