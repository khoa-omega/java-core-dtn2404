package assignment;

import java.util.Scanner;

public class ScannerUtil {
    private Scanner scanner = new Scanner(System.in);

    public int inputInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.err.println("Yêu cầu nhập vào số nguyên");
            }
        }
    }

    public int inputPositiveInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                int n = Integer.parseInt(input);
                if (n > 0) {
                    return n;
                } else {
                    System.err.println("Yêu cầu nhập vào số nguyên dương");
                }
            } catch (NumberFormatException exception) {
                System.err.println("Yêu cầu nhập vào số nguyên dương");
            }
        }
    }

    public String inputEmail() {
        while (true) {
            String input = scanner.nextLine();
            if (input.contains("@")) {
                return input;
            } else {
                System.err.println("Yêu cầu email chứa ký tự @");
            }
        }
    }

    public String inputPassword() {
        while (true) {
            String input = scanner.nextLine();
            int length = input.length();
            if (length < 6 || length > 12) {
                System.err.println("Yêu cầu password có từ 6 tới 12 ký tự");
            } else if (hasAnyUpperCharacter(input)) {
                return input;
            } else {
                System.err.println("Yêu cầu password có ít nhất 1 ký tự viết hoa");
            }
        }
    }

    private boolean hasAnyUpperCharacter(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
}
