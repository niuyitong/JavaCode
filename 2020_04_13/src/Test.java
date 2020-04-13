import java.util.*;

public class Test{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                int tmp = in.nextInt();
                int len = in.nextInt();
                if(tmp==1){
                    list.add(len);
                }else{
                    if(list.indexOf(len)!=-1){
                        list.remove(list.indexOf(len));
                    }
                }
                int size = list.size();
                int sum = 0;
                if(size>=3){
                    for(int j=0; j<size; j++){
                        sum += list.get(j);
                    }
                    int j = 0;
                    for(j=0; j<size; j++){
                        if(!(sum-list.get(j) > list.get(j))){
                            System.out.println("No");
                            break;
                        }
                    }
                    if(j==size){
                        System.out.println("Yes");
                    }
                }else{
                    System.out.println("No");
                }
            }
        }
    }
    //进制转换
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int count = 0;
            int sum = 0;
            String str = in.nextLine().substring(2);
            for(int i=str.length()-1; i>=0; i--){
                char ch = str.charAt(i);
                int n = 0;
                if(ch>='A' && ch<='F'){
                    n = ch-'A'+10;
                }else{
                    n = Integer.valueOf(ch+"");
                }
                sum += n*(int)Math.pow(16,count);
                count++;
            }
            System.out.println(sum);
        }
    }
    //字母统计
    public static void main1(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine();
            Map<Character,Integer> map = new HashMap<>();
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                if(ch>='A' && ch<='Z'){
                    if(!map.containsKey(ch)){
                        map.put(ch,1);
                    }else{
                        map.put(ch,map.get(ch)+1);
                    }
                }
            }
            for(char ch='A'; ch<='Z'; ch++){
                if(map.containsKey(ch)){
                    System.out.println(ch+":"+map.get(ch));
                }else{
                    System.out.println(ch+":"+'0');
                }
            }
        }
    }
}