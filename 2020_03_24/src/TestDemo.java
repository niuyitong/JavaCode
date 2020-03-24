class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class TestDemo {
    //微信红包
    public int getValue(int[] gifts, int n) {
        int count = 0;
        int num = gifts[0];
        for (int i = 1; i < n; i++) {
            if (gifts[i] == num) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                num = gifts[i];
            }
        }
        int size = 0;
        for (int j = 0; j < n; j++) {
            if (num == gifts[j]) {
                size++;
            }
        }
        return size > n / 2 ? num : 0;
    }

    //链表分割
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.val < x) {
                //是不是第一次插入
                if (bs == null) {
                    bs = cur;
                    be = bs;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                //是不是第一次插入
                if (as == null) {
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //第一个区间没有数据
        if (bs == null) {
            return as;
        }
        be.next = as;
        if (as != null) {
            ae.next = null;
        }
        return bs;
    }
}

