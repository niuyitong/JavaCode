import java.util.*;

public class TestDemo {

    //最高分是多少
    public static int getMaxScore(int[] arr,int a, int b){
        if(a>b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        int max = arr[a];
        for(int i=a+1; i<=b; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[] arr = new int[N+1];
            for(int i=1; i<N+1; i++){
                arr[i] = in.nextInt();
            }
            in.nextLine();
            for(int j=0; j<M; j++){
                int ret = -1;
                String[] str = in.nextLine().split(" ");
                char c = str[0].charAt(0);
                int a = Integer.valueOf(str[1]);
                int b = Integer.valueOf(str[2]);

                if(c=='Q'){
                    ret = getMaxScore(arr,a,b);
                }else{
                    arr[a] = b;
                }
                if(ret!=-1){
                    System.out.println(ret);
                }
            }
        }
    }
    //小易的升级之路
    public static int maxGYS(int m, int n){
        if(m<n){//m存大值
            int tmp = m;
            m = n;
            n = tmp;
        }
        if(m%n==0){
            return n;
        }else{
            for(int i=n-1; i>0; i--){
                if(m%i==0 && n%i==0){
                    return i;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int a = in.nextInt();
            for(int i=0; i<n; i++){
                int tmp = in.nextInt();
                if(tmp<=a){
                    a += tmp;
                }else{
                    a += maxGYS(a,tmp);
                }
            }
            System.out.println(a);
        }
    }
}