import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Test {
    //树的子结构
    private boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    private boolean dfs(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
    //二叉搜索树转双向链表
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        Node head = null;
        List<Node> list = new ArrayList<>();
        Inorder(list,root);
        head = list.get(0);
        Node pre = head;
        for(int i=1; i<list.size(); i++){
            Node node = list.get(i);
            pre.right = node;
            node.left = pre;
            pre = pre.right;
        }
        pre.right = head;
        head.left = pre;
        return head;
    }

    public void Inorder(List<Node> nodes, Node root){
        if(root==null) return;
        Inorder(nodes,root.left);
        nodes.add(root);
        Inorder(nodes,root.right);
    }
}
