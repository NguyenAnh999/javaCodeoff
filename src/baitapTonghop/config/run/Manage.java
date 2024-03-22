package baitapTonghop.config.run;

import baitapTonghop.config.business.entity.Employee;
import baitapTonghop.config.business.inplement.ManageEmployeeDepartment;

import java.util.Scanner;

public class Manage {
    static {

    }
    public static void main(String[] args) {
        ManageEmployeeDepartment cal = new ManageEmployeeDepartment();

        boolean checkOut = true;
        do {
            System.out.println("➢ ===== QUẢN LÝ NHÂN VIÊN ===== \n" +
                    "1. Quản lý nhân viên \n" +
                    "2. Quản lý phòng ban \n" +
                    "3. Tìm kiếm \n" +
                    "0. thoát ");
            System.out.println("mời bạn chọn");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    do {
                        System.out.println("➢ ===== QUẢN LÝ NHAAN VIEEN ===== \n" +
                                "1. Thêm mới nhân viên \n" +
                                "2. HIển thị danh sách thông tin tất cả nhân viên \n" +
                                "3. Xem chi tiết thông tin nhân viên theo mã \n" +
                                "4. Chỉnh sửa thông tin nhân viên \n" +
                                "5. Xóa nhân viên  \n" +
                                "0. Quay lại ");
                        System.out.println("mời bạn chọn");
                        int y = sc.nextInt();
                        switch (y) {
                            case 1:
                                cal.add(2);
                                break;
                            case 2:
                                cal.displayDAta(2);
                                break;
                            case 3:
                                cal.searchByID();
                                break;
                            case 4:
                                cal.upDate(2);
                                break;
                            case 5:
                                cal.delete(2);
                                break;
                            case 0:
                                checkOut = false;
                                break;
                        }
                    } while (checkOut);
                    break;
                case 2:
                    do {
                        System.out.println(" ➢ ===== QUẢN LÝ PHÒNG BAN ===== \n" +
                                "1. Thêm mới phòng ban \n" +
                                "2. Hiển thị danh sách phòng ban \n" +
                                "3. Chỉnh sửa tên phòng ban \n" +
                                "4. Hiển thị danh sách nhân viên của phòng ban theo mã phòng \n" +
                                "5. Xóa phòng ban \n" +
                                "0. Quay lại ");
                        System.out.println("mời bạn chọn");
                        int z = sc.nextInt();
                        switch (z) {
                            case 1:
                                cal.add(1);
                                break;
                            case 2:
                                cal.displayDAta(1);
                                break;
                            case 3:
                                cal.upDate(1);
                                break;
                            case 4:
                                cal.display();
                                break;
                            case 5:
                                cal.delete(1);
                                break;
                            case 0:
                                checkOut = false;
                                break;
                        }
                    } while (checkOut);
                    break;
                case 3:
                    do {
                        System.out.println(" ➢ ===== TÌM KIẾM ===== \n" +
                                "1. Thống kê số lượng nhân viên trung bình của mỗi phòng  \n" +
                                "2. Tìm ra 5 phòng có số lượng nhân viên đông nhất \n" +
                                "3. Tìm ra người quản lý nhiều  nhân viên nhất \n" +
                                "4. Tìm ra 5 nhân viên có tuổi cao nhất công ty \n" +
                                "5. Tìm ra 5 nhân viên hưởng lương cao nhất \n" +
                                "0. Quay lại ");
                        System.out.println("mời bạn chọn");
                        int z = sc.nextInt();
                        switch (z) {
                            case 1:
                                System.out.println("lượng nhân viên trung bình của mỗi phòng: " + cal.statistics());
                                break;
                            case 2:
                                cal.top5D();
                                break;
                            case 3:
                                cal.topManage();
                                break;
                            case 4:
                                cal.maxAge();
                                break;
                            case 5:
                                cal.maxSalary();
                                break;
                            case 0:
                                checkOut = false;
                                break;
                        }
                    } while (checkOut);
                    break;
            }
            checkOut = true;
        } while (true);

    }
}
