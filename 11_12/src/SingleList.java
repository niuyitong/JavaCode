class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
class SingleList {

    public ListNode head;//标志头

    public SingleList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {//无节点时
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        //0、判断是否是第一次插入
        if (this.head == null) {
            this.head = node;
        } else {
            //1、找尾巴
            while (cur.next != null) {
                cur = cur.next;
            }
            //2、进行插入
            cur.next = node;
        }
    }

    //插入到index位置

    /**
     * 找到index-1位置的节点  返回当前节点的引用
     *
     * @param index
     * @return
     */

    private ListNode searchIndex(int index) {
        //prev-->index-1;
        ListNode prev = this.head;
        int count = 0;
        while (count < index - 1) {//找到index的前一个节点，从头开始，需要找index-1次
            prev = prev.next;
            count++;
        }
        return prev;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        //下标不合法
        if (index < 0 || index > getLength()) {
            return false;
        }
        //头插法
        if (index == 0) {
            addFirst(data);
            return true;
        }
        ListNode prev = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
        return false;
    }

    public int getLength() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //打印单链表数据
    public void display() {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void display2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //分隔链表
    //输入: head = 1->4->3->2->5->2, x = 3
    //输出: 1->2->2->4->3->5
    public ListNode partition(int x) {
        ListNode bs = null;     //before start
        ListNode be = null;          //  end
        ListNode as = null;     //after
        ListNode ae = null;
        ListNode cur = this.head;
        while (cur != null) { //遍历链表
            if (cur.data < x) {
                if (bs == null) { //第一次插入
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = cur;
                }
            } else {
                if (as == null) { //第一次插入
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = cur;
                }
            }
            cur = cur.next;
        }
        if (bs == null) { //
            return as;
        }
        be.next = as;
        if(as != null){
            ae.next = null;
        }
        return bs;
    }

    //给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
    //输入: 2->1->3->5->6->4->7->NULL
    //输出: 2->3->6->7->1->5->4->NULL
    public ListNode oddEvenList() {
        ListNode os = null;     //odd start
        ListNode oe = null;       //  end
        ListNode es = null;     //even start
        ListNode ee = null;
        ListNode cur = head;
        int count = 1;
        while(cur != null){
            if(count%2 == 1){ //奇节点
                if(os == null){ //第一次
                    os = cur;
                    oe = cur;
                }else{ //
                    oe.next = cur;
                    oe = cur;
                }
            }else { //偶
                if(es == null){ //第一次
                    es = cur;
                    ee = cur;
                }else{ //
                    ee.next = cur;
                    ee = cur;
                }
            }
            cur = cur.next;
            count++;
        }
        if (os == null) { //
            return es;
        }
        oe.next = es;
        if(es != null){
            ee.next = null;
        }
        return os;

    }




}
