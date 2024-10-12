package abstraction;

public class InterfaceDemo {
    public static void main(String[] args) {
        // Interface: Độ trừu tượng = 100%
        // Property: public static final
        // Method: public abstract
        // Từ khóa: implements
        // Đa kế thừa: Có thể triển khai nhiều interface
        Bird bird = new Bird();
        bird.run();
        bird.fly();
    }
}
