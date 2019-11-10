
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

    //查找是否包含关键字key是否在单链表中
    public ListNode contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    private ListNode searchPrev(int key) {
        ListNode prev = this.head;
        while (prev.next != null) {
            if (prev.next.data == key) {
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    public void remove(int key) {
        //1、删除的节点如果是头结点
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //2、找到删除的节点的前驱  如果找不到  返回null
        ListNode prev = searchPrev(key);
        if (prev == null) {
            System.out.println("没有你要删除的节点");
            return;
        }
        ListNode del = prev.next;
        //3、进行删除
        prev.next = del.next;
    }

    //删除所有关键字为key的节点
    public void removeAllKey(int key) {
        ListNode prev = this.head;
        ListNode cur = this.head.next;//当前要删除的节点
        while (cur != null) {
            if (prev.next.data == key) {
                prev.next = cur.next; //删除
                cur = cur.next;
            } else {
                cur = cur.next;
                prev = prev.next;
            }
        }
        //最后处理头节点
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    //清空节点
    //java自动回收 前提：什么时候不用这块内存
    public void clear() {
        //this.head = null;//暴力
        //一个一个删
        while (this.head.next != null) {
            ListNode cur = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;
    }


    //反转单链表
    public ListNode reverseList() {
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode newHead = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                newHead = cur;
            }
            //反转
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
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

    //链表的中间节点
    public ListNode middleNode1() {//遍历两遍
        int len = getLength() / 2;
        ListNode cur = this.head;
        while (len != 0) {
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
    public ListNode findKthToTail(int k) {
        if (k <= 0) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k - 1 != 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                System.out.println("没有这个节点");
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    //以x为基准分割链表,小于X的在左边，大于的在右边
    //1 3 8 4 9  ==>  若x为5  1 3 4 8 9
    public ListNode partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while (cur != null) {//遍历数组
            if (cur.data < x) {
                //是不是第一次插入
                if (bs == null) {
                    bs = cur;
                    be = cur;

                } else {
                    be.next = cur;
                    be = cur;
                }
            } else {
                //是不是第一次插入
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
        //如果第一个区间没有数据
        if (bs == null) {
            return as;
        }
        be.next = as;//将两部分链接起来
        if(as != null){//避免死循环
            ae.next = null;
        }
        return bs;
    }

    //有序的链表中，删除重复的节点
    //原：1 2 3 3 4 4 5  后：1 2 5
    public ListNode deleteDuplication(){
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);//虚拟头节点
        ListNode tmp = newHead;
        while (cur != null) {//遍历一遍
            //重复的节点
            if(cur.next != null
                    && cur.data == cur.next.data) {
                while(cur.next != null//这个数重复几次就循环几遍
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
        tmp.next = null;//如果最后一个节点也为重复的节点，将tmp.next置为空
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
            if(this.head.next == slow){//偶数节点返回
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;//奇数节点返回
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
            if(fast == slow){//相遇了
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
            if(fast == slow){//相遇了，有环
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;//无环
        }
        slow = this.head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }



}
