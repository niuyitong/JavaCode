import java.util.Stack;

//两个栈实现队列
class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if(!stack2.empty()){
            return stack2.pop();
        }
        return -1;
    }
}
public class TestDemo {
    //旋转数组的最小数字
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            //只要右边比中间大，那右边一定是有序数组
            if (numbers[r] > numbers[mid]) {
                r = mid;
            } else if (numbers[r] < numbers[mid]) {
                l = mid + 1;
                //去重
            } else r--;
        }
        return numbers[l];
    }
    //青蛙跳台阶
    //1 1 2 3 5
    public int numWays(int n) {
        if (n <= 1) return 1;
        int f0 = 1, f1 = 1;
        int res = f0 + f1;
        for (int i = 2; i < n+1; ++i) {
            res = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = res;
        }
        return res;
    }
    //斐波那契
    public int fib(int n) {
        if(n<2){
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = 0;
        while(n-1>0){
            sum = (a + b)%1000000007;
            a = b;
            b = sum;
            n--;
        }
        return sum;
    }
    public static void main(String[] args) {

    }
}
