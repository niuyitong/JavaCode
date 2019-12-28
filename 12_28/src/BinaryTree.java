import java.util.*;

class TreeNode{
    public char val;
    TreeNode left;
    TreeNode right;
    public TreeNode(char val){
        this.val = val;
    }
}

public class BinaryTree {
    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek();
            if(cur != null) {
                return false;
            }else {
                queue.poll();
            }
        }
        return true;
    }

    //给一个字符串==》前序构建二叉树，并用中序打印
    public static int i = 0;
    public static TreeNode buildTree(String str) {
        TreeNode root = null;
        if(str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        }else {
            i++;
        }
        return root;
    }

    public static void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        //"ABC##DE#EF"  ＃代表节点为空
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        TreeNode root = buildTree(str);
        inorder(root);
    }


    //二叉搜索树转为双向链表
    TreeNode prev = null;
    public void ConvertChild(TreeNode pCur) {
        if(pCur == null) {
            return;
        }
        ConvertChild(pCur.left);
        pCur.left = prev;
        if(prev != null) {
            prev.right = pCur;
        }
        prev = pCur;
        ConvertChild(pCur.right);
    }
    //返回的是双向链表的头结点
    public TreeNode Convert(TreeNode pRootOfTree) {
        //这个函数，执行完成后，二叉搜索树的结构已经被改变了
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        //一路向左
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }


    //寻找公共祖先
    public TreeNode lowestCommonAncestor
    (TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        }
        //开始以前序遍历的方式进行查找
        TreeNode leftTree = lowestCommonAncestor(root.left,p,q);
        TreeNode rightTree = lowestCommonAncestor(root.right,p,q);
        if(leftTree!= null && rightTree!= null) {
            return root;
        }
        if(leftTree!= null) {
            return leftTree;
        }
        if(rightTree != null) {
            return rightTree;
        }
        return null;
    }


    /*
    //前序中序构建二叉树
    int preIndex = 0;

    public TreeNode buildTreeChild(int[] preorder,
                                   int[] inorder,int inbegin,int inend) {
        //判断是否有左树或者是右树
        if(inbegin > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        //找root在中序遍历的下标
        int rootIndex =
                findIndexOfInorder(inorder,inbegin,inend,preorder[preIndex]);
        preIndex++;

        root.left = buildTreeChild(preorder ,inorder,inbegin,
                rootIndex-1);

        root.right = buildTreeChild(preorder ,inorder
                ,rootIndex+1,inend);

        return root;
    }
    public int findIndexOfInorder(int[] inorder,int inbegin,
                                  int inend,int val){
        for(int i = inbegin;i <= inend;i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) {
            return null;
        }
        if(preorder.length == 0 || inorder.length ==0) {
            return null;
        }

        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
    */



    /*
    //中序后序构建二叉树
    public int postIndex = 0;

    public TreeNode buildTreeChild(int[] inorder,
                                   int[] postorder,int inbegin,int inend) {
        //判断是否有左树或者是右树
        if(inbegin > inend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        //找root在中序遍历的下标
        int rootIndex =
                findIndexOfInorder(inorder,inbegin,inend,postorder[postIndex]);
        postIndex--;

        root.right = buildTreeChild(inorder
                ,postorder ,rootIndex+1,inend);


        root.left = buildTreeChild(inorder ,postorder,inbegin,
                rootIndex-1);


        return root;
    }

    public int findIndexOfInorder(int[] inorder,int inbegin,
                                  int inend,int val){
        for(int i = inbegin;i <= inend;i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || inorder == null) {
            return null;
        }
        if(postorder.length == 0 || inorder.length ==0) {
            return null;
        }
        postIndex = postorder.length-1;
        return buildTreeChild(inorder,postorder,0,inorder.length-1);
    }
    */


    //二叉树创建字符串
    public void tree2strChild(TreeNode t,StringBuilder sb) {
        if(t == null) {
            return ;
        }
        sb.append(t.val);
        if(t.left == null) {
            if(t.right == null) {
                return;
            }else{
                sb.append("()");
            }
        }else{
            sb.append("(");
            tree2strChild(t.left,sb);
            sb.append(")");
        }
        //以上代码是递归前t的位置
        if(t.right == null) {
            return;
        }else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }

    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();

        tree2strChild(t,sb);

        return sb.toString();
    }
}
