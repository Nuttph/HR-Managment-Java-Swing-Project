package Hrmanage;

import java.util.ArrayList;
import java.util.Iterator;

public class Employees {
    protected int idEPY;

    protected String name, surname, role, salary, phone, email;
    protected String address, district, amphur, province, postcode, housing;

    private static int idCounter = 1;
    private static ArrayList<Employees> applicantList = new ArrayList<>();

    public Employees(String name, String surname, String role, String salary, String phone, String email,
                     String address, String district, String amphur, String province, String postcode, String housing) {
        this.idEPY = idCounter++;
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

    public Employees(String name, String surname, String role, String salary, String phone, String email) {
        this(name, surname, role, salary, phone, email, "", "", "", "", "", "");
    }

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

    public static void addApplicant(Employees emp) {
        applicantList.add(emp);
    }

    public static void removeApplicant(String name, String surname) {
        applicantList.removeIf(emp -> emp.getName().equals(name) && emp.getSurname().equals(surname));
    }

    public static void moveToEmployeeList(String name, String surname) {
        Employees foundApplicant = null;
        for (Employees emp : applicantList) {
            if (emp.getName().equals(name) && emp.getSurname().equals(surname)) {
                foundApplicant = emp;
                break;
            }
        }

        if (foundApplicant != null) {
            applicantList.remove(foundApplicant);
            //nut
            DB.addEmployee(foundApplicant);  // ✅ เพิ่มเข้า Database
        }
    }

    // ✅ เมธอดใหม่สำหรับลบพนักงานออกจาก Database
    public static void removeEmployee(String name, String surname) {
        Iterator<Employees> iterator = DB.getEmployeeDatabase().iterator();
        while (iterator.hasNext()) {
            Employees emp = iterator.next();
            if (emp.getName().equals(name) && emp.getSurname().equals(surname)) {
                iterator.remove(); // ลบพนักงานออกจาก List
                System.out.println("Removed Employee: " + name + " " + surname);
                break;
            }
        }
    }

    public static ArrayList<Employees> getApplicantList() {
        return new ArrayList<>(applicantList);
    }


    public static Employees getEmployeeDetails(String name, String surname) {
        // ค้นหาใน applicantList
        for (Employees emp : applicantList) {
            if (emp.getName().equals(name) && emp.getSurname().equals(surname)) {
                return emp; // คืนค่าพนักงานที่ตรงกับชื่อและนามสกุล
            }
        }

        // ถ้าไม่พบใน applicantList ให้ค้นหาใน employeeList (ถ้ามี)
        // สมมุติว่า DB.getEmployeeDatabase() คืนค่าเป็น List<Employees>
        for (Employees emp : DB.getEmployeeDatabase()) {
            if (emp.getName().equals(name) && emp.getSurname().equals(surname)) {
                return emp; // คืนค่าพนักงานที่ตรงกับชื่อและนามสกุล
            }
        }

        return null; // คืนค่า null ถ้าไม่พบพนักงาน
    }
}
