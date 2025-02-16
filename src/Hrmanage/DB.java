package Hrmanage;

import java.util.ArrayList;

public class DB {
    private static ArrayList<Employees> employeeDatabase = new ArrayList<>();

    // Method to add employee to database
    public static void addEmployee(Employees emp) {
        employeeDatabase.add(emp);
        System.out.println("Employee added to DB: " + emp.getName() + " " + emp.getSurname());
    }

    // Method to retrieve employee list
    public static ArrayList<Employees> getEmployeeDatabase() {
        return new ArrayList<>(employeeDatabase);
    }
}
