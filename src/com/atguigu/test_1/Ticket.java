package com.atguigu.test_1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {

	// 线程 操作  资源类  
	// 判断 干活  通知 
	private int num = 30;
	
	Lock lock = new ReentrantLock();
	
	//	Condition c = lock.newCondition();
	
	
	public  void sale() {
		lock.lock();
		
		try {
			if(num >0) {
				
				System.out.println("窗口为 : " + Thread.currentThread().getName() + " 票号为 : " +num + " 余票 : " + ( --num) + " 张" );
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
		
	}
	
}
