package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class QuanLyTaiLieu {
    private Scanner scanner = new Scanner(System.in);
    private List<TaiLieu> taiLieuList = new ArrayList<>();

    public void showMenu() {
        while (true) {
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm tài liệu");
            System.out.println("2. Xóa tài liệu theo mã tài liệu");
            System.out.println("3. Hiển thị danh sách tài liệu");
            System.out.println("4. Tìm kiếm tài liệu theo loại");
            System.out.println("5. Thoát chương trình");
            int menu = Integer.parseInt(scanner.nextLine());
            if (menu == 1) {
                themTaiLieu();
            } else if (menu == 2) {
                xoaTaiLieuTheoMaTaiLieu();
            } else if (menu == 3) {
                hienThiDanhSachTaiLieu();
            } else if (menu == 4) {
                timKiemTaiLieuTheoLoai();
            } else if (menu == 5) {
                return;
            }
        }
    }

    public void themTaiLieu() {
        System.out.println("Chọn loại tài liệu muốn thêm:");
        System.out.println("1. Sách");
        System.out.println("2. Tạp chí");
        System.out.println("3. Báo");
        int menu = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào mã tài liệu:");
        int maTaiLieu = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào tên nhà xuất bản:");
        String tenNhaXuatBan = scanner.nextLine();
        System.out.println("Nhập vào số bản phát hành:");
        int soBanPhatHanh = Integer.parseInt(scanner.nextLine());
        if (menu == 1) {
            System.out.println("Nhập vào tên tác giả:");
            String tenTacGia = scanner.nextLine();
            System.out.println("Nhập vào số trang:");
            int soTrang = Integer.parseInt(scanner.nextLine());
            Sach sach = new Sach(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, tenTacGia, soTrang);
            taiLieuList.add(sach);
        } else if (menu == 2) {
            System.out.println("Nhập vào số phát hành:");
            int soPhatHanh = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập vào tháng phát hành:");
            int thangPhatHanh = Integer.parseInt(scanner.nextLine());
            TapChi tapChi = new TapChi(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, soPhatHanh, thangPhatHanh);
            taiLieuList.add(tapChi);
        } else {
            System.out.println("Nhập vào ngày phát hành:");
            int ngayPhatHanh = Integer.parseInt(scanner.nextLine());
            Bao bao = new Bao(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, ngayPhatHanh);
            taiLieuList.add(bao);
        }
    }

    public void xoaTaiLieuTheoMaTaiLieu() {
        System.out.println("Nhập vào mã tài liệu cần xóa:");
        int maTaiLieu = Integer.parseInt(scanner.nextLine());
        taiLieuList.removeIf(new Predicate<TaiLieu>() {
            @Override
            public boolean test(TaiLieu taiLieu) {
                return taiLieu.getMaTaiLieu() == maTaiLieu;
            }
        });
    }

    public void hienThiDanhSachTaiLieu() {
        System.out.println("+----------+--------------------+----------+----------+----------+----------+");
        System.out.println("|   MA TL  |     TEN TAC GIA    | SO TRANG |   SO PH  | THANG PH |  NGAY PH |");
        System.out.println("+----------+--------------------+----------+----------+----------+----------+");
        for (TaiLieu taiLieu : taiLieuList) {
            if (taiLieu instanceof Sach) {
                Sach sach = (Sach) taiLieu;
                System.out.printf(
                        "| %-8s | %-18s | %-8s | %-8s | %-8s | %-8s |%n",
                        sach.getMaTaiLieu(), sach.getTenTacGia(), sach.getSoTrang(), null, null, null
                );
            } else if (taiLieu instanceof TapChi) {
                TapChi tapChi = (TapChi) taiLieu;
                System.out.printf(
                        "| %-8s | %-18s | %-8s | %-8s | %-8s | %-8s |%n",
                        tapChi.getMaTaiLieu(), null, null, tapChi.getSoPhatHanh(), tapChi.getThangPhatHanh(), null
                );
            } else {
                Bao bao = (Bao) taiLieu;
                System.out.printf(
                        "| %-8s | %-18s | %-8s | %-8s | %-8s | %-8s |%n",
                        bao.getMaTaiLieu(), null, null, null, null, bao.getNgayPhatHanh()
                );
            }
            System.out.println("+----------+--------------------+----------+----------+----------+----------+");
        }
    }

    public void timKiemTaiLieuTheoLoai() {
        System.out.println("Chọn loại cần tìm:");
        System.out.println("1. Sách");
        System.out.println("2. Tạp chí");
        System.out.println("3. Báo");
        int menu = Integer.parseInt(scanner.nextLine());
        if (menu == 1) {
            System.out.println("+----------+--------------------+----------+");
            System.out.println("|   MA TL  |     TEN TAC GIA    | SO TRANG |");
            System.out.println("+----------+--------------------+----------+");
            for (TaiLieu taiLieu : taiLieuList) {
                if (taiLieu instanceof Sach) {
                    Sach sach = (Sach) taiLieu;
                    System.out.printf(
                            "| %-8s | %-18s | %-8s |%n",
                            sach.getMaTaiLieu(), sach.getTenTacGia(), sach.getSoTrang()
                    );
                }
            }
            System.out.println("+----------+--------------------+----------+");
        } else if (menu == 2) {
            System.out.println("+----------+----------+----------+");
            System.out.println("|   MA TL  |   SO PH  | THANG PH |");
            System.out.println("+----------+----------+----------+");
            for (TaiLieu taiLieu : taiLieuList) {
                if (taiLieu instanceof TapChi) {
                    TapChi tapChi = (TapChi) taiLieu;
                    System.out.printf(
                            "| %-8s | %-8s | %-8s|%n",
                            tapChi.getMaTaiLieu(), tapChi.getSoPhatHanh(), tapChi.getThangPhatHanh()
                    );
                }
            }
            System.out.println("+----------+----------+----------+");
        } else {
            System.out.println("+----------+----------+");
            System.out.println("|   MA TL  |  NGAY PH |");
            System.out.println("+----------+----------+");
            for (TaiLieu taiLieu : taiLieuList) {
                if (taiLieu instanceof Bao) {
                    Bao bao = (Bao) taiLieu;
                    System.out.printf(
                            "| %-8s | %-8s |%n",
                            bao.getMaTaiLieu(), bao.getNgayPhatHanh()
                    );
                }
            }
            System.out.println("+----------+----------+");
        }
    }
}
