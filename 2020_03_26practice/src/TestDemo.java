import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
class Student{
    String name;
    int score;
    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
}
public class TestDemo {
//数字分类
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = in.nextInt();
            }
            int A1 = 0;
            int A2 = 0;
            int flg = 1;
            int A3 = 0;
            double A4 = 0.0;
            int A5 = 0;
            int count = 0;
            Boolean B1 = true;
            Boolean B2 = true;
            Boolean B3 = true;
            Boolean B4 = true;
            Boolean B5 = true;
            for(int i=0; i<arr.length; i++){
                if(arr[i]%2==0 && arr[i]%5==0){
                    A1 += arr[i];
                    B1 = false;
                }
                if((arr[i]%5)==1){
                    A2 += flg*arr[i];
                    flg = -flg;
                    B2 = false;
                }
                if((arr[i]%5)==2){
                    A3++;
                    B3 = false;
                }
                if((arr[i]%5)==3){
                    A4 += arr[i];
                    count++;
                    B4 = false;
                }
                if((arr[i]%5)==4){
                    if(arr[i]>A5){
                        A5 = arr[i];
                    }
                    B5 = false;
                }
            }
            if(B1){
                System.out.print("N ");
            }else{
                System.out.print(A1+ " ");
            }
            if(B2){
                System.out.print("N ");
            }else{
                System.out.print(A2+ " ");
            }
            if(B3){
                System.out.print("N ");
            }else{
                System.out.print(A3+ " ");
            }
            if(B4){
                System.out.print("N");
            }else{
                A4 = A4/count;
                System.out.printf("%.1f",A4);
            }
            if(B5){
                System.out.print(" N");
            }else{
                System.out.print(" " + A5);
            }
            System.out.println();
        }
    }
    //平衡二叉树
    public class Balance {
        public int treeHight(TreeNode root){
            if(root==null){
                return 0;
            }
            int leftH = treeHight(root.left);
            int rightH = treeHight(root.right);
            return leftH > rightH ? leftH+1 : rightH+1;
        }
        public boolean isBalance(TreeNode root) {
            if(root==null){
                return true;
            }
            int leftH = treeHight(root.left);
            int rightH = treeHight(root.right);
            int len = Math.abs(leftH-rightH);
            return len<=1 && isBalance(root.left) && isBalance(root.right);
        }
    }
    //给学生排序
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int type = in.nextInt();
            List<Student> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(new Student(in.next(),in.nextInt()));
            }
            if(type==1){
                list.sort((o1,o2) -> o1.score-o2.score);
            }else{
                list.sort((o2,o1) -> o1.score-o2.score);
            }
            for(Student stu : list){
                System.out.println(stu.name + " " + stu.score);
            }
        }
    }
}