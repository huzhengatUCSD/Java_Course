package ch09;

public class BaseClass {
    //私有属性
    private String user;
    private String name;
    //私有方法
    private void privateMethod(){
        System.out.println("私有方法调用成功！");
    }
  //省略get 和set
    public void setName(String nstr) {
    	name=nstr;
    }
    
    public void setUser(String ustr) {
    	user=ustr;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getUser() {
    	return user;
    }
}
   
