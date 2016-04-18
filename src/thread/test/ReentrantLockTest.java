package thread.test;

import java.util.concurrent.locks.*;

public class ReentrantLockTest implements Runnable {
	Lock lock;
	
	ReentrantLockTest() {
		lock = new ReentrantLock();
	}
	
	/*@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" waiting for lock...");
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName()+" acquired lock...!!!");
			Thread.sleep(2000);
		} catch(InterruptedException ie) {
			System.out.println(Thread.currentThread().getName()+" exception!");
		} finally {
			System.out.println(Thread.currentThread().getName()+" Releasing lock!!!");
			lock.unlock();
		}		
	}*/
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" trying for lock...");
		boolean locked = lock.tryLock();
		if (locked) {
			try {
				System.out.println(Thread.currentThread().getName()+" acquired lock...!!!");
				Thread.sleep(2000);
			} catch(InterruptedException ie) {
				System.out.println(Thread.currentThread().getName()+" exception!");
			} finally {
				System.out.println(Thread.currentThread().getName()+" Releasing lock!!!");
				lock.unlock();
			}
		}
		System.out.println("after if...");
	}
}
