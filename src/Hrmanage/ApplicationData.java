package Hrmanage;

public class ApplicationData {
    private static String name;
    private static String surname;
    private static String position;
    private static String salary;

    // Getter and Setter methods for the application details
    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        ApplicationData.name = name;
    }

    public static String getSurname() {
        return surname;
    }

    public static void setSurname(String surname) {
        ApplicationData.surname = surname;
    }

    public static String getPosition() {
        return position;
    }

    public static void setPosition(String position) {
        ApplicationData.position = position;
    }

    public static String getSalary() {
        return salary;
    }

    public static void setSalary(String salary) {
        ApplicationData.salary = salary;
    }

    // Method to save application details
    public static void setApplication(String name, String surname, String position, String salary) {
        ApplicationData.name = name;
        ApplicationData.surname = surname;
        ApplicationData.position = position;
        ApplicationData.salary = salary;
    }
}
