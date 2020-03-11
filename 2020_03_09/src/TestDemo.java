import java.util.Scanner;


public class TestDemo {
    //不要二
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int evenICount = (n / 4) * 2 + (n % 4 < 2 ? n % 4 : 2);
        int oddICount = ((n - 2) / 4) * 2 + ((n - 2) % 4 < 2 ? (n - 2) % 4 : 2);
        int ans = m / 4 * (evenICount + oddICount) * 2;
        if(m % 4 > 0) ans += evenICount;
        if(m % 4 > 1) ans += evenICount;
        if(m % 4 > 2) ans += oddICount;
        System.out.println(ans);
    }
    //求最小公倍数
    //法二(a*b==a和b的最大公约数乘以a和b的最小公倍数
    public static int lcm(int m, int n) {
        return (m * n) / gcd(m, n);
    }
    //求最大公约数
    private static int gcd(int a, int b) {
        int r = a%b;
        while(r!=0){
            a = b;
            b = r;
            r = a%b;
        }
        return b;
        /*
        if (b == 0) return a;
        return gcd(b, a % b);*/
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(lcm(a, b));
    }
    //法一
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int min = 0;
        min = B<A ? B : A;
        int tmp = min;
        while(!(min%A==0 && min%B==0)){
            min += tmp;
        }
        System.out.println(min);
    }
}

