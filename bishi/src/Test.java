
import java.lang.*;
import java.util.*;
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Test {
    int index = 0;
    public int findRootIndex(int [] in,int inbegin,int inend,int val){
        for(int i=inbegin; i<=inend; i++){
            if(in[i]==val){
                return i;
            }
        }
        return -1;
    }
    public TreeNode reConstructBinaryTreeChild(int [] pre, int [] in, int inbegin, int inend){
        if(inbegin>inend){
            return null;
        }
        TreeNode root = new TreeNode(pre[index]);
        int rootIndex = findRootIndex(in,inbegin,inend,pre[index]);
        index++;
        root.left = reConstructBinaryTreeChild(pre,in,inbegin,rootIndex-1);
        root.right = reConstructBinaryTreeChild(pre,in,rootIndex+1,inend);
        return root;
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null || in==null|| pre.length!=in.length){
            return null;
        }
        return reConstructBinaryTreeChild(pre,in,0,in.length-1);
    }

    ArrayList<Integer> arrayList = new ArrayList<>();
    public void printListFromTailToHead2(ListNode listNode) {
        if(listNode==null) return;
        printListFromTailToHead2(listNode.next);
        arrayList.add(listNode.val);
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        printListFromTailToHead2(listNode);
        return arrayList;
    }
    public String replaceSpace(StringBuffer str) {
        int n = str.length();
        int count = 0;
        for(int i=0; i<n; i++){
            if(str.charAt(i)==' '){
                count++;
            }
        }
        int n2 = n + count * 2;
        char[] res = new char[n2];
        //we are happy
        int k = n-1;
        int j = n2-1;
        while(j>=0){
            if(str.charAt(k)==' '){
                res[j--] = '0';
                res[j--] = '2';
                res[j--] = '%';
            }else{
                res[j--] = str.charAt(k);
            }
            k--;
        }
        return new String(res);
    }
    public boolean Find(int target, int [][] array) {
        if(array==null || array.length==0){
            return false;
        }
        int m = array.length;//m行
        int n = array[0].length;//n列
        int i = 0;
        int j = n-1;
        while(i<m && j>=0){
            if(target < array[i][j]){
                j--;
            }else if(target > array[i][j]){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }









































































































    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int max = 0;
            for (int i = 2; i <= n / 2; i++) {
                int c = n / i;
                int b = n % i;
                if (b == 1) {
                    if (max < (int) Math.pow(c, i - 1)) {

                        max = (int) Math.pow(c, i - 1);
                        max *= c + 1;
                    }
                } else if (b == 2) {
                    if (max < (int) Math.pow(c, i)) {
                        max = (int) Math.pow(c, i);
                        max *= 2;
                    }
                } else if (b == 0) {
                    if (max < (int) Math.pow(c, i)) {
                        max = (int) Math.pow(c, i);
                    }
                }
            }
            System.out.println(max);
        }
    }

    public static int BinaryWays(int[] nums, int num, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right + left) / 2;
        int ret = -1;
        if (nums[mid] > num) {
            ret = BinaryWays(nums, num, left, mid - 1);
        } else if (nums[mid] < num) {
            ret = BinaryWays(nums, num, mid + 1, right);
        } else {
            ret = mid;
        }
        return ret;
    }

    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int num = sc.nextInt();
            int ret = BinaryWays(nums, num, 0, nums.length - 1);
            System.out.println(ret);
        }
    }


    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        //得到不同的两数的异或值
        for(int num : nums){
            ret ^= num;
        }
        //从右往左找这两数哪一位不同
        int index = 0;
        while((ret&1)==0){
            index++;
            ret >>= 1;
        }
        //根据这一位不同，将所有数分为两组，且不同的两个数肯定在不同组
        int[] res = new int[2];
        for(int num : nums){
            if(((num>>index)&1)==0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                new Comparator<Integer>(){
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                }
        );
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<input.length; i++){
            pq.add(input[i]);
        }
        for(int j=0; j<k; j++){
            list.add(pq.poll());
        }
        return list;
    }



    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            int firstIndex = 0;
            int secondIndex = 0;
            int f = 0;
            int s = 0;
            for(int i=0; i<str.length(); i++){
                char tmp = str.charAt(i);
                if(tmp-'0'>=0 && tmp-'0'<=9){
                    f = i;
                    i++;
                    while(i<str.length()){
                        tmp = str.charAt(i);
                        if(tmp-'0'>=0 && tmp-'0'<=9){
                            i++;
                        }else{
                            break;
                        }
                    }
                    s = i-1;

                    if((s-f)>(secondIndex-firstIndex)){
                        firstIndex = f;
                        secondIndex = s;
                    }
                }
            }
            System.out.println(str.substring(firstIndex,secondIndex+1));
        }
    }
}
class Single {
    public static volatile Single ins = null;
    public Single getIns(){
        if(ins==null){
            synchronized (Single.class){
                if(ins==null){
                    ins = new Single();
                }
            }
        }
        return ins;
    }


}