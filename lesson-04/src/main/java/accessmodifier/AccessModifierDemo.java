package accessmodifier;

public class AccessModifierDemo {
    public static void main(String[] args) {
        // Phạm vi truy cập
        // public: Có thể truy cập từ mọi nơi
        Dog dog = new Dog();
        System.out.println("dog.name = " + dog.name);

        // protected: Có thể truy cập trong cùng package hoặc class con
        System.out.println("dog.age = " + dog.age);

        // default: Có thể truy cập trong cùng package
        System.out.println("dog.color = " + dog.color);

        // private: Có thể truy cập trong class đó
        // System.out.println("dog.weight = " + dog.weight);
    }
}
