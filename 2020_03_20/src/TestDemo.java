import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class TestDemo {
    //镜像二叉树
    public void Mirror(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null){
            stack.push(root);
        }
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            stack.push(cur.left);
            stack.push(cur.right);
            if(!stack.empty()){
                cur.left = stack.pop();
            }
            if(!stack.empty()){
                cur.right = stack.pop();
            }

            Mirror(cur.left);
            Mirror(cur.right);
        }
    }
}

