package overloading;

public class MathUtil {
    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int a, short b) {
        return a + b;
    }

    public int sum(short a, int b) {
        return a + b;
    }

    public int sum(int a, int b, int c) {
        return a + b;
    }
}
