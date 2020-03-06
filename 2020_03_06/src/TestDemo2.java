import java.util.*;
public class TestDemo2 {
    //两个栈实现队列
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        while (n>0) {
            list.add(in.nextInt());
            n--;
        }
        int count = 0;
        for(int i=0; i<list.size()-1; i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i)+list.get(j)==40){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
