import java.util.Scanner;
import java.util.Random;
public class Test {
	
	
	public static void main (String[] args) {
		//完成猜数字游戏
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int randNum = rand.nextInt(100)+1;//0-99 +1 ->1-100
		while(true) {
			System.out.println("请输入要猜的数字：");
			int num = scan.nextInt();
			if(num>randNum){
				System.out.println("猜大了");
			}else if(num<randNum){
				System.out.println("猜小了");
			}else {
				System.out.println("猜对了");
				break;
			}
		}
		scan.close();
		
		//输出一个整数的每一位.(递归) 
		int num = 1234;
		Print(num);

		//获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
		int num = 10;
		int i = 0;
		for(i=31;i>=1;i-=2){
			System.out.print(((num>>i)&1)+" ");//偶位  移完后num不变
		}
		System.out.println();
		for(i=30;i>=0;i-=2){
			System.out.print(((num>>i)&1)+" ");//奇位
		}
		*/
		

		//写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
		int num = 15;
		int ret = count_1(num);
		System.out.println(ret);
		
		
		// 编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，
		//提示“登录成功”,密码错误， 可以重新输 入，最多输入三次。三次均错，
		//则提示退出程序 
		int i = 3;
		String str = "123321";
		int count = 0;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("请输入密码：");
			String scr = scan.nextLine();//  A.equals(B),其中A不能为空
			if(str.equals(scr)){     //equals相当于C中的strcmp,比较
				System.out.println("输入正确，登陆成功");
				break;
			}else {
				System.out.println("密码错误");
				count++;
			}
		}while(count<3);
		if(count==3){
			System.out.println("三次均错，退出程序");
		}
		scan.close();
		
		
		//求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，
		//其各位数字的立方和确好等于该数本身，如；153＝1＋5＋3?，则153是
		//一个“水仙花数”。) 
		int sum = 0;
		int i = 0;
		for(i=100; i<=999;i++){
			if(i==Math.pow(i%10,3)+Math.pow(i%100/10,3)+Math.pow(i/100,3)){
				System.out.println(i);
			}
		}
		
		
		//编写程序数一下 1到 100 的所有整数中出现多少个数字9
		//20个
		int i = 0;
		int count = 0;
		for(i=1; i<=100; i++){
			if(i%10==9){
				count++;
			}
			if(i/10==9){
				count++;
			}
		}
		System.out.println(count);
		
		
		//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
		int i = 0;
		double j = 1.0;
		double sum = 0;
		for(i=1; i<=100; i++){
			sum += j/i;
			j = -j;
		}
		System.out.println(sum);
		
		
		//求两个正整数的最大公约数
		//
		int n1=34;
		int n2=40;
		int c = n1;
		if(n1>n2){
			c = n2;
		}
		while(n1%c!=0 || n2%c!=0){
			c--;
		}
		System.out.println(c);
		//优化 辗转相除法
		/*
		public static int fun1(int a,int b){
			int c=0;
			while(a%b!=0){
				c=a%b;
				a=b;
				b=c;
			}
			return tmp;
		}
		*/
		
		
		//输出乘法口诀表 
		int n = 9;
		printMulTab(n);
		
		
		//输出 1000 - 2000 之间所有的闰年
		int i=0;
		int ret = 1;
		for (i=1000; i<=2000;i++) {
			if(ret == leapYear(i)) {
				System.out.println(i);
			}
		}
		
		
		//打印 1 - 100 之间所有的素数 
		int i = 0;
		int ret = 1;
		for(i=2; i<=100;i++) {
			if(ret==isPrime(i)) {
				System.out.println(i);
			}
		}
		
		
		//判定一个数字是否是素数 
		int num = 17;
		int i=0;
		int flag = 0;
		for(i=2;i<num;i++){
			if(num%i==0) {
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
			System.out.println("是素数");
		}else {
			System.out.println("不是素数");
		}
		/*
		public static boolean isPrime(int n){
			for(int i=2;i<=Math.sqrt(n);i++){
				if(n%i==0){
					return false;
				}
				return true;
			}
		}
		*/
			
		
		//根据年龄, 来打印出当前年龄的人是少年(低于18),
		//青年(19-28), 中年(29-55), 老年(56以上)
		Scanner scan = new Scanner(System.in);
		System.out.println("输入学生的年龄：");
		int age = scan.nextInt();
		
		if(age<=18) {
			System.out.println("少年");
		}else if(age>=19 && age<=28) {
			System.out.println("青年");
		}else if(age>=29 && age<=55) {
			System.out.println("中年");
		}else {
			System.out.println("老年");
		}
		scan.close();
		
	}
	//以下为方法
	public static int isPrime (int num) {
		int i = 0;
		for(i=2; i<num; i++) {
			if(num%i==0){
				return 0;
			}
		}
		return 1;
	}
	public static int leapYear(int year) {
		if((year%4==0&&year%100!=0)||(year%400==0)) {
			return 1;
		}
		return 0;
	}
	public static void printMulTab(int n){
		int i = 0;
		int j = 0;
		for(i=1; i<=9; i++){
			for(j=1; j<=i; j++) {
				System.out.print(i+"*"+j+"="+i*j+" ");
			}
			System.out.println();
		}
	}
	public static int pow(int num,int n){
		int ret = 1;
		int i=0;
		for(i=1; i<=n; i++){
			ret *= num;
		}
		return ret;
	}
	public static int count_1(int num){
		int i=0;
		int count = 0;
		for(i=0; i<31; i++){
			if((num&1)==1){
				count++;
			}
			num = num>>1;
		}
		return count;
		//另一种方法
		/*
		int count = 0;
		while(num!=0){
			count++;
			num = num&(num-1);
		}
		return count;
		*/
	}
	public static void Print (int num){
		if(num>9) {
			Print(num/10);
		}
		System.out.println(num%10);
	}
}
