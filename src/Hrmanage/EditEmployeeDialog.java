package Hrmanage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditEmployeeDialog extends JDialog {
    private JTextField nameField, surnameField, roleField, salaryField, phoneField, emailField, addressField;
    private JTextField districtField, amphurField, provinceField, postcodeField, housingField;
    private Employees employee;

    public EditEmployeeDialog(Frame parent, Employees employee) {
        super(parent, "Edit Employee", true);
        this.employee = employee;

        setSize(400, 500);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(13, 2, 10, 10));

        add(new JLabel("Name:"));
        nameField = new JTextField(employee.getName());
        add(nameField);

        add(new JLabel("Surname:"));
        surnameField = new JTextField(employee.getSurname());
        add(surnameField);

        add(new JLabel("Role:"));
        roleField = new JTextField(employee.getRole());
        add(roleField);

        add(new JLabel("Salary:"));
        salaryField = new JTextField(String.valueOf(employee.getSalary()));
        add(salaryField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField(employee.getPhone());
        add(phoneField);

        add(new JLabel("Email:"));
        emailField = new JTextField(employee.getEmail());
        add(emailField);

        add(new JLabel("Address:"));
        addressField = new JTextField(employee.getAddress());
        add(addressField);

        add(new JLabel("District:"));
        districtField = new JTextField(employee.getDistrict());
        add(districtField);

        add(new JLabel("Amphur:"));
        amphurField = new JTextField(employee.getAmphur());
        add(amphurField);

        add(new JLabel("Province:"));
        provinceField = new JTextField(employee.getProvince());
        add(provinceField);

        add(new JLabel("Postcode:"));
        postcodeField = new JTextField(employee.getPostcode());
        add(postcodeField);

        add(new JLabel("Housing:"));
        housingField = new JTextField(employee.getHousing());
        add(housingField);

        // ปุ่ม Save และ Cancel
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveEmployeeData();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(saveButton);
        add(cancelButton);

        setVisible(true);
    }

    private void saveEmployeeData() {
        // อัปเดตค่าจากฟอร์มลงอ็อบเจ็กต์ employee
        employee.setName(nameField.getText());
        employee.setSurname(surnameField.getText());
        employee.setRole(roleField.getText());
        employee.setSalary(salaryField.getText());
        employee.setPhone(phoneField.getText());
        employee.setEmail(emailField.getText());
        employee.setAddress(addressField.getText());
        employee.setDistrict(districtField.getText());
        employee.setAmphur(amphurField.getText());
        employee.setProvince(provinceField.getText());
        employee.setPostcode(postcodeField.getText());
        employee.setHousing(housingField.getText());

        // บันทึกลงฐานข้อมูล
        DB.updateEmployee(employee);

        JOptionPane.showMessageDialog(this, "Employee data updated successfully!");
        dispose(); // ปิดหน้าต่างเมื่อบันทึกเสร็จ
    }
}
