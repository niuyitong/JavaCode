import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        int res = combination(2,3);
        System.out.println(res);
    }
    public static  int combination (int r, int n) {
        int res = 0;
        int tmp = n;
        int sum = 1;
        while(tmp>r){
            sum *= tmp;
            tmp--;
        }
        int sub = n-r;
        while(sub>=1){
            sum /= sub;
            sub--;
        }
        return sum;
    }
    public int[] arrayMerge (int[] array1, int n, int[] array2, int m) {
        if(m==0){
            return array1;
        }
        int i = 0;
        int j = m-1;
        int[] res = new int[m+n];
        int k = 0;
        while(i<n && j>=0){
            if(array1[i]<=array2[j]){
                res[k] = array1[i];
                ++k;
                ++i;
            }else{
                res[k] = array2[j];
                ++k;
                --j;
            }
        }
        if(i==n){
            while(j>=0){
                res[k] = array2[j];
                ++k;
                --j;
            }
        }
        if(j<0){
            while(i<n){
                res[k] = array1[i];
                ++k;
                ++i;
            }
        }
        return res;
    }
















    public static void main1(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int[][] arr = new int[4][3];
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    arr[i][j] = in.nextInt();
                }
            }
            int res = minPathSum(arr);
            System.out.println(res);
        }
    }

    public static int minPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        for(int i=1; i<m; i++){
            grid[i][0] += grid[i-1][0];
        }
        for(int j=1; j<n; j++){
            grid[0][j] += grid[0][j-1];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                grid[i][j] += Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }




    public static int minPathSum1(int[][] grid) {
        int width = grid[0].length, high = grid.length;

        // 初始化
        for (int i = 1; i < high; i++) grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < width; i++) grid[0][i] += grid[0][i - 1];
        for (int i = 1; i < high; i++)
            for (int j = 1; j < width; j++)
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        return grid[high - 1][width - 1];
    }
}