public class HashBucket {

    static class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] array = new Node[8];//存放单链表的头结点
    private int size;//当前数据的个数


    public int getValue(int key) {
        int index = key % array.length;
        //遍历array[index]下标的链表，找到值为key的数据，并且返回
        Node head = array[index];
        while(head!=null){
            if(head.key==key){
                return head.value;
            }else{
                head = head.next;
            }
        }
        return -1;
    }
    public void put(int key,int value){
        int index = key%array.length;
        Node cur = array[index];
        while(cur!=null){
            //如果链表中已存在key,则更新value
            if(cur.key==key){
                cur.value = value;
                return;
            }else{
                cur = cur.next;
            }
        }
        //说明不存在key 采用头插
        Node node = new Node(key,value);
        node.next = array[index];
        array[index] = node;
        this.size++;

        //负载因子超过0.75，则扩容
        if(loadFactor() >= 0.75) {
            resize();//扩容
        }
    }
    private double loadFactor(){
        return this.size*1.0/array.length;
    }
    private void resize(){
        Node[] newArray = new Node[array.length*2];
        //重新哈希
        //1、遍历原来的数组，将里面的元素重新进行哈希到新的数组里面
        for(int i=0; i<array.length; i++){
            Node cur = array[i];
            while(cur!=null){
                int index = cur.key%newArray.length;
                Node curNext = cur.next;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        array = newArray;
    }
}