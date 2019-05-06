package com.atguigu.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

	Lock lock = new ReentrantLock();
	Condition t1 = lock.newCondition();
	Condition t2 = lock.newCondition();
	
	private int num = 1 ;
	
	
	public void print() {
		lock.lock();
		try {
			for(int i = 1;i<= 52; i++) {
				while(num %3 == 0) {
					t1.await();
				}
				
				System.out.print(i);
				num++;
				// 通知 
				t2.signal();
			}
			
			
		} catch (Exception e) {
		}finally {
			lock.unlock();
		}
	}
	
	public void printAZ() {
		lock.lock();
		// 65～90为26个大写英文字母  A 65 ~ Z 90
		try {
		
			for(int i= 65; i<= 90 ; i++) {
				while(num %3 != 0 ) {
					t2.await();
				}
				// 干活 
				System.out.print( (char)(i) );
				num++;
				// 通知 
				t1.signal();
			}
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
	
	
	
	
}
