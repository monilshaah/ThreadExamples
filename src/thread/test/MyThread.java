package thread.test;

public class MyThread extends Thread {
	MyThread() {
		super();
	}
	
	MyThread(String name) {
		super(name);
	}
	
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("Thread is running - "+i+" "+this);
			if (i==50)
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public String toString() {
		return Thread.currentThread().getName();
	}
}
