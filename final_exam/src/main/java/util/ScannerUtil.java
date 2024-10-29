package util;

import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputInt() {
        while (true) {
            try {
                String input = inputString();
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.err.println("Yêu cầu nhập vào số nguyên");
            }
        }
    }

    private static String inputString() {
        return SCANNER.nextLine()
                .trim()
                .replaceAll("\\s{2,}", " ");
    }
}
