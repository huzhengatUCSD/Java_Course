package ch21;

public class ExtendedThread extends Thread {
	
	public void run() {
		for (int a = 0; a < 50; a++) {
			System.out.println(currentThread().getName() + ":" + a);
			try {
				sleep(100); // 给其他线程运行的机会
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String args[]) {
		ExtendedThread machine1 = new ExtendedThread(); // 创建第一个Machine对象
		ExtendedThread machine2 = new ExtendedThread(); // 创建第二个Machine对象
		machine1.start(); // 启动第一个Machine线程
		machine2.start(); // 启动第二个Machine线程
		machine1.run(); // 主线程执行第一个Machine对象的run()方法 主线程方法栈加入一个栈帧置顶！
	}
}