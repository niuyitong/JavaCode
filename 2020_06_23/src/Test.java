class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Test {
    public int length(ListNode node){
        ListNode tmp = node;
        int count = 0;
        while(tmp!=null){
            count++;
            tmp = tmp.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);

        if(lenA>lenB){
            int len = lenA-lenB;
            while(len!=0){
                headA = headA.next;
                len--;
            }
        }else{
            int len = lenB-lenA;
            while(len!=0){
                headB = headB.next;
                len--;
            }
        }
        while(headA!=null && headB!=null && headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        if(headA==null || headB==null){
            return null;
        }else{
            return headA;
        }
    }
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = nums[0];
        for(int i=0; i<nums.length; i++){
            if(num == nums[i]){
                count++;
            }else if(count>0){
                count--;
            }else{
                num = nums[i];
            }
        }
        return num;
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while(k!=0 && fast != null){
            fast = fast.next;
            k--;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public int maxSubArray(int[] nums) {
        int maxNum = nums[0];
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum>maxNum){
                maxNum = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        return maxNum;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if(l1==null){
            tmp.next = l2;
        }else{
            tmp.next = l1;
        }
        return newHead.next;
    }
}
