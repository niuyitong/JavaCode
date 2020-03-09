
import java.util.*;
public class TestDemo {
    //n个数里出现次数大于等于n/2的数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int[] arr = new int[strs.length];
        for(int i=0; i<strs.length; i++){
            arr[i] = Integer.valueOf(strs[i]);
        }
        int num = arr[0];
        int count = 0;
        for(int j=1; j<arr.length; j++){
            if(arr[j]==num){
                count++;
            }else if(count>=0){
                count--;
            }else{
                num = arr[j];
            }
        }
        System.out.println(num);
    }
    //计算糖果
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y1 = sc.nextInt();
        int y2 = sc.nextInt();
        int y3 = sc.nextInt();
        int y4 = sc.nextInt();
        float a = (y1+y3)/2f;
        float b = (y3-y1)/2f;
        float c = (y4-y2)/2f;
        if( (a-((y1+y3)/2))!=0 ){
            System.out.println("No");
            return ;
        }
        if((b-((y3-y1)/2)!=0) || b!=((y2+y4)/2)){
            System.out.println("No");
            return ;
        }
        if((c-((y4-y2)/2))!=0){
            System.out.println("No");
            return ;
        }
        System.out.print((int)a + " " + (int)b + " " + (int)c);
    }
}
