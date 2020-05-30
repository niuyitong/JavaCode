import java.util.HashMap;
import java.util.Map;

public class Test {
    public static int reverse(int x) {
        int sum = 0;
        while(x!=0){
            int tmp = x%10;
            if(sum>Integer.MAX_VALUE/10 || (sum==Integer.MAX_VALUE/10 && tmp>7)) return 0;
            if(sum<Integer.MIN_VALUE/10 || (sum==Integer.MIN_VALUE/10 && tmp<-8)) return 0;
            sum = sum * 10+tmp;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
    //最长回文子串
    private int broad(String s,int L, int R){
        int len = s.length();
        while(L>=0 && R<len && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int oddLen = broad(s,i,i);
            int evenLen = broad(s,i,i+1);
            int len = Math.max(oddLen,evenLen);
            if(len>end-start+1){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

   //字符串相加
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int i = arr1.length-1;
        int j = arr2.length-1;
        int flg = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0 || flg!=0){
            if(i>=0) flg += arr1[i]-'0';
            if(j>=0) flg += arr2[j]-'0';
            sb.append(flg%10);
            flg /= 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
    //反转字符串中的单词
    public String reverse(String s){
        char[] arr = s.toCharArray();
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
            l++;
            r--;
        }
        return new String(arr);
    }
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<strs.length; i++){
            sb.append(reverse(strs[i])+" ");
        }
        return sb.toString().trim();
    }
    //实现strStr
    public static int strStr(String haystack, String needle) {
        if(haystack.length()==0 ){
            if(needle.length()==0){
                return 0;
            }else{
                return -1;
            }
        }
        if(needle.length()==0){
            return 0;
        }
        int start = 0;
        int j=0;
        for(int i=0; i<haystack.length(); i++){
            if(haystack.charAt(i)==needle.charAt(j)){
                start = i;
                while(i<haystack.length() && j<needle.length()
                        && haystack.charAt(i)==needle.charAt(j)){
                    i++;
                    j++;
                }
                if(j==needle.length()){
                    return start;
                }
                i = start;
                j = 0;
            }
        }
        return -1;
    }
    //反转字符串II
    public void reverse(char[] arr, int i, int j){
        while(i<j){
            arr[i]^=arr[j];
            arr[j]^=arr[i];
            arr[i]^=arr[j];
            i++;
            j--;
        }
    }
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = s.length();
        for(int i=0; i<len; i += 2*k){
            if(i+2*k<len || i+k<len){
                reverse(arr,i,i+k-1);
            }else{
                reverse(arr,i,len-1);
                break;
            }
        }
        return new String(arr);
    }
    //回文排列
    public boolean canPermutePalindrome(String s) {
        int[] chas = new int[256];
        for(int i=0; i<s.length(); i++){
            int index = (int)(s.charAt(i));
            chas[index] += 1;
        }
        int count1 = 0;
        for(int i=0; i<chas.length; i++){
            if(chas[i]%2==1){
                count1++;
            }
        }
        if(count1==1 || count1==0){
            return true;
        }else{
            return false;
        }
    }
    //最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String str = strs[0];
        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(str)!=0){
                str = str.substring(0,str.length()-1);
            }
        }
        return str;
    }
    //罗马数字转整数
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = 0;
        int i = 0;
        for(i=0; i<s.length()-1; i++){
            int tmp1 = map.get(s.charAt(i));
            int tmp2 = map.get(s.charAt(i+1));
            if(tmp1>=tmp2){
                sum += tmp1;
            }else{
                sum -=tmp1;
            }
        }
        sum += map.get(s.charAt(s.length()-1));
        return sum;
    }
    //检测大写字母
    public boolean detectCapitalUse(String word) {
        if(word.length()==1){
            return true;
        }
        char ch = word.charAt(word.length()-1);
        if(ch>='A' && ch<='Z'){
            for(int i=word.length()-2; i>=0; i--){
                if(word.charAt(i)<'A' || word.charAt(i)>'Z'){
                    return false;
                }
            }
        }else{
            for(int i=word.length()-2; i>=1; i--){
                if(word.charAt(i)>='A' && word.charAt(i)<='Z'){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main1(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder("RBGL");
        String a = "asjidisnci";
        String b = "dis";
        int ret = strStr(a,b);
        System.out.println(ret);
    }
}
