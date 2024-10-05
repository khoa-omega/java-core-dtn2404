public class ReturnDemo {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int n = 200;

        int index = indexOf(numbers, n);
        System.out.println("index = " + index);
    }

    static int indexOf(int[] numbers, int n) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
