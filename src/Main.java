import Hrmanage.DB;
import Hrmanage.Employees;
import Hrmanage.HR1;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Employees[] empMockData = {
                new Employees("John", "Doe", "Manager", "50000", "0912345678", "john.doe@example.com",
                        "123 Main St", "Downtown", "Manhattan", "New York", "10001", "Own"),
                new Employees("Jane", "Smith", "Developer", "40000", "0923456789", "jane.smith@example.com",
                        "456 Elm St", "Westminster", "London", "England", "SW1A 1AA", "Rented"),
                new Employees("Michael", "Johnson", "Designer", "38000", "0934567890", "michael.j@example.com",
                        "789 Pine St", "Shibuya", "Tokyo", "Kanto", "150-0001", "Hotel"),
                new Employees("Emily", "Brown", "HR", "35000", "0945678901", "emily.b@example.com",
                        "159 Oak St", "Chatuchak", "Bangkok", "Bangkok", "10900", "Parent"),
                new Employees("David", "Wilson", "Accountant", "42000", "0956789012", "david.w@example.com",
                        "753 Maple St", "Huai Khwang", "Bangkok", "Bangkok", "10310", "Own"),
                new Employees("Sophia", "Martinez", "Sales", "36000", "0967890123", "sophia.m@example.com",
                        "951 Cedar St", "Pathumwan", "Bangkok", "Bangkok", "10330", "Rented"),
                new Employees("James", "Anderson", "Marketing", "41000", "0978901234", "james.a@example.com",
                        "246 Birch St", "Suan Luang", "Bangkok", "Bangkok", "10250", "Hotel"),
                new Employees("Olivia", "Thomas", "Customer Support", "34000", "0989012345", "olivia.t@example.com",
                        "357 Willow St", "Bang Khen", "Bangkok", "Bangkok", "10220", "Parent"),
                new Employees("William", "White", "IT Support", "37000", "0990123456", "william.w@example.com",
                        "654 Spruce St", "Thonburi", "Bangkok", "Bangkok", "10600", "Own"),
                new Employees("Isabella", "Harris", "Receptionist", "32000", "0901234567", "isabella.h@example.com",
                        "852 Redwood St", "Bang Rak", "Bangkok", "Bangkok", "10500", "Rented"),
                new Employees("Alexander", "Garcia", "Network Engineer", "46000", "0912345679", "alex.g@example.com",
                        "369 Aspen St", "Watthana", "Bangkok", "Bangkok", "10120", "Hotel"),
                new Employees("Charlotte", "Miller", "UI/UX Designer", "39000", "0923456788", "charlotte.m@example.com",
                        "789 Palm St", "Ratchathewi", "Bangkok", "Bangkok", "10400", "Parent")
        };

        Employees[] applying = {
                new Employees("Alice", "Walker", "Manager", "55000", "0911223344", "alice.w@example.com",
                        "321 Birch St", "Sukhumvit", "Bangkok", "Bangkok", "10120", "Own"),
                new Employees("Robert", "Anderson", "Developer", "42000", "0922334455", "robert.a@example.com",
                        "654 Cedar St", "Silom", "Bangkok", "Bangkok", "10150", "Rented"),
                new Employees("Sophia", "Martinez", "Designer", "39000", "0933445566", "sophia.m@example.com",
                        "987 Willow St", "Phaya Thai", "Bangkok", "Bangkok", "10240", "Hotel"),
                new Employees("Daniel", "Lee", "HR", "36000", "0944556677", "daniel.l@example.com",
                        "258 Cherry St", "Bang Rak", "Bangkok", "Bangkok", "10910", "Parent"),
                new Employees("Olivia", "Clark", "Accountant", "43000", "0955667788", "olivia.c@example.com",
                        "852 Spruce St", "Din Daeng", "Bangkok", "Bangkok", "10320", "Own"),
                new Employees("Ethan", "Martinez", "Security Analyst", "47000", "0966787855", "ethan.m@example.com",
                        "753 Mango St", "Prawet", "Bangkok", "Bangkok", "10260", "Rented")
        };

        for (Employees emp : empMockData) {
            DB.addEmployee(emp);
        }
        for (Employees emp : applying) {
            Employees.addApplicant(emp);
        }

        SwingUtilities.invokeLater(() -> new HR1().setVisible(true));
    }
}
