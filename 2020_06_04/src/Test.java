
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class Test {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode pre = newHead;
        ListNode cur = head;
        while(cur!=null){
            if(cur.next!=null && cur.val==cur.next.val){
                while(cur.next!=null && cur.val==cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            }else{
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        pre.next = null;
        return newHead.next;
    }
    public boolean isSubSequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()){
            index = t.indexOf(c, index+1);
            if (index == -1) return false;
        }
        return true;
    }
    public boolean isSubSequence(String s, String t) {
        for(int i=0,j=0; i<s.length(); i++,j++){
            char ch = s.charAt(i);
            while(j<t.length() && t.charAt(j)!=ch){
                j++;
            }
            if(j==t.length()){
                return false;
            }
        }
        return true;
    }
}
