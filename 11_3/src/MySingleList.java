
import java.util.List;
//节点类
class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
class MySingleList {

    public ListNode head;//标志头

    public MySingleList() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null) {//无节点时
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        //0、判断是否是第一次插入
        if(this.head == null) {
            this.head = node;
        }else {
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
     * @param index
     * @return
     */
    private ListNode searchIndex(int index) {
        //prev-->index-1;
        ListNode prev = this.head;
        int count = 0;
        while (count < index-1) {//找到index的前一个节点，从头开始，需要找index-1次
            prev = prev.next;
            count++;
        }
        return prev;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        //下标不合法
        if(index < 0 || index > getLength()) {
            return false;
        }
        //头插法
        if(index == 0) {
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
    public void display(){
        if(this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //查找是否包含关键字key是否在单链表中
    public ListNode contains (int key){
        ListNode cur = this.head;
        while(cur!=null){
            if(cur.data==key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    private ListNode searchPrev(int key) {
        ListNode prev = this.head;
        while(prev.next!=null){
            if(prev.next.data==key){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

        public void remove(int key){
            //1、删除的节点如果是头结点
            if(this.head.data == key) {
                this.head = this.head.next;
                return;
            }
            //2、找到删除的节点的前驱  如果找不到  返回null
            ListNode prev = searchPrev(key);
            if(prev == null) {
                System.out.println("没有你要删除的节点");
                return;
            }
            ListNode del = prev.next;
            //3、进行删除
            prev.next = del.next;
        }

    //删除所有关键字为key的节点
    public void removeAllKey(int key){
        ListNode prev = this.head;
        ListNode cur = this.head.next;//当前要删除的节点
        while(cur != null){
            if(prev.next.data==key){
                prev.next = cur.next; //删除
                cur = cur.next;
            }else {
                cur = cur.next;
                prev = prev.next;
            }
        }
        //最后处理头节点
        if(this.head.data == key){
            this.head = this.head.next;
        }
    }

    //清空节点
    //java自动回收 前提：什么时候不用这块内存
    public void clear(){
        //this.head = null;//暴力
        //一个一个删
        while(this.head.next!=null){
            ListNode cur = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;
    }



    //反转单链表
    public ListNode reverseList(){
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode newHead = null;
        while(cur!=null){
            ListNode curNext = cur.next;
            if(curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public void display2(ListNode head){
        if(head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //链表的中间节点
    public ListNode middleNode1(){//遍历两遍
        int len = getLength()/2;
        ListNode cur = this.head;
        while(len!=0){
            cur = cur.next;
            len--;
        }
        return cur;
    }

    public ListNode middleNode2() {//遍历一遍
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //倒数第K个节点
    public ListNode findKthToTail(int k){
        if(k<=0 || head == null){
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(k-1!=0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            } else{
                System.out.println("没有这个节点");
                return null;
            }
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }




}
