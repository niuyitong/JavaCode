class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class TestDemo {
    //对称二叉树
    public boolean isSymmetric2(TreeNode node1, TreeNode node2){
        if(node1==null && node2==null){
            return true;
        }
        if(node1==null || node2==null){
            return false;
        }
        if(node1.val!=node2.val){
            return false;
        }
        return isSymmetric2(node1.left,node2.right)&&isSymmetric2(node1.right,node2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric2(root.left,root.right);
    }
    //二叉树的镜像
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
    //找出倒数第K个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode node = head;
        while(node !=null && k!=0){
            node = node.next;
            k--;
        }
        ListNode cur = head;
        while(node != null){
            cur = cur.next;
            node = node.next;
        }
        return cur;
    }
    //调整数组
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while(i < j){
            while(i<j && nums[i]%2==1){
                i++;
            }
            while(i<j && nums[j]%2==0){
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
    //数值的整数次方
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }

    public static void main(String[] args) {

    }
}
