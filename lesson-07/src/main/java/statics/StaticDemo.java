package statics;

public class StaticDemo {
    public static void main(String[] args) {
        // static: Truy cập thông qua tên class
        // property
        Student.moneyGroup = 100;
        System.out.println("Student.moneyGroup = " + Student.moneyGroup);

        // method
        int sum = Student.sum(1, 10);
        System.out.println("sum = " + sum);

        // class
        System.out.println("Math.PI = " + Math.PI);

        // Áp dụng
        Student s1 = new Student("A", 1);
        Student s2 = new Student("B", 2);
        Student s3 = new Student("C", 3);
        System.out.println("Student.count = " + Student.count);
    }

    public static class Math {
        public static double PI = 3.14;
    }
}
