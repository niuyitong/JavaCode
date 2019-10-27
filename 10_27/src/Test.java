public class Test {
    public static void main(String[] args){
        Calculator cal = new Calculator();
        System.out.println(cal.add(2,5));
        System.out.println(cal.add(10.5,20.2));
        System.out.println(cal.sub(2,5));
        System.out.println(cal.sub(10.5,20.2));
        System.out.println(cal.mul(2,5));
        System.out.println(cal.mul(10.5,20.2));
        System.out.println(cal.div(2,5));
        System.out.println(cal.div(10.5,20.2));

        Person per1 = new Person();
        per1.show();
        Person per2 = new Person("玛丽",20,"woman",80);
        per2.show();

    }
}
