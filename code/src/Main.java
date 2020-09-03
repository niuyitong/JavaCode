import java.util.*;
public class Main {
    public static void main(String[] args) {
        Hashtable<Integer,Integer> table = new Hashtable<>();
        Map<Integer,Integer> map = new HashMap<>();
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            int count = 0;
            for(int i=0; i<n; i++){
                String str = sc.nextLine().toLowerCase();
                int len = str.length();
                if(len<=10){
                    int j = 0;
                    for(; j<len; j++){
                        if(!(str.charAt(j)>='a' && str.charAt(j)<='z')){
                            break;
                        }
                    }
                    if(j==len){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
