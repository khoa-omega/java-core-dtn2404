public class OutputDemo {
    public static void main(String[] args) {
        // Escape characters
        // \' single quote
        // \" double quote
        // \\ backslash
        // \n new line
        // \t tab

        System.out.println(1);
        System.out.println("\"Hai\"");
        System.err.println("Ba");

        System.err.print("Bốn\n");
        System.err.print("Năm\n");

        // Ký tự đại diện
        // %d: Số nguyên
        // %f: Số thực
        // %s: String
        // %c: char
        // %n: Xuống dòng
        String fullName = "Nguyễn Văn Khoa";
        int age = 19;
        String address = "Hà Nội";
        System.err.printf(
                "Tôi tên là: %s, tuổi: %d, địa chỉ: %s%n",
                fullName, age, address
        );
        // %5s: Căn lề phải, chiếm 5 ô trống
        System.err.printf("%5d%n", 100);
        System.err.printf("%-5d%n", 100);
        // %.2f: Làm tròn 2 chữ số
        System.err.printf("%10.2f%n", 123.789);
        // %,d: Gom 3 số
        System.err.printf("%,d%n", 123456789);

        // VD: Tạo bảng
        int[] ids = {1,2,3};
        String[] usernames = {"khoa.nv", "long.vuduc", "duy.nm"};
        System.err.println("+------+--------------------+");
        System.err.println("|  ID  |      USERNAME      |");
        System.err.println("+------+--------------------+");
        for (int i = 0; i < 3; i++) {
            System.err.printf("| %4d | %-18s |%n", ids[i], usernames[i]);
            System.err.println("+------+--------------------+");
        }
    }
}
