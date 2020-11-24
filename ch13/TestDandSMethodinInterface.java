package ch13;

interface MyInterfaceA{  
	String USER_NAME = "铮";
	/* Already existing public and abstract method
     * We must need to implement this method in 
     * implementation classes.
     */
    void existingMethod(String str); 
	
    /* This is a default method so we need not
     * to implement this method in the implementation 
     * classes  
     */
    default void newMethod(){  
        System.out.println("Newly added default method in myinterfaceA");  
    }  
    /* This is a static method. Static method in interface is
     * similar to default method except that we cannot override 
     * them in the implementation classes.
     * Similar to default methods, we need to implement these methods
     * in implementation classes so we can safely add them to the 
     * existing interfaces.
     */
    static void anotherNewMethod(){
    	System.out.println("Newly added static method in myinterfaceA");
    }
    
     
} 

/**
 * 继承接口MyInterfaceA
 */
interface MyInterfaceB extends MyInterfaceA {

    /** 重写父接口的newMethod方法,USER_NAME常量可以直接被使用 */
    default public void newMethod() {
        System.out.println("MyInterfaceB 的默认方法 newMethod() ");
    }


}

interface MyInterfaceC {
	//父接口的同样的default method
    default public void newMethod() {
        System.out.println("MyInterfaceC 的默认方法 newMethod() ");
    }


}


public class TestDandSMethodinInterface implements MyInterfaceA, MyInterfaceB {
	public void existingMethod(String str){           
        System.out.println("String is: "+str);  
    }  
    public void disp(String str){
    	System.out.println("String is: "+str); 
    }
    //Implementation of duplicate default method
    public void newMethod(){ 
    	
    	MyInterfaceB.super.newMethod();
        System.out.println("Re-Implementation of default method at concrete class"); 
    } 
    
    public static void main(String[] args) {  
    	MyInterfaceA obj = new TestDandSMethodinInterface();
    	
    	//calling the default method of interface
        obj.newMethod();     
       
        //calling the static method of interface
        MyInterfaceA.anotherNewMethod();
        
        //calling the abstract method of interface
        obj.existingMethod("Java 8 is easy to learn"); 
        
        //testing if static method in interface can be inherited
        //MyInterfaceB.anotherNewMethod();
        //testing if static fields in interface can be inherited
        System.out.println(MyInterfaceA.USER_NAME);
  
    }  

}
