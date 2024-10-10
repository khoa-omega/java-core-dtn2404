package encapsulation;

public class EncapsulationDemo {
    public static void main(String[] args) {
        // Tính đóng gói
        // Che giấu, bảo vệ dữ liệu
        // 1. Áp dụng private cho thuộc tính
        // 2. Thêm getter / setter cho thuộc tính
        Atm atm = new Atm(0);
        atm.setBalance(-10000000);
        System.out.println("atm = " + atm);
    }
}
