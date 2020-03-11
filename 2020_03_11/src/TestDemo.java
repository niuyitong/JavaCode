import java.util.Scanner;

public class TestDemo {
    //将数字以字符串的形式倒序输出
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = String.valueOf(n);
        int len = str.length();
        for(int i=len-1; i>=0; i--){
            System.out.print(str.charAt(i));
        }
    }
    //末尾0的个数
    public static int fib(int n){
        int sum = 1;
        while(n!=0){
            sum *= n;
            n--;
        }
        return sum;
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int ret = fib(n);
            int count = 0;
            while(ret!=0){
                int tmp = ret%10;
                if(tmp==0){
                    count++;
                }else{
                    break;
                }
                ret /= 10;
            }
            System.out.println(count);
        }
    }
}
