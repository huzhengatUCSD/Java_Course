package ch09;
/**
 * @author huihuijor 
 * 来源：CSDN 
 * 原文：https://blog.csdn.net/huihuijor/article/details/38902893 
 */
public class StaticVarLoadTest {

	public static void main(String[] args) {
		System.out.println("StaticVarLoadTest");
		printStaticVar();
	}
	
	private static void printStaticVar() {
		System.out.println(StaticVar.FIANL_VAR);
		System.out.println(StaticVar.VAR);
	}


}
