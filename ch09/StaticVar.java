package ch09;
/**
 *  作者：huihuijor 
 *  来源：CSDN 
 *  原文：https://blog.csdn.net/huihuijor/article/details/38902893 
 * */
public class StaticVar {
	static {
		System.out.println("Class4Load loaded...");
	}
	
	public static String VAR = "VAR_In_LOAD";
	
	public static final String FIANL_VAR = "FIANL_VAR_In_LOAD";

}
