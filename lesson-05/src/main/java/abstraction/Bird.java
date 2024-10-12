package abstraction;

public class Bird extends Pet implements Runnable, Flyable {
    @Override
    public void makeSound() {
        System.out.println("Líu lo");
    }

    @Override
    public void run() {
        System.out.println("Bird running");
    }

    @Override
    public void fly() {
        System.out.println("Bird flying");
    }
}
