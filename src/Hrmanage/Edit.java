package Hrmanage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class Edit extends JFrame {
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JButton backButton;
    private JTextField searchField;
    private JButton searchButton;
    public Edit() {
        setTitle("Edit Employees");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> loadEmployeeData(searchField.getText().trim()));

        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        panel.add(searchPanel, BorderLayout.BEFORE_FIRST_LINE);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            new Menu().setVisible(true);
            setVisible(false);
        });
        panel.add(backButton, BorderLayout.SOUTH);
        
        String[] columnNames = {"Name", "Surname", "Role", "Salary", "Edit"};
        tableModel = new DefaultTableModel(columnNames, 0);
        employeeTable = new JTable(tableModel);
//        employeeTable.setRowHeight(30); // ปรับความสูงของแถวให้เหมาะกับปุ่ม

        loadEmployeeData("");

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // กำหนดให้คอลัมน์ "Edit" ใช้ Renderer และ Editor
        TableColumn editColumn = employeeTable.getColumnModel().getColumn(4);
        editColumn.setCellRenderer(new ButtonRenderer());
        editColumn.setCellEditor(new ButtonEditor(new JCheckBox(), employeeTable));
    }

    protected void loadEmployeeData(String keyword) {
        tableModel.setRowCount(0);
        ArrayList<Employees> employeeList = DB.getEmployeeDatabase();

        for (Employees emp : employeeList) {
            String name = emp.getName();
            String role = emp.getRole();
            if (keyword.isEmpty() || name.contains(keyword) || role.contains(keyword)) {
                tableModel.addRow(new Object[]{
                        emp.getName(), emp.getSurname(), emp.getRole(), emp.getSalary(), "Edit"
                });
            }}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Edit().setVisible(true));
    }
}
