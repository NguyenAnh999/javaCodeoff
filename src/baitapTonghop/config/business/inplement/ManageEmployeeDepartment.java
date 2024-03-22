package baitapTonghop.config.business.inplement;

import baitap3.business.config.InputMethods;
import baitapTonghop.config.business.design.CRUD;
import baitapTonghop.config.business.entity.Department;
import baitapTonghop.config.business.entity.Employee;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManageEmployeeDepartment implements CRUD {
    public static List<Department> departmentList = new ArrayList<>();
    public static List<Employee> employeeList = new ArrayList<>();
static {

    departmentList.add(new Department("D001","giám đốc",0));
    departmentList.add(new Department("D002","phó giám đốc",0));
    departmentList.add(new Department("D003","kinh doanh",0));
    departmentList.add(new Department("D005","sales",0));
    departmentList.add(new Department("D006","vệ sinh",0));
    departmentList.add(new Department("D007","bảo vệ",0));
    departmentList.add(new Department("D008","tạp vụ",0));
    departmentList.add(new Department("D009","quản lý",0));
    departmentList.add(new Department("D0010","dào tạo",0));


    employeeList.add(new Employee("E0001","nuyễn văn a",LocalDate.of(2000,5,5),true,120.0,null,departmentList.get(0)));
    employeeList.add(new Employee("E0002","nuyễn văn b",LocalDate.of(2001,5,5),true,110.0,null,departmentList.get(7)));
    employeeList.add(new Employee("E0003","nuyễn văn c",LocalDate.of(2002,5,5),true,130.0,employeeList.get(0),departmentList.get(8)));
    employeeList.add(new Employee("E0004","nuyễn văn d",LocalDate.of(2003,5,5),true,140.0,null,departmentList.get(3)));
    employeeList.add(new Employee("E0005","nuyễn văn e",LocalDate.of(2004,5,5),true,150.0,null,departmentList.get(4)));
    employeeList.add(new Employee("E0006","nuyễn văn f",LocalDate.of(2005,5,5),true,160.0,null,departmentList.get(2)));
    employeeList.add(new Employee("E0007","nuyễn văn g",LocalDate.of(2006,5,5),true,170.0,null,departmentList.get(1)));
    employeeList.add(new Employee("E0008","nuyễn văn h",LocalDate.of(2007,5,5),true,180.0,employeeList.get(0),departmentList.get(6)));
    employeeList.add(new Employee("E0009","nuyễn văn i",LocalDate.of(2008,5,5),true,190.0,employeeList.get(0),departmentList.get(6)));
    employeeList.add(new Employee("E0010","nuyễn văn k",LocalDate.of(2009,5,5),true,220.0,null,departmentList.get(4)));
    employeeList.add(new Employee("E0011","nuyễn văn l",LocalDate.of(20010,5,5),true,320.0,employeeList.get(0),departmentList.get(6)));

}
    public static int getLength(String ID) {
        int sum = 0;
        for (Employee employee : employeeList) {
            if (employee.getDepartment().getDepartmentId().equals(ID)) {
                sum++;
            }
        }
        return sum;
    }

    @Override
    public void add(int choice) {
        switch (choice) {
            case 1:
                System.out.println("MỜI BẠN NHẬP SỐ PHÒNG BAN MUỐN TẠO");
                int quantity = InputMethods.getInteger();
                for (int i = 0; i < quantity; i++) {
                    Department newDepartment = new Department();
                    newDepartment.inputData();
                    departmentList.add(newDepartment);
                }
                break;
            case 2:
                System.out.println("MỜI BẠN NHẬP SỐ NHÂN VIÊN MUỐN TẠO");
                int quantity1 = InputMethods.getInteger();
                for (int i = 0; i < quantity1; i++) {
                    Employee newEmployee = new Employee();
                    newEmployee.inputDAta();
                    employeeList.add(newEmployee);
                }
                ManageEmployeeDepartment.updateTotalDepartment();
                break;
        }
    }

    @Override
    public void delete(int choice) {

        switch (choice) {
            case 1:
                System.out.println("mời bạn chọn phòng ban muốn xóa theo số thứ tự");
                for (int i = 0; i < departmentList.size(); i++) {
                    System.out.println("phòng ban thứ: " + (i + 1));
                    System.out.println(departmentList.get(i).toString());
                }
                System.out.println("mời bạn chọn phòng ban muốn xóa");
                int choice1 = InputMethods.getInteger();
                boolean check = false;
                if (employeeList.stream().anyMatch(employee -> employee.getDepartment().getDepartmentId().equals(departmentList.get(choice1).getDepartmentId()))) {
                    check = true;
                }
                if (check) {
                    System.out.println("phòng ban của bạn đang có nhân viên bạn không thể xóa");
                } else {
                    departmentList.remove(departmentList.get(choice1));
                    System.out.println("xóa thành công");
                }
                break;
            case 2:
                System.out.println("mời bạn chọn nhân viên muốn xóa theo số thứ tự");
                for (int i = 0; i < employeeList.size(); i++) {
                    System.out.println("nhân viên thứ: " + (i + 1));
                    System.out.println(employeeList.get(i).toString());
                }
                System.out.println("mời bạn chọn nhân viên muốn xóa");
                int choice2 = InputMethods.getInteger();
                for (Employee employee : employeeList) {
                    if (employee.getManager().getEmployeeId().equals(employeeList.get(choice2).getManager().getEmployeeId())) {
                        employee.setManager(null);
                    }
                }
                employeeList.remove(employeeList.get(choice2));
        }
        ManageEmployeeDepartment.updateTotalDepartment();
    }

    @Override
    public void upDate(int choice) {
        switch (choice) {
            case 1:
                System.out.println("mời bạn chọn phòng ban muốn sửa theo số thứ tự");
                for (int i = 0; i < departmentList.size(); i++) {
                    System.out.println("phòng ban thứ: " + (i + 1));
                    System.out.println(departmentList.get(i).toString());
                }
                System.out.println("mời bạn chọn phòng ban muốn sửa");
                int choice1 = InputMethods.getInteger();
                System.out.println("mời bạn nhập vào tên phòng ban mới");
                departmentList.get(choice1).setDepartmentName(InputMethods.getString());
//                employeeList.stream()
//                        .filter(employee->employee.getDepartment().getDepartmentId().equals(departmentList.get(choice1).getDepartmentId())).
//                        map(employee->employee.setDepartment(departmentList.get(choice1)));
                for (Employee employee : employeeList) {
                    if (employee.getDepartment().getDepartmentId().equals(departmentList.get(choice1).getDepartmentId())) {
                        employee.setDepartment(departmentList.get(choice1));
                    }
                }
                break;
            case 2:
                System.out.println("mời bạn chọn nhân viên muốn sửa theo số thứ tự");
                for (int i = 0; i < employeeList.size(); i++) {
                    System.out.println("nhân viên thứ: " + (i + 1));
                    System.out.println(employeeList.get(i).toString());
                }
                System.out.println("mời bạn chọn nhân viên muốn sửa");
                int choice2 = InputMethods.getInteger();
                boolean flag = true;
                do {
                    System.out.println("mời bạn chon trường muốn sửa");
                    System.out.println("1: tên");
                    System.out.println("2: lương");
                    System.out.println("3: giới tính");
                    System.out.println("4: sinh nhật");
                    System.out.println("5: phòng ban");
                    System.out.println("6: Manage");
                    System.out.println("0: thoát");
                    int choiceEdit = InputMethods.getInteger();
                    switch (choiceEdit) {
                        case 1:
                            System.out.println("mời bạn nhập tên mới");
                            employeeList.get(choice2).setEmployeeName(InputMethods.getString());
                            break;
                        case 2:
                            System.out.println("mời bạn nhập lương mới");
                            employeeList.get(choice2).setSalary(InputMethods.getDouble());
                            break;
                        case 3:
                            System.out.println("mời bạn nhập vào giới tính mới true/nam false/nu");
                            employeeList.get(choice2).setSex(InputMethods.getBoolean());
                            break;
                        case 4:
                            System.out.println("mời bạn nhập vào sinh nhật dd/MM/yyyy");
                            employeeList.get(choice2).setBirthday(InputMethods.getLocalDate());
                            break;
                        case 5:
                            employeeList.get(choice2).setDepartment(ManageEmployeeDepartment.departmentSet());
                            break;
                        case 6:
                            employeeList.get(choice2).setManager(ManageEmployeeDepartment.choiceManage());
                            break;
                        case 0:
                            flag = false;
                            break;
                    }
                }
                while (flag);

        }
        ManageEmployeeDepartment.updateTotalDepartment();
    }

    @Override
    public void displayDAta(int choice) {
        ManageEmployeeDepartment.updateTotalDepartment();
        switch (choice) {
            case 1:
                departmentList.forEach(System.out::println);
                break;
            case 2:
                employeeList.forEach(System.out::println);
                break;
        }
    }

    @Override
    public void sortUp(int choice) {

    }

    @Override
    public void sortDown(int choice) {

    }

    public void searchByID() {
        displayDAta(2);
        System.out.println("mời bạn nhập vào id");
        String id = InputMethods.getString();
        employeeList.stream().filter(employee -> employee.getEmployeeId().equals(id)).forEach(System.out::println);
    }

    @Override
    public void searchByName(int choice) {

    }

    public static Department departmentSet() {
        ManageEmployeeDepartment cal = new ManageEmployeeDepartment();
        if (departmentList.isEmpty()) {
            System.out.println("bạn chưa có phòng ban nào cả");
            System.out.println("mời bạn tạo phòng ban");
            cal.add(1);
            System.out.println("tạo thành công");
        }
        System.out.println("mời bạn chọn phòng ban theo số thứ tự");
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.println("phòng ban thứ:" + (i + 1));
            System.out.println(departmentList.get(i).toString());
        }
        int choice = InputMethods.getInteger();
        return departmentList.get(choice - 1);
    }

    public static Employee choiceManage() {
        if (employeeList.isEmpty()) {
            System.out.println("bạn chưa có nhân viên nào để trở thành quản lý");
            System.out.println("bạn có muốn tạo nhân viên để quản lý ?");
            System.out.println("1: có");
            System.out.println("2:không");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    ManageEmployeeDepartment cal = new ManageEmployeeDepartment();
                    cal.add(2);
                    System.out.println("tạo thành công");
                    break;
                case 2:
                    return null;
                default:
                    System.out.println("lệnh bạn chọn không đúng");
                    System.out.println("quản lý sẽ được đặt mặc định là null");
                    System.out.println("bạn có thể sửa lại trong menu sau");
                    return null;
            }

        }
        System.out.println("nhân viên này có cần người quản lí không");
        System.out.println("1:có");
        System.out.println("2:không");
        System.out.println("mời bạn chọn");
        int choice = InputMethods.getInteger();
        if (choice == 1) {
            for (int i = 0; i < employeeList.size(); i++) {
                System.out.println("nhân viên thứ: " + i);
                System.out.println(employeeList.get(i).toString());
            }
            int choice1 = InputMethods.getInteger();
            return employeeList.get(choice1);
        } else {
            return null;
        }
    }

    public static void updateTotalDepartment() {
        for (Department department : departmentList) {
            int sum = 0;
            for (Employee employee : employeeList) {
                if (department.getDepartmentId().equals(employee.getDepartment().getDepartmentId())) {
                    sum++;
                }
            }
            department.setTotalMembers(sum);
        }
    }

    public void display() {
        for (Department department : departmentList) {
            System.out.println(department.getDepartmentName());
            for (Employee employee : employeeList) {
                if (department.getDepartmentId().equals(employee.getDepartment().getDepartmentId())) {
                    System.out.println(employee.getEmployeeName());
                }
            }
        }
    }

    public int statistics() {
        ManageEmployeeDepartment.updateTotalDepartment();

        int averenge = 0;
        for (Department department : departmentList) {
            averenge += department.getTotalMembers();
        }
        int tb = averenge / departmentList.size();
        return tb;
    }

    public void top5D() {
        List<Department> sort = departmentList.stream().sorted((o1, o2) -> o1.getTotalMembers() - o2.getTotalMembers()).toList();
        for (int i = sort.size()-5; i < sort.size(); i++) {
            System.out.println(sort.get(i));
        }
    }

    public void topManage() {
        Map<String, Integer> manager = new HashMap<>();
        int sum ;
        for (Employee employeeManager : employeeList) {
            sum=0;

                for (Employee employee : employeeList) {
                    if (employee.getManager()!=null) {
                        if (employeeManager.getEmployeeId().equals(employee.getManager().getEmployeeId())) {
                            sum++;
                        }
                    }
                }
                manager.put(employeeManager.getEmployeeName(),sum);

        }
        int maxValue =  0;
        String maxKey = "";
        for (Map.Entry<String, Integer> entry : manager.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        // In ra phần tử có giá trị lớn nhất
        System.out.println("quản lý: " + maxKey + " có " + maxValue+"nhân viên là quản lý có nhiều nhân viên nhất" );


    }
    public void maxSalary(){
        List<Employee> sort = employeeList.stream().sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())).toList();
        for (int i = sort.size()-5; i < sort.size(); i++) {
            System.out.println(sort.get(i));
        }
    }
    public static long ageSet(LocalDate bod){
        LocalDate now = LocalDate.now();


        return ChronoUnit.YEARS.between(bod,now);
    }
    public void maxAge (){

       List<Employee> sort = employeeList.stream().sorted((o1,o2)-> (int) (o1.getAge()-o2.getAge())).toList();
        for (int i = sort.size()-5; i < sort.size(); i++) {
            System.out.println(sort.get(i));
        }
    }
}
