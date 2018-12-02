package ch12;

public class MultiExceptionTest
{
	public static void main(String[] args)
	{
		try
		{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println("您输入的两个数相除的结果是：" + c );
			//throw new Exception("customised exception!");
		}
		catch (IndexOutOfBoundsException|NumberFormatException
			|ArithmeticException ie)
		{
			System.out.println("程序发生了数组越界、数字格式异常、算术异常之一");
//			捕捉多异常时，异常变量默认有final修饰，
//			所以下面代码有错：
//			ie = new ArithmeticException("test");  // ①
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage()+"等未知异常");
			// 捕捉一个类型的异常时，异常变量没有final修饰
			// 所以下面代码完全正确。
			e = new RuntimeException("test");    // ②
		}
	}
}
 
 

