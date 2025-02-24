package Hrmanage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;

public class Employee extends JFrame {
    private JTable employeeTable;
    private static DefaultTableModel tableModel;
    private JTextField searchField;
    private JButton searchButton, backButton;
    private String B2E = "Employee";

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
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // ทำให้คอลัมน์ปุ่มเป็นแบบแก้ไขได้
            }
        };
        tableModel.addColumn("Name");
        tableModel.addColumn("Surname");
        tableModel.addColumn("Role");
        tableModel.addColumn("Salary");
        tableModel.addColumn("Action"); // เพิ่มคอลัมน์ปุ่ม

        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // ตั้งค่า Renderer และ Editor สำหรับปุ่ม
        TableColumnModel columnModel = employeeTable.getColumnModel();
        columnModel.getColumn(4).setCellRenderer(new ButtonRenderer());
        columnModel.getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox(), employeeTable,B2E)); // View detail

        // Search Panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> loadEmployeeData(searchField.getText().trim()));

        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        panel.add(searchPanel, BorderLayout.NORTH);

        // Back Button
        backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            new Menu().setVisible(true);
            setVisible(false);
        });
        panel.add(backButton, BorderLayout.SOUTH);

        add(panel);
        loadEmployeeData(""); // โหลดข้อมูลตอนเปิดหน้าต่าง
    }

    // โหลดข้อมูลพนักงานจาก DB
    public static void loadEmployeeData(String keyword) {
        tableModel.setRowCount(0); // เคลียร์ข้อมูลก่อนโหลดใหม่
        ArrayList<Employees> employeeList = DB.getEmployeeDatabase();

        for (Employees emp : employeeList) {
            String name = emp.getName();
            String surname = emp.getSurname();
            String role = emp.getRole();
            String salary = emp.getSalary();

            if (keyword.isEmpty() || name.contains(keyword) || role.contains(keyword)) {
                tableModel.addRow(new Object[]{name, surname, role, salary, "View Details"});
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Employee().setVisible(true));
    }
}
