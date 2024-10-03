import java.time.LocalDate;

public class DataTypeDemo {
    public static void main(String[] args) {
        // Cú pháp khởi tạo biến
        // <Kiểu dữ liệu> <Tên biến> = [Giá trị khởi tạo];

        // Kiểu số nguyên: byte, short, int, long
        // Giá trị mặc định: 0
        int age = 18;
        System.out.println("age = " + age);

        // Kiểu số thực: float, double
        // Giá trị mặc định: 0.0
        float score = 9.5f;
        System.out.println("score = " + score);

        // Kiểu boolean
        // Giá trị mặc định: false
        boolean isLoading = true;
        System.out.println("isLoading = " + isLoading);

        // Kiểu kí tự: char (2 bytes)
        // Bọc kí tự trong dấu nháy đơn
        // Giá trị mặc định: \u0000
        char c = 'K';
        System.out.println("c = " + c);

        // Kiểu chuỗi kí tự: String
        // Bọc chuỗi kí tự trong dấu nháy kép
        // Giá trị mặc định: null
        String email = "khoa.nv@gmail.com";
        System.out.println("email = " + email);

        // Kiểu thời gian: LocalDate, LocalTime, LocalDateTime
        // Giá trị mặc định: null
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);

        // Kiểu enum
        // Giá trị mặc định: null
        Gender gender = Gender.FEMALE;
        System.out.println("gender = " + gender);

        // Kiểu mảng: array
        // Giá trị mặc định: null
        int[] numbers = {1, 3, 5, 7, 9};
        String[] fruits = new String[]{"Táo", "Cam", "Đào", "Nho"};
        // Chỉ số của mảng bắt đầu từ 0
        System.out.println("fruits.length = " + fruits.length);
        System.out.println("numbers[0] = " + numbers[0]);
        System.out.println("numbers[numbers.length - 1] = " + numbers[numbers.length - 1]);
    }
}
