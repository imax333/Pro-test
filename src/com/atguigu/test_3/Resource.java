package com.atguigu.test_3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
	
	private int  num = 1;

	Lock lock = new ReentrantLock();
	Condition c5  = lock.newCondition();
	Condition c10  = lock.newCondition();
	Condition c15  = lock.newCondition();
	
	
	public void print5(int loopNum) {
		lock.lock();
		try {
			while(num != 1) {
				c5.await();
			}
			for(int i = 1;i<=5;i++) {
				System.out.println(Thread.currentThread().getName() +" 第 " + loopNum + " 轮 " + " 值为 : " + i);
			}
			++num ;
			c10.signal();
			
		} catch (Exception e) {
		}finally {
			lock.unlock();
		}
	}
	
	public void print10(int loopNum) {
		lock.lock();
		try {
			while(num != 2) {
				c10.await();
			}
			for(int i = 1;i<=10;i++) {
				System.out.println(Thread.currentThread().getName() +" 第 " + loopNum + " 轮 " + " 值为 : " + i);
			}
			++num ;
			c15.signal();
		} catch (Exception e) {
		}finally {
			lock.unlock();
		}
	}
	
	public void print15(int loopNum) {
		lock.lock();
		try {
			while(num != 3) {
				c15.await();
			}
			for(int i = 1;i<=15;i++) {
				System.out.println(Thread.currentThread().getName() +" 第 " + loopNum + " 轮 " + " 值为 : " + i);
			}
			num=1 ;
			c5.signal();
		} catch (Exception e) {
		}finally {
			lock.unlock();
		}
	}
	
	
	
	
}
