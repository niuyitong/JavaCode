import java.util.Scanner;

public class TestDemo{

    //从网格左上角走到左下角的方法有几条
    public static int countWays(int x, int y) {
        if(x==1 && y ==1){
            return 1;
        }
        if(y==1) {
            return countWays(x - 1, y);
        }
        if(x==1){
            return countWays(x,y-1);
        }
        return countWays(x,y-1)+countWays(x-1,y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(countWays(x,y));
    }
    //斐波那契
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = 1;
        int b = 1;
        int c = 0;
        while(c<N){
            c = a+b;
            a = b;
            b = c;
        }
        int num = c-N;
        if(num>N-a){
            num = N-a;
        }
        System.out.println(num);
    }
}