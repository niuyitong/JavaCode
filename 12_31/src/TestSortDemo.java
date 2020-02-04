import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
public class TestSortDemo{
    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param array
     */
    public static void bubbleSort(int[] array) {
        boolean flg = false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(!flg) {
                break;
            }
        }
    }
    //找基准的下标
    public static int partion(int[] array,int start,int end) {
        int tmp = array[start];
        while (start < end) {
            while ((start < end) && array[end] >= tmp) {
                end--;
            }
            if(start >= end) {
                break;
            }else {
                array[start] = array[end];
            }
            while ((start < end) && array[start] <= tmp) {
                start++;
            }
            if(start >= end) {
                break;
            }else {
                array[end] = array[start];
            }
        }
        array[start] = tmp;
        return start;
    }

    public static void insertSort2(int[] array,int low,int high) {
        for (int i = low+1; i <= high; i++) {
            int tmp = array[i];
            int j = 0;
            for (j = i-1; j >= low ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;//前面的序列已经有序
                }
            }
            //
            array[j+1] = tmp;
        }
    }

    public static void swap(int[] array,int low,int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }

    public static void ThreeNumOfMiddle
            (int[] array,int low,int high) {
        //array[mid] <= array[low] <= array[high];
        int mid = (low+high)/2;
        //array[mid] <= array[high]
        if(array[mid] > array[high]) {
            swap(array,mid,high);
        }
        //array[mid] <= array[low]
        if(array[mid] > array[low]) {
            swap(array,mid,low);
        }
        //array[low] <= array[high]
        if(array[low] > array[high]) {
            swap(array,low,high);
        }
    }
    //快排的递归
    public static void quick(int[] array,int low,int high) {
        //if(low == high) {} 他两相遇有一个元素
        //if(low > high) {} 右边的情况
        if(low >= high) {
            return;
        }
        //优化方式一：
        if(high-low+1 < 100) {
            insertSort2(array,low,high);
            return;
        }
        //优化方式二
        ThreeNumOfMiddle(array,low,high);

        //1、写一个函数，将待排序序列分为两部分
        int pivot = partion(array,low,high);
        //2、开始递归，左   右
        quick(array,low,pivot-1);
        quick(array,pivot+1,high);

    }

    /**
     * 时间复杂度：O(nlog2n)    最坏情况：O(n^2) 数据有序
     * 空间复杂度：O(log2n)
     * 稳定性：不稳定
     * @param array
     */
    public static void quickSort(int[] array) {
        quick(array,0,array.length-1);
        quick2(array,0,array.length-1);
    }
    //快排的非递归
    public static void quick2(int[] array,int low,int high) {
        int pivot = partion(array,low,high);

        Stack<Integer> stack = new Stack<>();
        if(pivot > low+1 ) {
            stack.push(low);
            stack.push(pivot-1);
        }
        if(pivot < high-1) {
            stack.push(pivot+1);
            stack.push(high);
        }
        while (!stack.empty()) {
            high = stack.pop();
            low = stack.pop();
            pivot = partion(array,low,high);
            if(pivot > low+1 ) {
                stack.push(low);
                stack.push(pivot-1);
            }
            if(pivot < high-1) {
                stack.push(pivot+1);
                stack.push(high);
            }
        }

    }
    public static void main1(String[] args) {
        int[] array = new int[10000000];
        /*for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }*/
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
        }

        //System.out.println(Arrays.toString(array));
        long time1 = System.currentTimeMillis();
        quickSort(array);
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
        //System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}

