import java.util.*;

public class Test{
    //二维数组打印
    static int k = 0;
    public  static void printAdd(int[][] arr, int i, int j,int n,int[] res){
        if(i>n-1 || j>n-1){
            return;
        }
        if(k==res.length){
            return;
        }
        res[k++] = arr[i][j];
        printAdd(arr,i+1,j+1,n,res);
    }
    public  static void print(int[][] arr,int i, int j,int n,int[] res){
        if(i<0 || j<0){
            return;
        }
        if(k==res.length){
            return;
        }
        res[k++] = arr[i][j];
        if(i==0){
            if(j<n){
                printAdd(arr,i+1,j+1,n,res);
                print(arr,i,j-1,n,res);
            }
        }else{
            if(j==0){
                if(i<n){
                    printAdd(arr,i+1,j+1,n,res);
                    print(arr,i+1,j,n,res);
                }
            }
        }
    }
    public  static int[] arrayPrint(int[][] arr, int n) {
        int[] res = new int[n*n];
        k = 0;
        int i = 0;
        int j = n-1;
        print(arr,i,j,n,res);
        print(arr,1,0,n,res);
        return res;
    }
    //回文串
    public static Boolean isHuiwen(String str){
        int left = 0;
        int right = str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            //ABCCBA
            StringBuffer str = new StringBuffer(in.nextLine());
            int left = 0;
            int right = str.length()-1;


            while(left<right){
                if(str.charAt(left)!=str.charAt(right)){
                    str.insert(right+1,str.charAt(left));
                    break;
                }
                left++;
                right--;
            }

            if(isHuiwen(str.toString())){
                System.out.println("YES");
            }else{
                str.deleteCharAt(right+1);
                left = 0;
                right = str.length()-1;
                while(left<right){
                    if(str.charAt(left)!=str.charAt(right)){
                        str.insert(left,str.charAt(right));
                        break;
                    }
                    left++;
                    right--;
                }
                if(isHuiwen(str.toString())){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

        }
    }
}