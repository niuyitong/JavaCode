public class Test {
	
	public static void main (String[] args){
		//给定三个 int 变量, 求其中的最大值和最小值.
		int a = 50;
		int b = 1;
		int c = 5;
		int max = a;
		int min = a;
		if(b>a) {
			max = b;
		}
		if(b<a) {
			min = b;
		}
		if(c<min) {
			min = c;
		}
		if(c>max) {
			max = c;
		}
		System.out.println("最大值="+max);
		System.out.println("最小值="+min);

	}
	
	public static void main1(String[] args){
		//写代码实现: 给定两个 int 变量, 交换变量的值.
		int a = 10;
	    int b = 30;
	    int tmp = 0;
	    tmp = a;
	    a = b;
	    b = tmp;
	    System.out.println(a);
	    System.out.println(b);
	
	}
}