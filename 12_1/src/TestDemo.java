import java.util.Scanner;
class TestDemo{
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

    public static void main(String[] args) {
        //bdca
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String str1 = strsort(str);
        System.out.println(str1);
    }
}

