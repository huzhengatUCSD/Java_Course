package ch01.huz.droid.adroid.smartdroid;

import ch01.huz.droid.adroid.Adroid;

/**
 * <p><strong>SmartDroid</strong> Smart Droid, being able to react to input</p>
 * @author Hu Zheng
 * @version 1.0
 * @since 1.0
 */
public class SmartDroid extends Adroid{
  
  /**
   * Smart Droid could set default words to speak
   */
  protected String word;
  
  /**
   * Create a smart Droid without setting default words to speak
   * @param name SmartDroid's name
   */  
  public SmartDroid(String name){
    super(name);
  };

  /**
   * Create a smart Droid setting default words to speak 
   * @param name SmartDroid's name
   * @param word default words to speak
   */  
  public SmartDroid(String name,String word){
    super(name); 
    this.word=word;
  };
 
  /**
   * setting default words to speak
   * @param word default words to speak
   * @since 1.0
   */ 
  public void setWord(String word){
    this.word=word;
  }  

  /**
   * <ul>
   * <li>if{@link #word word member variables}is not null, invoke{@link #speak(String) speak(String) method}</li>
   * <li>if{@link #word word member variables}is null, invoke{@link ch0102.huz.droid.adroid.Adroid #speak() super.speak() method}</li>
   * </ul>
   */ 
  public void speak(){
     if(this.word!=null){
       try{
         speak(word);
       }catch(Exception e){}  
     }
     else
       super.speak();
  }
  
   /**
   * @param word setting words to speak
   * @return the words spoken by droid
   * @exception Exception if word parameter is null, throw Exception
   */ 
  public String speak(String word) throws Exception{
    if(word==null)
       throw new Exception("what to say");
    System.out.println(word);
    return word;
  }


}