public class Program {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.name = "Nguyễn Văn Khoa";
        System.out.println("s1.name = " + s1.name);

        s1.age = 1;
        System.out.println("s1.age = " + s1.age);

        int sum = s1.sum(7, 6);
        System.out.println("sum = " + sum);

        s1.goToSchool();
    }
}
