import java.util.*;
public class TestDemo2 { 
	//神奇的口袋
	static int[] weight; 
	static int N; 
	static int count=0; 
	public static void main(String[] args) { 
		Scanner input = new Scanner(System.in); 
		while (input.hasNext()) { 
			N = input.nextInt(); 
			weight = new int[N+1]; 
			for (int i = 1; i <= N; i++) { 
				weight[i] = input.nextInt(); 
			}
		count(40,N); 
		System.out.println(count); 
		} 
	}
	public static void count(int s,int n) {
		
	//如果正好装满 
		if(s==0) { 
			++count; 
			return ;
		}
		//是s<0或n<1则不能完成 
		if(s<0||(s>0&&n<1)) 
			return ; 
		count(s-weight[n],n-1); 
		count(s,n-1);
	}
    //两个栈实现队列
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        while (n>0) {
            list.add(in.nextInt());
            n--;
        }
        int count = 0;
        for(int i=0; i<list.size()-1; i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i)+list.get(j)==40){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
