import java.util.Arrays;

/**
 * 字符串拷贝：
 * 1.for
 * 2.arraycopy方法   使用时System.arraycopy() 无返回
 * 3.copyOf方法      使用时int[] newarr = Array.copyOf() 有返回
 * 两者区别：①返回值  ②调用System Array不同   ③速度问题：System.arraycopy()更快
 * 4.array.clone即数组名.clone       数组名为你要拷贝的数组名
 */
 
//以上四种方式：
// 对于数组中是简单类型就是深拷贝   数组中是引用类型就是浅拷贝
// 浅拷贝：把1拷贝到2中，改变2则1也改变   即修改源数组不会影响到新数组
//深拷贝： 把1拷贝到2中，改变2则1不改变   即修改源数组会影响到新数组


/**
 * 学习Arrays当中的方法：
 * Arrays.toString();
 * Arrays.binary.Search();
 * Arrays.copyOf();
 * Arrays.copyOfRange();
 * Arrays.equals();数组比较
 * Arrays.fill();数组填充（全部填充
 * Arrays.fill(arr,2，7，99)（将下标为[2，7）部分填充
 * Arrays.sort(arr)将数组排序
 */
public class Test {

    public static int max(int[] array){
        int max = array[0];
        for(int i=1; i<array.length;i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        return max;
    }
    public static int min(int[] array){
        int min = array[0];
        for(int i=1; i<array.length;i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        return min;
    }
    public static double ave(int[] array){
        double sum = 0.0;
        for(int i=0; i<array.length;i++){
            sum +=array[i];
        }
        return sum/array.length;
    }
    public static void reverse(int[] array){
        int left = 0;
        int right = array.length-1;
        while(left<right) {
            int tmp = 0;
            tmp = array[right];
            array[right] = array[left];
            array[left] = tmp;
            left++;
            right--;
        }
    }
    public static void eveAfterOdd(int[] array){
        int i = 0;
        int j = array.length-1;
        while(i<j){
            while((i<j) && (array[i]%2!=0)){  //找偶数
                i++;
            }
            while((i<j) && (array[j]%2==0)){  //找奇数
                j--;
            }
            if(i<j){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;

            }
        }
    }
	//二分查找递归法
    public static int binarySearch(
            int[]array,int key,int left,int right){
        if(left>right){
            return -1;
        }
        int mid = (left+right)>>1;
        if(array[mid] == key) {
            return mid;
        }else if(array[mid]>key){
            return binarySearch(array,key,left,mid-1);
        }else {
            return binarySearch(array,key,mid+1,right);
        }
    }
	//二分查找非递归法
	public static int binarySearch2(int[]array,int key,int left,int right){
		while(left<right){
			int mid = (left+right)/2;
			if(array[mid]==key){
				return mid;
			}
			if(array[mid]<key){
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		return -1;
	}
    public static void bubbleSort(int[] array){
        int i = 0;
        int j = 0;
        int tmp = 0;

        for(i = 0;i<array.length-1;i++){
            boolean flag = true;
            for(j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
    public static void main(String[] args){
        //求数组当中的最大值 最小值 平均值 数组逆置 奇数放到偶数前面  二分查找 冒泡排序和冒泡排序的优化
        int[] arr = {5,2,7,8,3,1,4,9,6};
        int[] arr2 = {10,9,8,7,6,5,4,3,2,1};
        int[] arr4 = {1,2,3,4,5,6,8,7,9,0};
        int ret = max(arr);//最大值
        System.out.println(ret);
        ret = min(arr);//最小值
        System.out.println(ret);
        double ret2 = ave(arr);//平均值
        System.out.println(ret2);
        reverse(arr);//逆置
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        eveAfterOdd(arr2);//将奇数放到偶数前
        for(int i = 0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
        int ret3 = binarySearch(arr4,7,0,arr2.length-1);//二分查找
        if(ret3>=0){
            System.out.println("下标为："+ret3);
        }else{
            System.out.println("没找到");
        }
        bubbleSort(arr);//排序
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


        //将数组以字符串的形式打印出来
        /*
        int[] array = {1,2,3,4,5};
        System.out.println(toString(array));
        */
        //将数组扩大二倍，并且返回，不能修改原数组
        /*
        int[] array = {1,2,3,4,5};
        int[] array2 = transform(array);
        System.out.println(Arrays.toString(array2));//直接打印数组元素
        System.out.println(Arrays.toString(array));
        */
        //给定一个double类型的浮点数base和int类型的整数exponent。
        // 求base的exponent次方。保证base和exponent不同时为0
        /*
        int n=5;
        double base = 2;
        double ret = Power(base,n);
        System.out.println(ret);
        */
    }
    public static String toString(int[] array){
        String arr = "[";
        for(int i=0;i<array.length;i++){
            arr = arr+array[i];//利用字符串拼接
            if(i!=array.length-1){
                arr +=", ";
            }
        }
        arr += "]";
        return arr;
    }
    public static int[] transform(int[] array){
        int i = 0;
        int[] arr = new int[array.length];//重新生成一个对象
        for(i=0;i<array.length;i++){
            arr[i] = 2*array[i];
        }
        return arr;
    }

    public static double Power(double base, int exponent) {
        double temp = 1.0;
        if(exponent>0){
            for(int i=0;i<exponent;i++){
                temp *= base;
            }
            if(temp>1.7976931348623157E308){
                System.out.println("已经超出double类型的取值范围。");
                return -1;
            }
            return temp;
        }else if(exponent<0){
            exponent=-exponent;
            for(int i=0;i<exponent;i++){
                temp *= base;
            }
            if(temp>1.7976931348623157E308){
                System.out.println("已经超出double类型的取值范围。");
                return -1;
            }
            return 1.0/temp;
        }else{
            return 1.0;
        }

    }
}
