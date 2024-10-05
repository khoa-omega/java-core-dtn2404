public class BreakDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                break;
            }
            System.out.println(i);
        }
    }
}
