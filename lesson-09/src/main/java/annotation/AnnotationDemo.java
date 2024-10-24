package annotation;

public class AnnotationDemo {
    public static void main(String[] args) {
        // Chú thích

        // @Override
        Cat cat = new Cat();
        cat.eat();

        // @Deprecated
        int max = Math.proMax(1, 2);
        System.out.println("max = " + max);

        // @SuppressWarnings
        @SuppressWarnings("deprecation")
        int m = Math.max(9, 99);
        System.out.println("m = " + m);
    }
}
