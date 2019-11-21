package yi.tong;

class Flower implements IShape{
    @Override
    public void have(){ //public 不可省略 因为接口中一定是public
        System.out.println("花");
    }
}
