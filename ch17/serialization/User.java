package ch17.serialization;

import java.io.*;
public class User implements Serializable {
  private String name;
  private transient String password;
 // private String password;
  public User(String name, String password) {
    this.name=name;
    this.password=password;
  }
  public String toString() {
    return name + " " + password;
  }
  
   public static void main(String[] args) throws Exception{
    User user = new User("Tom", "123456");
    System.out.println("Before Serialization:" + user);
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
   
    //��User�������л���һ���ֽڻ�����
    ObjectOutputStream o =new ObjectOutputStream(buf);
    o.writeObject(user);
      
    //���ֽڻ����з����л�User����
    ObjectInputStream in =new ObjectInputStream(
          new ByteArrayInputStream(buf.toByteArray()));
    user= (User)in.readObject();
    System.out.println("After Serialization:" + user);
   }
}



