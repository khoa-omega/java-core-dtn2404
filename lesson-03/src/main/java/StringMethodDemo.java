import java.util.Scanner;

public class StringMethodDemo {
    public static void main(String[] args) {
        String s = "Java Core";

        System.out.println(s.length());
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s.isEmpty());
        System.out.println(s.charAt(0));
        System.out.println(s.indexOf('a'));
        System.out.println(s.lastIndexOf('a'));
        System.out.println(s.contains("Core"));
        System.out.println(s.substring(0, 4));
        System.out.println(s.substring(5));
        String[] words = s.split(" ");
        for (String word : words) {
            System.out.println("word = " + word);
        }

        question01();
    }

    static void question01() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một xâu kí tự:");
        String s = scanner.nextLine();
        String[] words = s.split("\\s+");
        System.out.println("count = " + words.length);
    }
}
