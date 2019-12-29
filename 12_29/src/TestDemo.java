import java.util.PriorityQueue;
import java.util.Queue;

public class TestDemo {

    public static void main3(String[] args) {
        //默认是一个小根堆
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(27);
        queue.offer(37);
        queue.offer(25);
        queue.offer(57);
        System.out.println(queue.peek());
    }
    public static void main(String[] args) {
        int[]  array = {27,15,19,18,28,34,65,49,25,37 };
        TestHeap testHeap = new TestHeap();
        testHeap.createHeap(array);
        testHeap.show();
        testHeap.pushHeap(100);
        testHeap.show();
        testHeap.popHeap();
        testHeap.show();
        System.out.println(testHeap.getHeapTop());
        System.out.println("================");
        testHeap.heapSort();
        testHeap.show();
    }
}

