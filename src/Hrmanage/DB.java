package Hrmanage;

import java.util.ArrayList;

public class DB {
    private static ArrayList<Employees> employeeDatabase = new ArrayList<>();

    // เพิ่มพนักงาน
    public static void addEmployee(Employees emp) {
        employeeDatabase.add(emp);
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

    // ✅ อัปเดตข้อมูลพนักงาน
    public static boolean updateEmployee(Employees updatedEmp) {
        for (int i = 0; i < employeeDatabase.size(); i++) {
            Employees emp = employeeDatabase.get(i);
            if (emp.getId() == updatedEmp.getId()) { // ตรวจสอบจาก ID
                employeeDatabase.set(i, updatedEmp); // อัปเดตข้อมูล
                System.out.println("Updated Employee: " + updatedEmp.getName() + " " + updatedEmp.getSurname());
                return true; // คืนค่า true ถ้าอัปเดตสำเร็จ
            }
        }
        System.out.println("Employee not found: ID " + updatedEmp.getId());
        return false; // คืนค่า false ถ้าไม่พบพนักงาน
    }
}
