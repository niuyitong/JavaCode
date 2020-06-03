class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Test {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null){
            return null;
        }
        int count = 1;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode node = newHead;
        while(node!=null && count!=m){
            node = node.next;
            count++;
        }
        ListNode pre = null;
        ListNode cur = node.next;
        while(cur!=null && count<=n){
            ListNode nextNode= cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
            count++;
        }
        node.next.next = cur;
        node.next = pre;
        return newHead.next;
    }
    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0; i<k; i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }

    public static void main(String[] args) {

    }
}
