import java.util.*;
class ListNode {
    private int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Test {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int len = 0;
        while(cur!=null){
            cur = cur.next;
            len++;
        }
        if(len==0 || n>len){
            return head;
        }
        if(n==len){
            return head.next;
        }
        int k = len-n;
        cur = head;
        while(k!=1){
            cur = cur.next;
            k--;
        }
        cur.next = cur.next.next;
        return head;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            double x = in.nextDouble();
            double y = in.nextDouble();
            int n = in.nextInt();
            double a = 0;
            double b = 0;
            double min = Double.MAX_VALUE;
            for(int i=0; i<n; i++){
                a = in.nextDouble();
                b = in.nextDouble();
                double tmp = Math.pow(x-a,2)+Math.pow(y-b,2);
                if(tmp<min){
                    min = tmp;
                }
            }
            min = Math.sqrt(min);

            System.out.println(min);
        }
    }
}
