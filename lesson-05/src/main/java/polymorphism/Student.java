package polymorphism;

public class Student extends Person {
    private int id;

    public Student(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public void sleep() {
        System.out.println("Student is sleeping...");
    }

    public void goToSchool() {
        System.out.println("Student is going to school...");
    }
}
