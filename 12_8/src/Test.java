import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        ArrayList<Integer> arrayList = new ArrayList<>();

        list.add("Hello");
        list.add("Java");
        list.add("20");
        System.out.println(list);
        list.add(1,"sun");
        System.out.println(list);
        List<String> list2 = new ArrayList<>();
        list2.add("20");
        list2.add("2");

        list.addAll(list2);

        System.out.println(list);
        String  s = list.remove(1);//返回的为移除的元素即sun
        System.out.println(s);
        System.out.println(list);
    }
}
