import java.util.*;

public class TestDemo {
    //数组乘积
    public static int[] mul(int[] A){
        int[] B = new int[A.length];
        for(int i=0; i<B.length; i++){
            int sum = 1;
            for(int j=0; j<i; j++){
                sum *= A[j];
            }
            for(int j=i+1; j<A.length; j++){
                sum *= A[j];
            }
            B[i] = sum;
        }
        return B;
    }
    //个位数统计
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Character,Integer> map = new HashMap<>();
        while (in.hasNextInt()) {
            String str = in.nextLine();
            for(int i=0; i<str.length(); i++) {
                char tmp = str.charAt(i);
                if (!map.containsKey(tmp)) {
                    map.put(tmp, 1);
                } else {
                    map.put(tmp, map.get(tmp) + 1);
                }
            }
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                System.out.print(entry.getKey() + ":" + entry.getValue());
                System.out.println();
            }
        }
    }
}
