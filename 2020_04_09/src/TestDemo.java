import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int[] center = new int[3];
            int[] spot = new int[3];
            for(int i=0; i<3; i++){
                center[i] = in.nextInt();
            }
            for(int i=0; i<3; i++){
                spot[i] = in.nextInt();
            }
            double m = Math.pow((center[0]-spot[0]),2)
                    + Math.pow((center[1]-spot[1]),2)
                    + Math.pow((center[2]-spot[2]),2);
            double r = Math.sqrt(m);
            double v = 4*Math.PI*Math.pow(r,3)/3;
            System.out.printf("%.3f %.3f",r,v);
        }
    }
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String kidStr = in.nextLine();
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<str.length(); i++){
                if(!kidStr.contains(str.charAt(i)+"")){
                    if(sb.indexOf((str.charAt(i)+"").toUpperCase())==-1){
                        sb.append((str.charAt(i)+"").toUpperCase());
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            in.nextLine();
            int[] wins = new int[3];
            int ping = 0;
            for(int i=0; i<n; i++){
                String[] strs = in.nextLine().split(" ");

                if(strs[0].equals("C")){
                    if(strs[1].equals("J")){
                        wins[0]++;
                    }else if(strs[1].equals("C")){
                        ping++;
                    }
                }else if(strs[0].equals("B")){
                    if(strs[1].equals("C")){
                        wins[1]++;
                    }else if(strs[1].equals("B")){
                        ping++;
                    }
                }else{
                    if(strs[1].equals("B")){
                        wins[2]++;
                    }else if(strs[1].equals("J")){
                        ping++;
                    }
                }
            }
            int win = 0;
            int max = 0;
            int j = 0;
            for(j=0; j<wins.length; j++){
                win += wins[j];
                if(wins[j]>max){
                    max = wins[j];
                }else if(wins[j]==max){

                }
            }
            String str = "";
            if(max==wins[0]){
                str = "C";
            }else if(max==wins[1]){
                str = "B";
            }else{
                str = "J";
            }
            System.out.println(win + " " + ping + " " + (n-win-ping));
            System.out.println(n-win-ping + " " + ping + " " + win);
            System.out.println(str + " " + str);
        }
    }
}
