import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode{
    int val;
    ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class Test {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode node = newHead;
        int flg = 0;
        while(l1!=null && l2!=null){
            int sum = l1.val+l2.val+flg;
            flg = sum/10;
            int tmp = sum%10;
            node.next = new ListNode(tmp);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            int sum = l1.val+flg;
            flg = sum/10;
            int tmp = sum%10;
            node.next = new ListNode(tmp);
            node = node.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int sum = l2.val+flg;
            flg = sum/10;
            int tmp = sum%10;
            node.next = new ListNode(tmp);
            node = node.next;
            l2 = l2.next;
        }
        if(l1==null && l2==null && flg!=0){
            node.next = new ListNode(flg);
            node = node.next;
        }
        return newHead.next;
    }
    //回文链表
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转后半部分
        ListNode pre = slow;
        slow = slow.next;
        while(slow!=null){
            ListNode nextNode = slow.next;
            slow.next = pre;
            pre = slow;
            slow = nextNode;
        }
        //比较
        fast = head;
        slow = pre;
        while(slow!=fast){
            if(slow.val!=fast.val){
                return false;
            }
            if(fast.next == slow){
                return true;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    //合并K个有序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                new Comparator<ListNode>(){
                    @Override
                    public int compare(ListNode o1,ListNode o2){
                        return o1.val-o2.val;
                    }
                }
        );

        for(ListNode list: lists){
            if(list!=null){
                pq.add(list);
            }
        }

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next!=null){
                pq.add(node.next);
            }
        }
        return newHead.next;
    }
}
