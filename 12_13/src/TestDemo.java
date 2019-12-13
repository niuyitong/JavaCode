import java.util.Arrays;
class Test {
    private int[] elem ;
    private int usedSize;//有效数据的个数
    private final int CAPACITY = 5;

    public Test() {
        this.elem = new int[CAPACITY];
        this.usedSize = 0;
    }
    //打印顺序表
    public void display(){
        for(int i = 0;i<this.usedSize;i++){
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
    //扩容
    private boolean isFull(){
        return this.usedSize==this.elem.length;
    }
    //在Pos位置添加元素
    public void add(int pos,int data){
        if(isFull()){
            //二倍扩容
            this.elem = Arrays.copyOf(
                    this.elem,this.elem.length*2);

        }
        if(pos<0 || pos>this.usedSize){
            System.out.println("位置不合法");
            return;
        }

        for(int i=usedSize-1;i>=pos;i--){
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    //查找某个元素对应的位置
    public int search(int toFind){
        for(int i = 0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    //获取Pos位置的元素
    public int getPos(int pos){
        if(pos<0 || pos>=this.usedSize){
            System.out.println("Pos位置不合法");
            return -1;
        }
        return this.elem[pos];
    }
    //获取顺序表长度
    public int size(){
        return this.usedSize;
    }
    //删除第一次出现的关键字
    public void remove(int num){
        int ret = search(num);
        if(ret == -1){
            System.out.println("找不到要删除的数字");
            return;
        }
        for(int i=ret;i<this.usedSize-1;i++){
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }
    //清空
    public void clear(){
        System.out.println("清空");
        this.usedSize = 0;
    }
}

