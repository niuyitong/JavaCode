import java.util.Scanner;

public class TestDemo {

    //链表A+B
    /*
    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode node = new ListNode(-1);
        ListNode cur = node;
        int flg = 0;
        while(a!=null && b!=null){
            cur.next = new ListNode(-1);
            cur = cur.next;
            cur.val = (a.val+b.val+flg)%10;
            if(a.val+b.val+flg>9){
                flg = 1;
            }else{
                flg = 0;
            }
            a = a.next;
            b = b.next;
        }
        if(flg == 1){
            if(a==null && b==null){
                cur.next = new ListNode(1);
            }else if(a==null && b!=null){
                if(flg+b.val<=9){
                    cur.next = new ListNode(-1);
                    cur = cur.next;
                    cur.val = flg + b.val;
                    cur.next = b.next;
                }else{
                    while(b!=null){
                        cur.next = new ListNode(-1);
                        cur = cur.next;
                        cur.val = (flg+b.val)%10;
                        if(flg+b.val<=9){
                            cur.next = b.next;
                            break;
                        }
                        b = b.next;

                    }

                }
            }else if(a!=null && b==null){
                if(flg+a.val<=9){
                    cur.next = new ListNode(-1);
                    cur = cur.next;
                    cur.val = flg + a.val;
                    cur.next = a.next;
                }else{
                    while(a!=null){
                        cur.next = new ListNode(-1);
                        cur = cur.next;
                        cur.val = (flg+a.val)%10;
                        if(flg+a.val<=9){
                            cur.next = a.next;
                            break;
                        }
                        a = a.next;

                    }

                }
            }
        }else{
            if(a!=null && b==null){
                cur.next = a;
            }else{
                cur.next = b;
            }
        }
        return node.next;
    }
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            StringBuffer sb = new StringBuffer(in.nextLine());
            String str = in.nextLine();
            int count = 0;
            boolean flag = true;
            for(int i=0; i<str.length(); i++){
                if(sb.indexOf(str.charAt(i)+"")!=-1){
                    sb.deleteCharAt(sb.indexOf(str.charAt(i)+""));
                }else{
                    count++;
                    flag = false;
                }
            }
            if(flag){
                System.out.println("YES " + sb.length());
            }else{
                System.out.println("NO " + count);
            }
        }
    }
    //最难的问题day21
    public static void main1(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();//ABCD
            char[] charStr = new char[str.length()];
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)==' '){
                    charStr[i] = ' ';
                }else{
                    if((str.charAt(i)-5)<'A'){
                        charStr[i] = (char)('Z'-('A' - (str.charAt(i)-5) ));
                    }else {
                        charStr[i] = (char) ((str.charAt(i) - 5));
                    }
                }
            }
            for(int j=0; j<charStr.length; j++){
                System.out.print(charStr[j]);
            }
            System.out.println();
        }
    }
}
