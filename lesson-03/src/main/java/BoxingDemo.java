public class BoxingDemo {
    public static void main(String[] args) {
        // Boxing: Primitive -> Wrapper class
        int a = 10;
        Integer b = Integer.valueOf(a);
        System.out.println("b = " + b);

        // Auto boxing
        Integer c = a;
        System.out.println("c = " + c);

        // Áp dụng: Convert chuỗi sang wrapper class
        String s = "12345";
        Integer d = Integer.valueOf(s);
        System.out.println(s + 1);
        System.out.println(d + 1);
    }
}
