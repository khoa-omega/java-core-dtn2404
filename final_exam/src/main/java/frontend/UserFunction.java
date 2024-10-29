package frontend;

import controller.UserController;
import entity.User;
import lombok.AllArgsConstructor;
import util.ScannerUtil;

import java.util.List;

@AllArgsConstructor
public class UserFunction {
    private UserController controller;

    public void showMenu() {
        while (true) {
            System.out.println("1. Đăng nhập");
            System.out.println("2. Hiển thị danh sách user");
            System.out.println("3. Tìm kiếm user theo id");
            System.out.println("4. Thoát chương trình");
            System.out.println("Mời bạn chọn chức năng:");
            int menu = ScannerUtil.inputInt();
            if (menu == 1) {

            } else if (menu == 2) {
                findAll();
            } else if (menu == 3) {

            } else if (menu == 4) {
                return;
            } else {
                System.err.println("Yêu cầu chọn đúng năng");
            }
        }
    }

    private void findAll() {
        List<User> users = controller.findAll();
        System.out.println("+------+--------------------+--------------------+");
        System.out.printf("| %-4s | %-18s | %-18s |%n", "ID", "FULL NAME", "EMAIL");
        System.out.println("+------+--------------------+--------------------+");
        if (users.isEmpty()) {
            System.out.printf("| %-4s | %-18s | %-18s |%n", "NULL", "NULL", "NULL");
            System.out.println("+------+--------------------+--------------------+");
        } else {
            for (User user : users) {
                System.out.printf(
                        "| %-4s | %-18s | %-18s |%n",
                        user.getId(), user.getFullName(), user.getEmail()
                );
                System.out.println("+------+--------------------+--------------------+");
            }
        }
    }
}
