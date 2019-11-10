public class TestDemo {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        /*
        mySingleList.addIndex(0,199);
        mySingleList.addLast(2);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(2);
        mySingleList.addLast(5);
        mySingleList.addLast(6);
        mySingleList.addLast(3);
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
        */
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);
        mySingleList.addLast(4);
        mySingleList.addLast(5);
        mySingleList.addLast(4);
        mySingleList.addLast(3);
        mySingleList.addLast(2);
        mySingleList.addLast(1);
        mySingleList.display();

        //创建一个有环链表
        mySingleList.creteLoop();
        //判断链表是否有环
        boolean a = mySingleList.hasCycle();
        System.out.println(a);
        //找环的入口
        ListNode c = mySingleList.detectCycle();
        System.out.println(c.data);
        /*
        //判断是否是回文链表
        boolean b = mySingleList.chkPalindrome();
        System.out.println(b);
        mySingleList.display();//1 2 2 3 4 4 5 6 6
        //有序的链表删除重复的节点
        ListNode newHead = mySingleList.deleteDuplication();
        mySingleList.display2(newHead);//1 3 5
        //以x为基准分割链表
        //ListNode node = mySingleList.partition(10);
        //mySingleList.display2(node);
        //逆置
       // ListNode newHead = mySingleList.reverseList();
       // mySingleList.display2(newHead);

        //中间节点
        //ListNode center = mySingleList.middleNode2();
        //System.out.println(center.data);

        //倒数第k个节点
        //ListNode k = mySingleList.findKthToTail(4);
        //System.out.println(k.data);
        //mySingleList.clear();
        //System.out.println("fakfalls");
*/
       /* boolean flg = mySingleList.contains(99);
        System.out.println(flg);
        ListNode node = mySingleList.contains(500);
        System.out.println(node.data);//5节点的地址*/
    }
}
