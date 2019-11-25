import java.util.Arrays;

/**
 * 如果要排序自定义的类型
 * 	1.需要自己动手实现Comparable接口
 * 	2.重写compareTo方法
 */
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public double score;
public Student (String name,int age,double score){
    this.name = name;
    this.age = age;
    this.score = score;
}
    @Override
    public String toString() {
        return "{"+this.name+","+this.age+","+this.score+"}";
    }

    @Override
    public int compareTo(Student o) {
        return o.name.compareTo(this.name);
        //return this.age-o.age;
        //return (int)(this.score-o.score);
    }
}
public class Test1 {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("小张",15,87.3);
        students[1] = new Student("李大",12,97.3);
        students[2] = new Student("老王",20,67.3);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

}
