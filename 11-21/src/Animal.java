//如果类被final修饰 则不能被继承
class Animal {
    protected String name;
    public Animal(String name){
        this.name = name;
        //System.out.println("父类构造");
        //System.out.println("==========");
    }
    /*
    {
        System.out.println("父类实例");
    }*/
    public void sleep(){
        System.out.println(name + "睡觉");
    }
    public void eat(){

    }
    public void run(){
        System.out.println(name + "跑");
    }
}
