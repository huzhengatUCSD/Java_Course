package ch21;

public class TaskThreadDemo {
  public static void main(String[] args) {
    // Create tasks
    Runnable printA = new PrintChar('a', 100);
    Runnable printB = new PrintChar('b', 100);
    Runnable print100 = new PrintNum(100);

    // Create threads
    Thread thread1 = new Thread(printA);
    Thread thread2 = new Thread(printB);
    Thread thread3 = new Thread(print100);
    
    System.out.println(thread1.getPriority());
    System.out.println(thread2.getPriority());
    System.out.println(thread3.getPriority());

    thread3.setPriority(Thread.MAX_PRIORITY);
    // Start threads
    thread3.start();
    thread2.start();
    thread1.start();
    printB.run();
    
    
  }
}

// The task for printing a specified character in specified times
class PrintChar implements Runnable {
  private char charToPrint; // The character to print
  private int times; // The times to repeat

  /** Construct a task with specified character and number of
   *  times to print the character
   */
  public PrintChar(char c, int t) {
    charToPrint = c;
    times = t;
  }

  @Override /** Override the run() method to tell the system
   *  what the task to perform
   */
  public void run() {
    for (int i = 0; i < times; i++) {
      System.out.print(charToPrint);
    }
  }
}

// The task class for printing number from 1 to n for a given n
class PrintNum implements Runnable {
  private int lastNum;

  /** Construct a task for printing 1, 2, ... i */
  public PrintNum(int n) {
    lastNum = n;
  }

  @Override /** Tell the thread how to run */
  /*public void run() {
    for (int i = 1; i <= lastNum; i++) {
      System.out.print(" " + i);
      
      try {
          if (i >=10) Thread.sleep(20);
        }
        catch (InterruptedException ex) {
        }

    }
  }
  */
  
  //@Override *//** Tell the thread how to run *//*
  public void run() {
	  Thread thread4 = new Thread(
	new PrintChar('c', 40));
	  thread4.start();
	  try {
	    for (int i = 1; i <= lastNum; i++) {
	      System.out.print(" " + i);
	      if (i == 10) thread4.join();
	    }
	  }
	  catch (InterruptedException ex) {
	  }
	}


  
}
