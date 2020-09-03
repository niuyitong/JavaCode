import java.util.*;
class Souvenir {
    public int price;
    public int weight;
    public int v;
    public Souvenir(int price,int weight,int v){
        this.price = price;
        this.weight = weight;
        this.v = v;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "price=" + price +
                ", weight=" + weight +
                ", v=" + v +
                '}';
    }
}
class VComparator implements Comparator<Souvenir>{
    @Override
    public int compare(Souvenir o1, Souvenir o2) {
        if(o1.v!=o2.v){
            return o2.v-o1.v;
        }else if(o1.price!=o2.price){
            return o1.price-o2.price;
        }else{
            return o1.weight-o2.weight;
        }
    }
}
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            Souvenir[] sou = new Souvenir[n];
            int m = in.nextInt();
            int k = in.nextInt();
            int price = 0;
            int weight = 0;
            int v = 0;
            for(int i=0; i<n; i++){
                price = in.nextInt();
                weight = in.nextInt();
                v = in.nextInt();
                sou[i] = new Souvenir(price,weight,v);
            }
            VComparator vComparator = new VComparator();
            Arrays.sort(sou,vComparator);
            int sumM = 0;
            int sumK = 0;
            int count = 0;
            for(int j=0; j<sou.length;j++){
                sumM += sou[j].weight;
                sumK += sou[j].price;
                if(sumK>k || sumM>m){
                    break;
                }
                count++;
            }
            System.out.println(count);
            for(int j=0;j < sou.length; j++){
                System.out.println(sou[j]);
            }
        }
    }

    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x0 = in.nextInt();
            int y0 = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == 'L') {
                    x0--;
                } else if (ch == 'R') {
                    x0++;
                } else if (ch == 'U') {
                    y0++;
                } else {
                    y0--;
                }
            }
            System.out.print(x0 + " ");
            System.out.println(y0);
        }
    }
    public static void main2(String[] args) {
        for(int i=1000; i<=100000; i++){
            if(huiwen(i)&&zhishu(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean huiwen(int num) {
        int tmp = num;
        StringBuilder sb = new StringBuilder();
        while(tmp!=0){
            sb.append(tmp%10);
            tmp /= 10;
        }
        String s1 = sb.toString();
        String s2 = sb.reverse().toString();
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static boolean zhishu(int num) {
        if(num%2==0){
            return false;
        }
        int tmp = 2;
        while(num%tmp!=0 && tmp<num){
            tmp++;
        }
        if(tmp==num){
            return true;
        }else{
            return false;
        }
    }
}