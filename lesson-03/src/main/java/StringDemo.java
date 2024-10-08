public class StringDemo {
    public static void main(String[] args) {
        // Primitive
        String s1 = "Java Core";
        String s2 = "Java Core";

        // Non primitive
        String s3 = new String("Java Core");
        String s4 = new String("Java Core");

        // ==: So sánh địa chỉ
        // equals: So sánh nội dung
        System.out.println(s1 == s2);           // true
        System.out.println(s2 == s3);           // false
        System.out.println(s3 == s4);           // false
        System.out.println(s1.equals(s2));      // true
        System.out.println(s2.equals(s3));      // true
        System.out.println(s3.equals(s4));      // true

        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        System.out.println(a == b);         // true
        System.out.println(c == d);         // false
        System.out.println(a.equals(b));    // true
        System.out.println(c.equals(d));    // true
    }
}
