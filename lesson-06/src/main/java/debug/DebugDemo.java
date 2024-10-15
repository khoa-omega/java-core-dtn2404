package debug;

public class DebugDemo {
    public static void main(String[] args) {
        // Break point: Điểm dừng
        // Step Into (F7): Chạy từng dòng code (chạy vào trong hàm)
        // Step Over (F8): Chạy từng dòng code (chạy qua hàm)
        // Step Out (Shift + F8): Thoát ra khỏi hàm
        System.out.println("main: Dòng 1");
        System.out.println("main: Dòng 2");
        System.out.println("main: Dòng 3");
        steps();

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void steps() {
        System.out.println("steps: Dòng 1");
        System.out.println("steps: Dòng 2");
        System.out.println("steps: Dòng 3");
    }
}
