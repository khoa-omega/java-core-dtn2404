package constructor;

public class Student {
    String name;
    int age;

    Student() {
    }

    Student(String name) {
        this.name = name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "constructor.Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
