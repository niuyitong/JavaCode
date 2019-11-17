public class TestDemo {
    public static void main(String[] args){
        DoubleList doubleList = new DoubleList();
        doubleList.addFirst(1);
        doubleList.addFirst(2);
        doubleList.addFirst(3);
        doubleList.addFirst(4);
        doubleList.addFirst(5);
        doubleList.addFirst(4);
        doubleList.display();
        doubleList.addLast(7);
        doubleList.addLast(8);
        doubleList.display();
        doubleList.addIndex(2,99);
        doubleList.addIndex(8,88);
        doubleList.display();
        doubleList.remove(8);
        doubleList.display();
        doubleList.removeAllKey(4);
        doubleList.display();
        doubleList.clear();

        /*
        doubleList.remove(4);
        doubleList.display();

        doubleList.display();
        doubleList.remove(3);
        doubleList.display();
        */

    }
}
