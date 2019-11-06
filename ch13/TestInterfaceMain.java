package ch13;

/**
 * 接口
 */
interface TestInter {

    /** 默认方法2 */
    default void test() {
        System.out.println("TestInter 的默认方法 test()");
    }

}

/**
 * 接口2继承接口TestInter，重写test()方法
 */
 interface TestInter2 extends TestInter {

    /** 默认方法2 */
    default void test() {
        System.out.println("TestInter2 的默认方法 test()");
    }

}

 /*
  * 同时实现了两个接口，这两个接口都包含相同的默认方法，编译报错
  * 必须重写接口相同的默认方法才可以
  */

 
/**
 * 同时实现了两个接口，这两个接口有继承关系，且都包含相同的默认方法，子接口的默认方法
 */
class TestInterface implements TestInter,TestInter2{
	/*@Override
    public void test() {
        TestInter.super.test();
    }*/
}


/**
 * Main方法
 */
public class TestInterfaceMain {

    public static void main(String[] args) {

        TestInterface test = new TestInterface();
        test.test(); // TestInter2 的默认方法 test()

    }
}