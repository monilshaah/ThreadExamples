package thread.test;

/*public class Reader {
	public static void main(String[] args){
        Calc b = new Calc();
        b.start();
 
        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
 
            System.out.println("Total is: " + b.total);
        }
    }
}*/

public class Reader extends Thread {
	Calc c;
	
	Reader(Calc calc) {
		c=calc;
	}
	
	public void run() {
		synchronized(c) {
			try {
				System.out.println("Waiting for calculation...");
				c.wait(3000);
			} catch (InterruptedException ie) {
				System.out.println("Total::"+c.total);
			}
			//System.out.println("out of wait!!!"+c.total);
		}
	}
	
	public static void main(String[] args) {
		Calc c1 = new Calc();
		new Reader(c1).start();
		//new Reader(c1).start();
		//new Reader(c1).start();
		new Thread(c1).start();
	}
}
