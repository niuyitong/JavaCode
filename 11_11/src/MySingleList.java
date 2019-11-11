class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
class MySingleList {

    public ListNode head;

    public MySingleList() {
        this.head = null;
    }
    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    //以x为基准分割链表,小于X的在左边，大于的在右边
    //1 3 8 4 9  ==>  若x为5  1 3 4 8 9
    public ListNode partition(int x) {
        ListNode bs = null;     //before start
        ListNode be = null;     //before end
        ListNode as = null;     //after start
        ListNode ae = null;     //after end
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data < x) {
                if (bs == null) {
                    bs = cur;
                    be = cur;

                } else {
                    be.next = cur;
                    be = cur;
                }
            } else {
                if (as == null) {
                    as = cur;
                    ae = cur;

                } else {
                    ae.next = cur;
                    ae = cur;
                }
            }
            cur = cur.next;
        }
        if (bs == null) {
            return as;
        }
        be.next = as;
        if(as != null){
            ae.next = null;
        }
        return bs;
    }

    //有序的链表中，删除重复的节点
    //原：1 2 3 3 4 4 5  后：1 2 5
    public ListNode deleteDuplication(){
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null) {
            if(cur.next != null
                    && cur.data == cur.next.data) {
                while(cur.next != null
                        && cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newHead.next;
    }


    //判断是否是回文链表
    public boolean chkPalindrome() {
        //1、找到单链表的中间节点
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、反转单链表
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3、fast/slow往前    head往后走
        while(this.head != slow){
            if(this.head.data != slow.data){
                return false;
            }
            if(this.head.next == slow){
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }

    //创造一个带环的链表
    public void creteLoop() {
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next.next;
    }
    //判断单链表是否有环
    public boolean hasCycle(){
        //只要相遇，就有环
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    //找到环的入口
    //fast一次走两步，slow一次走一步，两者相遇后，将fast/slow置为头，
    // 接下来两者每次走一步，相遇的节点就是环的入口
    public ListNode detectCycle(){
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = this.head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

