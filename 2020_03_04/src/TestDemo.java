import java.util.*;
public class TestDemo {
    //括号匹配
    public static boolean chkParenthesis(String A, int n) {
        if(n%2==1){
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<A.length(); i++){
            char ch = A.charAt(i);
            if(ch=='('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        boolean ret = chkParenthesis("(()())",6);
        System.out.println(ret);
    }
    //字符串中找出连续最长的数字串
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        int start = 0;
        int end = 0;
        while(end<str.length()){
            while(end<str.length()&& !(str.charAt(end) <= '9' && str.charAt(end) >= '0')){//字母
                start++;
                end++;
            }
            while(end<str.length()&& (str.charAt(end) <= '9' && str.charAt(end) >= '0')){//数字
                end++;
            }
            if(sb.length()!=0){
                if(end-start>sb.length()){
                    if(end==str.length()){
                        sb.delete(0,sb.length());
                        sb.append(str.substring(start));
                    }else{
                        sb.delete(0,sb.length());
                        sb.append(str.substring(start,end));

                    }
                }
            }else{
                if(end==str.length()){
                    sb.append(str.substring(start));
                }else{
                        sb.append(str.substring(start,end));
                }
            }
            start = end;
        }

        System.out.println(sb.toString());
    }
    //快排的思想寻找第K大
    public int findKth(int[] a, int n, int K) {
        return findKth(a, 0, n-1, K);
    }
    public int findKth(int[] a,int low, int high, int k){
        int part = partition(a,low,high);
        if(part-low+1 == k)
            return a[part];
        if(part-low+1>k){
            return findKth(a,low,part-1,k);
        }else{
            return findKth(a,part+1,high,k-part+low-1);
        }
    }
    public int partition(int[] a,int low, int high){
        int tmp = a[low];
        while(low<high){
            while(low<high && a[high]<tmp){
                high--;
            }
            a[low] = a[high];
            while(low<high && a[low]>tmp){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = tmp;
        return low;
    }
}
