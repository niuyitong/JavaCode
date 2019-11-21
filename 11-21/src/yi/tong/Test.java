package yi.tong;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Cycle();
        shape.draw();

        IShape ishape = new Flower();
        ishape.have();
    }
}
