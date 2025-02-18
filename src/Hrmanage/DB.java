package Hrmanage;

import java.util.ArrayList;

public class DB {
    private static ArrayList<Employees> employeeDatabase = new ArrayList<>();

    // ✅ เพิ่มพนักงานเข้า Database
    public static void addEmployee(Employees emp) {
        employeeDatabase.add(emp);
        System.out.println("Employee added to DB: " + emp.getName() + " " + emp.getSurname());
    }

    // ✅ คืนค่ารายชื่อพนักงานทั้งหมด
    public static ArrayList<Employees> getEmployeeDatabase() {
        return new ArrayList<>(employeeDatabase);
    }

    // ✅ ลบพนักงานออกจาก Database
    public static void removeEmployee(String name, String surname) {
        employeeDatabase.removeIf(emp -> emp.getName().equals(name) && emp.getSurname().equals(surname));
        System.out.println("Removed from DB: " + name + " " + surname);
    }
}
