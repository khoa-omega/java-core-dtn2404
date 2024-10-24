package gc;

public class Dog {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Dog is collected...");
    }
}
