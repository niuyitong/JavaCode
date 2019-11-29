public class TestDemo {
    public static void main5(String[] args) {
        String str1 = "ef";
        String str = "ab"+"cd"+"ef";
    }
    //public native String intern(); C/C++
    /**
     * 如果常量池当中存在将要入池的字符串，直接将常量池当中的
     * 字符串常量的地址返回
     * 如果常量池不存在，那么在常量池当中将该字符串入池。
     * @param args
     */
    public static void main4(String[] args) {
        char[] array = {'a','b','c','d','e','f'};
        String str2 = new String(array).intern();
        String str1 = "abcdef";
        System.out.println(str1 == str2);//true
    }

    public static void main3(String[] args) {
        String str1 = "abcdef";
        String str2 = new String("abcdef");
        System.out.println(str1 == str2);//false
        String str3 = "abc"+"def";//拼接
        System.out.println(str1 == str3);//false  true
        String str4 = "abc"+ new String("def");
        System.out.println(str1 == str4);//false
        String str5 = "abc";
        String str6 = "def";
        String str7 = str5+str6;
        System.out.println(str1 == str7);//false
        String str8 = str5+new String("def");
        System.out.println(str4 == str8);//false
    }

    public static void main2(String[] args) {
        String str = "abcdef";//直接赋值
        String str2 = new String("abcdef");
        System.out.println(str == str2);//false
        System.out.println(str.equals(str2));
        char[] array = {'a','b','c','d'};
        String str3 = new String(array);
        System.out.println(str == str3);
    }

    public static void main1(String[] args) {
        String str = "abcdef";//直接赋值
        String str2 = new String("abcdef");
        char[] array = {'a','b','c','d'};
        String str3 = new String(array);
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);
    }
    public static boolean isNumber(String str){
        int i = 0;
        for(;i<str.length();i++){
            if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        String str = "1023456";
        boolean ret = isNumber(str);
        System.out.println(ret);
    }
}
