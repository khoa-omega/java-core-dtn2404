import java.time.LocalDate;
import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();

        int n = random.nextInt();
        System.out.println("n = " + n);

        // 0 <= m < 100
        int m = random.nextInt(100);
        System.out.println("m = " + m);

        // min <= k <= max
        int min = 100;
        int max = 999;
        int k = min + random.nextInt(max - min + 1);
        System.out.println("k = " + k);

        // VD: Lấy ngẫu nhiên một phần tử trong mảng
        String[] fruits = {"Táo", "Cam", "Nho", "Lê"};
        int randomIndex = random.nextInt(fruits.length);
        String randomFruit = fruits[randomIndex];
        System.out.println(randomFruit);

        // VD: Lấy ra một ngày ngẫu nhiên trong khoảng
        // |------------ 1000 ---------------- 2000 -------------> Date
        // |------------ 3000 ---------------- 6000 -------------> Day
        // Random day: 4500 -> Random date: 1500
        LocalDate minDate = LocalDate.of(2019, 4, 30);
        LocalDate maxDate = LocalDate.of(2023, 9, 2);
        int minDay = (int) minDate.toEpochDay();
        int maxDay = (int) maxDate.toEpochDay();
        int randomDay = minDay + random.nextInt(maxDay - minDay + 1);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        System.out.println("randomDate = " + randomDate);
    }
}
