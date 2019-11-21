class Bird extends Animal{
    public String sex;
    public Bird(String name, String sex){
        super(name);
        this.sex = sex;
    }
    public void fly(){
        System.out.println(name + "飞");
    }
    @Override
    public void eat(){
        System.out.println(name + "吃虫子");
    }
}
