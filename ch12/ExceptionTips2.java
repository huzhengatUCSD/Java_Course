package ch12;
import java.util.*;
import java.io.*;
/*
不要过分的细化异常
      用来演示corejava中提到的第二个技巧，代码中给出了两种异常的使用方法  
      设置了两种不同异常。分别为从空栈中弹出数据的异常以及读取当前目录下读取一个并不存在文件
      的异常（循环读取文件实际上是一种错误的做法，这里仅用于代码的演示），以达到所要表达的意思。
       * 第一种：将每一条语句都分装一个独立的try语句块中  
      	     这种编程方式将导致代码量的急剧膨胀，对于不确定的语句都要进行一次try-catch操作。
      	     在这里，由于try指令在循环内部，当系统检测到异常并抛出后，程序会继续执行，并进行
      	     下一个异常检测。最后的输出结果表明，程序一共循环了100次，并在每一次循环中都抛出
      	     检测到异常后的输出。  
       * 第二种：将整个任务包装在一个try语句块中  
             这种编程方式将所有要检测的异常放在同一个try语句块下，当任何一个操作出现问题时，
             会中断接下来的操作，系统检测到当前的异常并执行异常操作语句。  
        
    可以看出，第二种做法代码看起来也更加的清晰，而且也便于程序的修改，这也满足了异常处理机制的一个目标，将正常处理与错误处理分开。

*/
public class ExceptionTips2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		int n = 0;

		/*设置了两种不同异常。分别为从空栈中弹出数据的异常以及读取当前目录下
		读取一个并不存在文件的异常（循环读取文件实际上是一种错误的做法，
		这里仅用于代码的演示），以达到书中所要表达的意思。*/

		/*第一种异常检测技巧，每一条语句都分装在一个独立的try语句块中
		在这里，由于try指令在循环内部，当系统检测到异常并抛出后，程序会继续执行，
		并进行下一个异常检测。最后的输出结果表明，程序一共循环了100次，
		并在每一次循环中都抛出检测到异常后的输出。*/
		for(int j = 0; j < 100; j++)
		{
			try {
				n = s.pop();   //在这里，希望从栈中弹出100个数值
			}catch(EmptyStackException e)
			{
				System.out.println("1.stack was empty");
			}
				
			try {
				//循环执行FileReader不是很恰当，这里仅用来说明问题。
				FileReader fr = new FileReader("aa.txt");//报错,处理找不到文件异常
			}catch(IOException e)
			{
				System.out.println("1.problem in opening file");
			}
		}
		
			
			
		Stack<Integer> t = new Stack<Integer>();
		/*第二种异常检测方式，将整个任务包装在一个try语句块中。结构更加清晰这种编程
		方式将所有要检测的异常放在同一个try语句块下，当任何一个操作出现问题时，会中断
		接下来的操作，系统检测到当前的异常并执行异常操作语句。最后输出为抛出一次空栈异常*/
		try {
			for(int r = 0; r < 100; r++)
			{
				int i = 0;
				i = t.pop();//遇到错误，跳入相应catch，执行完catch后结束，不再执行错误的下一句
				FileReader fr = new FileReader("d:\\aa.txt");//报错    处理找不到文件异常
			}
		}

		catch(EmptyStackException e)
		{
			System.out.println("2.stack was empty");
		}catch(IOException e)
		{
			System.out.println("2.problem in opening file");
		}
		
	}
}
