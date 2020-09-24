package practice;

import java.util.*;


public class Test {
    static int[] primeFactorization(int num) {
        List<Integer> list = new ArrayList<>();
        for(int i=2; i<=num; i++){
            while(num!=i){
                if(num%i==0){
                    list.add(i);
                    num /= i;
                }else
                    break;
            }
            if(num==i){
                list.add(num);
            }

        }
        int[] res = new int[list.size()];
        for(int j=0; j<list.size(); j++){
            res[j] = list.get(j);
        }
        return res;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;

        int _num;
        _num = Integer.parseInt(in.nextLine().trim());

        res = primeFactorization(_num);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }










    static class A{
        static void C(){
            System.out.println("A.C");
        }
        void D(){

        }
    }
    class B extends A{
        void D(){

        }
    }
    public static void main1(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();

    }
}
