/**
 * 一般一个.java文件建一个类就好
 * 一个类生成一个class文件
 */
class Person{           //类
    private String name1;
    private int age1;

    //属性
    //实例化数据成员
    public String name = "cao";
    public int age = 10;
    //静态数据成员
    public static int count = 100;
    //行为
    //实例化数据方法
    public void eat(){
        System.out.println("吃饭");
    }
    public void show(){
        System.out.println("name:"+name+" age:"+age);
    }
    //静态数据方法
    public static void func(){
        System.out.println("哈哈");
    }
}
public class Test {     //类

        public static void main(String[] args){
            //实例化一个对象  即new一个对象
            Person per = new Person();
            //实例化数据成员访问与调用
            System.out.println(per.name);
            System.out.println(per.age);
            per.show();
            per.eat();
            //静态数据成员 需要用类名访问调用
            System.out.println(Person.count);
            Person.func();
        }
}
