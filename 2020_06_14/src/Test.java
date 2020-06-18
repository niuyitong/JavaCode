import java.util.*;

class Students {
    String name;
    int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class AgeComparator implements Comparator<Students> {
    @Override
    public int compare(Students o1, Students o2) {
        return o1.age-o2.age;//compareTo是String内部的比较方法
    }
}
class NameComparator implements Comparator<Students> {
    @Override
    public int compare(Students o1, Students o2) {
        return o1.name.compareTo(o2.name);//compareTo是String内部的比较方法
    }
}
public class Test {
    public static void main(String[] args) {
        Students student1 = new Students("芳姐",20);
        Students student2 = new Students("李姐",10);
        Students student3 = new Students("小花",15);
        //年龄比较
        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(student1,student2));//10
        //姓名比较
        NameComparator nameComparator = new NameComparator();
        System.out.println(nameComparator.compare(student1,student2));

       Students[] students = new Students[3];
       students[0] = student1;
       students[1] = student2;
       students[2] = student3;
       AgeComparator ageComparator1 = new AgeComparator();
       Arrays.sort(students,ageComparator1);
        System.out.println(Arrays.toString(students));
    }
}
