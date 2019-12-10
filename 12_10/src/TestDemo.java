import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class TestDemo {

    public static void main2(String[] args) {
        MyListQueue myListQueue = new MyListQueue();
        myListQueue.offer(1);
        myListQueue.offer(2);
        myListQueue.offer(3);
        myListQueue.offer(4);

        System.out.println(myListQueue.poll());//1
        System.out.println(myListQueue.peek());//2

        Queue<String> queue1 = new LinkedList<>();
        queue1.offer("abc");
        Queue<Integer> queue2 = new LinkedList<>();
    }
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        System.out.println(myStack.pop());//40
        System.out.println(myStack.getTop());//30
        MyStack<String> myStack2 = new MyStack<>();
        myStack2.push("Java");
        myStack2.push("20");
        myStack2.push("bit");
        myStack2.push("hhhh");
        System.out.println(myStack2.pop());//40
        System.out.println(myStack2.getTop());//30
    }
}