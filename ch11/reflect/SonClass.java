package ch11.reflect;

public class SonClass extends FatherClass{
	 
    private String mSonName;
    protected int mSonAge;
    public String mSonBirthday;
    private String MSG="Original";
    private final String FINAL_VALUE;//="FINAL";
    
    public SonClass() {
    	this.FINAL_VALUE="FINAL";
    }
    
    public String getFinalValue() {
    	return FINAL_VALUE;
    }
    
    private void privateMethod(String head, int tail) {
    	//注意是 String  类型的值    	 
    	System.out.println(head+tail);
    }
    
    public String getMsg() {
    	return MSG;
    }
 
    public void printSonMsg(){
        System.out.println("Son Msg - name : "
                + mSonName + "; age : " + mSonAge);
    }
 
    private void setSonName(String name){
        mSonName = name;
    }
 
    private void setSonAge(int age){
        mSonAge = age;
    }
 
    private int getSonAge(){
        return mSonAge;
    }
 
    private String getSonName(){
        return mSonName;
    }
}

