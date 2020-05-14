import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    //第一个只出现一次的字符
    public char firstUniqChar(String s) {
        int[] count = new int[256];
        char[] chars = s.toCharArray();
        for(char c : chars)
            count[c]++;
        for(char c : chars){
            if(count[c] == 1)
                return c;
        }
        return ' ';
    }
    //丑数
    public int min(int a,int b,int c){
        int res = a;
        if(b<res){
            res = b;
        }
        if(c<res){
            res = c;
        }
        return res;
    }

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i=0;
        int j=0;
        int k=0;
        for(int m=1; m<n; m++){
            int tmp = min(ugly[i]*2,ugly[j]*3,ugly[k]*5);
            if(tmp==ugly[i]*2) i++;
            if(tmp==ugly[j]*3) j++;
            if(tmp==ugly[k]*5) k++;
            ugly[m] = tmp;
        }
        return ugly[n-1];
    }
}
