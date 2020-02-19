import java.util.*;
public class TestDemo {
    //MAP:底层是一个哈希表-》key是不能够重复的,V可以重复
    // key 的值可以为null 会自动按key的大小排序
    //Set:key是不能够重复的->key 的值可以为null  会自动按key的大小排序
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(5, "he");
        map.put(2, "ha");
        System.out.println(map);
        System.out.println(map.containsKey(2));
        System.out.println(map.keySet());//按顺序打印出key
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
        Set<Integer> set = map.keySet();
        System.out.println(set);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(1);
        System.out.println(set2);

        //迭代器->只要实现了iterable接口
        Iterator<Integer> iterator = set2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());//遍历set
        }
    }
}
