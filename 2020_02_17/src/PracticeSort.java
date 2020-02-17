import java.util.*;
public class PracticeSort {
    public static void main(String[] args) {
        int[] array = {2,8,4,1};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
    //堆排序
    public static void heapSort(int[] array) {
        createHeap(array);
        int end = array.length-1;//9
        while (end > 0) {
            int tmp = array[end];
            array[end] = array[0];
            array[0] = tmp;
            adjustDown(array,0,end);//9
            end--;//8
        }
    }
    public static void adjustDown(int[] array,int root,int len) {
        //log2n
        int parent = root;
        int child = 2*parent+1;
        while (child < len) {
            if(child+1 < len && array[child] < array[child+1]) {
                child++;
            }
            //child保存的是最大值的下标
            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }
    public static void createHeap(int[] array) {
        for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
            adjustDown(array,i,array.length);
        }
    }

    //直接插入排序
    public static void insertSort(int[] array){

        for(int i=1; i<array.length; i++){
            int tmp = array[i];
            int j = 0;
            for(j=i-1; j>=0; j--){
                if(array[j]>tmp){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    //希尔排序
    public static void shellSort(int[] array,int gap){

        for(int i=gap; i<array.length; i++){
            int tmp = array[i];
            int j = 0;
            for(j=i-gap; j>=0; j -= gap){
                if(array[j]>tmp){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    //选择排序
    public static void selectSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1;j<arr.length; j++){
                if(arr[i]>arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    //快速排序
    public static int partition(int[] arr,int start, int end){
        int tmp = arr[start];
        while(start<end){
            while(start<end && arr[end]>=tmp){
                end--;
            }
            if(start<end) arr[start++] = arr[end];

            while(start<end && arr[start]<=tmp){
                start++;
            }
            if(start<end) arr[end--] = arr[start];
        }
        arr[start] = tmp;
        return start;
    }
    public static void quick(int[] arr, int low, int high){
        if(low>=high){
            return;
        }
        int pivot = partition(arr,low,high);
        quick(arr,low,pivot-1);
        quick(arr,pivot+1,high);
    }
    public  static void quickSort(int[] arr){
        quick(arr,0,arr.length-1);
    }

    //归并排序
    public static void merge(int[] arr, int start, int mid, int end){
        int[] array = new int[end-start+1];
        int s1 = start;
        int s2 = mid+1;
        int i = 0;
        while(s1<=mid && s2<=end){
            if(arr[s1]<=arr[s2]){
                array[i++] = arr[s1++];
            }else{
                array[i++] = arr[s2++];
            }
        }
        while(s1<=mid){
            array[i++] = arr[s1++];
        }
        while(s2<=end){
            array[i++] = arr[s2++];
        }
        i = 0;
        while(i<array.length){
            arr[start+i] = array[i++];
        }
    }
    public static void mergeSortInternal(int[] arr, int low, int high){
        if(low>=high){
            return;
        }
        int mid = (low+high)/2;
        mergeSortInternal(arr,0,mid-1);
        mergeSortInternal(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public static void mergeSort(int[] arr){
        mergeSortInternal(arr,0,arr.length-1);
    }
}
