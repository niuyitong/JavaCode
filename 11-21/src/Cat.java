import java.sql.SQLOutput;

class Cat extends Animal{
    protected String color;
    public Cat(String name, String color){
        super(name);
        this.color = color;
        //System.out.println("子类构造");
        //System.out.println("==========");
    }
    /*
    {
        System.out.println("子类实例");
    }
    */
    public void miao(){
        System.out.println(name + "喵喵叫");
    }
    @Override
    public void eat(){
        System.out.println(name + "吃猫粮");
    }
}
