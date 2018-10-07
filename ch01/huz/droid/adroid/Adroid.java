package ch01.huz.droid.adroid;

/**
 * <p><strong>Adroid</strong>A Droid able to do something</p>
 * @author Hu Zheng
 * @version 1.0
 * @since 1.0
 */
public class Adroid{
  /**
   * Name of the Droid
   */
  private String name;

  public Adroid(String name){
    this.name=name;
  }
  
  /**
   * Droid speaks
   */
  public void speak(){
    System.out.println("My Name is: " + name);
  }  
  
  /**
   * Droid walks
   */
  public void walk(){
    System.out.println("I am walking towards "+ name +"\'s home");
 
  }  
}

