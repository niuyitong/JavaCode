import java.util.Arrays;
public class Test {

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

            public static int[] plusOne(int[] digits) {
             /*
             //待完善
            int right = digits.length-1;
            int[] arr = new int[] {1,0};

            if(digits[right]<9){
                digits[right]++;
                return digits;
            }else {
                digits[right-1]++;
                digits[right] = 0;
                return digits;
            }
            */
//完善过的
        for(int i = digits.length-1;i>=0;i--){
            if(digits[i]!=9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        //跳出来说明全部为9
        int[] arr = new int[digits.length+1];
        arr[0] = 1;
        return arr;
         }


    public static int climbStairs(int n) {
        if(n==1 || n==2){
            return n;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for(int i = 3;i<=n;i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
         public static int singleNumber(int[] nums) {
            int tmp = 0;
            for(int i = 0;i<nums.length;i++){
                tmp ^=nums[i];
            }
            return tmp;
         }
        public static int majorityElement(int[] nums) {

            int count = 0;
            int ret = 0;
            for (int num : nums) {
                if (count == 0) {
                    ret = num;
                }
                count += (num == ret) ? 1 : -1;
            }
            return ret;
          }
    public static int fib(int N) {
        if(N==1 || N==2){
            return 1;
        }
        int i = 1;
        int j = 1;
        int ret = 0;
        for(int n = 3;n<=N;n++){
            ret = i+j;
            i = j;
            j = ret;
        }
        return ret;
    }
    public static int mySqrt(int x) {
        int left = 0;
        int right = x / 2 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
//标准解法
    public static double  myPow2(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) res *= x;
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    public static double myPow(double x, int n) {
            double ret = 1.0;
            if(n>0){
                for(int i = 0;i<n;i++){
                    ret *=x;
                }
            }else if(n<0){
                int tmp = -n;
                for(int i=0;i<tmp;i++){
                    ret *= x;
                }
                ret = 1.0/ret;
            }else
                ret = 1;
            return ret;
    }
        public static void main(String[] args){

            //实现 pow(x, n) ，即计算 x 的 n 次幂函数。
            double x = 2;
            int n = -3;
            double ret = myPow(x,n);
            System.out.println(ret);
            /*
            //计算并返回 x 的平方根，其中 x 是非负整数。
            int num = 8;
            int ret = mySqrt(num);
            System.out.println(ret);

            //斐波那契
            int N = 5;
            int ret = fib(N);
            System.out.println(ret);
            //求众数（从第一个数开始count=1，遇到相同的就加1，
            // 遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
            int[] arr2 = {2,2,1,1,2,4,4};
            int ret3 = majorityElement(arr2);
            System.out.println(ret3);

            //只出现一次的数字
            int[] arr = {1,2,3,3,1,5,2};
            int ret2 = singleNumber(arr);
            System.out.println(ret2);

            //爬楼梯
            int n = 10;
            int ret = climbStairs(n);

            //给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
            //最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
            //输入: [1,2,3]   输出: [1,2,4]
            //解释: 输入数组表示数字 123。129 130
            int[] arr = {9};
            System.out.println(Arrays.toString(plusOne(arr)));

            //判断一个数是否是回文数
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
