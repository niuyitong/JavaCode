import java.lang.reflect.Array;
import java.util.Arrays;
public class TestDemo {
    public static void main(String[] args) {
        //int[] A = {-4,-1,0,3,10};
        //int[] B = sortedSquares2(A);
        //for(int i=0;i<B.length;i++){
        //    System.out.print(B[i]+" ");
        //}


    }

    //寻找数组的中心索引
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        int leftSum = 0;
        for(int i=0; i<nums.length; i++){
            if(leftSum*2+nums[i]==sum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
    //按奇偶排序数组
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length-1;
        while((left) < (right)){
            while(left<right && A[left]%2==0){
                left++;
            }
            while(left<right && A[right]%2!=0){
                right--;
            }
            int tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
            left++;
            right--;
        }
        return A;
    }

    //仅仅反转字母
    class Solution {
        public String reverseOnlyLetters(String S) {
            char[] arr = S.toCharArray();
            int left = 0;
            int right = S.length()-1;
            while(left<right){
                while(left<right && !(arr[left]>='A'&&arr[left]<='Z'
                        ||arr[left]>='a'&&arr[left]<='z')){
                    left++;
                }
                while(left<right && !(arr[right]>='A'&&arr[right]<='Z'
                        ||arr[right]>='a'&&arr[right]<='z')){
                    right--;
                }
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
            String str = new String(arr);
            return str;
        }
    }

    //有序数组的平方（注意负数）
    public static int[] sortedSquares(int[] A) {
        for(int i=0; i<A.length; i++){
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
    public static int[] sortedSquares2(int[] A) {
        int[] nums = new int[A.length];
        int left = 0;
        int right = A.length-1;
        int i = right;
        while(i>=0){
            nums[i--] = A[left]*A[left]>A[right]*A[right] ?
                    A[left]*A[left++] : A[right]*A[right--];
        }
        return nums;
    }
}
