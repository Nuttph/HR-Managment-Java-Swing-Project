package Hrmanage;

import javax.swing.*;
import java.awt.*;

public class Detail extends JFrame {
    private String name;
    private String surname;
    private String role;
    private String salary;
    private String phone;
    private String email;
    private String address;
    private String district;
    private String amphur;
    private String province;
    private String postcode;
    private String housing;
    private String source;

    public Detail(String name, String surname, String role, String salary, String phone, String email,
                  String address, String district, String amphur, String province, String postcode,
                  String housing, String source) {
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
        this.source = source;

        setTitle("Employee Details");
        setSize(250, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(0, 2));

        // แสดงข้อมูลพนักงาน
        panel.add(new JLabel("Name:"));
        panel.add(new JLabel(name));

        panel.add(new JLabel("Surname:"));
        panel.add(new JLabel(surname));

        panel.add(new JLabel("Role:"));
        panel.add(new JLabel(role));

        panel.add(new JLabel("Salary:"));
        panel.add(new JLabel(salary));

        panel.add(new JLabel("Phone:"));
        panel.add(new JLabel(phone));

        panel.add(new JLabel("Email:"));
        panel.add(new JLabel(email));

        panel.add(new JLabel("Address:"));
        panel.add(new JLabel(address));

        panel.add(new JLabel("District:"));
        panel.add(new JLabel(district));

        panel.add(new JLabel("Amphur:"));
        panel.add(new JLabel(amphur));

        panel.add(new JLabel("Province:"));
        panel.add(new JLabel(province));

        panel.add(new JLabel("Postcode:"));
        panel.add(new JLabel(postcode));

        panel.add(new JLabel("Housing:"));
        panel.add(new JLabel(housing));

        // ปุ่มกลับ
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            if (source.equals("Employee")) {
                new Employee().setVisible(true);
            }else if (source.equals("Applying")){
                new Applying().setVisible(true);
            }
            dispose(); // ปิดหน้าต่าง Detail
        });

        panel.add(backButton);
        add(panel);
    }
}
