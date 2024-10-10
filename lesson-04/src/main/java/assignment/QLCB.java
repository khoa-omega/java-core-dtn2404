package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class QLCB {
    private Scanner scanner = new Scanner(System.in);
    private List<CanBo> canBoList = new ArrayList<>();

    public void showMenu() {
        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm cán bộ");
            System.out.println("2. Tìm kiếm cán bộ theo họ tên");
            System.out.println("3. Hiển thị danh sách cán bộ");
            System.out.println("4. Xóa cán bộ theo tên");
            System.out.println("5. Thoát chương trình");
            int menu = Integer.parseInt(scanner.nextLine());
            if (menu == 1) {
                themCanBo();
            } else if (menu == 2) {
                timKiemTheoHoTen();
            } else if (menu == 3) {
                hienThiDanhSachCanBo();
            } else if (menu == 4) {
                xoaCanBoTheoTen();
            } else if (menu == 5) {
                return;
            } else {
                System.err.println("Vui lòng chọn đúng chức năng");
            }
        }
    }

    private void themCanBo() {
        System.out.println("Thêm cán bộ");
        System.out.println("1. Công nhân");
        System.out.println("2. Kỹ sư");
        System.out.println("3. Nhân viên");
        int menu = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào họ tên:");
        String hoTen = scanner.nextLine();
        System.out.println("Nhập vào tuổi:");
        int tuoi = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào giới tính:");
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        System.out.println("3. Khác");
        int submenu = Integer.parseInt(scanner.nextLine());
        GioiTinh gioiTinh;
        if (submenu == 1) {
            gioiTinh = GioiTinh.NAM;
        } else if (submenu == 2) {
            gioiTinh = GioiTinh.NU;
        } else {
            gioiTinh = GioiTinh.KHAC;
        }
        System.out.println("Nhập vào địa chỉ:");
        String diaChi = scanner.nextLine();
        if (menu == 1) {
            System.out.println("Nhập vào bậc:");
            int bac = Integer.parseInt(scanner.nextLine());
            CongNhan congNhan = new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac);
            canBoList.add(congNhan);
        } else if (menu == 2) {
            System.out.println("Nhập ngành đào tạo:");
            String nganhDaoTao = scanner.nextLine();
            KySu kySu = new KySu(hoTen, tuoi, gioiTinh, diaChi, nganhDaoTao);
            canBoList.add(kySu);
        } else {
            System.out.println("Nhập vào công việc:");
            String congViec = scanner.nextLine();
            NhanVien nhanVien = new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec);
            canBoList.add(nhanVien);
        }
    }

    private void timKiemTheoHoTen() {
        System.out.println("Nhập vào họ tên cần tìm:");
        String hoTen = scanner.nextLine();
        for (CanBo canBo : canBoList) {
            if (canBo.hoTen.equals(hoTen)) {
                System.out.println("canBo.hoTen = " + canBo.hoTen);
            }
        }
    }

    private void hienThiDanhSachCanBo() {
        for (CanBo canBo : canBoList) {
            System.out.println("canBo.hoTen = " + canBo.hoTen);
        }
    }

    private void xoaCanBoTheoTen() {
        System.out.println("Nhập vào tên cần xóa:");
        String tenCanXoa = scanner.nextLine();
        canBoList.removeIf(new Predicate<CanBo>() {
            @Override
            public boolean test(CanBo canBo) {
                int lastWhiteSpaceIndex = canBo.hoTen.lastIndexOf(' ');
                if (lastWhiteSpaceIndex == -1) {
                    return canBo.hoTen.equals(tenCanXoa);
                }
                String tenCanBo = canBo.hoTen.substring(lastWhiteSpaceIndex + 1);
                return tenCanBo.equals(tenCanXoa);
            }
        });
    }
}
