package abstraction;

public class Cat extends Pet implements Runnable {
    @Override
    public void makeSound() {
        System.out.println("Meo meo");
    }

    @Override
    public void run() {
        System.out.println("Cat running");
    }
}
