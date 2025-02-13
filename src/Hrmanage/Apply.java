package Hrmanage;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

class Employee {
    String name, surname, role, salary, phone, email;
    String address, district, amphur, province, postcode;
    String housing;

    public Employee(String name, String surname, String role, String salary, String phone, String email,
                    String address, String district, String amphur, String province, String postcode, String housing) {
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
    }
}

public class Apply extends JFrame {
    private JTextField txtName, txtSurname, txtRole, txtSalary, txtPhone, txtEmail;
    private JTextField txtAddress, txtDistrict, txtAmphur, txtProvince, txtPostcode;
    private JRadioButton rbParent, rbOwn, rbRented, rbHotel;
    private JButton btnApply, btnBack;

    private static ArrayList<Employee> employeeList = new ArrayList<>();

    public Apply() {
        setTitle("Applying");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Applying", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 36));
        lblTitle.setBounds(300, 20, 400, 50);
        panel.add(lblTitle);

        // ชื่อ-นามสกุล
        JLabel lblName = new JLabel("Name:");
        txtName = new JTextField();
        JLabel lblSurname = new JLabel("Surname:");
        txtSurname = new JTextField();

        lblName.setBounds(50, 100, 100, 30);
        txtName.setBounds(150, 100, 200, 30);
        lblSurname.setBounds(370, 100, 100, 30);
        txtSurname.setBounds(470, 100, 200, 30);

        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblSurname);
        panel.add(txtSurname);

        // ตำแหน่ง-เงินเดือน
        JLabel lblRole = new JLabel("Role:");
        txtRole = new JTextField();
        JLabel lblSalary = new JLabel("Salary:");
        txtSalary = new JTextField();

        lblRole.setBounds(50, 150, 100, 30);
        txtRole.setBounds(150, 150, 200, 30);
        lblSalary.setBounds(370, 150, 100, 30);
        txtSalary.setBounds(470, 150, 200, 30);

        panel.add(lblRole);
        panel.add(txtRole);
        panel.add(lblSalary);
        panel.add(txtSalary);

        // ที่อยู่
        JLabel lblAddress = new JLabel("Address:");
        txtAddress = new JTextField();
        JLabel lblDistrict = new JLabel("District:");
        txtDistrict = new JTextField();
        JLabel lblAmphur = new JLabel("Amphur:");
        txtAmphur = new JTextField();
        JLabel lblProvince = new JLabel("Province:");
        txtProvince = new JTextField();
        JLabel lblPostcode = new JLabel("Post Code:");
        txtPostcode = new JTextField();

        lblAddress.setBounds(50, 200, 100, 30);
        txtAddress.setBounds(150, 200, 200, 30);
        lblDistrict.setBounds(370, 200, 100, 30);
        txtDistrict.setBounds(470, 200, 200, 30);

        lblAmphur.setBounds(50, 250, 100, 30);
        txtAmphur.setBounds(150, 250, 200, 30);
        lblProvince.setBounds(370, 250, 100, 30);
        txtProvince.setBounds(470, 250, 200, 30);

        lblPostcode.setBounds(50, 300, 100, 30);
        txtPostcode.setBounds(150, 300, 200, 30);

        panel.add(lblAddress);
        panel.add(txtAddress);
        panel.add(lblDistrict);
        panel.add(txtDistrict);
        panel.add(lblAmphur);
        panel.add(txtAmphur);
        panel.add(lblProvince);
        panel.add(txtProvince);
        panel.add(lblPostcode);
        panel.add(txtPostcode);

        // โทรศัพท์ & อีเมล
        JLabel lblPhone = new JLabel("Phone:");
        txtPhone = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();

        lblPhone.setBounds(50, 350, 100, 30);
        txtPhone.setBounds(150, 350, 200, 30);
        lblEmail.setBounds(370, 350, 100, 30);
        txtEmail.setBounds(470, 350, 200, 30);

        panel.add(lblPhone);
        panel.add(txtPhone);
        panel.add(lblEmail);
        panel.add(txtEmail);

        // ประเภทที่พัก
        rbParent = new JRadioButton("Living with parent");
        rbOwn = new JRadioButton("Own home");
        rbRented = new JRadioButton("Hired house");
        rbHotel = new JRadioButton("Hired flat/Hotel");

        ButtonGroup group = new ButtonGroup();
        group.add(rbParent);
        group.add(rbOwn);
        group.add(rbRented);
        group.add(rbHotel);

        rbParent.setBounds(50, 400, 150, 30);
        rbOwn.setBounds(210, 400, 150, 30);
        rbRented.setBounds(370, 400, 150, 30);
        rbHotel.setBounds(530, 400, 150, 30);

        panel.add(rbParent);
        panel.add(rbOwn);
        panel.add(rbRented);
        panel.add(rbHotel);

        // ปุ่ม Apply
        btnApply = new JButton("Apply");
        btnApply.setBounds(470, 500, 100, 40);
        btnApply.addActionListener(e -> saveData());

        // ปุ่ม Back
        btnBack = new JButton("Back");
        btnBack.setBounds(350, 500, 100, 40);
        btnBack.addActionListener(e -> {
//            dispose(); // ปิดหน้าปัจจุบัน
            this.setVisible(false);
            new HR1().setVisible(true);
        });

        panel.add(btnBack);


        panel.add(btnApply);

        add(panel);
    }

    private void saveData() {
        String housing = rbParent.isSelected() ? "Parent" : rbOwn.isSelected() ? "Own" : rbRented.isSelected() ? "Rented" : "Hotel";

        Employee emp = new Employee(
                txtName.getText(), txtSurname.getText(), txtRole.getText(), txtSalary.getText(),
                txtPhone.getText(), txtEmail.getText(), txtAddress.getText(), txtDistrict.getText(),
                txtAmphur.getText(), txtProvince.getText(), txtPostcode.getText(), housing
        );

        employeeList.add(emp);
        JOptionPane.showMessageDialog(this, "Application Submitted!");

        // เช็คข้อมูลที่เก็บไว้
        System.out.println("Employee List Size: " + employeeList.size());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Apply().setVisible(true));
    }
}
