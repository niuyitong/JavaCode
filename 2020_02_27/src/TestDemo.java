
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class TestDemo {
    //给定一个头结点为 root 的链表,
    // 编写一个函数以将链表分隔为 k 个连续的部分。
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] listNode = new ListNode[k];
        int count = 0;
        ListNode cur = root;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        cur = root;
        if(count<=k){
            for(int i=0; i<listNode.length; i++){
                if(cur==null){
                    break;
                }
                ListNode curNext = cur.next;
                listNode[i] = cur;
                cur.next = null;
                cur = curNext;
            }
        }else{
            cur = root;
            int m = count/k;//3
            int n = count%k;//1
            ListNode curNext = null;
            for(int i=0; i<n; i++){
                listNode [i] = cur;
                int tmp = m;
                while(tmp!=0){
                    cur = cur.next;
                    tmp--;
                }
                curNext = cur.next;
                cur.next = null;
                cur = curNext;
            }
            for(int i=n; i<listNode.length; i++){
                listNode [i] = cur;
                int tmp = m-1;
                while(tmp!=0){
                    cur = cur.next;
                    tmp--;
                }
                curNext = cur.next;
                cur.next = null;
                cur = curNext;
            }
        }
        return listNode;

    }

    //分隔链表
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        while(cur!=null){
            if(cur.val<x){
                if(bs==null){
                    bs = cur;
                    be = cur;
                }else{
                    be.next = cur;
                    be = be.next;
                }
            }else{
                if(as==null){
                    as = cur;
                    ae = cur;
                }else{
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if(bs==null){
            return as;
        }
        be.next = as;
        if(ae!=null){
            ae.next = null;
        }
        return bs;
    }
    //找相交链表的节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode pL = headA;
        ListNode pS = headB;
        int len1 = 0;
        int len2 = 0;
        while(pL!=null){
            len1++;
            pL = pL.next;
        }
        while(pS!=null){
            len2++;
            pS = pS.next;
        }
        int len = len1-len2;
        if(len2>len1){
            pL = headB;
            pS = headA;
            len = -len;
        }else{
            pL = headA;
            pS = headB;
        }
        while(len!=0){
            pL = pL.next;
            len--;
        }
        while(pL!=pS){
            pL = pL.next;
            pS = pS.next;
        }
        return pL;
    }
}
