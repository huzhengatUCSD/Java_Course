package ch21;

public class MachineStartOverriden extends Thread {
	private int a = 0;

	public void start() {
		//super.start();
		run();
	}

	public void run() {
		for (a = 0; a < 50; a++) { // 使用Machine对象的实例变量a
			System.out.println(currentThread().getName() + ":" + a);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String args[]) {
		MachineStartOverriden machine = new MachineStartOverriden();
		MachineStartOverriden machine1 = new MachineStartOverriden();
		
		machine.start();
		machine1.start();
	    machine1.run();
	    
		
	}
}
