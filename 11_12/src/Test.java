public class Test {
    public static void main(String[] args) {
        SingleList mySingleList = new SingleList();
        mySingleList.addLast(2);
        mySingleList.addLast(5);
        mySingleList.addLast(9);
        mySingleList.addLast(1);
        mySingleList.addLast(7);
        mySingleList.addLast(3);
        mySingleList.display();//2 5 9 1 7 3

        mySingleList.oddEvenList2();
        mySingleList.display();
    }
}
