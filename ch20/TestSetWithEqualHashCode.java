package ch20;

import java.util.HashSet;

/*
 * 重写equals和hashCode方法
 */
public class TestSetWithEqualHashCode {
    public static void main(String[] args) {
        //创建集合对象
        HashSet<Student> hs = new HashSet<>();
        //创建Person对象
        Student s1 = new Student("张三",10);
        Student s2 = new Student("李四",11);
        Student s3 = new Student("王五",11);
        Student s31 = new Student("王五",12);
        Student s4 = new Student("王五",11);

        //添加集合元素
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s31);
        hs.add(s4);
        //遍历集合
        System.out.println(hs.size());
        for (Student student : hs) {
            System.out.println(student);
        }
        s2.name = "李四十";
        hs.remove(s2);
        System.out.println(hs.size());
        for (Student student : hs) {
            System.out.println(student);
        }

    }
}

class Student {
    String name;
    int age;

    public Student() {

    }

    public Student(String name,int age) {
        this.name = name;
        this.age = age;
    }
    //重写toString方法
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    //重写hashCode方法
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        //result= result+age
        result = prime*1 + result;
        //result=result+name.hashCode()
        //name=null返回0，否则返回name.hashCode().
        result = prime*result + ((name == null)?0 : name.hashCode());
        return result;
    }
    //重写equals方法
    public boolean equals(Object obj) {
        //提高效率
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        //提高代码健壮性,不是同一个类型就直接返回false,省得向下转型了
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        //向下转型
        Student p = (Student)obj;
        if(this.age != p.age) {
            return false;
        }
        if(this.name == null) {
            if(p.name != null) {
                return false;
            }

        }
        else if(!this.name.equals(p.name)) {
            return false;
        }
        return true;
    }

}
