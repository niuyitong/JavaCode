import java.util.Scanner;

public class TestDemo {
    //整数与IP地址间的转换
    public static long IPToNum(String str){
        String[] strs = str.split("\\.");

        int[] arr = new int[32];
        int k=0;
        for(int i=0; i<strs.length; i++){
            long num = Integer.valueOf(strs[i]);
            long tmp = 128;
            for(int j=0; j<8; j++){
                long t = num & tmp;
                if(t!=0){
                    arr[k++] = 1;
                }else{
                    arr[k++] = 0;
                }
                tmp /= 2;
            }
        }
        long sum = 0;
        for(int i=0; i<32; i++){
            sum += arr[31-i] * (long)Math.pow(2,i);
        }
        return sum;
    }
    public static long[] NumToIP(long num){
        String[] str = new String[4];
        long[] arr = new long[4];
        StringBuffer sb = new StringBuffer();
        int k = 31;
        for(int i=0; i<str.length; i++){
            for(int j=0; j<8; j++){
                sb.append((num>>(k--))&1);
            }
            str[i] = sb.toString();
            sb.delete(0,sb.length());
            //00101100
            long tmp = 0;
            for(int m=0; m<8; m++){
                tmp += Integer.valueOf(str[i].charAt(m)+"")*(int)Math.pow(2,7-m);
            }
            arr[i] = tmp;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            System.out.println(IPToNum(str));

            String str2 = in.nextLine();
            long num = Long.valueOf(str2);
            long[] ret2 = NumToIP(num);
            for(int i=0; i<ret2.length; i++){
                if(i==ret2.length-1){
                    System.out.print(ret2[i]);
                    System.out.println();
                }else {
                    System.out.print(ret2[i] + ".");
                }
            }
        }
    }
}
