package thread.test;

public class ThreadTest {
	public static void main(String[] args) {
		ThreadRunnable tr1 = new ThreadRunnable(new StringBuffer("A"));
		ThreadRunnable tr2 = new ThreadRunnable(new StringBuffer("W"));
		Thread t1 = new Thread(tr1,"One");
		Thread t2 = new Thread(tr1,"Two");
		Thread t3 = new Thread(tr2,"Three");
		t1.start();
		t2.start();
		t3.start();
		/*MyThread mt = new MyThread("Monil");
		mt.start();*/
	}
}


