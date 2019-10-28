package ch09;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
 
public class RfPrivateTest {
        public static  void main(String[]args){
 
            BaseClass bc = new BaseClass();
            bc.setUser("originalU");
            bc.setName("originalN");
            //私有属性的访问权限
            try {
                //每一个Field 对象对应一个私有属性，当然也可以用for循环遍历来统一设置私有属性的访问权限
                Field user = bc.getClass().getDeclaredField("user");
                Field name = bc.getClass().getDeclaredField("name");
                user.setAccessible(true);  // 获取user访问权限
                name.setAccessible(true);// 获取name访问权限
                //给user 和 name 赋值
                user.set(bc,"ok");
                name.set(bc,"hh");
                System.out.println("bc.user="+user.get(bc));
                System.out.println("bc.name="+name.get(bc)+"\n===========");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
 
            //获取私有方法的访问权限
            try {
                Method privateMethod = bc.getClass().getDeclaredMethod("privateMethod");
                privateMethod.setAccessible(true);
                privateMethod.invoke(bc);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
}
