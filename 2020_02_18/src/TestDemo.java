import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:  通用栈   Object
 *  1、泛型的意义：
 *     a:在存放数据的时候，对数据进行类型检查
 *     b:取数据时不需要进行强制类型转换，泛型可以自动进行类型的转换。
 * 2、<T> ：T是一个占位符，表明当前类是一个泛型类
 * 3、不能new T类型的数组：不能new泛型类型的数组。
 * 4、泛型的参数，不能是简单类型。只能引用类型。
 * 5、面试问题：
 *    泛型到底怎么编译的？---》泛型真正起作用的时候，是在编译时期。
 *    泛型是在编译的时候的一种机制。
 *    泛型到底怎么编译的？--》擦除机制。
 *6、       MyStack<Integer> myStack = new MyStack<>();
 *         MyStack<String> myStack = new MyStack<>();
 *         泛型的参数，不参与类型的组成。为什么？被擦除了！擦除成什么了？Object
 * 在编译的时候，她会拿着泛型类型进行检查，但是不是替换。
 *
 * User: GAOBO
 * Date: 2020-02-18
 * Time: 10:23
 */
class MyStack<T>{

    public T[] elem;
    public int top;

    public MyStack() {
        //this.elem = new T[10];错误的 不能New
        this.elem = (T[]) new Object[10];
        this.top = 0;
    }

    public void push(T data) {
        this.elem[top++] = data;
    }

    public T pop() {
        T oldData = this.elem[top-1];
        top--;
        return oldData;
    }
}

/**
 * 同学：给我写一个泛型类，找出数组当中的最大值。
 * 泛型的上界：extends
 * T extends Comparable：掺入的泛型参数T一定要实现Comparable
 */
class Algorithm<T extends Comparable<T>> {

    public T findMaxVal(T[] array) {
        T maxVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i].compareTo(maxVal) > 0) {
                maxVal = array[i];
            }
        }
        return maxVal;
    }
}
class Algorithm2 {
    //通过实参的类型可以推导出形参的T是什么类型！
    //在static后写
    public static<T extends Comparable<T>> T findMaxVal(T[] array) {
        T maxVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i].compareTo(maxVal) > 0) {
                maxVal = array[i];
            }
        }
        return maxVal;
    }
}

/**
 * 写一个泛型方法打印出数组中所有的元素
 */
class Algorithm3 {
    public static<T> void printList(ArrayList<T> array) {
        for (T obj : array) {
            System.out.print(obj+" ");
        }
        System.out.println();
    }

    /**
     * 通配符：读取
     * @param array
     */
    public static void printList2(ArrayList<?> array) {
        for (Object obj : array) {
            System.out.print(obj+" ");
        }
        System.out.println();
    }

}


public class TestDemo {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Algorithm3.printList2(arrayList);
    }

   //（静态调用）
    public static void main4(String[] args) {
        Integer[] array = {10,3,1,67,32,45};
        //Algorithm2.<Integer>这样也可以指定
        Integer ret = Algorithm2.<Integer>findMaxVal(array);
        System.out.println(ret);
    }

    public static void main3(String[] args) {
        Algorithm<Integer> algorithm = new Algorithm<>();
        Integer[] array = {10,3,1,67,32,45};
        Integer ret = algorithm.findMaxVal(array);
        System.out.println(ret);
    }

    public static void main2(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        int a = myStack.pop();
        System.out.println(a);

        MyStack<String> myStack2 = new MyStack<>();
        myStack2.push("wang");
        String s = myStack2.pop();
        System.out.println(s);

        System.out.println(myStack);
        System.out.println(myStack2);

        //MyStack<int> myStack3 = new MyStack<>();

        /* MyStack myStack4 = new MyStack();
        myStack4.push(1);
        myStack4.push("wang");
        String s1 =  myStack4.pop();
        System.out.println(s1);*/

        /*MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push("wang");
        String a =  myStack.pop();
        System.out.println(a);*/
    }
}
