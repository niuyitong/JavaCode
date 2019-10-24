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
        public static int majorityElement(int[] nums2) {

            int count = 1;
            int maj = nums2[0];
            for (int i = 1; i < nums2.length; i++) {
                if (maj == nums2[i])
                    count++;
                else {
                    count--;
                    if (count == 0) {
                        maj = nums2[i + 1];
                    }
                }
            }
            return maj;
          }
        public static void main(String[] args){
            //求众数（从第一个数开始count=1，遇到相同的就加1，
            // 遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
            int[] arr2 = {2,2,1,1,2,4,2,4,4,4,4,4,4,4};
            int ret3 = majorityElement(arr2);
            System.out.println(ret3);
            //只出现一次的数字
            int[] arr = {1,2,3,3,1,5,2};
            int ret2 = singleNumber(arr);
            System.out.println(ret2);
            //爬楼梯
            int n = 10;
            int ret = climbStairs(n);
            /*
            //给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
            //最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
            //输入: [1,2,3]   输出: [1,2,4]
            //解释: 输入数组表示数字 123。129 130
            int[] arr = {9};
            System.out.println(Arrays.toString(plusOne(arr)));
            */
            /*
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
