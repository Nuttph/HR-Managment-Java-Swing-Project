package Hrmanage;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

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

        lblName.setBounds(190, 80, 100, 30);
        txtName.setBounds(250, 80, 200, 30);
        lblSurname.setBounds(480, 80, 100, 30);
        txtSurname.setBounds(570, 80, 200, 30);

        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblSurname);
        panel.add(txtSurname);

        JLabel lblRole = new JLabel("Role:");
        txtRole = new JTextField();
        JLabel lblSalary = new JLabel("Salary:");
        txtSalary = new JTextField();

        lblRole.setBounds(190, 130, 100, 30);
        txtRole.setBounds(250, 130, 200, 30);
        lblSalary.setBounds(480, 130, 100, 30);
        txtSalary.setBounds(570, 130, 200, 30);

        panel.add(lblRole);
        panel.add(txtRole);
        panel.add(lblSalary);
        panel.add(txtSalary);

        JLabel lblPhone = new JLabel("Phone:");
        txtPhone = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();

        lblPhone.setBounds(190, 180, 100, 30);
        txtPhone.setBounds(250, 180, 200, 30);
        lblEmail.setBounds(480, 180, 100, 30);
        txtEmail.setBounds(570, 180, 200, 30);

        panel.add(lblPhone);
        panel.add(txtPhone);
        panel.add(lblEmail);
        panel.add(txtEmail);

        JLabel lblAddress = new JLabel("Address:");
        txtAddress = new JTextField();
        JLabel lblDistrict = new JLabel("District:");
        txtDistrict = new JTextField();

        lblAddress.setBounds(190, 230, 100, 30);
        txtAddress.setBounds(250, 230, 520, 30);
        lblDistrict.setBounds(190, 280, 100, 30);
        txtDistrict.setBounds(250, 280, 200, 30);

        panel.add(lblAddress);
        panel.add(txtAddress);
        panel.add(lblDistrict);
        panel.add(txtDistrict);

        JLabel lblAmphur = new JLabel("Amphur:");
        txtAmphur = new JTextField();
        JLabel lblProvince = new JLabel("Province:");
        txtProvince = new JTextField();

        lblAmphur.setBounds(480, 280, 100, 30);
        txtAmphur.setBounds(570, 280, 200, 30);
        lblProvince.setBounds(190, 330, 100, 30);
        txtProvince.setBounds(250, 330, 200, 30);

        panel.add(lblAmphur);
        panel.add(txtAmphur);
        panel.add(lblProvince);
        panel.add(txtProvince);

        JLabel lblPostcode = new JLabel("Postcode:");
        txtPostcode = new JTextField();
        lblPostcode.setBounds(480, 330, 100, 30);
        txtPostcode.setBounds(570, 330, 200, 30);

        panel.add(lblPostcode);
        panel.add(txtPostcode);

        JLabel lblHousing = new JLabel("Housing:");
        lblHousing.setBounds(190, 380, 100, 30);
        panel.add(lblHousing);

        rbParent = new JRadioButton("Parent");
        rbOwn = new JRadioButton("Own");
        rbRented = new JRadioButton("Rented");
        rbHotel = new JRadioButton("Hotel");

        ButtonGroup housingGroup = new ButtonGroup();
        housingGroup.add(rbParent);
        housingGroup.add(rbOwn);
        housingGroup.add(rbRented);
        housingGroup.add(rbHotel);

        rbParent.setBounds(250, 380, 100, 30);
        rbOwn.setBounds(350, 380, 100, 30);
        rbRented.setBounds(450, 380, 100, 30);
        rbHotel.setBounds(550, 380, 100, 30);

        panel.add(rbParent);
        panel.add(rbOwn);
        panel.add(rbRented);
        panel.add(rbHotel);

        btnApply = new JButton("Apply");
        btnApply.setBounds(675, 450, 100, 40);
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
        // ตรวจสอบว่ามีช่องไหนว่างหรือไม่
        if (txtName.getText().trim().isEmpty() || txtSurname.getText().trim().isEmpty() ||
                txtRole.getText().trim().isEmpty() || txtSalary.getText().trim().isEmpty() ||
                txtPhone.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty() ||
                txtAddress.getText().trim().isEmpty() || txtDistrict.getText().trim().isEmpty() ||
                txtAmphur.getText().trim().isEmpty() || txtProvince.getText().trim().isEmpty() ||
                txtPostcode.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // ถ้ามีช่องว่างให้หยุดทำงาน
        }

        // ตรวจสอบว่ามีการเลือก Housing หรือไม่
        if (!rbParent.isSelected() && !rbOwn.isSelected() && !rbRented.isSelected() && !rbHotel.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a housing type.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String housing = rbParent.isSelected() ? "Parent" :
                rbOwn.isSelected() ? "Own" :
                        rbRented.isSelected() ? "Rented" : "Hotel";

        Employees emp = new Employees(
                txtName.getText(), txtSurname.getText(), txtRole.getText(), txtSalary.getText(),
                txtPhone.getText(), txtEmail.getText(), txtAddress.getText(), txtDistrict.getText(),
                txtAmphur.getText(), txtProvince.getText(), txtPostcode.getText(), housing
        );

        Employees.addApplicant(emp); // เพิ่มข้อมูลลง applicantList
        JOptionPane.showMessageDialog(this, "Application Submitted!");

        // กลับไปหน้า HR1 และปิดหน้านี้
        this.setVisible(false);
        new HR1().setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Apply().setVisible(true));
    }
}
