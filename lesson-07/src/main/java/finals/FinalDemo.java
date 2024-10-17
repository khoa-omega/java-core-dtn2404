package finals;

public class FinalDemo {
    public static final double E = 2.71;

    public static void main(String[] args) {
        // final property / variable / parameter: Tạo hằng số
        final double pi = 3.14;
        // pi = 5;
        int sum = sum(1, 10);
        System.out.println("sum = " + sum);
        System.out.println("E = " + E);

        // final method: Tạo phương thức không thể bị ghi đè
        // final class: Tạo class không thể bị extend (kế thừa)
    }

    public static int sum(final int a, final int b) {
        // a = 100;
        // b = 100;
        return a + b;
    }
}
