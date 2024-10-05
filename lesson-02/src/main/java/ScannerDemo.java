import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào tên của bạn:");
        String name = scanner.nextLine();
        System.out.println("Tên của bạn là: " + name);

        System.out.println("Bạn ăn cơm chưa?");
        boolean b = scanner.nextBoolean();
        System.out.println("b = " + b);

        System.out.println("Nhập vào tuổi của bạn:");
        int age = scanner.nextInt();
        System.out.println("age = " + age);
    }
}
