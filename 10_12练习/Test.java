/**
//啦啦啦
//；噜噜
*/
public class Test {
	public static void print(int num) {
		if(num>9) {
			print(num/10);
		}
		System.out.println(num%10);
	}
	public static int Sum (int num) {
		int sum = 0;
		if(num ==1){
			return 1;
		}
			return num + Sum(num-1);
	}
	public static int func (int num){
		if(num <9){
			return num;
		}
		return num%10+func(num/10);
	}
	public static int jump (int n) {
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		return jump(n-1)+jump(n-2);
	}
	public static void main (String[] args){
		//青蛙跳台阶
		int n = 4;
		int ret = jump(n);
		System.out.println(ret);
	}
	public static void main3 (String[] args){
		int num = 1279;
		int ret = func(num);
		System.out.println(ret);
	}
	public static void main2 (String[] args){
		//求1+2+3......num
		int num = 10;
		int sum = Sum(num);
		System.out.println(sum);
	}
	public static void main1 (String[] args){
		//打印1 2 3 4
		int num = 1234;
		print(num);
	}
}