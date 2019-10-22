import java.util.Arrays;
public class Test {
    //判断一个数是否是回文数
        public static boolean isPalindrome(int x) {
            if(x<0){
                return false;
            }
            int y = x;
            int tem = 0;
            int n = 0;
            while(y!=0){
                n = y%10;
                tem = tem*10+n;
                y /= 10;
            }
            return tem==x;
        }
        //给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
        //最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
        //输入: [1,2,3]   输出: [1,2,4]
        //解释: 输入数组表示数字 123。129 130
//待完善
            public static int[] plusOne(int[] digits) {
            int right = digits.length-1;
            int[] arr = new int[] {1,0};
            if(right==0){
                if(digits[right]<9){
                    digits[right]++;
                    return digits;
                }else {
                    return arr;
                }
            }
            if(digits[right]<9){
                digits[right]++;
                return digits;
            }else {
                digits[right-1]++;
                digits[right] = 0;
                return digits;
            }
         }
        public static void main(String[] args){
            int[] arr = {9};
            System.out.println(Arrays.toString(plusOne(arr)));


            /*
            int x = 121;
            boolean ret = isPalindrome(x);
            if(ret){
                System.out.println("是回文数");
            }else {
                System.out.println("不是回文数");
            }
            */
        }
}
