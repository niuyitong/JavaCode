public class TestDemo {
    public static void main(String[] args) {
        /*
        int[] nums = {1,2,9};
        int[] ret = plusOne(nums);
        String a = "42";
        int ret2 = myAtoi(a);
        System.out.println(ret2);
        */
        int num = 10;
        String s = "a eS:e";
        s = s.toLowerCase();
        System.out.println(s);

    }
    //压缩字符串
    public static int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<chars.length){
            char ret = chars[i++];
            int count = 1;
            while(i<chars.length && chars[i]==ret){
                i++;
                count++;
            }
            if(count!=1){
                sb.append(ret).append(count);
            }else{
                sb.append(ret);
            }
        }
        for(int j=0; j<sb.length(); j++){
            chars[j] = sb.charAt(j);
        }
        return sb.length();
    }

    //验证回文串
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            while(left<right &&
                    (s.charAt(left)<'a'|| s.charAt(left)>'z') &&
                    (s.charAt(left)<'0'|| s.charAt(left)>'9')){
                left++;
            }
            while(left<right &&
                    (s.charAt(right)<'a'|| s.charAt(right)>'z') &&
                    (s.charAt(right)<'0'|| s.charAt(right)>'9')){
                right--;
            }
            if(left<right && s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //给定一个按照升序排列的整数数组 nums，和一个目标值 target。
    // 找出给定目标值在数组中的开始位置和结束位置。
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        int start = 0;
        int end = 0;
        int i = 0;
        while(i<nums.length && nums[i]!=target){
            i++;
        }
        if(i==nums.length){
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
        start = i++;
        while(i<nums.length && nums[i]==target){
            i++;
        }
        end = i-1;
        ret[0] = start;
        ret[1] = end;
        return ret;
    }
    //字符串转换整数
    public static int myAtoi(String str) {
        int sign = 1;
        int i = 0;
        while(i<str.length() && str.charAt(i)==' '){
            i++;
        }
        if(i<str.length() && (str.charAt(i)=='-'||str.charAt(i)=='+')){
            sign = str.charAt(i)=='-' ? -1 : 1;
            i++;
        }
        if(i<str.length() && (str.charAt(i)-'0')<0 &&
                (str.charAt(i)-'0')>9){
            return 0;
        }
        long sum = 0;
        while(i<str.length() && (str.charAt(i)-'0')>=0
                && (str.charAt(i)-'0')<=9){
            sum = 10*sum+(str.charAt(i)-'0');
            i++;
        }
        sum *= sign;
        if(sum>Integer.MAX_VALUE ){
            return Integer.MAX_VALUE;
        }else if(sum<Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }else{
            return (int)sum;
        }
    }
    //二进制求和
    public static String addBinary(String a, String b) {
        return null;
    }
    //两数之和
    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return ret;
    }
    //第三大的数
    public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>first){
                third = second;
                second = first;
                first = nums[i];
            }else if(nums[i]<first && nums[i]>second){
                third = second;
                second = nums[i];
            }else if(nums[i]<second && nums[i]>third){
                third = nums[i];
            }
        }
        return (third==Long.MIN_VALUE || third==second) ? (int)first : (int)third;
    }
    //加一
    public static int[] plusOne(int[] digits) {
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
}
