import java.util.*;

public class TestDemo {
    public int findKth(int[] a, int n, int K) {
        Arrays.sort(a);
        while(n>=0){
            while(n>=0 && a[n-1]==a[n-2]){
                n--;
            }
            if(n>=0){
                K--;
            }

            if(K==1){
                return a[n-1];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int count = 0;
        for(int i=0; i<a.length(); i++){
            StringBuffer sb = new StringBuffer(a);
            sb.insert(i,b);
            if(isHUIWEN(sb)){
                count++;
            }
        }
        StringBuffer sb = new StringBuffer(a);
        sb.append(b);
        if(isHUIWEN(sb)){
            count++;
        }
        System.out.println(count);
    }
    public static boolean isHUIWEN(StringBuffer sb){
        int right = sb.length()-1;
        int left = 0;
        while(left<right){
            if(sb.charAt(left)!=sb.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
