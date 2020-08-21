package daria;

import daria.model.Duck;
import daria.model.DuckShop;
import daria.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");
//        //从容器中获取bean对象
//        Duck duck1 = (Duck) context.getBean("duck1");
//        System.out.println(duck1);
//        Duck duck2 = (Duck) context.getBean("duck2");
//        System.out.println(duck2);
//        DuckShop shop = (DuckShop) context.getBean("duckShop");
//        System.out.println(shop);
//        //
//        Person person1 = (Person) context.getBean("p1");//通过id
//        //若容器中只有一个对象，可以通过类型
//        Person person2 = (Person) context.getBean(Person.class);//通过类型
//        System.out.println(person1);
//        System.out.println(person2);
//        //静态工厂方法
//        Duck duck3 = (Duck) context.getBean("duck3");
//        System.out.println(duck3);
//        //实例工厂方法
//        Duck duck4 = (Duck) context.getBean("duck4");
//        System.out.println(duck4);



    }
}
