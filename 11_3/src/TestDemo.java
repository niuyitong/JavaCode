public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addIndex(0,199);
        mySingleList.addLast(2);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(2);
        mySingleList.addLast(5);
        mySingleList.display();
        mySingleList.addIndex(0,2);
        mySingleList.display();
        mySingleList.addIndex(7,2);
        mySingleList.display();
        mySingleList.addFirst(45);
        mySingleList.addFirst(88);
        mySingleList.display();
        mySingleList.remove(2);
        mySingleList.display();
        mySingleList.removeAllKey(2);
        mySingleList.display();
        mySingleList.remove(199);
        System.out.println("删除199");
        mySingleList.display();

        mySingleList.clear();
        System.out.println("fakfalls");

       /* boolean flg = mySingleList.contains(99);
        System.out.println(flg);
        ListNode node = mySingleList.contains(500);
        System.out.println(node.data);//5节点的地址*/
    }
}
