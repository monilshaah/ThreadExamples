package thread.test;

public class ThreadRunnable implements Runnable {
	private StringBuffer sb;
	private static int num;
	
	static {
		num = 99999;
	}
	
	ThreadRunnable() {
		super();
	}
	
	ThreadRunnable(StringBuffer sb) {
		this.sb = sb;
	}
	
	public static synchronized void getNum() {
		System.out.println(Thread.currentThread().getName()+" got lock on getNum()!!!*** num="+num+" ... sleeping for 5 secs!!!");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Awaked from sleep***");
	}
	
	@Override
	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName()+" got lock!!!*** sb="+sb);
			for (int i=0; i< 100; i++) {
				/*try {
					if (i == 50) {
						System.out.println("i==50");
						MyThread t = new MyThread("Inner");
						t.start();
						t.join(300);
					}
				} catch(InterruptedException ie) {
					System.out.println(Thread.currentThread().getName()+" is interrupted!!!");
				}*/
//				System.out.println(Thread.currentThread().getName()+" "+sb+" "+i);
			}
			int sbVal = sb.charAt(0);
			sbVal += 1;
			char sbChar = (char) sbVal;
			sb.setCharAt(0, sbChar);
			System.out.println(Thread.currentThread().getName()+" getting lock on getNum()*** sb="+sb);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getNum();
		}
	}
	
}
