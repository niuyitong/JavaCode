import java.util.*;

public class Person implements Comparable<Person>{
    String name;
    int id;
    int age;

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        //return this.name.compareTo(o.name);
        return this.age-o.age;
    }
}
