import java.util.*;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main {

    public  int FindGreatestSumOfSubArray(int[] array) {
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(sum>0){
                sum += array[i];
            }else{
                sum = array[i];
            }
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str==null || str.length()==0){
            return list;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        list.add(String.valueOf(chars));
        int i = 0;
        int j = 0;
        while(true){
            i = chars.length-1;
            while(i>=1 && chars[i]<=chars[i-1]){
                i--;
            }
            if(i==0){
                break;
            }
            j = i;
            while(j<chars.length && chars[j]>chars[i-1]){
                j++;
            }
            swap(chars,i-1,j-1);
            reverse(chars,i);
            list.add(String.valueOf(chars));
        }
        return list;
    }
    public static void swap(char[] chars,int i,int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
    public static void reverse(char[] chars,int start){
        int end = chars.length-1;
        while(start<end){
            swap(chars,start,end);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        //divingBoard(1,2,3);
        String str = "bac";
        Permutation(str);
    }


    static int[] divingBoard(int a, int b, int k) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<=k; i++){
            sum += i*a;
            sum += (k-i)*b;
            set.add(sum);
            sum = 0;
        }
        int[] res = new int[set.size()];
        Object[] tmp = set.toArray();
        for(int j=0; j<res.length; j++){
            res[j] = (int)tmp[j];
            System.out.println(res[j]);
        }
        Arrays.sort(res);
        return res;
    }



















































    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int s = in.nextInt();
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] arr = new int[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = in.nextInt();
                }
            }
            if(s==0 || m==0 || n==0 || arr[0][0]==0 || arr[m-1][n-1]==0){
                System.out.println(0);
            }else{
                int i = 0;
                int j = 0;
                if(ways(arr,i,j+s,m,n,s) || ways(arr,i+s,j,m,n,s) || ways(arr,i-s,j,m,n,s) || ways(arr,i,j-s,m,n,s)){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }

        }
    }
    public static boolean ways(int[][] arr, int i, int j,int m, int n, int s){
        if(i==m-1 && j==n-1){
            return true;
        }
        if(i>=m || i<0 || j>=n || j<0){
            return false;
        }
        if(arr[i][j]==0){
            return false;
        }
        return ways(arr,i,j+s,m,n,s) || ways(arr,i+s,j,m,n,s) || ways(arr,i-s,j,m,n,s) || ways(arr,i,j-s,m,n,s);
    }
}
