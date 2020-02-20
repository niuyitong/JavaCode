import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class TestDemo {
    //前K个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        //先将单词及出现的次数成对存放在Map中
        Map<String,Integer> map = new HashMap<>();
        for (String s : words) {
            if(map.get(s)==null){
                map.put(s,1);
            }else{
                map.put(s,map.get(s)+1);
            }
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new
                PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().equals(o2.getValue())){
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue()-o2.getValue();
            }
        });
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(minHeap.size()<k){
                minHeap.add(entry);
            }else{
                Map.Entry<String,Integer> top = minHeap.peek();
                if(top!=null && top.getValue().equals(entry.getValue())){
                    if(top.getKey().compareTo(entry.getKey())>0){
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                }else{
                    if(top!=null && top.getValue().compareTo(entry.getValue())<0){
                        minHeap.poll();
                        minHeap.add(entry);
                    }
                }
            }
        }
        System.out.println(minHeap);// love  i
        List<String> list = new ArrayList<>();
        for(int i = 0;i < k;i++) {
            String pop = minHeap.peek().getKey();
            list.add(0,pop);
            minHeap.poll();
        }
        return list;// i  love
    }
    //topK问题
    public static Integer[] findKNum(int[] array,int k){
        //1.建立大小为K的堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>
                (k, new Comparator<Integer>() {
                    //调整的时候使用
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);//建立小堆
                //return o2.compareTo(o1);建立大堆
            }
        });
        //2.
        for(int i=0; i<array.length; i++){
            if(minHeap.size()<k){
                minHeap.add(array[i]);
            }else{
                Integer top = minHeap.peek();
                if(top!=null && top<array[i]){
                    minHeap.poll();
                    minHeap.add(array[i]);
                }
            }
        }
        Integer[] integers = new Integer[k];
        for(int i=0; i<k; i++){
            Integer top = minHeap.peek();
            integers[i] = top;
            minHeap.poll();
        }
        return  integers;
    }


    public static void main(String[] args) {
        int[] array = {12,4,6,17,9,51,21,10,45,31};
        Integer[] ret = findKNum(array,4);
        System.out.println(Arrays.toString(ret));
    }

    //找坏的键盘(力扣)
    public static void main1(String[] args){
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();//期望的字符串
        String str2 = scan.nextLine();//实际输入的字符串
        Set<Character> setAct = new HashSet<>();
        for(char ch : str2.toUpperCase().toCharArray()) {
            setAct.add(ch);
        }//说明实际输入的字符，全部都存在了集合setAct当中。

        Set<Character> broken  = new HashSet<>();
        for(char ch1 : str1.toUpperCase().toCharArray()) {

            if(!setAct.contains(ch1) && !broken.contains(ch1)) {
                broken.add(ch1);
                System.out.print(ch1);
            }

        }
        System.out.println();

    }
    //拷贝带随机指针的链表
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while(cur!=null){
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    //宝石与石头
    public int numJewelsInStones(String J, String S) {
        //1.将宝石放到集合
        Set<Character> set = new HashSet<>();
        for(int i=0; i<J.length(); i++){
            set.add(J.charAt(i));
        }
        int count = 0;
        //2.遍历石头s,是宝石的++
        for(int i=0; i<S.length(); i++){
            if(set.contains(S.charAt(i))){
                count++;
            }
        }
        //3.返回结果
        return count;
    }

}

