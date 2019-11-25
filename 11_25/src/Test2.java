/**
 *面试问题：
 *    Cloneable接口他是一个空接口，请问为什么呢？
 *    标记接口：
 *     Person implements Cloneable  认为Person
 *  *     将来可以被克隆
 *  1、implements Cloneable
 *  2、重写Object clone()
 *  3、如果当前类包含了引用类型
 *    Person-》Money
 *    在Person的clone方法内，不仅要克隆自己本身
 *    还需要克隆Money
 */
class Money implements Cloneable{
    public int money = 15;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();//调用父类克隆方法
    }
}
class Person implements Cloneable{
    public String name;
    public Money m;
    public Person(){
        this.m = new Money();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person per = (Person)super.clone();//调用父类的clone方法
        per.m = (Money)this.m.clone();
        return per;
    }
}
public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException{
        Person person = new Person();
        Person person2 = (Person)person.clone();
        System.out.println(person.m.money); //15
        System.out.println(person2.m.money);//15
        //说明是深拷贝，改变源不会影响拷贝的数值
        person2.m.money = 20;
        System.out.println(person.m.money);//15
        System.out.println(person2.m.money);//20
    }
}
