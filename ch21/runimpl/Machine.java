package ch21.runimpl;

public class Machine implements Runnable {
	private int a = 0;

	public void run() {
		for (a = 0; a < 50; a++) {
			System.out.println(Thread.currentThread().getName() + ":" + a);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String args[]) {
		Machine machine1 = new Machine();
		Machine machine2 = new Machine();
		Thread t1 = new Thread(machine1);
		Thread t2 = new Thread(machine2);
		t1.start();
		t2.start();
	}
}
