import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Test {
    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,5,6};
        merge(A,3,B,3);

    }
    public static void merge(int[] A, int m, int[] B, int n) {
        int[] tmp = new int[m+n];
        int i=0;
        int j=0;
        int k = 0;
        for(k=0; k<tmp.length; k++){
            if(i<m && j<n ){
                if(A[i]<B[j]){
                    tmp[k] = A[i++];
                }else{
                    tmp[k] = B[j++];
                }
            }else{
                break;
            }
        }
        if(i==m){
            while(k<tmp.length){
                tmp[k++] = B[j++];
            }
        }else{
            while(k<tmp.length){
                tmp[k++] = A[i++];
            }
        }
        for(int index=0; index<tmp.length; index++){
            A[index] = tmp[index];
        }
    }
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(i);
        }
        int index = 0;
        while(list.size()!=1){
            index = m-1;
            index = index%list.size();
            list.remove(index);
        }
        return list.get(0);
    }
    //1->2->3->4->5->NULL
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                res[0] = i;
                res[1] = map.get(nums[i]);
                break;
            }
            map.put(target-nums[i],i);
        }
        return res;
    }


}
