package Hrmanage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Employee extends JFrame {
    private JTable employeeTable;
    private static DefaultTableModel tableModel;
    private JTextField searchField;
    private JButton searchButton, backButton;

    public Employee() {
        setTitle("Employee List");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        // Table Model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Surname");
        tableModel.addColumn("Role");
        tableModel.addColumn("Salary");

        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Search Panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = searchField.getText().trim();
                loadEmployeeData(keyword);
            }
        });

        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        panel.add(searchPanel, BorderLayout.NORTH);

        // Back Button
        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu().setVisible(true);
                setVisible(false);
            }
        });
        panel.add(backButton, BorderLayout.SOUTH);

        add(panel);
        loadEmployeeData(""); // โหลดข้อมูลทั้งหมดตอนเปิดหน้าต่าง
    }

    // ✅ โหลดข้อมูลจาก Database และแสดงบน JTable
    public static void loadEmployeeData(String keyword) {
        tableModel.setRowCount(0); // ล้างข้อมูลก่อนโหลดใหม่

        ArrayList<Employees> employeeList = DB.getEmployeeDatabase();
        for (Employees emp : employeeList) {
            String name = emp.getName();
            String surname = emp.getSurname();
            String role = emp.getRole();
            String salary = emp.getSalary();

            if (keyword.isEmpty() || name.contains(keyword) || role.contains(keyword)) {
                tableModel.addRow(new Object[]{name, surname, role, salary});
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Employee().setVisible(true));
    }
}
