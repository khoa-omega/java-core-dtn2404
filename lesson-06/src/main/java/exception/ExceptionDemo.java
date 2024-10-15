package exception;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            int a = 1 / 0;
            System.out.println("a = " + a);

            int[] numbers = {1, 2, 3};
            System.out.println("numbers[10] = " + numbers[10]);

            String s = null;
            System.out.println("s.toUpperCase() = " + s.toUpperCase());
        } catch (ArithmeticException exception) {
            System.out.println("Can not divide by zero");
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Out of bounds");
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println("Có lỗi xảy ra");
        } finally {
            System.out.println("Finally luôn được gọi");
        }
    }
}
