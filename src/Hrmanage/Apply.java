package Hrmanage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Apply extends JFrame {
    private JTextField txtName, txtSurname, txtPosition, txtSalary;
    private JButton btnSubmit;

    public Apply() {
        setTitle("สมัครงาน");
        setSize(500, 400);
        setLocationRelativeTo(null); // จัดให้อยู่กึ่งกลางจอ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JLabel lblName = new JLabel("ชื่อ:");
        JLabel lblSurname = new JLabel("นามสกุล:");
        JLabel lblPosition = new JLabel("ตำแหน่ง:");
        JLabel lblSalary = new JLabel("เงินเดือน:");

        txtName = new JTextField(20);
        txtSurname = new JTextField(20);
        txtPosition = new JTextField(20);
        txtSalary = new JTextField(20);

        btnSubmit = new JButton("ส่งใบสมัคร");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblSurname);
        panel.add(txtSurname);
        panel.add(lblPosition);
        panel.add(txtPosition);
        panel.add(lblSalary);
        panel.add(txtSalary);
        panel.add(new JLabel()); // ช่องว่างสำหรับการจัดเรียง
        panel.add(btnSubmit);

        add(panel);

        // การทำงานเมื่อกดปุ่ม Submit
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveApplication();
            }
        });
    }

    private void saveApplication() {
        String name = txtName.getText();
        String surname = txtSurname.getText();
        String position = txtPosition.getText();
        String salary = txtSalary.getText();

        // Save the details to static memory or pass to the Menu class
        // You can store the details in a simple static variable or database here
        ApplicationData.setApplication(name, surname, position, salary);

        JOptionPane.showMessageDialog(this, "ใบสมัครถูกบันทึกแล้ว!");

        // หลังจากส่งใบสมัครเสร็จแล้ว ปิดหน้าต่างนี้และกลับไปที่หน้าเมนู
        this.setVisible(false);
        new Menu().setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Apply().setVisible(true));
    }
}
