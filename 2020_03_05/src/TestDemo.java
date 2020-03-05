import java.util.Scanner;

public class TestDemo {
    //买苹果
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count1 = n/8;//0
        int count2 = n%8/6;//3
        while(count1>=0){
            if(count1>=0&&(count1*8+count2*6<n)){
                count1--;
            }
            while((count1*8+count2*6)<n){
                count2++;
            }
            if(count1*8+count2*6==n){
                System.out.println(count1+count2);
                return ;
            }
            count1--;
        }
        System.out.println(-1);
    }
    //删除公共字符串
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str1.length(); i++){
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")){
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }
}
