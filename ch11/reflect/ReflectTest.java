package ch11.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;


public class ReflectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printFields();
		printMethods();
		try {
			getPrivateMethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			modifyPrivateFiled();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			modifyFinalFiled();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 通过反射获取类的所有变量
	 */
	private static void printFields(){
	    //1.获取并输出类的名称
	    Class mClass = SonClass.class;
	    System.out.println("类的名称：" + mClass.getName());
	    System.out.println("=========");
	    //2.1 获取所有 public 访问权限的变量
	    // 包括本类声明的和从父类继承的
	    Field[] fields1 = mClass.getFields();
	 
	    //2.2 获取所有本类声明的变量（不问访问权限）
	    Field[] fields2 = mClass.getDeclaredFields();
	 
	    //3. 遍历变量并输出变量信息
	    for (Field field :
	            fields1) {
	        //获取访问权限并输出
	        int modifiers = field.getModifiers();
	        System.out.print(Modifier.toString(modifiers) + " ");
	        //输出变量的类型及变量名
	        System.out.println(field.getType().getName()
	                 + " " + field.getName());
	    }
	    System.out.println("=========");
	    for (Field field :
            fields2) {
        //获取访问权限并输出
        int modifiers = field.getModifiers();
        System.out.print(Modifier.toString(modifiers) + " ");
        //输出变量的类型及变量名
        System.out.println(field.getType().getName()
                 + " " + field.getName());
    }
	}
	/**
	 * 通过反射获取类的所有方法
	 */
	private static void printMethods(){
	    //1.获取并输出类的名称
	    Class mClass = SonClass.class;
	    System.out.println("类的名称：" + mClass.getName());
	 
	    //2.1 获取所有 public 访问权限的方法
	    //包括自己声明和从父类继承的
	    //Method[] mMethods = mClass.getMethods();
	 
	    //2.2 获取所有本类的的方法（不问访问权限）
	    Method[] mMethods = mClass.getDeclaredMethods();
	 
	    //3.遍历所有方法
	    for (Method method :
	            mMethods) {
	        //获取并输出方法的访问权限（Modifiers：修饰符）
	        int modifiers = method.getModifiers();
	        System.out.print(Modifier.toString(modifiers) + " ");
	        //获取并输出方法的返回值类型
	        Class returnType = method.getReturnType();
	        System.out.print(returnType.getName() + " "
	                + method.getName() + "( ");
	        //获取并输出方法的所有参数
	        Parameter[] parameters = method.getParameters();
	        for (Parameter parameter:
	             parameters) {
	            System.out.print(parameter.getType().getName()
	                    + " " + parameter.getName() + ",");
	        }
	        //获取并输出方法抛出的异常
	        Class[] exceptionTypes = method.getExceptionTypes();
	        if (exceptionTypes.length == 0){
	            System.out.println(" )");
	        }
	        else {
	            for (Class c : exceptionTypes) {
	                System.out.println(" ) throws "
	                        + c.getName());
	            }
	        }
	    }
	}

	/**
	 * 访问对象的私有方法
	 * 为简洁代码，在方法上抛出总的异常，实际开发别这样
	 */
	private static void getPrivateMethod() throws Exception{
	    //1. 获取 Class 类实例
	    SonClass sonClass = new SonClass();
	    Class mClass = sonClass.getClass();
	 
	    //2. 获取私有方法
	    //第一个参数为要获取的私有方法的名称
	    //第二个为要获取方法的参数的类型，参数为 Class...，没有参数就是null
	    //方法参数也可这么写 ：new Class[]{String.class , int.class}
	    Method privateMethod =
	            mClass.getDeclaredMethod("privateMethod", String.class, int.class);
	 
	    //3. 开始操作方法
	    if (privateMethod != null) {
	        //获取私有方法的访问权
	        //只是获取访问权，并不是修改实际权限
	        privateMethod.setAccessible(true);
	 
	        //使用 invoke 反射调用私有方法
	        //privateMethod 是获取到的私有方法
	        //testClass 要操作的对象
	        //后面两个参数传实参
	        privateMethod.invoke(sonClass, "Java Reflect ", 666);
	    }
	}
	/**
	 * 修改对象私有变量的值
	 * 为简洁代码，在方法上抛出总的异常
	 */
	private static void modifyPrivateFiled() throws Exception {
	    //1. 获取 Class 类实例
	    SonClass sonClass = new SonClass();
	    Class mClass = sonClass.getClass();
	 
	    //2. 获取私有变量
	    Field privateField = mClass.getDeclaredField("MSG");
	 
	    //3. 操作私有变量
	    if (privateField != null) {
	        //获取私有变量的访问权
	        privateField.setAccessible(true);
	 
	        //修改私有变量，并输出以测试
	        System.out.println("Before Modify：MSG = " + sonClass.getMsg());
	 
	        //调用 set(object , value) 修改变量的值
	        //privateField 是获取到的私有变量
	        //testClass 要操作的对象
	        //"Modified" 为要修改成的值
	        privateField.set(sonClass, "Modified");
	        System.out.println("After Modify：MSG = " + sonClass.getMsg());
	    }
	}

	/**
	 * 修改对象私有常量的值
	 * 为简洁代码，在方法上抛出总的异常，实际开发别这样
	 */
	private static void modifyFinalFiled() throws Exception {
	    //1. 获取 Class 类实例
	    SonClass sonClass = new SonClass();
	    Class mClass = sonClass.getClass();
	 
	    //2. 获取私有常量
	    Field finalField = mClass.getDeclaredField("FINAL_VALUE");
	 
	    //3. 修改常量的值
	    if (finalField != null) {
	 
	        //获取私有常量的访问权
	        finalField.setAccessible(true);
	 
	        //调用 finalField 的 getter 方法
	        //输出 FINAL_VALUE 修改前的值
	        System.out.println("Before Modify：FINAL_VALUE = "
	                + finalField.get(sonClass));
	 
	        //修改私有常量
	        finalField.set(sonClass, "Modified");
	 
	        //调用 finalField 的 getter 方法
	        //输出 FINAL_VALUE 修改后的值
	        System.out.println("After Modify：FINAL_VALUE = "
	                + finalField.get(sonClass));
	 
	        //使用对象调用类的 getter 方法
	        //获取值并输出
	        System.out.println("Actually ：FINAL_VALUE = "
	                + sonClass.getFinalValue());
	    }
	}




}
