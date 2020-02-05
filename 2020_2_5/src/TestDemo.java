public class TestDemo {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        merge(num1,3,num2,3);
        for (int i = 0; i < num1.length; i++) {
            System.out.print(num1[i]);
        }

        int ret3 = lengthOfLastWord("hello world");
        System.out.println(ret3);
        String arr = "aa";
        String ar = "ab";
        boolean ret = canConstruct(arr,ar);
        System.out.println(ret);
        int[] nums = {1,3,5,6};
        int ret2 = searchInsert(nums,7);
        System.out.println(ret);
    }

    //长按键入
    public static boolean isLongPressedName(String name, String typed) {
        int len_n = name.length();
        int len_t = typed.length();
        if(len_n>len_t){
            return false;
        }
        int i=0;
        int j=0;
        while(i<len_n&&j<len_t){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }else if(j>0&&typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        return i ==len_n;
    }
    //给定一个整数数组，判断是否存在重复元素。
    public static boolean containsDuplicate(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1;j<nums.length; j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void bubbleSort(int[] nums,int len){
        for(int i=0; i<len-1; i++){
            for(int j=0; j<len-i-1; j++){
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }
    //合并两个整形数组
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n;
        for(int j=0; j<n; j++){
            nums1[m] = nums2[j];
            m++;
        }
        bubbleSort(nums1,len);
    }
    //求最后一个单词长度
    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        int end = arr.length-1;
        if(end<0){
            return 0;
        }else{
            return arr[end].length();
        }
    }
    public static int switchit(int x) {
        int j=1;
        switch (x) {
            case 1:j++;
            case 2:j++;
            case 3:j++;
            case 4:j++;
            case 5:j++;
            default:j++;
        } return j+x;
    }
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    // 如果目标值不存在于数组中，返回它
    //将会被按顺序插入的位置,你可以假设数组中无重复元素
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        for(i=0; i<nums.length; i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return i;
    }

    //回文数
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
    //赎金信
    public static boolean canConstruct(
            String ransomNote, String magazine) {
        StringBuilder sb = new StringBuilder(magazine);
        for(int i=0; i<ransomNote.length(); i++){
            int ret = sb.indexOf(ransomNote.charAt(i)+"");
            if(ret>=0){
                sb.deleteCharAt(ret);
            }else{
                return false;
            }
        }
        return true;
    }
}
