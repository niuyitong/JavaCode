public class Test {
    public static void main(String[] args) {
        Animal animal = new Cat("nana","白色");
        //cat.miao();
        //cat.sleep();
        animal.sleep();
        if(animal instanceof Cat)
        {
            Cat cat= (Cat)animal;
            cat.miao();
        }
        Animal animal2 = new Bird("鸟儿","雌");
        animal2.eat();

        run(animal2);

    }

    public static void run(Animal animal){
        animal.run();
    }

}
