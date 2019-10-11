

import java.util.Scanner;


/**
1、Scanner:工具类 引入包
   new;
   Scanner scan = new Scanner(System.in);//生成一个对象
2、public static 方法的返回值 
*/
public class Test {
	
	public static void main (String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("输入学生的姓名：");
		String name = scan.nextLine();
		System.out.println("姓名："+name);
		System.out.println("输入学生的年龄：");
		int age = scan.nextInt();
		System.out.println("年龄："+age);
		scan.close;
		/*
		//计算1!+2!+3!+4!+5!
		int num = 5;
		int ret = 1;
		int sum = 0;
		int i = 0;
		for(i=1; i<=num; i++){
			ret *= i;
			sum += ret;
		}
		System.out.println(sum);
		
		
		//分别计算奇数的和，偶数的和
		int sumOdd = 0;//奇数
		int sumEve = 0;//偶数
		int i = 0;
		for(i=1; i<=100; i+=2) {
			sumOdd += i;
		}
		System.out.println(sumOdd);
		for(i=2; i<=100; i+=2) {
			sumEve += i;
		}
		System.out.println(sumEve);
		*/
	}
}