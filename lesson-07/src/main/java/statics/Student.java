package statics;

public class Student {
    private int id;
    public String name;
    public int age;

    public static int moneyGroup;
    public static int count;

    public Student(String name, int age) {
        this.id = ++count;
        this.name = name;
        this.age = age;
    }

    public static int sum(int a, int b) {
        return a + b;
    }
}
