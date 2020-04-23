import java.util.*;

public class Test{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] a = in.nextLine().split(" ");
            StringBuffer sb = new StringBuffer(a[0]);
            int i = 0;
            for(i=0; i<a[1].length(); i++){
                if(sb.indexOf(a[1].charAt(i)+"")!=-1){
                    sb.deleteCharAt(sb.indexOf(a[1].charAt(i)+""));
                }else{
                    break;
                }
            }
            if(i==a[1].length()){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    public static String encryption(String a){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<a.length(); i++){
            char tmp = a.charAt(i);
            if(tmp>='a' && tmp<='z'){
                if(tmp!='z'){
                    tmp = (char)(tmp-31);
                }else{
                    tmp = (char)(tmp-57);
                }
                sb.append(tmp);
            }else if(tmp>='A' && tmp<='Z'){
                if(tmp!='Z'){
                    tmp = (char)(tmp+33);
                }else{
                    tmp = (char)(tmp+7);
                }
                sb.append(tmp);
            }else if((tmp-'0')>=0 && (tmp-'0')<=9){
                int n = tmp-'0';
                if(n!=9){
                    n += 1;
                }else{
                    n = 0;
                }
                sb.append(n);
            }else{
                sb.append(tmp);
            }
        }
        return sb.toString();
    }
    public static String deciphering(String b){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<b.length(); i++){
            char tmp = b.charAt(i);
            if(tmp>='a' && tmp<='z'){
                if(tmp!='a'){
                    tmp = (char)(tmp-33);
                }else{
                    tmp = (char)(tmp-7);
                }
                sb.append(tmp);
            }else if(tmp>='A' && tmp<='Z'){
                if(tmp!='A'){
                    tmp = (char)(tmp+31);
                }else{
                    tmp = (char)(tmp+57);
                }
                sb.append(tmp);
            }else if((tmp-'0')>=0 && (tmp-'0')<=9){
                int n = tmp-'0';
                if(n!=0){
                    n -= 1;
                }else{
                    n = 9;
                }
                sb.append(n);
            }else{
                sb.append(tmp);
            }
        }
        return sb.toString();
    }
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String c = in.nextLine();
            String b = in.nextLine();
            c = encryption(c);//加密
            b = deciphering(b);//解密
            System.out.println(c);
            System.out.println(b);
        }
    }

}