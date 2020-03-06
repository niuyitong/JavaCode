
class Base{
    public Base(String s){
    System.out.print("B");
    }
}
 public class TestDemo extends Base{
    public TestDemo (String s) {
        super(s);
        System.out.print("D");
    }
    public static void main(String[] args){
        new TestDemo("A");
    }
}


/*public class TestDemo {
    String str = new String("good");
    char[] ch = {'a','b','c'};
    public static void main(String[] args) {
        TestDemo t = new TestDemo();
        t.change(t.str,t.ch);
        System.out.print(t.str+" and ");
        System.out.print(t.ch);
    }
    public  void change(String str,char[] ch){
        str = "test ok";
        ch[0] = 'g';
    }

}*/
