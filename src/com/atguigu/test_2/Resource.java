package com.atguigu.test_2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.atguigu.callable.MyThread;

public class Resource {
	
	// 现有两个线程,可以操作初始值为零的一个变量.实现一个线程对变量加1,一个线程对该变量减1,交替10轮
	
	private int num = 1;
	
	Lock lock = new ReentrantLock();
	Condition c1 = lock.newCondition();
	Condition c2 = lock.newCondition();
	
	public void add(int loopNum) {
		lock.lock();
		
		try {
			// 判断
			while(num != 1) {
				c1.await();
			}
			// 干活
			System.out.println(Thread.currentThread().getName() +"第"+loopNum+ "轮" + " num值为: " + num );
			
			// 通知
			num--;
			c2.signal();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
	
	
	public void dev (int loopNum) {
		
		lock.lock();
		try {
			while(num != 0) {
				c2.await();
			}
			System.out.println(Thread.currentThread().getName() + "第"+loopNum+ "轮" + " num值为: " + num );
			
			num++;
			c1.signal();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.lock();
		}
		
		
	}
	
	
}
