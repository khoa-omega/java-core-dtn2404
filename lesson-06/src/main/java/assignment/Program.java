package assignment;

public class Program {
    public static void main(String[] args) {
        ScannerUtil util = new ScannerUtil();

        System.out.println("Nhập vào số nguyên:");
        int n = util.inputInt();
        System.out.println("n = " + n);

        System.out.println("Nhập vào password:");
        String password = util.inputPassword();
        System.out.println("password = " + password);
    }
}
