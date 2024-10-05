public class ForIndexDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        for (int i = 5; i > 0; i--) {
            System.out.println(i);
        }

        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i);
        }

        int[] numbers = {6, 3, 6, 8, 3, 5, 7, 2};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
