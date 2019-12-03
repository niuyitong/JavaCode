import java.util.Scanner;
class TestDemo{
    //输入：abcgfhruach 输出：abcgfhru
    //即删除第二次出现的字符
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<str.length();i++){
            if(!sb.toString().contains(str.charAt(i)+"")){
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
    public static int compare(String str){
        String[] arr = str.split(" ");
        for(int i = 0;i<arr[0].length();i++){
            if(arr[0].charAt(i)<arr[1].charAt(i)){
                return -1;
            }else if(arr[0].charAt(i)>arr[1].charAt(i)){
                return 1;
            }else{
                continue;
            }
        }
        return 0;

    }
    public static void main3(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int ret = compare(str);
        System.out.println(ret);
    }
    public static String yasuo(String str){
        char[] arr = str.toCharArray();
        char ch = arr[0];
        int count = 0;
        StringBuilder ret = new StringBuilder();
        for(int i = 1;i<arr.length;i++){
            if(arr[i] == ch){
                count++;
            }else{
                ret.append(count).append(ch);
                ch = arr[i];
                count = 0;
            }
        }
        return ret.append(count).append(ch).toString();
    }
    public static void main2(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        str = yasuo(str);
        System.out.println(str);
    }
    public static String strsort(String str){
        char[] arr = str.toCharArray();
        for(int i = 0;i<str.length()-1;i++){
            int j = 0;
            for(;j<str.length()-1-i;j++){
                if(arr[j]>arr[j+1]){
                    char ch = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = ch;
                }
            }
        }
        return String.copyValueOf(arr);
    }

    public static void main1(String[] args) {
        //bdca
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String str1 = strsort(str);
        System.out.println(str1);
    }
}

