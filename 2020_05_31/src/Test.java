import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    //最大子序和
    public static int maxSubArray(int[] nums) {
        int Maxsum=nums[0],sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(sum>Maxsum){
                Maxsum=sum;
            }
            if(sum<0)
            {
                sum=0;
            }
        }
        return Maxsum;
    }
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String str = "1";
        for(int i=2; i<=n; i++){
            StringBuilder sb = new StringBuilder();
            char tmp = str.charAt(0);//2
            int count = 0;
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j)==tmp){
                    count++;
                }else{
                    sb.append(count).append(tmp);
                    count = 0;
                    tmp = str.charAt(j);
                    j--;
                }
            }
            sb.append(count).append(tmp);
            str = sb.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        int[] nums = {1,6,-2,4};
        System.out.println(maxSubArray(nums));
    }
}
