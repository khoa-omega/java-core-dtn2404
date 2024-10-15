package exception;

public class ThrowDemo {
    public static void main(String[] args) {
        // throw: Chủ động ném ra ngoại lệ
        try {
            int age = 15;
            if (age < 18) {
                throw new IllegalStateException("Chưa đủ 18 tuổi");
            } else {
                System.out.println("Bạn đã đủ 18 tuổi");
            }
        } catch (IllegalStateException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
