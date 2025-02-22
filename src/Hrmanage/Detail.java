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
    private int id;

    public Detail(int id,String name, String surname, String role, String salary, String phone, String email,
                  String address, String district, String amphur, String province, String postcode,
                  String housing, String source) {
        this.id = id;
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

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Role: " + role);
        System.out.println("Salary: " + salary);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("District: " + district);
        System.out.println("Amphur: " + amphur);
        System.out.println("Province: " + province);
        System.out.println("Postcode: " + postcode);
        System.out.println("Housing: " + housing);
        System.out.println("Source: " + source + "\n");


        setTitle("Employee Details");
        setSize(400, 420);
        setLocationRelativeTo(null);
        setResizable(false);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // ✅ Panel สำหรับแสดงข้อมูล (GridLayout)
        JPanel infoPanel = new JPanel(new GridLayout(0, 2, 5, 5)); // 5px padding
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // ขอบรอบๆ

        infoPanel.add(new JLabel("ID:"));
        infoPanel.add(new JLabel(String.valueOf(id)));

        infoPanel.add(new JLabel("Name:"));
        infoPanel.add(new JLabel(name));

        infoPanel.add(new JLabel("Surname:"));
        infoPanel.add(new JLabel(surname));

        infoPanel.add(new JLabel("Role:"));
        infoPanel.add(new JLabel(role));

        infoPanel.add(new JLabel("Salary:"));
        infoPanel.add(new JLabel(salary));

        infoPanel.add(new JLabel("Phone:"));
        infoPanel.add(new JLabel(phone));

        infoPanel.add(new JLabel("Email:"));
        infoPanel.add(new JLabel(email));

        infoPanel.add(new JLabel("Address:"));
        infoPanel.add(new JLabel(address));

        infoPanel.add(new JLabel("District:"));
        infoPanel.add(new JLabel(district));

        infoPanel.add(new JLabel("Amphur:"));
        infoPanel.add(new JLabel(amphur));

        infoPanel.add(new JLabel("Province:"));
        infoPanel.add(new JLabel(province));

        infoPanel.add(new JLabel("Postcode:"));
        infoPanel.add(new JLabel(postcode));

        infoPanel.add(new JLabel("Housing:"));
        infoPanel.add(new JLabel(housing));

        // ✅ Panel สำหรับปุ่ม Back (FlowLayout ชิดขวา)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            if (source.equals("Employee")) {
                new Employee().setVisible(true);
            } else if (source.equals("Applying")) {
                new Applying().setVisible(true);
            }
            dispose(); // ปิดหน้าต่าง Detail
        });
//        JButton editButton = new JButton("Edit");
//        editButton.addActionListener(e -> {
//           System.out.println("Editing Detail "+id+name+surname+role);
//        });

//        buttonPanel.add(editButton);
        buttonPanel.add(backButton);

        // ✅ เพิ่มส่วนต่างๆ ลงใน mainPanel
        mainPanel.add(infoPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
}
