package com.atguigu.resource;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个线程之间按顺序调用 实现 A->B->C 三个线程启动,要求如下: AA打印5次,BB打印10次,CC打印15次 接着
 * AA打印5次,BB打印10次,CC打印15次 .....循环10轮
 * 
 * @author 83721 线程 操作 资源类
 * 
 *         判断 干活 通知
 */
public class Resourse {

	private int num = 1;

	Lock lock = new ReentrantLock();
	Condition c5 = lock.newCondition();
	Condition c10 = lock.newCondition();
	Condition c15 = lock.newCondition();

	public void print5(int loopNum) {
		lock.lock();
		// 判断
		try {
			while (num != 1) {
				c5.await();
			}
			for(int i = 1;i<=5;i++) {
				// 干活
				System.out.println(Thread.currentThread().getName()+ " 数字为 :" + i + " 第" + loopNum + "轮");
				
			}
			// 通知
			++num;
			c10.signal();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}

	}

	public void print10(int loopNum) {
		lock.lock();
		try {
			// 判断
			while (num != 2) {
				c10.await();
			}

			// 干活
			for(int i = 1 ;i <= 10; i++) {
				
				System.out.println(Thread.currentThread().getName() + " 数字为 :" + i+ " 第" + loopNum + "轮");
			}
			// 通知
			++num;
			c15.signal();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}

	public void print15(int loopNum) {
		lock.lock();

		try {
			// 判断
			while (num != 3) {
				c15.await();
			}
			// 干活
			for(int i = 1; i<= 15; i++) {
				System.out.println(Thread.currentThread().getName()+" 数字为 :"+i + " 第" + loopNum + "轮");
			}
			// 通知
			num = 1;
			c5.signal();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}

}
