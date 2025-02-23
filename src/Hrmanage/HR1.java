package Hrmanage;

import java.awt.*;
import javax.swing.*;

public class HR1 extends JFrame {
    private static final String USER_ID = "a";
    private static final String PASSWORD = "a";

    private JTextField jTextField1;
    private JPasswordField jPasswordField1;
    private JButton jButtonLogin, jButtonApply;

    public HR1() {
//        Employees[] applying = {
//                new Employees("Alice", "Walker", "Manager", "55000", "0911223344", "alice.w@example.com",
//                        "321 Birch St", "Sukhumvit", "Bangkok", "Bangkok", "10120", "Yes"),
//                new Employees("Robert", "Anderson", "Developer", "42000", "0922334455", "robert.a@example.com",
//                        "654 Cedar St", "Silom", "Bangkok", "Bangkok", "10150", "No"),
//                new Employees("Sophia", "Martinez", "Designer", "39000", "0933445566", "sophia.m@example.com",
//                        "987 Willow St", "Phaya Thai", "Bangkok", "Bangkok", "10240", "Yes"),
//                new Employees("Daniel", "Lee", "HR", "36000", "0944556677", "daniel.l@example.com",
//                        "258 Cherry St", "Bang Rak", "Bangkok", "Bangkok", "10910", "No"),
//                new Employees("Olivia", "Clark", "Accountant", "43000", "0955667788", "olivia.c@example.com",
//                        "852 Spruce St", "Din Daeng", "Bangkok", "Bangkok", "10320", "Yes")
//
//        };
//
//        for (Employees emp : applying) {
//            Employees.addApplicant(emp);
//        }
//
//        Employees[] empMockData = {
//                new Employees("John", "Doe", "Manager", "50000", "0912345678", "john.doe@example.com",
//                        "123 Main St", "Downtown", "Bangkok", "Bangkok", "10100", "Yes"),
//                new Employees("Jane", "Smith", "Developer", "40000", "0923456789", "jane.smith@example.com",
//                        "456 Elm St", "Sathorn", "Bangkok", "Bangkok", "10110", "No"),
//                new Employees("Michael", "Johnson", "Designer", "38000", "0934567890", "michael.j@example.com",
//                        "789 Pine St", "Ladprao", "Bangkok", "Bangkok", "10230", "Yes"),
//                new Employees("Emily", "Brown", "HR", "35000", "0945678901", "emily.b@example.com",
//                        "159 Oak St", "Chatuchak", "Bangkok", "Bangkok", "10900", "No"),
//                new Employees("David", "Wilson", "Accountant", "42000", "0956789012", "david.w@example.com",
//                        "753 Maple St", "Huai Khwang", "Bangkok", "Bangkok", "10310", "Yes"),
//                new Employees("Sophia", "Martinez", "Sales", "36000", "0967890123", "sophia.m@example.com",
//                        "951 Cedar St", "Pathumwan", "Bangkok", "Bangkok", "10330", "No"),
//                new Employees("James", "Anderson", "Marketing", "41000", "0978901234", "james.a@example.com",
//                        "246 Birch St", "Suan Luang", "Bangkok", "Bangkok", "10250", "Yes"),
//                new Employees("Olivia", "Thomas", "Customer Support", "34000", "0989012345", "olivia.t@example.com",
//                        "357 Willow St", "Bang Khen", "Bangkok", "Bangkok", "10220", "No"),
//                new Employees("William", "White", "IT Support", "37000", "0990123456", "william.w@example.com",
//                        "654 Spruce St", "Thonburi", "Bangkok", "Bangkok", "10600", "Yes"),
//                new Employees("Isabella", "Harris", "Receptionist", "32000", "0901234567", "isabella.h@example.com",
//                        "852 Redwood St", "Bang Rak", "Bangkok", "Bangkok", "10500", "No"),
//                new Employees("Alexander", "Garcia", "Network Engineer", "46000", "0912345679", "alex.g@example.com",
//                        "369 Aspen St", "Watthana", "Bangkok", "Bangkok", "10120", "Yes"),
//                new Employees("Charlotte", "Miller", "UI/UX Designer", "39000", "0923456788", "charlotte.m@example.com",
//                        "789 Palm St", "Ratchathewi", "Bangkok", "Bangkok", "10400", "No"),
//                new Employees("Benjamin", "Davis", "Software Engineer", "48000", "0934567877", "ben.d@example.com",
//                        "147 Sycamore St", "Klong Toey", "Bangkok", "Bangkok", "10150", "Yes"),
//                new Employees("Mia", "Rodriguez", "QA Tester", "35000", "0945677866", "mia.r@example.com",
//                        "951 Pineapple St", "Din Daeng", "Bangkok", "Bangkok", "10410", "No"),
//                new Employees("Ethan", "Martinez", "Security Analyst", "47000", "0956787855", "ethan.m@example.com",
//                        "753 Mango St", "Prawet", "Bangkok", "Bangkok", "10260", "Yes"),
//                new Employees("Amelia", "Hernandez", "System Administrator", "45000", "0967897844", "amelia.h@example.com",
//                        "852 Banana St", "Lat Krabang", "Bangkok", "Bangkok", "10520", "No"),
//                new Employees("Daniel", "Lopez", "Business Analyst", "43000", "0978907833", "daniel.l@example.com",
//                        "123 Coconut St", "Nong Khaem", "Bangkok", "Bangkok", "10160", "Yes"),
//                new Employees("Harper", "Gonzalez", "Technical Writer", "37000", "0989017822", "harper.g@example.com",
//                        "654 Watermelon St", "Bang Na", "Bangkok", "Bangkok", "10270", "No"),
//                new Employees("Matthew", "Wilson", "Database Administrator", "49000", "0990127811", "matthew.w@example.com",
//                        "246 Avocado St", "Don Mueang", "Bangkok", "Bangkok", "10210", "Yes"),
//                new Employees("Ella", "Anderson", "AI Engineer", "52000", "0901237800", "ella.a@example.com",
//                        "357 Papaya St", "Sai Mai", "Bangkok", "Bangkok", "10220", "No")
//        };
//
//        for (Employees emp : empMockData) {
//            DB.addEmployee(emp);
//        }



        setTitle("HR Login");
        setSize(1024, 768);
        setLocationRelativeTo(null); // จัดให้อยู่กึ่งกลางจอ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        // ตั้งค่า Font และสีให้กับข้อความ
        JLabel jLabel1 = new JLabel("HR Management", SwingConstants.CENTER);
        jLabel1.setFont(new Font("Arial", Font.BOLD, 36));
        jLabel1.setForeground(Color.WHITE);

        JLabel jLabel2 = new JLabel("Username:");
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 24));
        jLabel2.setForeground(Color.WHITE);

        JLabel jLabel3 = new JLabel("Password:");
        jLabel3.setFont(new Font("Arial", Font.PLAIN, 24));
        jLabel3.setForeground(Color.WHITE);

        jTextField1 = new JTextField(20);
        jTextField1.setFont(new Font("Arial", Font.PLAIN, 22));

        jPasswordField1 = new JPasswordField(20);
        jPasswordField1.setFont(new Font("Arial", Font.PLAIN, 22));

        // ตั้งค่าให้ปุ่ม Login มีสีพื้นหลัง
        jButtonLogin = new JButton("Log in");
        jButtonLogin.setFont(new Font("Arial", Font.BOLD, 22));
        jButtonLogin.setBackground(Color.BLUE);
        jButtonLogin.setForeground(Color.WHITE);
        jButtonLogin.addActionListener(evt -> loginAction());

        jButtonApply = new JButton("Apply");
        jButtonApply.setFont(new Font("Arial", Font.BOLD, 16));
        jButtonApply.setBackground(Color.GREEN);
        jButtonApply.setForeground(Color.WHITE);
        jButtonApply.addActionListener(e -> openApply());

        // สร้าง JPanel สำหรับการจัดวางและตั้งค่าพื้นหลัง
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY); // ตั้งค่าพื้นหลังเป็นสีเข้ม

        // กำหนดตำแหน่งให้กับแต่ละคอมโพเนนต์
        jLabel1.setBounds(350, 100, 400, 50);
        jLabel2.setBounds(320, 250, 150, 30);
        jTextField1.setBounds(450, 250, 250, 40);
        jLabel3.setBounds(320, 320, 120, 30);
        jPasswordField1.setBounds(450, 320, 250, 40);
        jButtonLogin.setBounds(450, 400, 120, 50);
        jButtonApply.setBounds(900, 680, 90, 30);

        panel.add(jLabel1);
        panel.add(jLabel2);
        panel.add(jTextField1);
        panel.add(jLabel3);
        panel.add(jPasswordField1);
        panel.add(jButtonLogin);
        panel.add(jButtonApply);

        add(panel);
    }

    private void loginAction() {
        String inputId = jTextField1.getText();
        String inputPassword = new String(jPasswordField1.getPassword());

        if (inputId.equals(USER_ID) && inputPassword.equals(PASSWORD)) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            openMenu();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid ID or Password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openMenu() {
        this.setVisible(false);
        new Menu().setVisible(true);
    }
    private void openApply() {
        this.setVisible(false);
        new Apply().setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HR1().setVisible(true));
    }
}
