import java.util.*;

public class TestDemo {
    //两个超长整数相加
    public static String AddLongInteger(String addend,String augend){
        char[] arr1 = addend.toCharArray();
        char[] arr2 = augend.toCharArray();
        int len1 = arr1.length;//8
        int len2 = arr2.length;//5
        int[] a;
        int[] b;
        if(len1>len2){
            a = new int[len1];//8
            b = new int[len1];//8
            for(int i=0; i<len1; i++){
                a[i] = arr1[i]-'0';
            }
            for(int i=0; i<len1-len2; i++){
                b[i] = 0;
            }
            for(int i=len1-len2; i<len1; i++){
                b[i] = arr2[i-len1+len2]-'0';
            }
        }else{
            a = new int[len2];
            b = new int[len2];
            for(int i=0; i<len2-len1; i++){
                a[i] = 0;
            }
            for(int i=len2-len1; i<len2; i++){
                a[i] = arr1[i-len2+len1]-'0';
            }
            for(int i=0; i<len2; i++){
                b[i] = arr2[i]-'0';
            }
        }
        int tmp = 0;
        int len = a.length-1;
        //18 13
        while(len>=0){
            if(a[len]+b[len]+tmp>9){
                a[len] = (a[len]+b[len]+tmp)%10;
                tmp = 1;
            }else{
                a[len] = a[len]+b[len]+tmp;
                tmp = 0;
            }
            len--;
        }
        //9 8
        if(tmp==1){
            int[] newA = new int[a.length+1];
            newA[0] = 1;
            for(int i=0; i<a.length; i++){
                newA[1+i] = a[i];
            }
            a = newA;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<a.length; i++){
            sb.append(a[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String a = in.nextLine();
            String b = in.nextLine();
            String ret = AddLongInteger(a,b);
            System.out.println(ret);
        }
    }
    //跟奥巴马一起编程
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int N = sc.nextInt();
            String c = sc.next();
            for(int j=0; j<Math.round(N/2.0); j++){
                if(j==0||j==Math.round(N/2.0)-1){
                    for(int i=0; i<N; i++){
                        System.out.print(c);
                        if(i==N-1){
                            System.out.println();
                        }
                    }
                }else{
                    for(int i=0; i<N; i++){
                        if(i==0){
                            System.out.print(c);
                        }else if(i==N-1){
                            System.out.print(c);
                            System.out.println();
                        }else{
                            System.out.print(" ");
                        }
                    }
                }
            }
        }
    }
}
