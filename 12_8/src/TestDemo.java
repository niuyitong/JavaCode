import java.util.*;
class Student{
    public String name;
    public String classes;
    public double grade;
    public Student(String name,String classes,double grade){
        this.name = name;
        this.classes = classes;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", grade=" + grade +
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        myArrayList.add("java");
        myArrayList.add("20191208");

        String ret = myArrayList.get();
        System.out.println(ret);

        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
        myArrayList2.add(1);
        myArrayList2.add(2);

    }

    //numRows：你的行数
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());//0
        triangle.get(0).add(1);
        //行数
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            //上一行
            List<Integer> prevRow = triangle.get(i-1);
            //第i行的第j列
            for (int j = 1; j < i; j++) {
                int tmp = prevRow.get(j-1)+prevRow.get(j);
                curRow.add(tmp);
            }
            curRow.add(1);
            triangle.add(curRow);
        }
        return triangle;
    }
    //杨辉三角
    public static void main4(String[] args) {
        List<List<Integer>> ret = generate(5);

        for (List<Integer> list  : ret) {
            System.out.println(list);
        }
    }

    //删除str1中也在str2中存在的字符
    public static List<Character> func(String str1,String str2){
        List<Character> ret = new ArrayList<>();
        for(int i = 0;i<str1.length();i++){
            char ch = str1.charAt(i);
            if(!str2.contains(ch+"")){
                ret.add(ch);
            }
        }
        return ret;
    }
    public static void main3(String[] args) {
        String str1 = "welcome to haha";
        String str2 = "come";
        List<Character> list = func(str1,str2);
        Object[] obj = list.toArray();
    }
    public static void main2(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三","05班",90));
        list.add(new Student("李四","07班",80));
        list.add(new Student("王二","06班",60.5));
        //System.out.println(collection);
        for(Student s:list){
            System.out.println(s);
        }
    }

    public static void main1(String[] args) {
        //Collection
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("nyt");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        System.out.println(collection);
        collection.remove("hello");
        System.out.println(collection);
        collection.add("nishizhu");
        collection.add("haha");
        System.out.println(collection);
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));

        //Map
        Map<String,String> map = new HashMap<>();
        map.put("lxq","beautiful");
        map.put("nyt","handsome");
        map.put("zry","my");
        System.out.println(map);
        String str = map.getOrDefault("nyt2,","lucky");
        System.out.println(str);
        String str2 = map.get("lxq");
        System.out.println(str2);
        System.out.println("=============");
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
