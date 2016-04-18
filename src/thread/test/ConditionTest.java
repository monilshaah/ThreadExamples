package thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest implements Runnable{
	Lock lock;
	Condition blockingPool;
	
	ConditionTest() {
		lock = new ReentrantLock();
		blockingPool = lock.newCondition();
	}

	@Override
	public void run() {
		lock.lock();
		try {
			if (Thread.currentThread().getName().equals("two")) {
				System.out.println("two sleeping..");
				Thread.sleep(3000);
				System.out.println("two signaling...");
				blockingPool.signalAll();
			} else if (Thread.currentThread().getName().equals("three")) {
				System.out.println("three sleeping");
//				Thread.sleep(1000);
				System.out.println("three waiting");
//				blockingPool.await();
				System.out.println("three awaked");
			} else {
				System.out.println("one sleeping");
				Thread.sleep(3000);
				System.out.println("one waiting");
				blockingPool.await();
				System.out.println("one awaked");
			}
		} catch(InterruptedException ie) {
			System.out.println("Exception");
		} finally {
			lock.unlock();
		}
		
	}
}
