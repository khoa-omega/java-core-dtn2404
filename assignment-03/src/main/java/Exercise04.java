import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Scanner;

public class Exercise04 {
    void question03() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên:");
        String name = scanner.nextLine();
        String result = name.substring(0, 1).toUpperCase()
                + name.substring(1);
        System.out.println("result = " + result);
    }

    void question04() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào tên:");
        String name = scanner.nextLine();
        int length = name.length();
        for (int i = 0; i < length; i++) {
            System.out.printf(
                    "Ký tự thứ %d là: %C%n",
                    i + 1, name.charAt(i)
            );
        }
    }
}
