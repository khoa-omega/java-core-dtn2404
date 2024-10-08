public class Exercise01 {
    void question05() {
        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();
        Group group = new Group();
        group.accounts = new Account[]{account1, account2, account3};

        switch (group.accounts.length) {
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
                break;
        }
    }
}
