import java.util.Arrays;

/**
 * 如果要排序自定义的类型
 * 需要自己手动进行实现Comparable接口
 * T:泛型
 *
 */
class Student implements Comparable<Student> {
    public String name;
    public int age;
    public double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
        //return (int)(this.score-o.score);
        //return this.age - o.age;//从小到大
        //return 0;
    }
}

public class TestDemo1 {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("caocao",16,99.6);
        students[1] = new Student("zhangfei",36,79.6);
        students[2] = new Student("guanyu",26,89.6);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}