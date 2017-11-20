package ch11;

class Parent{
    public void function(){ System.out.println("I am in Parent!");
     }
    }
class Child extends Parent{
	public Child() {
		super();
	}
    public void function(){
        System.out.println("I am in Child!");
     }
}
public class RTpolyTest{
      public static void main(String args[]){
       Parent pl=new Parent( );
       Parent p2=new Child( );
          pl.function( );
          p2.function( );  //编译出错
     }
}
