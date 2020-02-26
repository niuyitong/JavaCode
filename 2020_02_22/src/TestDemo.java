import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class TestDemo {

    //把二叉树转化成累加树
    public static int num = 0;
    public static TreeNode convertBST(TreeNode root) {
        if(root!=null){
            //遍历右子树
            convertBST(root.right);
            //遍历顶点
            root.val += num;
            num = root.val;
            //遍历左子树
            convertBST(root.left);
            return root;
        }
        return null;
    }
    public static int fib(int N){
        if(N == 1 || N == 2){
            return 1;
        }
        return fib(N-1)+fib(N-2);
    }
    //汉诺塔

    public static void main(String[] args) {
        TreeNode root = null;
        TreeNode node = convertBST(root);
        int N = 0;
        int ret = fib(N);
    }
    public static void main1(String[] args) {
        //BUTTER  FLOUR
        //HONEY   FLOUR  EGG
        int ret = 0;
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            for(int i=0; i<arr.length; i++){
                String tmp = arr[i];
                if(!list.contains(tmp)){
                    list.add(tmp);
                }
            }
            ret = list.size();
        }
        System.out.println(ret);
    }
}
