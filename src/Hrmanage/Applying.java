package Hrmanage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Applying extends JFrame {
    private JTable applicantTable;
    private JButton btnBack;
    private DefaultTableModel model;
    private JTextField searchField;
    private JButton searchButton;
    public Applying() {
        setTitle("Applicant List");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Table Model
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Surname");
        model.addColumn("Role");
        model.addColumn("Salary");
        model.addColumn("Accept");  // ปุ่ม Yes
        model.addColumn("Reject");  // ปุ่ม No
        model.addColumn("Details");  // ปุ่ม View Details

        // Add applicants to table

        applicantTable = new JTable(model);
        applicantTable.getColumn("Accept").setCellRenderer(new ButtonRenderer());
        applicantTable.getColumn("Accept").setCellEditor(new ButtonEditor(new JCheckBox(), applicantTable));

        applicantTable.getColumn("Reject").setCellRenderer(new ButtonRenderer());
        applicantTable.getColumn("Reject").setCellEditor(new ButtonEditor(new JCheckBox(), applicantTable));

        applicantTable.getColumn("Details").setCellRenderer(new ButtonRenderer());
        applicantTable.getColumn("Details").setCellEditor(new ButtonEditor(new JCheckBox(), applicantTable));

        JScrollPane scrollPane = new JScrollPane(applicantTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        //search
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> loadEmployeeData(searchField.getText().trim()));

        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        panel.add(searchPanel, BorderLayout.NORTH);

        // Back button
        btnBack = new JButton("Back");
        btnBack.setBounds(900, 680, 100, 40);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Menu().setVisible(true);  // Assuming Menu is your main screen
                setVisible(false);
            }
        });
        panel.add(btnBack, BorderLayout.SOUTH);

        add(panel);
        loadEmployeeData("");
    }


    private void loadEmployeeData(String keyword) {
        model.setRowCount(0); // Clear existing data
        ArrayList<Employees> employeeList = DB.getEmployeeDatabase();

        for (Employees emp : Employees.getApplicantList()) {
//            tableModel.addRow(new Object[]{
//                    emp.getName(), emp.getSurname(), emp.getRole(), emp.getSalary(), "Fire"
//            });
            String name = emp.getName();
            String role = emp.getRole();
            if (keyword.isEmpty() || name.contains(keyword) || role.contains(keyword)) {
                Object[] rowData = {
                        emp.getName(),
                        emp.getSurname(),
                        emp.getRole(),
                        emp.getSalary(),
                        "Yes",  // ปุ่ม Accept
                        "No",   // ปุ่ม Reject
                        "View Details" // ปุ่ม Details
                };
                model.addRow(rowData);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Applying().setVisible(true));
    }
}
