public class UnboxingDemo {
    public static void main(String[] args) {
        // Unboxing: Wrapper class -> Primitive
        Integer a = 10;
        double b = a.doubleValue();
        System.out.println("b = " + b);

        // Auto unboxing
        int c = a;
        System.out.println("c = " + c);

        // Áp dụng: Convert String sang Primitive
        String s = "12345";
        int d = Integer.parseInt(s);
        System.out.println(s + 1);
        System.out.println(d + 1);
    }
}
