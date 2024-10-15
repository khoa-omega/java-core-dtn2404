package exception;

public class ThrowsDemo {
    public static void main(String[] args) {
        // throws: Lan truyền ngoại lệ
        try {
            check(16);
        } catch (IllegalStateException exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static void check(int age) throws IllegalStateException {
        if (age < 18) {
            throw new IllegalStateException("Chưa đủ 18 tuổi");
        } else {
            System.out.println("Bạn đã đủ 18 tuổi");
        }
    }
}
