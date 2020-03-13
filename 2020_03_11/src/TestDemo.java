import java.util.Scanner;

public class TestDemo {
    //将数字以字符串的形式倒序输出
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = String.valueOf(n);
        int len = str.length();
        for(int i=len-1; i>=0; i--){
            System.out.print(str.charAt(i));
        }
    }
    //末尾0的个数
    public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int res = 0; 
		for(int i = n; i >= 5; i--) { 
			int tmp = i; 
			while(tmp % 5 == 0) { 
				res++; 
				tmp /= 5; 
			} 
		}
		System.out.println(res); 
	}
}
