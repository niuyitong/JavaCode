class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TestDemo {
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
    //二维数组中的查找
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if(n==0){
            return false;
        }
        int m = matrix[0].length;
        int i = 0;
        int j = m-1;
        while(i<n && j>=0 && matrix[i][j]!=target){
            if(matrix[i][j]<target){
                i++;
            }else{
                j--;
            }
        }
        if(i<n && j>=0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(arr, 20));
    }
}
