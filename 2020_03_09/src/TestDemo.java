import java.util.Scanner;

class Test{
    //不要二
    public static void main(String[] args) {
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
public class TestDemo {

}

