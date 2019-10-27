public class Person {
    private String name;
    private int age;
    private String sex;
    private double grade;
    //默认构造函数
    /*
    public Person(){
        this.name = "苏珊";
        this.age = 18;
        this.sex = "woman";
        this.grade = 90.5;
    }
    */
    //用this默认构造函数  效果同上
    public Person(){
        this("杰瑞",21,"man",66);
    }
    //带有参数的构造函数
    public Person(String name,int age,String sex,double grade){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.grade = grade;
    }

    //实例代码块  比构造函数先运行
    {
        this.name = "haha";
        this.age = 25;
        this.sex = "man";
        this.grade = 84;
        System.out.println("实例代码块");
    }
    //静态代码块
    static{
        ;
    }

    public void show(){
        System.out.println("name:"+name+" age:"+age+
                " sex:"+sex+" grade:"+grade);
    }
}
