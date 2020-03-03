import java.util.*;
public class TestDemo{
    public static void main(String[] args) {

    }
    //汽水瓶
    public static int getNumber(int num){
        if(num<2){
            return 0;
        }
        int sum = 0;
        while(num>=3){
            sum += num/3;
            num = num/3+num%3;
        }
        if(num==2){
            sum++;
        }
        return sum;
    }
    public static void main1(String[] args){
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            if(a==0){
                break;
            }
            list.add(a);
        }
        for(int i=0; i<list.size(); i++){
            int num = list.get(i);
            int ret = getNumber(num);
            System.out.println(ret);
        }
    }
}
