package polymorphism;

public class PolymorphismDemo {
    public static void main(String[] args) {
        // Widening: Student -> Person
        Person person = (Person) new Student("Khoa", 1);

        // Chỉ truy cập được phương thức của super
        person.sleep();
        // person.goToSchool();

        // Toán tử: instanceof
        boolean isStudent = person instanceof Student;
        System.out.println("isStudent = " + isStudent);

        // Compile polymorphism, Runtime polymorphism
    }
}
