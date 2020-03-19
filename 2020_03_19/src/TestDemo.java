import java.util.*;

public class TestDemo {

    //3
    //3 1  1 2 3  4 5 6    6 3 5 2 4 1
    //3 2  1 2 3 4 5 6    6 3 5 2 4 1   -->1 4 2 5 3 6    6 2 3 4 5 1 -->1 5 4 3 2 6
    //2 2  1 1 1 1      -->1 1 1 1
    //洗牌
    public static List reverse(List<Integer> list1, List<Integer> list2,int k){
        List<Integer> tmp = new ArrayList<>();
        for(int i=0; i<list1.size(); i++){
            tmp.add(list1.get(i));
            tmp.add(list2.get(i));
        }
        if(k==1){
            return tmp;
        }else{
            list1.clear();
            list2.clear();
            for(int i=0; i<tmp.size()/2; i++){
                list1.add(tmp.get(i));
            }
            for(int i=tmp.size()/2; i<tmp.size(); i++){
                list2.add(tmp.get(i));
            }
            return reverse(list1,list2,k-1);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int T = in.nextInt();
            for(int i=0; i<T; i++){
                int n = in.nextInt();
                int k = in.nextInt();
                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();
                for(int j=0; j<n; j++){
                    list1.add(in.nextInt());
                }
                for(int j=0; j<n; j++){
                    list2.add(in.nextInt());
                }
                List<Integer> ret = reverse(list1,list2,k);
                for(int m=0; m<ret.size(); m++){
                    System.out.print(ret.get(m) + " ");
                }
                System.out.println();
            }
        }
    }
    //统计同成绩学生人数
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            if(N!=0){
                List<Integer> list = new ArrayList<>();
                for(int i=0; i<N; i++){
                    list.add(in.nextInt());
                }
                int grade = in.nextInt();
                int count = 0;
                Object[] arr = list.toArray();
                for(int i=0; i<arr.length; i++){
                    if((int)arr[i]==grade){
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }
}
