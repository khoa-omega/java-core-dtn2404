package gc;

public class GarbageCollectorDemo {
    public static void main(String[] args) {
        // Vùng nhớ không có tham chiếu
        Dog dog = new Dog();
        dog = null;
        System.gc();

        // Biến cục bộ
        test();
        System.gc();
    }

    public static void test() {
        Dog dog = new Dog();
    }
}
