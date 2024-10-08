import java.util.Scanner;

public class Exercise05 {
    void question05() {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        System.out.println("Nhập vào id:");
        account.id = scanner.nextInt();

        System.out.println("Nhập vào email:");
        account.email = scanner.nextLine();

        Position position = new Position();
        System.out.println("Nhập vào position name:");
        System.out.println("1. Dev");
        System.out.println("2. Test");
        System.out.println("3. Scrum Master");
        System.out.println("4. PM");
        int menu = scanner.nextInt();
        if (menu == 1) {
            position.name = PositionName.DEV;
        } else if (menu == 2) {
            position.name = PositionName.TEST;
        } else if (menu == 3) {
            position.name = PositionName.SCRUM_MASTER;
        } else if (menu == 4) {
            position.name = PositionName.PM;
        }
        account.position = position;
    }
}
