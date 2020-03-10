import java.lang.reflect.Array;
import java.util.*;

public class TestDemo {

    //找n个数里的前K个小数，并从小到大排列
    public static Integer[] findKNum(int[] array,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>
                (k, new Comparator<Integer>() {
                    //调整的时候使用
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);//建大堆
                    }
                });
        for(int i=0; i<array.length; i++){
            if(maxHeap.size()<k){
                maxHeap.add(array[i]);
            }else{
                Integer top = maxHeap.peek();
                if(top!=null && top>array[i]){
                    maxHeap.poll();
                    maxHeap.add(array[i]);
                }
            }
        }
        Integer[] integers = new Integer[k];
        for(int i=k-1; i>=0; i--){
            Integer top = maxHeap.peek();
            integers[i] = top;
            maxHeap.poll();
        }
        return integers;
    }

    //删数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        while(sc.hasNextInt()){
            int N = sc.nextInt();
            if(N>1000){
                N = 1000;
            }
            for(int i=0; i<N; i++){
                queue.offer(i);
            }
            while(queue.size()!=1){
                int tmp = 0;
                while(queue.size()!=0 && tmp<2){
                    queue.offer(queue.poll());
                    tmp++;
                }
                if(queue.size()!=0)
                    queue.poll();
            }
            System.out.println(queue.peek());
        }
    }
}
