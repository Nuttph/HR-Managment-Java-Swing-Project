package Hrmanage;

import java.util.ArrayList;

public class Employees {
    protected String name, surname, role, salary, phone, email;
    protected String address, district, amphur, province, postcode, housing;

    // ✅ Static List สำหรับเก็บข้อมูล
    private static ArrayList<Employees> applicantList = new ArrayList<>();
    private static ArrayList<Employees> employeeList = new ArrayList<>();

    // ✅ Constructor หลัก
    public Employees(String name, String surname, String role, String salary, String phone, String email,
                     String address, String district, String amphur, String province, String postcode, String housing) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.district = district;
        this.amphur = amphur;
        this.province = province;
        this.postcode = postcode;
        this.housing = housing;
    }

    // ✅ Constructor แบบสั้น (ถ้าไม่มีที่อยู่)
    public Employees(String name, String surname, String role, String salary, String phone, String email) {
        this(name, surname, role, salary, phone, email, "", "", "", "", "", "");
    }

    // ✅ Getter Methods
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getRole() { return role; }
    public String getSalary() { return salary; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getDistrict() { return district; }
    public String getAmphur() { return amphur; }
    public String getProvince() { return province; }
    public String getPostcode() { return postcode; }
    public String getHousing() { return housing; }

    // ✅ Setter Methods
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setRole(String role) { this.role = role; }
    public void setSalary(String salary) { this.salary = salary; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress(String address) { this.address = address; }
    public void setDistrict(String district) { this.district = district; }
    public void setAmphur(String amphur) { this.amphur = amphur; }
    public void setProvince(String province) { this.province = province; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    public void setHousing(String housing) { this.housing = housing; }

    // ✅ เพิ่มข้อมูลผู้สมัคร
    public static void addApplicant(Employees emp) {
        applicantList.add(emp);
    }

    // ✅ ลบข้อมูลผู้สมัคร
    public static void removeApplicant(String name, String surname) {
        applicantList.removeIf(emp -> emp.getName().equals(name) && emp.getSurname().equals(surname));
    }

    // ✅ รับพนักงานเข้าทำงาน (ย้ายจาก applicantList → employeeList)
    public static void moveToEmployeeList(String name, String surname) {
        for (Employees emp : applicantList) {
            if (emp.getName().equals(name) && emp.getSurname().equals(surname)) {
                employeeList.add(emp);
                applicantList.remove(emp);
                break;
            }
        }
    }

    // ✅ ดึงรายชื่อผู้สมัครทั้งหมด
    public static ArrayList<Employees> getApplicantList() {
        return new ArrayList<>(applicantList);
    }

    // ✅ ดึงรายชื่อพนักงานทั้งหมด
    public static ArrayList<Employees> getEmployeeList() {
        return new ArrayList<>(employeeList);
    }

    // ✅ แสดงข้อมูลทั้งหมด
    public String getDetails() {
        return "Name: " + name + " " + surname + "\nRole: " + role + "\nSalary: " + salary +
                "\nPhone: " + phone + "\nEmail: " + email + "\nAddress: " + address +
                "\nDistrict: " + district + "\nAmphur: " + amphur + "\nProvince: " + province +
                "\nPostcode: " + postcode + "\nHousing: " + housing;
    }
}
