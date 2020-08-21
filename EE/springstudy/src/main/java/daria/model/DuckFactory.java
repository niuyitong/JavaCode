package daria.model;

public class DuckFactory {
    //静态工厂方法
    public static Duck create(){
        Duck d = new Duck();
        d.setName("小三");
        d.setAge(3);
        return d;
    }
    public Duck create2(){
        Duck d = new Duck();
        d.setName("小四");
        d.setAge(4);
        return d;
    }
}
