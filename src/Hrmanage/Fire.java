package Hrmanage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Fire extends JFrame {
    private JTable employeeTable;
    private DefaultTableModel tableModel;
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
        tableModel.addColumn("Action");

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
        loadEmployeeData();
    }

    private void loadEmployeeData() {
        tableModel.setRowCount(0); // Clear existing data
        ArrayList<Employees> employeeList = DB.getEmployeeDatabase();

        for (Employees emp : employeeList) {
            tableModel.addRow(new Object[]{
                    emp.getName(), emp.getSurname(), emp.getRole(), emp.getSalary(), "Fire"
            });
        }
    }

    // Method to fire an employee (remove from DB)
    public void fireEmployee(int row) {
        String name = (String) tableModel.getValueAt(row, 0);
        String surname = (String) tableModel.getValueAt(row, 1);
        DB.removeEmployee(name, surname); // Remove from DB
        loadEmployeeData(); // Refresh the employee list
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Fire().setVisible(true));
    }
}
