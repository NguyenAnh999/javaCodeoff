package baitapTonghop.config.business.entity;

import baitap3.business.config.InputMethods;
import baitapTonghop.config.business.inplement.ManageEmployeeDepartment;

public class Department {
    private String departmentId;
    private String departmentName;
    private int totalMembers;

    public Department() {

    }

    public Department(String departmentId, String departmentName, int totalMembers) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = totalMembers;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", totalMembers='" + totalMembers + '\'' +
                '}';
    }
    public void inputData (){
        System.out.println("mời bạn nhập id");
        departmentId= InputMethods.getString();
        System.out.println("mời bạn nhập tên");
        departmentName= InputMethods.getString();
        totalMembers=  ManageEmployeeDepartment.getLength(departmentId);

    }
}
