import java.util.Scanner;


public class Test {
	
	public static void main(String[] args) {
		/*
		//递归求N的阶乘
		int N = 5;
		int ret = fac(N);
		System.out.println(ret);
		*/
		
		/*
		//递归求1+2+3+4...+10
		int num = 10;
		int ret = Sum(num);
		System.out.println(ret);
		*/
		
		/*
		//按顺序打印每一个数字的每一位
		int num = 1234;
		Print(num);
		*/
		
		/*
		//写一个递归方法，输入一个非负整数，返回组成他的数字之和
		int num = 255;
		int ret = numSum(num);
		System.out.println(ret);
		*/
		
		/*
		//求斐波那契数列的第N项
		//1 1 2 3 5 8 13 21 34 55
		int N = 8;
		int ret = fab(N);
		System.out.println(ret);
		*/
		
		/* 
		//汉诺塔
		Hanota(3,'A','B','C');
		*/
		
		
		//青蛙跳台阶，一次跳一级或两级，问跳上一个N级的台阶有几种跳法
		//1 2 3 5 8
		int n = 5;
		int ret = Jump(n);
		System.out.println(ret);
	}
	public static int Jump(int n){
			if (n==1 || n==2){
				return n;
			}
			int f1 = 1;
			int f2 = 2;
			int f3 = 0;
			for(int i=3; i<=n; i++){
				f3 = f1+f2;
				f1 = f2;
				f2 = f3;
			}
			return f3;
		}
	//A-C,A-B,C-B,A-C,B-A,B-C,A-C
	public static void move(char pos1,char pos2){
	System.out.println(pos1 + "->" + pos2);
	}
	//pos1通过pos2移动到pos3
	public static void Hanota(int n,char pos1,char pos2,char pos3){
		if(n==1){
			move(pos1,pos3);
		}
		else {
			Hanota(n-1,pos1,pos3,pos2);
			move(pos1,pos3);
			Hanota(n-1,pos2,pos1,pos3);
		}
	}
	public static int fab(int N){
		if(N<=2){
			return 1;
		}
		return fab(N-1)+fab(N-2);
	}
	public static int numSum(int num){
		if(num<10){
			return num%10;
		}
		return num%10+numSum(num/10);
	}
	public static void Print(int num){
		if(num>9){
			Print(num/10);
		}
		System.out.println(num%10);
	}
	
	public static int Sum(int num){
	if(num==1){
		return 1;
	}
	return num+Sum(num-1);
	}
	
	
	public static int fac(int num){
		if(num==1){
			return 1;
		}
		return num*fac(num-1);
	}
}