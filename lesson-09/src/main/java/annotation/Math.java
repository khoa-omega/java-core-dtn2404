package annotation;

public class Math {
    /**
     * @deprecated replaced by {@link #proMax(int, int)}
     */
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int proMax(int a, int b) {
        return a > b ? a : b;
    }
}
