package thread.test;

import java.util.concurrent.locks.*;

public class ReentrantReadWriteLockTest implements Runnable {
	ReentrantReadWriteLock lock;
	
	public ReentrantReadWriteLockTest() {
		lock = new ReentrantReadWriteLock();
	}
	
	
	@Override
	public void run() {
		writeTest();
		readTest();
	}
	
	public void writeTest() {
		System.out.println(Thread.currentThread().getName()+" waiting for write lock...");
		lock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+" acquired write lock!");
			Thread.sleep(3000);
		} catch(InterruptedException ie) {
			System.out.println(Thread.currentThread().getName()+" exception!");
		} finally {
			System.out.println(Thread.currentThread().getName()+" releasing write lock!");
			lock.writeLock().unlock();
		}
	}

	public void readTest() {
		System.out.println(Thread.currentThread().getName()+" waiting for read lock...");
		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+" acquired read lock!");
			Thread.sleep(3000);
		} catch(InterruptedException ie) {
			System.out.println(Thread.currentThread().getName()+" exception!");
		} finally {
			System.out.println(Thread.currentThread().getName()+" releasing read lock!");
			lock.readLock().unlock();
		}
	}
}
