package ch09;

public class TestStaticBlock {
    static int i;
    int j;
    static {
        i = 10;
        System.out.println("static block called ");
    }
    
    // Initializer block starts..
    {
        // This code is executed before every constructor.
        System.out.println("Common part of constructors invoked !!");
    }
    
    // Initializer block ends    
    TestStaticBlock(){
        System.out.println("No-arg Constructor called");
    }
    
    TestStaticBlock(int arg){
        System.out.println("with-arg Constructor called");
    }
    
    public static void main(String args[]) {
 
       // Although we have two objects, static block is executed only once.
    		//TestStaticBlock.i=20;
    	    TestStaticBlock t1 = new TestStaticBlock();
    		TestStaticBlock t2 = new TestStaticBlock(0);
    }
}