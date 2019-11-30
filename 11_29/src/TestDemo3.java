import java.util.Arrays;
import java.util.Scanner;

public class TestDemo3 {
    //3、题目： i am student 逆置 为  student  am i
    public static void reverse(char[] array,int left,int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
    public static String reverseSentence(String str) {
        char[] array = str.toCharArray();
        reverse(array,0,array.length-1);//整体逆置
        int i = 0;
        int j = 0;
        //单词逆置
        while (i<array.length) {
            if(array[i] == ' '){
                i++;
                j++;
            }else if(j == array.length || array[j] == ' '){
                reverse(array,i,j-1);
                i = ++j;
            }else{
                j++;
            }
        }
        return String.copyValueOf(array);
    }
    public static void main(String[] args) {
        String ret = reverseSentence("i am student");
        System.out.println(ret);
    }
    //2、字符串转化（压缩）   “aabbccdaa” -> "2a2b2c1d2a"
    public static String transform(String str){
        char ch = str.charAt(0);//得到第一个字符
        int repCount = 1;//重复出现的次数
        StringBuilder sb = new StringBuilder();//一个新的字符串
        for(int i = 1;i<str.length();i++){
            if(str.charAt(i) == ch){
                repCount++;
            }else{
                sb.append(repCount).append(ch);
                ch = str.charAt(i);
                repCount = 1;
            }
        }
        return sb.append(repCount).append(ch).toString();
    }
    public static void main2(String[] args) {
        String str = "aabbccdaa";
        String ret = transform(str);
        System.out.println(ret);
    }

    //1、合并两个有序的数组 如int[] array1 = {1,3,6,9}
    //int[] array2 = {2,4,6,8}
    //合并之后的结果：1,2,3,4,6,6,9
    public static int[] mixed(int[] arr1,int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] newArr = new int[len1+len2];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<len1 && j<len2){
            if(arr1[i] < arr2[j]){
                newArr[k++] = arr1[i++];
            }else{
                newArr[k++] = arr2[j++];
            }
        }
        while(i<len1){
            newArr[k++] = arr1[i++];
        }
        while(j<len2){
            newArr[k++] = arr2[j++];
        }
        return newArr;
    }
    public static void main1(String[] args) {
        int[] arr1 = {1,3,6,9};
        int[] arr2 = {2,4,6,8};
        int[] ret = mixed(arr1,arr2);
        System.out.println(Arrays.toString(ret));
    }
    //4.将k下标之前的字符串整体向右移，将k下标之后的整体向左移
    //如 输入str1="abedef"  K=3，
    //输出str2="defabe"
    public static String reverse(String str,int start,int end){
        char[] arr = str.toCharArray();
        int left = start;
        int right = end;
        while(left < right){
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return String.copyValueOf(arr);
    }
    public static String func(String str,int k){
        String str1 = reverse(str,0,k-1);
        str1 = reverse(str1,k,str1.length()-1);
        str1 = reverse(str1,0,str1.length()-1);
        return str1;
    }
    public static void main4(String[] args){
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        String chas = scan.next();//scan.nextLine()不能与nextInt()同时用
        String ret = func(chas,size);
        System.out.println(ret);
    }
}
