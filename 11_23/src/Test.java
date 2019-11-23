public class Test {

    //编写一个程序，找到两个单链表相交的起始节点。
    //输入：intersectVal = 8, listA = [4,1,8,4,5],
    // listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
    // 输出：Reference of the node with value = 8
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pL = headA;//永远指向长链表
        ListNode pS = headB;//永远指向短链表
        int lenA = getLength(headA), lenB = getLength(headB);
        int len = lenA - lenB;
        if (len < 0) {
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }
        //让pL先走len步
        while (len != 0) {
            pL = pL.next;
            len--;
        }
        //开始一起走
        while (pL != pS) {
            pL = pL.next;
            pS = pS.next;
        }
        return pL;
    }

    public static int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            ++cnt;
            head = head.next;
        }
        return cnt;

    }
    //创造一个相交链表
    public static void createCut(ListNode headA,ListNode headB){
        headA.next = headB.next.next;
    }

    //将两个有序链表合并为一个新的有序链表并返回。
    //新链表是通过拼接给定的两个链表的所有节点组成的。
    //输入：1->2->4, 1->3->4   输出：1->1->2->3->4->4
    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);//虚拟节点
        ListNode tmp = newHead;
        while(headA != null && headB != null){
            if(headA.data < headB.data){
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA == null){
            tmp.next = headB;
        }else{
            tmp.next = headA;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        SingleList mySingleList = new SingleList();
        mySingleList.addLast(2);
        mySingleList.addLast(5);
        mySingleList.addLast(9);
        mySingleList.addLast(10);
        mySingleList.addLast(15);
        mySingleList.addLast(20);
        mySingleList.display();//2 5 9 10 15 20
        SingleList mySingleList2 = new SingleList();
        mySingleList2.addLast(1);
        mySingleList2.addLast(3);
        mySingleList2.addLast(7);
        mySingleList2.addLast(8);
        mySingleList2.addLast(12);
        mySingleList2.addLast(16);
        mySingleList2.display();// 1 3 7 8 12 16
        //ListNode node = mergeTwoLists(mySingleList.head,mySingleList2.head);
        //mySingleList.display2(node);

        createCut(mySingleList.head,mySingleList2.head);//相交节点值为7
        ListNode node2 = getIntersectionNode(mySingleList.head,mySingleList2.head);
        System.out.println(node2.data);
        //mySingleList.display2(node2);

        //奇偶节点
        //mySingleList.oddEvenList2();
        //mySingleList.display();
    }
}

