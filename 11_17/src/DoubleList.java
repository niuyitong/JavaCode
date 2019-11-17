class ListNode {
    public int data;
    public ListNode next;
    public ListNode prev;
    public ListNode(int data) {
        this.data = data;
    }
}

public class DoubleList {
    public ListNode head;
    public ListNode last;//尾巴

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){//第一次插入
            this.head = node;
            this.last = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){//第一次插入
            this.head = node;
            this.last = node;
        }else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }
    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.data+ " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        ListNode node = new ListNode(data);
        if(index == 0){ //头插
            addFirst(data);
            return true;
        }else if(index == size()){//尾插
            addLast(data);
            return true;
        }else if(index >0 && index < size()){ // 中间插
            ListNode cur = this.head;
            while(index >0 ){
                cur = cur.next;
                index--;
            }
            node.next = cur;
            node.prev = cur.prev;
            cur.prev.next = node;
            cur.prev = node;
            return true;
        }else{ //坐标不合法
            return false;
        }
    }
    //得到单链表的长度
    public int size(){
        ListNode cur = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key){ //要删除的节点
                if(cur == this.head){ //为头节点
                    this.head = this.head.next;
                    this.head.prev = null;
                }else if(cur == this.last){ //为尾节点
                    this.last = cur.prev;
                    last.next = null;
                }else { //为中间节点
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return; //删除一个后跳出
            }else{
                cur = cur.next;
            }
        }
        //没有要删除的节点
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key){ //要删除的节点
                if(cur == this.head){ //为头节点
                    this.head = this.head.next;
                    this.head.prev = null;
                }else if(cur == this.last){ //为尾节点
                    this.last = cur.prev;
                    last.next = null;
                }else { //为中间节点
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                cur = cur.next; //继续删除
            }else{
                cur = cur.next;
            }
        }
    }
    //清空
    public void clear(){
        while(this.head != null){
            ListNode cur = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = cur;
        }
        this.last = null;//不要忘了把尾置空
    }


}
