import java.util.*;
public class TestDemo {
    //生成格雷码  使用递归
    //递归的思路就是n位gray码是由n-1位gray码生成，举个例子简单一些：
    //比如求n=3的gray码，首先知道n=2的gray码是(00,01,11,10)
    //那么n=3的gray码其实就是对n=2的gray码首位添加0或1生成的，添加0后变成(000,001,011,010)
    //添加1后需要顺序反向就变成(110,111,101,100)
    //组合在一起就是(000,001,011,010,110,111,101,100)
    public static String[] getGray(int n) {
        if(n==1){
            String[] str = {"0","1"};
            return str;
        }
        String[] ret = getGray(n-1);
        String[] tmp = new String[ret.length];
        for(int m=ret.length-1; m>=0; m--){
            tmp[tmp.length-1-m] = ret[m];
        }
        for(int i=0; i<ret.length; i++){
            ret[i] = "0" + ret[i];
        }
        for(int j=0; j<tmp.length; j++){
            tmp[j] = "1" + tmp[j];
        }
        String[] strs = new String[ret.length+tmp.length];
        for(int i=0; i<ret.length; i++){
            strs[i] = ret[i];
        }
        for(int j=0; j<tmp.length; j++){
            strs[ret.length+j] = tmp[j];
        }
        return strs;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ret = getGray(n);
        System.out.println(Arrays.toString(ret));
    }

    public static void main1(String[] args) {
        int[] AB = {2,4};
        int[] CD = exchangeAB(AB);
        System.out.println(Arrays.toString(CD));
    }
    //不用临时变量交换两个数的值
    public static int[] exchangeAB(int[] AB) {
        AB[0] = AB[0]^AB[1];
        AB[1] = AB[0]^AB[1];
        AB[0] = AB[0]^AB[1];
        return AB;
    }
}
