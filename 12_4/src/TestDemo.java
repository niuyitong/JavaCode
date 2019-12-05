import java.util.Scanner;
public class TestDemo {
    //如果一个字符串为str，把字符串的前面任意部分挪到后面形成的字符串
    // 叫str的旋转词。比如str=“12345”，
    //str的旋转串有“12345”、“45123”等等。给定两个字符串，判断是否为旋转词
    public static String isRount(int a,int b,String str1,String str2){
        if(a!=b){
            return "NO";
        }
        if(str1.equals(str2)){
            return "YES";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<str1.length();i++){
            String s1 = str1.substring(0,i);
            String s2 = str1.substring(i);
            if(sb.append(s2).append(s1).toString().equals(str2)){
                return "YES";
            }
            sb = new StringBuilder();
        }
        return "NO";
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        String str1 = scan.next();
        String str2 = scan.next();
        String ret = isRount(a,b,str1,str2);
        System.out.println(ret);
    }

    //给定一个字符串str，返回str的统计字符串。
    // 例如“aaabbbbcccd”的统计字符串为“a_3_b_4_c_3_d_1”。
    public static String countStr(String str){
        int count = 1;
        char ch = str.charAt(0);
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<str.length();i++){
            if(str.charAt(i)==ch){
                count++;
            }else{
                if(sb.toString().equals("")){
                    sb.append(ch).append("_").append(count);
                }else{
                    sb.append("_").append(ch).append("_").append(count);
                }
                count = 1;
                ch = str.charAt(i);
                flag = 1;
            }
        }
        if(flag==0){
            sb.append(ch).append("_").append(count);
        }else{
            sb.append("_").append(ch).append("_").append(count);
        }
        return sb.toString();
    }
    public static void main4(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str = countStr(str);
        System.out.println(str);
    }

    //单词逆置
    public static void reverse(char[] arr,int left,int right){
        while(left<right){
            char ch = arr[left];
            arr[left] = arr[right];
            arr[right] = ch;
            left++;
            right--;
        }
    }
    public static String reverseStr(String str){
        char[] arr = str.toCharArray();
        int left = 0;
        int right = 0;
        while(right!=str.length()){
            if(arr[right]==' '){
                reverse(arr,left,right-1);
                left = ++right;
            }else{
                right++;
            }
        }
        reverse(arr,left,right-1);
        return new String(arr);
    }
    public static void main3(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str = reverseStr(str);
        System.out.println(str);
    }

//给定一个字符类型的数组chas[],chas右半区全是空字符，
// 左半区不含有空字符。现在想将左半区的空格字符串替换成“%20”，
    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String ret = str.replace(" ","%20");
        System.out.println(ret);
    }

    //给定一个字符串chas[],其中只含有字母字符和“*”字符，
    // 现在想把所有“*”全部挪到chas的左边，字母字符移到chas的右边。
    // 输入：qw**23  输出：**qw23
    public static String changeStr(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< str.length(); i++){
            if(str.charAt(i) == '*'){
                sb.insert(0,'*');
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main2(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String ret = changeStr(str);
        System.out.println(ret);
    }
}
