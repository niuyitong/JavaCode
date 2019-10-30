import static java.lang.Math.abs;

public class Test {
    public static int hammingWeight(int n) {
        int count = 0;
        for(int i=0;i<32;i++){

            if(((n>>i)&1)==1){
                count++;
            }
        }
        return count;
    }
    public static int reverseBits(int n) {

        int res = 0;
        for(int i=0; i<32; i++){
            if((n&1)==1){
                res = (res<<1)+1;
            }else {
                res = res<<1;
            }
            n = n>>1;
        }
        return res;
    }
    public static int reverse(int x) {
        int ret = 0;
        while(x!=0){
                ret = ret*10+x%10;
                x /=10;
            }
            return ret;
    }


    public static void main(String[] args){
        /*
        //位1的个数
        int n = 3;
        int ret = hammingWeight(n);
        */

        /*
        //颠倒给定的 32 位无符号整数的二进制位。
        //输入0011 1010   输出0101 1100
        int n = 33;
        int ret = reverseBits(n);
        System.out.println(ret);
        */

        //给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
        //输入123  输出321
        int num = -123;
        int ret = reverse(num);
        System.out.println(ret);
    }
}
