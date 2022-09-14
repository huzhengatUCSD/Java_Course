package ch09;

public class TestInitializerBlock {
	 // Initializer block starts..
    {
        // This code is executed before every constructor.
        System.out.println("Common part of constructors invoked !!");
    }
    // Initializer block ends    

    TestInitializerBlock(){
        System.out.println("No-arg Constructor called");
    }
    TestInitializerBlock(int x)
    {
        System.out.println("Parametrized Constructor invoked");
    }
    public static void main(String args[]) {
 
       // Although we have two objects, static block is executed only once.
    		TestInitializerBlock t1 = new TestInitializerBlock();
    		TestInitializerBlock t2 = new TestInitializerBlock(0);
    }
}