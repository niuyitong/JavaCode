import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] ret = fibArray(n);
            circularMatrix(ret,n);
        }
    }

    private static void circularMatrix(int[] ret,int x ) {
        int[][] nums = new int [x][x];
        int count = 0;
        for(int k = 0, n = x; k < n; k++, n--) {
            for(int i = k; i < n; i++)
                nums[k][i] = ret[count++];
            for(int i = k + 1; i < n; i++)
                nums[i][n-1] = ret[count++];
            for(int i = n - 2; i >= k; i--  )
                nums[n-1][i] = ret[count++];
            for(int i = n - 2; i > k; i--)
                nums[i][k] = ret[count++];
        }

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < x; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] fibArray(int n) {
        int[] res = new int[n*n];//4
        if(res.length==1){
            res[0] = 1;
            return res;
        }
        res[res.length-1] = 1;
        res[res.length-2] = 1;
        int k = res.length-3;
        int a = 1;
        int b = 1;
        int c = a+b;

        while(k>=0){
            res[k--] = c;
            a = b;
            b = c;
            c = a+b;
        }
        return res;
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            sc.nextLine();
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String[] highRink = str1.split(" ");
            String[] farRink = str2.split(" ");
            int best = 1;
            Map<String,Integer> map = new HashMap<>();
            for(int i=0; i<highRink.length; i++){
                if(highRink[i].charAt(0)!='X'){
                    map.put(highRink[i],1);
                }else{
                    break;
                }

            }
            for(int j=0; j<farRink.length; j++){
                if(map.containsKey(farRink[j])){
                    best++;
                }else if(farRink[j].charAt(0)=='X'){
                    break;
                }
            }
            Map<String,Integer> map2 = new HashMap<>();
            int bad = n;
            for(int i=highRink.length-1; i>=0; i--){
                if(highRink[i].charAt(0)!='X'){
                    map2.put(highRink[i],1);
                }else {
                    break;
                }
            }
            for(int j=farRink.length-1; j>=0; j--){
                if(map2.containsKey(farRink[j])){
                    bad--;
                }else if(farRink[j].charAt(0)=='X'){
                    break;
                }
            }
            System.out.println(best);
            System.out.println(bad);
        }
    }
    public static void main5(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()) {
            int sum=0, leap=0, valid=1;
            int year=scan.nextInt();
            int month=scan.nextInt();
            int day=scan.nextInt();

            if(year%400==0||(year%4==0&&year%100!=0)) {
                leap=1;
            }
            else {
                leap=0;
            }

            if((leap==0&&month==2&&day>28)||leap==1&&month==2&&day>29) {
                valid=0;
            }

            if(((month==1||month==3||month==5||month==7||month==8||month==10||month==12)&&day>31)) {
                valid=0;
            }

            if(((month==4||month==6||month==9||month==11)&&day>30)) {
                valid=0;
            }

            switch(month) {
                case 1:sum=0;break;
                case 2:sum=31;break;
                case 3:sum=59;break;
                case 4:sum=90;break;
                case 5:sum=120;break;
                case 6:sum=151;break;
                case 7:sum=181;break;
                case 8:sum=212;break;
                case 9:sum=243;break;
                case 10:sum=273;break;
                case 11:sum=304;break;
                case 12:sum=334;break;
                default:valid=0;break;
            }

            sum=sum+day;

            if(leap==1&&month>2){
                sum++;
            }

            if(valid==1) {
                System.out.println(sum);
            }
            else {
                System.out.println("wrong");
            }
        }
    }
    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            String[] list = new String[n];
            for(int i=0; i<list.length; i++){
                String tmp = in.nextLine();
                list[i] = tmp;

            }
            int count = 0;
            for(int i=0; i<list.length; i++){
                String[] str = reverse(list,i,i+count);
                count = str.length;
                for(int j=0; j<str.length; j++){
                    if(!str[j].equals(list[j+count+1])){
                        break;
                    }
                }
                    //if(str[j].equals(str[j+count+1])){

                        //reverse(list,j,j+str.length);
                    //}

            }
        }
    }
    public static String[] reverse(String[] list,int i, int j){
        while(i<j){
            String tmp = list[i];
            list[i] = list[j];
            list[j] = tmp;
            i++;
            j--;
        }
        int m = 0;
        String[] str = new String[j-i+1];
        for(int k=i; k<=j; k++){
            str[m++] = list[k];
        }
        return str;
    }
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(in.nextInt());
            }
            int count = 0;
            for(int i=0; i<=n-m; i++){
                int j = i;
                boolean flg = false;
                for(j=i; j<m+i&&j<n; j++){
                    if(list.get(j)<k) {
                        i = j;
                        flg = true;
                        break;
                    }
                }
                if(!flg)
                    count++;
            }
            System.out.println(count);
        }
    }
    public static void main1(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){

            String str = in.nextLine();
            StringBuffer sb = new StringBuffer(str);
            int count = in.nextInt();
            for(int i=0; i<sb.length()-1; i++){
                if(count!=0 && sb.charAt(i)>sb.charAt(i+1)){
                    sb.deleteCharAt(i);
                    i--;
                    count--;
                }else if(count!=0 && sb.charAt(i)<=sb.charAt(i+1)){
                    sb.deleteCharAt(i+1);
                    count--;
                }else{
                    break;
                }
            }
            while(sb.length()!=0){
                if(sb.charAt(0)-'0'==0){
                    sb.deleteCharAt(0);
                }else{
                    break;
                }
            }
            System.out.println(sb.toString());
        }
    }
}