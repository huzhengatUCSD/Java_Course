package ch01.huz.droid.main;
import ch01.huz.droid.adroid.Adroid;
import ch01.huz.droid.adroid.smartdroid.SmartDroid;

/**
 * Droid main program
 * @author Hu Zheng
 * @version 1.0
 * @since 1.0
 */
public class DroidApp{
  
  /**
   * Main method
   */
  public static void main(String args[]){
	Adroid jaja=new Adroid("Jaja");  //Create a Droid Jaja
	Adroid wawa=new Adroid("Wawa");  //Create a Droid Wawa
	Adroid java=new SmartDroid("Java");  //Create a Droid Java
	Adroid jsp =new SmartDroid("Jsp","Human being are the most noticeable threaten to me!");   //create a smart Droid Jsp


    jaja.speak();  //jaja speaks
    wawa.speak();  //wawa speak
    jaja.walk();   //jaja walks
    wawa.walk();   //wawa walks
    java.speak();  //java speaks default words
    java.walk();   //java walks
    jsp.speak();   //jsp speaks the words that was input 
    jsp.walk();    //jsp walks
  
  }
}