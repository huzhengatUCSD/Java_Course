package ch10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexDemo {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
 
        /*
         * 正则表达式对字符串的常见操作:
         * 1, 匹配
         *      其实使用的就是String类中matches方法。
         * 
         * 2，切割。
         *      其实使用的就是String类中的split方法。 
         * 
         * 3，替换。
         *      其实使用的就是String类中的replaceAll()方法。
         * 
         * 4，获取。
         *      
         */
         
        functionDemo_3();
        checkQQ();
    }
    

    /*
     * 需求：定义一个功能对QQ号进行校验。
     * 要求：长度5~15，只能是数字，0不能开头
     */
	public static void checkQQ() {
		String qq = "123k4567";

		String regex = "[1-9][0-9]{4,14}";// 正则表达式

		boolean b = qq.matches(regex);
		System.out.println(qq + ":" + b);

		String str = "aoooooooob";
		String reg = "ao{4,6}b";
		b = str.matches(reg);
		System.out.println(str + ":" + b);
		
		/*
		
		int len = qq.length();

		if (len >= 5 && len <= 15) {

			if (!qq.startsWith("0")) {
				try {
					long l = Long.parseLong(qq);

					System.out.println(l + ":正确");
				} catch (NumberFormatException e) {
					System.out.println(qq + ":含有非法字符");
				}

			} else {
				System.out.println(qq + ":不能0开头");
			}
		} else {
			System.out.println(qq + ":长度错误");
		}*/

	}
     
    /*
     * 获取 
     * 将正则规则进行对象的封装。 
     * Pattern p = Pattern.compile("a*b");
     *  //通过正则对象matcher方法字符串相关联。获取要对字符串操作的匹配器对象Matcher .
     * Matcher m = p.matcher("aaaaab");
     * //ͨ通过Matcher匹配器对象的方法对字符串进行操作
     * boolean b = m.matches();
     * 
     * 
     */
    public  static void functionDemo_4() {
         
        String str = "da jia hao,ming tian bu fang jia!";
         
        String regex = "\\b[a-z]{3}\\b";
         
        //1,将正则封装成对象
        Pattern p = Pattern.compile(regex);
        //2, 通过正则对象获取匹配器对象 
        Matcher m = p.matcher(str);
         
        //使用Matcher对象的方法对字符串进行操作
        //既然要获取三个字母组成的单词 
        //查找。 find();
        System.out.println(str);
        while(m.find()){
            System.out.println(m.group());//获取匹配的子序列
             
            System.out.println(m.start()+":"+m.end());
        }
    }
 
    /*
     * 替换 
     */
    public static void functionDemo_3() {
         
        String str = "zhangsanttttxiaoqiangmmmmmmzhaoliu";
         
        str = str.replaceAll("(.)\\1+", "$1");
         
        System.out.println(str);
         
        String tel = "15800001111";//158****1111;
         
        tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
         
        System.out.println(tel);
         
    }
 
    /*
     * 切割
     * 
     * 组：((A)(B(C))) 
     */
    public static void functionDemo_2(){
 
        String str = "zhangsanttttxiaoqiangmmmmmmzhaoliu";
         
        String[] names = str.split("(.)\\1+");//str.split("\\.");
         
        for(String name : names){
            System.out.println(name);
        }
         
    }
    /*
     * 演示匹配。 
     */
    public static void functionDemo_1(){
     
         
        //匹配手机号码是否正确 
        String tel = "15800001111";
         
        String regex = "1[358]\\d{9}";   
         
        boolean b = tel.matches(regex);
        System.out.println(tel+":"+b);
    }
     
 
}