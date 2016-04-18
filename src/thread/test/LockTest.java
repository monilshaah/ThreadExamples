package thread.test;

import java.util.concurrent.locks.*;

public class LockTest {
	public static void main(String[] args) {
//		ReentrantLockTest rlt = new ReentrantLockTest();
//		ReentrantReadWriteLockTest rlt = new ReentrantReadWriteLockTest();
		ConditionTest ct = new ConditionTest();
		ConditionTest ct2 = ct;
		ConditionTest ct3 = new ConditionTest();
		Thread t1 = new Thread(ct,"one");
		Thread t2 = new Thread(ct2,"two");
		Thread t3 = new Thread(ct3,"three");
//		Thread t3 = new Thread(rlt,"three");
		t1.start();
		t2.start();
		t3.start();
	}
}
