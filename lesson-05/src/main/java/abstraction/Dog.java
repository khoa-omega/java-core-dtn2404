package abstraction;

public class Dog extends Pet implements Runnable {
    @Override
    public void makeSound() {
        System.out.println("Gâu Gâu");
    }

    @Override
    public void run() {
        System.out.println("Dog running");
    }
}
