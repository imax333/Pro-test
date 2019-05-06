package com.atguigu.test_4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

	Lock lock = new ReentrantLock();

	Condition c1 = lock.newCondition();
	Condition c2 = lock.newCondition();
	private int num = 1;

	public void print() {
		lock.lock();

		try {
			for (int i = 1; i <= 52; i++) {
				while (num % 3 == 0) {
					c1.await();
				}
				System.out.print(i);
				num++;

				c2.signal();
			}
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}

	public void printAZ() {
		lock.lock();
		try {
			for (int i = 65; i <= 90; i++) {
				while (num % 3 != 0) {
					c2.await();
				}

				System.out.print((char) (i));
				num++;
				c1.signal();
			}
		} catch (Exception e) {
		} finally {

		}

	}

}
