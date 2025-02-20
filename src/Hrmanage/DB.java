package Hrmanage;

import java.util.ArrayList;

public class DB {
    private static ArrayList<Employees> employeeDatabase = new ArrayList<>();

    // เพิ่มพนักงาน
    public static void addEmployee(Employees emp) {
        employeeDatabase.add(emp);
//        System.out.println("Employee added to DB: " + emp.getName() + " " + emp.getSurname());
    }

    // ดึงข้อมูลพนักงานทั้งหมด
    public static ArrayList<Employees> getEmployeeDatabase() {
        return new ArrayList<>(employeeDatabase);
    }

    // ลบพนักงานออกจากฐานข้อมูล
    public static boolean removeEmployee(String name, String surname) {
        boolean isRemoved = employeeDatabase.removeIf(emp -> emp.getName().equals(name) && emp.getSurname().equals(surname));
        if (isRemoved) {
            System.out.println("Removed Employee: " + name + " " + surname);
        } else {
            System.out.println("Employee not found: " + name + " " + surname);
        }
        return isRemoved; // คืนค่า true ถ้าลบสำเร็จ, false ถ้าไม่พบพนักงาน
    }
}
