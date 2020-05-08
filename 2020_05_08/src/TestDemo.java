class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class TestDemo {
    //复杂链表的复制
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        //1.复制新链表 与旧链表连接起来
        //A->B->C ==>> A->A'->B->B'->C->C'
        Node cur = head;
        while(cur!=null){
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        //2.复制random
        cur = head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //3.拆分成两个链表
        cur = head;
        Node res = head.next;//新链表的头节点
        Node tmp = res;
        cur.next = cur.next.next;//将新链表的第一个节点分离开
        cur = cur.next;
        while(cur!=null){
            tmp.next = cur.next;
            tmp = tmp.next;
            cur.next = tmp.next;
            cur = cur.next;

        }
        return res;

    }
}
