import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] nums = {5,3,9,0,2,8,6,4};
        //bubbleSort(nums);
        //selectSort(nums);
        //quickSort(nums,3,7);
        mergeSort(nums,0,7);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }
    public static void merge(int[] nums,int left,int mid,int right){

        int s1 = left;
        int s2 = mid+1;
        int k = 0;
        int[] newArr = new int[right-left+1];
        while(s1<=mid && s2<=right){
            if(nums[s1]<=nums[s2]){
                newArr[k++] = nums[s1++];
            }else{
                newArr[k++] = nums[s2++];
            }
        }
        while(s1<=mid){
            newArr[k++] = nums[s1++];
        }
        while(s2<=right){
            newArr[k++] = nums[s2++];
        }
        for(int i=0; i<newArr.length; i++){
            nums[left+i] = newArr[i];
        }
    }
    public static void mergeSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int mid = (right+left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    public static int partition(int[] nums,int low,int high){
        int tmp = nums[low];
        while(low<high){
            while(low<high && nums[high]>=tmp){
                high--;
            }
            if(low<high){
                nums[low] = nums[high];
                low++;
            }
            while(low<high && nums[low]<=tmp){
                low++;
            }
            if(low<high){
                nums[high] = nums[low];
                high--;
            }
        }
        nums[low] = tmp;
        return low;
    }
    public static void quickSort(int[] nums, int low, int right){
        if(low>right){
            return;
        }
        int pivot = partition(nums,low,right);
        quickSort(nums,low,pivot-1);
        quickSort(nums,pivot+1,right);

    }
    public static void selectSort(int[] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]>nums[j]){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
    public static void insertSort(int[] nums){

        for(int i=1; i<nums.length; i++){
            int tmp = nums[i];
            int j = 0;
            for(j=i-1; j>=0; j--){
                if(nums[j]>tmp){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            nums[j+1] = tmp;
        }
    }
    public static void bubbleSort(int[] nums){
        boolean flg = true;
        for(int i=0; i<nums.length-1; i++) {
            flg = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flg = false;
                }
            }
            if(flg){
                break;
            }
        }
    }
}
