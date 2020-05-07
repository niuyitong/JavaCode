import java.util.*;
class MinStack {
    private Node head;

    public MinStack() {

    }

    public void push(int x) {

        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(head.min, x), head);
    }

    public void pop() {

        head = head.next;
    }

    public int top() {

        return head.val;
    }

    public int min() {

        return head.min;
    }

    private class Node {

        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {

            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class TestDemo {
    //层序遍历 偶数层从右到左打印 奇数层从左到右打印
    public void reverse(List<Integer> list){
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            int tmp = list.get(left);
            list.set(left,list.get(right));
            list.set(right,tmp);
            left++;
            right--;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        int flg = -1;
        queue.offer(root);
        while(!queue.isEmpty()){
            flg++;
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size>0){
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if(tmp.left!=null){
                    queue.offer(tmp.left);
                }
                if(tmp.right!=null){
                    queue.offer(tmp.right);
                }
                size--;
            }
            if(flg%2==0){
                res.add(list);
            }else{
                reverse(list);
                res.add(list);
            }
        }
        return res;
    }
    //层序遍历
    public int[] levelOrder1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            if(tmp.left!=null){
                queue.offer(tmp.left);
            }
            if(tmp.right!=null){
                queue.offer(tmp.right);
            }

        }
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {


    }
}
