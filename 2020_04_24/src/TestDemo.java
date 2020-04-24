import java.util.*;

public class TestDemo {

//纯粹的考代码实现能力
//记录个数，故使用Map，不需要排序故使用HashMap，根据题意是要循环输出，而且提交一次会有测试用例提示，需要按照输入顺序输出，故使用LinkedHashMap
//在输出的时候，题目的意思是循环八个，但问题是必须记录全部错误个数，否则刚记录完后弹出了，错误数就对不上了，跟操作系统里的缺页有那么点相似
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    Map<String, Integer> map=new LinkedHashMap<String, Integer>();
    while(sc.hasNext()){
        String str=sc.next();
        int linenum=sc.nextInt();
        String[] arr=str.split("\\\\");  //根据\切割
        String s=arr[arr.length-1];
        if(s.length()>16)  //截取
            s=s.substring(s.length()-16);
        String key=s+" "+linenum;
        int value=1;
        if(map.containsKey(key))
            map.put(key, map.get(key)+1);
        else {
            map.put(key, value);
        }
    }
    int count=0;
    for(String string:map.keySet()){
        count++;
        if(count>(map.keySet().size()-8)) //输出最后八个记录
            System.out.println(string+" "+map.get(string));
    }
}

    //数组里出现次数超过一半的数字
    public int MoreThanHalfNum_Solution(int [] array) {
        //123
        int mode=array[0];//1
        int count=0;
        for(int i=0;i<array.length;i++){
            if(count==0)mode=array[i];
            if(array[i]==mode) count++;
            else count--;
        }
        count = 0;
        for(int i=0; i<array.length; i++){
            if(mode==array[i]){
                count++;
            }
        }
        if(count>array.length/2){
            return mode;
        }
        return 0;
    }
}
