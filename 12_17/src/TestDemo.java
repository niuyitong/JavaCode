import java.util.*;

class TreeNode {
    char value;
    TreeNode left;
    TreeNode right;
    public TreeNode(char value) {
        this.value = value;
    }
}


public class TestDemo {
    //树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);

        return leftHight > rightHight
                ? leftHight + 1 : rightHight + 1;

    }

    //平衡二叉树
    //1.以当前root为根节点，判断当前root是否平衡。
    //2.如果是，那么需要判断root的左树是不是平衡的，右树是不是平衡的。
    //3.依据：Math.abs()<=1;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
        return Math.abs(leftHight-rightHight)<=1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
    //对称二叉树
    public boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree) {
        if(rightTree==null&&leftTree!=null || rightTree!=null&&leftTree==null){
            return false;
        }
        if(rightTree==null && leftTree==null){
            return true;
        }
        if(leftTree.value!=rightTree.value){
            return false;
        }
        return isSymmetricChild(leftTree.left,rightTree.right)&&
                isSymmetricChild(leftTree.right,rightTree.left);

    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }

    //非递归前序遍历
    List<Character> preOrderTraversalNor(TreeNode root){
        List<Character> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.empty()){
            while(cur!=null){
                stack.push(cur);
                System.out.println(cur.value + " ");
                list.add(cur.value);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }

    //非递归中序遍历
    List<Character> inOrderTraversalNor(TreeNode root){
        List<Character> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.value + " ");
            list.add(cur.value);
            cur = cur.right;
        }
        return list;
    }

    //非递归后序遍历
    void postOrderTraversalnNor(TreeNode root) {
        Stack<TreeNode > stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //cur = null;  异议
            cur = stack.peek();
            if(cur.right == null || cur.right == prev) {
                stack.pop();
                System.out.print(cur.value+" ");
                prev = cur;
                cur = null;
            }else {
                cur = cur.right;
            }
        }

    }

    //层序遍历
    void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;

        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            cur = queue.poll();
            System.out.println(cur.value + "");

            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
    //力扣 ：层序遍历
    public List<List<Character>> binaryTreeLevelOrder2(TreeNode root) {
        List<List<Character>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Character> list = new ArrayList<>();
            while (size > 0) {
                TreeNode cur = queue.poll();
                System.out.print(cur.value+" ");
                list.add(cur.value);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(list);
        }
        return ret;
    }


}