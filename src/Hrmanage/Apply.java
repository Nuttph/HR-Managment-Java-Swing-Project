package Hrmanage;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

class Employees {
    String name, surname, role, salary, phone, email;
    String address, district, amphur, province, postcode;
    String housing;

    public Employees(String name, String surname, String role, String salary, String phone, String email,
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

    private static ArrayList<Employees> employeeList = new ArrayList<>();

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

        JLabel lblName = new JLabel("Name:");
        txtName = new JTextField();
        JLabel lblSurname = new JLabel("Surname:");
        txtSurname = new JTextField();

        lblName.setBounds(190, 120, 100, 30);
        txtName.setBounds(250, 120, 220, 30);
        lblSurname.setBounds(480, 120, 100, 30);
        txtSurname.setBounds(570, 120, 200, 30);

        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblSurname);
        panel.add(txtSurname);

        JLabel lblRole = new JLabel("Role:");
        txtRole = new JTextField();
        JLabel lblSalary = new JLabel("Salary:");
        txtSalary = new JTextField();

        lblRole.setBounds(190, 170, 100, 30);
        txtRole.setBounds(250, 170, 200, 30);
        lblSalary.setBounds(480, 170, 100, 30);
        txtSalary.setBounds(570, 170, 200, 30);

        panel.add(lblRole);
        panel.add(txtRole);
        panel.add(lblSalary);
        panel.add(txtSalary);

        JLabel lblPhone = new JLabel("Phone:");
        txtPhone = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();

        lblPhone.setBounds(190, 220, 100, 30);
        txtPhone.setBounds(250, 220, 200, 30);
        lblEmail.setBounds(480, 220, 100, 30);
        txtEmail.setBounds(570, 220, 200, 30);

        panel.add(lblPhone);
        panel.add(txtPhone);
        panel.add(lblEmail);
        panel.add(txtEmail);

        btnApply = new JButton("Apply");
        btnApply.setBounds(675, 300, 100, 40);
        btnApply.addActionListener(e -> saveData());
        panel.add(btnApply);

        btnBack = new JButton("Back");
        btnBack.setBounds(900, 680, 100, 40);
        btnBack.addActionListener(e -> {
            this.setVisible(false);
            new HR1().setVisible(true);
        });
        panel.add(btnBack);

        add(panel);
    }

    private void saveData() {
        String housing = rbParent.isSelected() ? "Parent" : rbOwn.isSelected() ? "Own" : rbRented.isSelected() ? "Rented" : "Hotel";

        Employees emp = new Employees(
                txtName.getText(), txtSurname.getText(), txtRole.getText(), txtSalary.getText(),
                txtPhone.getText(), txtEmail.getText(), "", "", "", "", "", housing
        );

        employeeList.add(emp);
        JOptionPane.showMessageDialog(this, "Application Submitted!");
    }

    public static ArrayList<Employees> getEmployeeList() {
        return employeeList;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Apply().setVisible(true));
    }
}
