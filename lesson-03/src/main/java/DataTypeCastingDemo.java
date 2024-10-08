public class DataTypeCastingDemo {
    public static void main(String[] args) {
        // Widening: byte -> short -> int -> long -> float -> double
        int a = 10;
        long b = a; // <--- implicit
        System.out.println("b = " + b);

        // Narrowing: double -> float -> long -> int -> short -> byte
        int c = 256;
        byte d = (byte) c; // <--- explicit
        System.out.println("d = " + d);

        // Áp dụng
        int x = 1;
        int y = 2;
        System.out.println((float) x / y);
        System.out.println(x / (float) y);
        System.out.println((float) x / (float) y);

        System.out.println((float) (x / y));
        System.out.println(x / y);
    }
}
