package Hrmanage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Applying extends JFrame {
    private JTable applicantTable;
    private JButton btnBack;
    private DefaultTableModel model;

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

        // Add applicants to table
        updateTableData();

        applicantTable = new JTable(model);
        applicantTable.getColumn("Accept").setCellRenderer(new ButtonRenderer());
        applicantTable.getColumn("Accept").setCellEditor(new ButtonEditor(new JCheckBox(), applicantTable));

        applicantTable.getColumn("Reject").setCellRenderer(new ButtonRenderer());
        applicantTable.getColumn("Reject").setCellEditor(new ButtonEditor(new JCheckBox(), applicantTable));


        JScrollPane scrollPane = new JScrollPane(applicantTable);
        panel.add(scrollPane, BorderLayout.CENTER);

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
    }

    // Method to update table data
    private void updateTableData() {
        model.setRowCount(0); // ล้างข้อมูลเก่าออกก่อน

        for (Employees emp : Employees.getApplicantList()) {
            Object[] rowData = {
                    emp.getName(),
                    emp.getSurname(),
                    emp.getRole(),
                    emp.getSalary(),
                    "Yes",  // ปุ่ม Accept
                    "No"    // ปุ่ม Reject
            };
            model.addRow(rowData);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Applying().setVisible(true));
    }
}
