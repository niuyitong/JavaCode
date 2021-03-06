import java.util.Arrays;
public class TestHeap {

    public int[] elem;
    public int usedSize;

    public TestHeap() {
        this.elem = new int[10];
        this.usedSize = 0;
    }
    //调整为大根堆（一棵树）
    public void AdjustDown(int root,int len) {
        int parent = root;//要调整的树的节点的下标
        int child = 2*parent+1;
        //判断是否有孩子
        while (child < len) {
            if(child+1 < len &&//判断是否有右孩子
                    this.elem[child] < this.elem[child+1]){//判断左右孩子的大小
                child = child+1;//child存储为值较大的孩子
            }
            //child是左右孩子的最大值下标
            if(this.elem[child] > this.elem[parent]) {
                //交换
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {//调整完毕
                break;
            }
        }
    }


    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {//创建树
            this.elem[i] = array[i];
            this.usedSize++;
        }
        /**
         * i:代表的是每一棵树的根节点
         *
         */
        for (int i = (this.usedSize-1-1)/2; i >= 0 ; i--) {
            //是每一棵树都按照向下调整的方式进行调整
            AdjustDown(i,this.usedSize);
        }

    }

    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] +" ");
        }
        System.out.println();
    }
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }
    public void AdjustUp(int child) {
        int parent = (child-1)/2;
        while (child > 0) {//调整到根节点停止
            if(this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else {
                break;
            }
        }
    }
    public void pushHeap(int val) {
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,
                    this.elem.length*2);
        }
        //先放到最后位置
        this.elem[this.usedSize] = val;
        this.usedSize++;
        //开始向上调整
        AdjustUp(this.usedSize-1);
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }
    public void popHeap() {
        if(isEmpty()) {
            return;
        }
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;
        AdjustDown(0,this.usedSize);
    }
    public int getHeapTop() {
        if(isEmpty()) {
            return -1;
        }
        return this.elem[0];
    }
    public void heapSort() {
        int end = this.usedSize-1;
        while (end > 0) {
            int tmp = this.elem[end];
            this.elem[end] = this.elem[0];
            this.elem[0] = tmp;
            AdjustDown(0,end);
            end--;
        }
    }

}
