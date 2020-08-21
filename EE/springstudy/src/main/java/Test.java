import java.util.*;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] ret = fibArray(n);
            circularMatrix(ret,n);
        }
    }

    private static void circularMatrix(int[] ret,int x ) {
        int[][] nums = new int [x][x];
        int count = 0;
        for(int k = 0, n = x; k < n; k++, n--) {
            for(int i = k; i < n; i++)
                nums[k][i] = ret[count++];
            for(int i = k + 1; i < n; i++)
                nums[i][n-1] = ret[count++];
            for(int i = n - 2; i >= k; i--  )
                nums[n-1][i] = ret[count++];
            for(int i = n - 2; i > k; i--)
                nums[i][k] = ret[count++];
        }

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < x; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] fibArray(int n) {
        int[] res = new int[n*n];//4
        if(res.length==1){
            res[0] = 1;
            return res;
        }
        res[res.length-1] = 1;
        res[res.length-2] = 1;
        int k = res.length-3;
        int a = 1;
        int b = 1;
        int c = a+b;

        while(k>=0){
            res[k--] = c;
            a = b;
            b = c;
            c = a+b;
        }
        return res;
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            sc.nextLine();
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String[] highRink = str1.split(" ");
            String[] farRink = str2.split(" ");
            int best = 1;
            Map<String,Integer> map = new HashMap<>();
            for(int i=0; i<highRink.length; i++){
                if(highRink[i].charAt(0)!='X'){
                    map.put(highRink[i],1);
                }else{
                    break;
                }

            }
            for(int j=0; j<farRink.length; j++){
                if(map.containsKey(farRink[j])){
                    best++;
                }else if(farRink[j].charAt(0)=='X'){
                    break;
                }
            }
            Map<String,Integer> map2 = new HashMap<>();
            int bad = n;
            for(int i=highRink.length-1; i>=0; i--){
                if(highRink[i].charAt(0)!='X'){
                    map2.put(highRink[i],1);
                }else {
                    break;
                }
            }
            for(int j=farRink.length-1; j>=0; j--){
                if(map2.containsKey(farRink[j])){
                    bad--;
                }else if(farRink[j].charAt(0)=='X'){
                    break;
                }
            }
            System.out.println(best);
            System.out.println(bad);
        }
    }
}
