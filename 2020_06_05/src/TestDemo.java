import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) {

    }
    public int longestPalindrome(String s) {
        char[] chas = s.toCharArray();
        int[] arr = new int[256];
        for(int i=0; i<chas.length; i++){
            arr[chas[i]-'0']++;
        }
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0 && arr[i]%2==0){
                count2 += arr[i];
            }else if(arr[i]%2==1){
                count2 += arr[i]-1;
                count1++;
            }
        }
        if(count1!=0){
            return count2+1;
        }else{
            return count2;
        }
    }
    List<String> res = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        next(s, 0, 0, new StringBuilder());
        return res;
    }

    void next(String s, int start, int pos, StringBuilder sb) {
        if(pos == 4) {
            if(start == s.length())
                res.add(sb.toString().substring(0, sb.length() - 1)); // 去除末尾的点
            return;
        }
        for(int i = start; i < start + 3 && i < s.length(); i++) { // 最多截取三位
            String substr = s.substring(start, i + 1);
            int num = Integer.parseInt(substr);
            if(num > 255) continue; // 最大限制255，剪枝
            sb.append(substr + ".");
            next(s, i + 1, pos + 1, sb);
            sb.delete(sb.length() - (i - start + 2), sb.length());
            if(s.charAt(start) == '0') break; // 首位是0，剪枝
        }
    }
}
