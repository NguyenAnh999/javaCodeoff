package baitapTonghop.config.business.entity;

import baitap3.business.config.InputMethods;
import baitapTonghop.config.business.inplement.ManageEmployeeDepartment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private long age;
private String employeeId;
private String employeeName;
private LocalDate birthday ;
private  boolean sex;
private  Double salary;
private Employee manager;
private Department department;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, LocalDate birthday, boolean sex, Double salary, Employee manager, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
        this.manager = manager;
        this.department = department;
        this.age=0;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String bodString = birthday.format(formatter);
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", birthday=" + bodString +
                ", sex=" + (sex?"nam":"nu")+
                ", salary=" + salary +
                ", manager=" + (manager == null?"khong co": manager.getEmployeeName()) +
                ", department=" + department.getDepartmentName() +
                '}';
    }
    public void inputDAta(){
        System.out.println("mời bạn nhập vào mã sinh viên");
        employeeId= InputMethods.getString();
        System.out.println("mời bạn nhập vào tên nhân viên");
        employeeName=InputMethods.getString();
        System.out.println("mòi bạn nhập vào ngày sinh");
        birthday=InputMethods.getLocalDate();
        System.out.println("mời bạn nhập giới tính");
        sex=InputMethods.getBoolean();
        System.out.println("mời bạn nhập vào lương");
        salary=InputMethods.getDouble();
        department= ManageEmployeeDepartment.departmentSet();
        manager= ManageEmployeeDepartment.choiceManage();
        age=ManageEmployeeDepartment.ageSet(birthday);
    }
}
