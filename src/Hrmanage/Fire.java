package Hrmanage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Fire extends JFrame {
    private JTable employeeTable;
    private static DefaultTableModel tableModel;
    private JButton backButton;

    public Fire() {
        setTitle("Fire Employee");
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
        tableModel.addColumn("Action"); // ปุ่ม Fire

        employeeTable = new JTable(tableModel);
        employeeTable.getColumn("Action").setCellRenderer(new ButtonRenderer());
        employeeTable.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox(), employeeTable));

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        panel.add(scrollPane, BorderLayout.CENTER);

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
        loadEmployeeData(); // โหลดข้อมูลพนักงานตอนเปิดหน้าต่าง
    }

    // ✅ โหลดข้อมูลจาก Database และแสดงบน JTable
    public static void loadEmployeeData() {
        tableModel.setRowCount(0); // ล้างข้อมูลก่อนโหลดใหม่

        ArrayList<Employees> employeeList = DB.getEmployeeDatabase();
        for (Employees emp : employeeList) {
            Object[] rowData = {
                    emp.getName(),
                    emp.getSurname(),
                    emp.getRole(),
                    emp.getSalary(),
                    "Fire"
            };
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Fire().setVisible(true));
    }
}
