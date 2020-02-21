import java.util.Objects;
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

 //如果以后要往哈希表当中存放自定义类型
 //必须重写equals和hashCode方法
 //面试问题：为什么要重写equals和hashCode方法

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
//要存放自定义类型
class HashBucket2<K,V>{
    static class Node<K,V>{
        private K key;
        private V value;
        private Node<K ,V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node<K,V>[] array = (Node<K,V>[])new Node[8];//存放单链表的头结点
    private int size;
    //放数据
    public void put(K key,V value){
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode)%array.length;
        Node<K,V> cur = array[index];
        //若key已存在，则更新value的值
        while(cur!=null){
            if(cur.key.equals(key)){
                cur.value = value;
            }else{
                cur = cur.next;
            }
        }
        //若不存在，放数据
        Node<K,V> node = new Node<>(key,value);
        node.next = array[index];
        array[index] = node;
        this.size++;
    }
    //取数据
    public V getValue(K key){
        int index = Math.abs(key.hashCode())%array.length;
        Node<K,V> cur = array[index];
        while(cur!=null){
            if(cur.key.equals(key)){
                return cur.value;
            }else{
                cur = cur.next;
            }
        }
        return null;
    }
}
public class TestDemo2 {
    public static void main(String[] args) {
        Person person = new Person("gaobo",18);
        Person person2 = new Person("gaobo",18);
        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());
        HashBucket2<Person,String> hashBucket2 = new HashBucket2<>();
        hashBucket2.put(person,"1310966");

        String id = hashBucket2.getValue(person2);
        System.out.println(id);
    }
}
