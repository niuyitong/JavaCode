public class Bird extends Animal{
    private String yumao;
    /* static {
         System.out.println("Bird::static{}");
     }
     {
         System.out.println("Bird::instance{}");
     }*/
    public Bird(String name,String yumao) {
        super(name);
        this.yumao = yumao;
        //System.out.println("Bird(String,String)");
    }
    public void fly() {
        System.out.println(this.name+"fly");
    }
}
