public class Exercise01 {
    void question01() {
        Department department = new Department();
        department.name = "Bảo vệ";
        Account account = new Account();
        account.department = department;

        if (account.department == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println(
                    "Phòng ban của nhân viên này là " + account.department.name
            );
        }
    }

    void question02() {

    }
}
