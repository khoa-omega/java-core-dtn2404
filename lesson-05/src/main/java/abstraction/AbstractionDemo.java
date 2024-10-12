package abstraction;

public class AbstractionDemo {
    public static void main(String[] args) {
        // Tính trừu tượng

        // 1. Không thể khởi tạo đối tượng từ abstract class
        // Pet pet = new Pet();

        // 2. Abstract class có thể không có abstract method nào
        // 3. Một class phải là abstract nếu có abstract method
        // 4. Abstract class: Độ trừu tượng <= 100%
        Dog dog = new Dog();
        dog.makeSound();
    }
}
