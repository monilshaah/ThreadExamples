package thread.test;

public class Calc implements Runnable {
	int total=0;
	
	@Override
	public void run() {
		synchronized(this) {
			System.out.println("Calculating total...");
			for(int i=0; i<100; i++) {
				total += i;
			}
			notifyAll();
		}
		
	}
}
