import java.util.*;

public class TestDemo {
    //记票统计
    public static void AddCandidate(List<String> list,String name){
        if(!list.contains(name)){
            list.add(name);
        }
    }
    public static void Vote(List<String> list,List<String> list2,String name){
        if(list.contains(name)){
            int index = list.indexOf(name);
            int count = Integer.valueOf(list2.get(index))+1;
            list2.set(index,count+"");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.valueOf(in.nextLine());
            String[] strs = in.nextLine().split(" ");
            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                AddCandidate(list,strs[i]);
            }
            int m = Integer.valueOf(in.nextLine());
            String[] strs2 = in.nextLine().split(" ");
            List<String> list2 = new ArrayList<>();
            for(int i=0; i<n; i++){
                list2.add(0+"");
            }
            for(int j=0; j<m; j++){
                Vote(list,list2,strs2[j]);
            }
            int count = 0;
            for(int i=0; i<n; i++){
                count += Integer.valueOf(list2.get(i));
                System.out.println(list.get(i) + " : " + list2.get(i));
            }
            count = m-count;
            System.out.println("Invalid : " + count);
        }
    }
    //数字之和
    public static int numSum(int n){
        if(n<10){
            return n;
        }
        return n%10 + numSum(n/10);
    }
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = (int)Math.pow(n,2);
            int sum1 = numSum(n);
            int sum2 = numSum(m);
            System.out.print(sum1 + " " + sum2);
            System.out.println();
        }
    }
}
