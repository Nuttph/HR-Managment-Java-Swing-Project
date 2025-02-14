package Hrmanage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Applying extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JButton btnBack;

    public Applying() {
        setTitle("Applying List");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        // สร้างตาราง
        String[] columnNames = {"Name", "Surname", "Role", "Salary", "Action"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        table.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // โหลดข้อมูลจาก Apply
        loadEmployeeData();

        // ปุ่ม Back
        btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            this.setVisible(false);
            new HR1().setVisible(true);
        });
        panel.add(btnBack, BorderLayout.SOUTH);

        add(panel);
    }

    private void loadEmployeeData() {
        ArrayList<Employee> employees = Apply.getEmployeeList();
        model.setRowCount(0);

        for (Employee emp : employees) {
            JButton btnView = new JButton("View");
            btnView.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null,
                            "Name: " + emp.name + "\n" +
                                    "Surname: " + emp.surname + "\n" +
                                    "Role: " + emp.role + "\n" +
                                    "Salary: " + emp.salary + "\n" +
                                    "Phone: " + emp.phone + "\n" +
                                    "Email: " + emp.email + "\n" +
                                    "Address: " + emp.address + ", " + emp.district + ", " + emp.amphur + "\n" +
                                    "Province: " + emp.province + " " + emp.postcode + "\n" +
                                    "Housing: " + emp.housing,
                            "Employee Details", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            model.addRow(new Object[]{emp.name, emp.surname, emp.role, emp.salary, btnView});
        }
    }
    public static ArrayList<Employees> getEmployeeList() {
        return employeeList;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Applying().setVisible(true));
    }
}
