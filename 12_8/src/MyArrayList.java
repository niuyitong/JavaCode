public class MyArrayList<T> {
    private T[] elem;
    private int usedSize;
    public MyArrayList() {
        //this.elem = new T[10];
        this.elem = (T[])new Object[10];
        this.usedSize = 0;
    }
    public void add(T data) {
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }
    public T get() {
        return this.elem[this.usedSize-1];
    }
}