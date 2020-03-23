import java.util.*;

public class TestDemo {
    //成绩排序（错误）
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int type = in.nextInt();
            Map<Integer,String> map = new HashMap<>();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                String name = in.next();
                int grade = in.nextInt();
                map.put(grade,name);
                arr[i] = grade;
            }
            System.out.println(n+" "+type);
            Arrays.sort(arr);

            if(type==1){//从小到大
                for(int i=0; i<arr.length; i++){
                    System.out.println(map.get(arr[i]) + " " + arr[i]);
                }
            }else{
                for(int i=arr.length-1; i>=0; i--){
                    System.out.println(map.get(arr[i]) + " " + arr[i]);
                }
            }
        }
    }

    //百万富翁
    public static void main1(String[] args){
        int sum = 0;
        int tmp = 1;
        for(int i=0; i<30; i++){
            sum += tmp;
            tmp *= 2;
        }
        int sum1 = 10*30;
        System.out.print(sum + " "+ sum1);
    }
    //AACTGTGCACGACCTGA
    //5
    //GCACG
    //DNA序列
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            int n = sc.nextInt();
            int max = 0;
            int maxStrInt = 0;
            for(int i=0; i<=str.length()-n; i++){
                int count = 0;
                for(int j=i; j<i+n; j++){
                    if(str.charAt(j)=='C' || str.charAt(j)=='G'){
                        count++;
                    }
                }
                if(count>max){
                    maxStrInt = i;
                    max = count;
                }
            }
            System.out.println(str.substring(maxStrInt,maxStrInt+n));
        }
    }
}
