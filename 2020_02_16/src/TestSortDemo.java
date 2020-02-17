import java.util.Arrays;
public class TestSortDemo {
    public static void main(String[] args) {
        int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     * //归并排序：分治思想    递归   非递归
     * 时间复杂度：n*log2n
     * 空间复杂度：O(n)
     * 稳定性：稳定的
     * @param array
     * @param low
     * @param mid
     * @param high
     */

    public static void merge1(int[] array,int low,int mid,int high) {

        int s1 = low;
        int s2 = mid+1;

        int[] tmpArr = new int[high-low+1];
        int i = 0;//tmpArr的数组下标
        //当两个归并段都有数据的时候
        while (s1 <= mid && s2 <= high) {
            //如果是小于，那么就不稳定了
            if(array[s1] <= array[s2]) {
                tmpArr[i++] = array[s1++];
            }else {
                tmpArr[i++] = array[s2++];
            }
        }
        //2:
        while (s1 <= mid) {
            tmpArr[i++] = array[s1++];
        }
        while (s2 <= high) {
            tmpArr[i++] = array[s2++];
        }
        //tmpArr里面存放的是有序的数据
        //将tmpArr里面存放的有序的数据，放回到array里面
        for (int j = 0; j < tmpArr.length; j++) {
            array[low+j] = tmpArr[j];
        }
    }

    public static void mergeSortInternal(int[] array,int low,int high) {
        if(low >= high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //合并
        merge1(array,low,mid,high);
    }

    public static void mergeSort1(int[] array) {
        mergeSortInternal(array,0,array.length-1);
    }

    /**
     * 非递归
     * @param array
     */

    public static void mergeSort(int[] array) {

        for (int i = 1; i < array.length; i *= 2) {
            merge(array,i);
        }
    }
    //gap代表每个归并段的数据
    public static void merge(int[] array,int gap) {
        int[] tmpArr = new int[array.length];
        int k = 0;//下标

        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 < array.length ? s2+gap-1:array.length-1;

        //两个归并段都有数据
        while (s2 < array.length) {

            while (s1 <= e1 && s2 <= e2) {
                if(array[s1] <= array[s2]) {
                    tmpArr[k++] = array[s1++];
                }else {
                    tmpArr[k++] = array[s2++];
                }
            }

            while (s1 <= e1) {
                tmpArr[k++] = array[s1++];
            }

            while (s2 <= e2) {
                tmpArr[k++] = array[s2++];
            }

            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 < array.length ? s2+gap-1:array.length-1;
        }
        //判断是不是还有一个归并段，且这个归并段一定是s1那个段,直接小于e1可能会越界
        while (s1 <= array.length-1) {
            tmpArr[k++] = array[s1++];
        }

        for (int i = 0; i < tmpArr.length; i++) {
            array[i] = tmpArr[i];
        }
    }
}
