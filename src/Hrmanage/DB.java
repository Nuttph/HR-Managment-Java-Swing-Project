package Hrmanage;

import java.util.ArrayList;

public class DB {
    private static ArrayList<Employees> employeeDatabase = new ArrayList<>();

    public static void addEmployee(Employees emp) {
        employeeDatabase.add(emp);
        System.out.println("Added to DB: " + emp.getName() + " " + emp.getSurname());
    }

    public static ArrayList<Employees> getEmployeeDatabase() {
        return new ArrayList<>(employeeDatabase);
    }
}
