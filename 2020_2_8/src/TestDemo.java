import javax.swing.tree.TreeNode;
import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,2};
        int ret = findUnsortedSubarray(nums);
        System.out.println(ret);
    }
    /*
    //二叉树的右视图
    public List<List<Character>> binaryTreeLevelOrder2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            int end = size-1;
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode cur = queue.poll();
                list.add(cur.value);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(list.get(end));
        }
        return ret;
    }*/
    //求子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }//[] [1] [2] [1,2] [3] [1,3] [2,3] [1,2,3]
    //逆波兰表达式求值
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ;i < tokens.length;i++){
            String str = tokens[i];
            if (str.length() == 1){
                char ch = str.charAt(0);
                if (ch-'0' >= 0 && ch - '0' <= 9 ){
                    Integer a = Integer.valueOf(str);
                    stack.push(a);
                }
                else{
                    if (stack.size() < 2)
                        return 0;
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    switch(ch){
                        case '+':
                            stack.push(num1 + num2);
                            break;
                        case '-':
                            stack.push(num1 - num2);
                            break;
                        case '*':
                            stack.push(num1 * num2);
                            break;
                        case '/':
                            stack.push(num1 / num2);
                            break;
                    }
                }
            }else{
                int n = Integer.valueOf(str);
                stack.push(n);
            }
        }
        return stack.pop();
    }
    //最短无序连续子数组
    public static void swap (int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static int findUnsortedSubarray(int[] nums) {
        int res = 0;
        int start = -1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]<nums[i-1]){
                int j = i;
                while(j>0 && nums[j]<nums[j-1]){
                    swap(nums,j,j-1);
                    j--;
                }
                if(start == -1 || start>j){
                    start = j;
                }
                res = i-start+1;
            }
        }
        return res;
    }
}
