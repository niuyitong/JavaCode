import java.util.*;

import static java.lang.Math.pow;

public class TestDemo {
    //尼克彻斯定理
    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int m = sc.nextInt();
            int tmp = m;
            if(m==1){
                System.out.println(1);
                return ;
            }
            int sum = (int)pow(m,3);
            for(int i=1; i<sum/2; i+=2){
                int ret = i;
                int a = ret;
                m = tmp;
                while(m!=1){
                    a += 2;
                    ret += a;
                    m--;
                }
                if(ret==sum){
                    while(tmp!=0){
                        if(tmp!=1){
                            System.out.print(i+"+");
                        }else{
                            System.out.print(i);
                            System.out.println();
                        }
                        i += 2;
                        tmp--;
                    }
                    break;
                }
            }
        }
    }
    //组个最小数
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(sc.hasNextLine()){
            String[] strs = sc.nextLine().split(" ");
            for(int i=0; i<strs.length; i++){
                list.add(Integer.valueOf(strs[i]));
            }
            StringBuffer sb = new StringBuffer();
            for(int i=1; i<list.size(); i++){
                if(list.get(i)!=0){
                    sb.append(i);
                    list.set(i,list.get(i)-1);
                    break;
                }
            }
            for(int i=0; i<list.size(); i++){
                while(list.get(i)!=0){
                    sb.append(i);
                    list.set(i,list.get(i)-1);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
