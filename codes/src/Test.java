import java.util.*;
public class Test{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String[] staffs = in.nextLine().split(" ");
            String[] tasks = in.nextLine().split(" ");
            if(staffs.length==0 || tasks.length==0){
                System.out.println(0);
            }else{
                int count = 0;
                for(int i=0,j=0; i<staffs.length && j<tasks.length; i++,j++){
                    for(; j<tasks.length; j++){
                        if(tasks[j].charAt(0)>=staffs[i].charAt(0)){
                            count++;
                            break;
                        }
                    }
                }
                System.out.println(count);
            }
        }
    }
}