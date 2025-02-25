package Hrmanage;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private String label;
    private JTable table;
    private boolean isPushed;
    private String B2somewhere;

    public ButtonEditor(JCheckBox checkBox, JTable table,String B2somewhere) {
        super(checkBox);
        this.table = table;
        this.B2somewhere = B2somewhere;
        button = new JButton();
        button.setOpaque(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(table, "Please select a row to perform this action.");
                    return; // ป้องกัน error กรณีไม่มีแถวถูกเลือก
                }

                String name = (String) table.getValueAt(row, 0);
                String surname = (String) table.getValueAt(row, 1);
                String role = (String) table.getValueAt(row, 2); // คอลัมน์ตำแหน่ง
                String salary = (String) table.getValueAt(row, 3); // คอลัมน์เงินเดือน

                fireEditingStopped();

                if (label.equals("Yes")) {
                    // รับผู้สมัคร -> บันทึกลงฐานข้อมูล
                    Employees.moveToEmployeeList(name, surname);
                    JOptionPane.showMessageDialog(table, "Accepted: " + name + " " + surname);
                    // ลบแถวออกจาก JTable
                    ((DefaultTableModel) table.getModel()).removeRow(row);
                } else if (label.equals("No")) {
                    // ลบผู้สมัคร
                    Employees.removeApplicant(name, surname);
                    JOptionPane.showMessageDialog(table, "Rejected: " + name + " " + surname);
                    // ลบแถวออกจาก JTable
                    ((DefaultTableModel) table.getModel()).removeRow(row);
                } else if (label.equals("Fire")) {
                    // ไล่ออกพนักงาน
                    int confirm = JOptionPane.showConfirmDialog(table, "Are you sure you want to fire " + name + " " + surname + "?", "Confirm Fire", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        DB.removeEmployee(name, surname); // ลบพนักงานออกจาก DB
                        // ลบแถวออกจาก JTable
                        ((DefaultTableModel) table.getModel()).removeRow(row);
                        JOptionPane.showMessageDialog(table, "Fired: " + name + " " + surname);
                    }
                } else if (label.equals("View Details")) {
                    Employees emp = Employees.getEmployeeDetails(name, surname); // ค้นหารายละเอียดพนักงาน

                    if (emp != null) {
                        // เปิดหน้าต่างรายละเอียดพนักงาน
                        Detail detailFrame = new Detail(emp.getId(),emp.getName(), emp.getSurname(), emp.getRole(), emp.getSalary(),
                                emp.getPhone(), emp.getEmail(), emp.getAddress(), emp.getDistrict(),
                                emp.getAmphur(), emp.getProvince(), emp.getPostcode(), emp.getHousing(), "back");
                        detailFrame.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(table, "Employee not found.");
                    }
                }else if (label.equals("Edit")) {
                    Employees emp = Employees.getEmployeeDetails(name, surname);

                    if (emp != null) {
                        EditEmployeeDialog dialog = new EditEmployeeDialog(null, emp);
                        dialog.setVisible(true);

                        // รีเฟรชตารางหลังจากปิด dialog
                        ((DefaultTableModel) table.getModel()).setRowCount(0);
                        ((Edit) SwingUtilities.getWindowAncestor(table)).loadEmployeeData("");
                    } else {
                        JOptionPane.showMessageDialog(table, "Employee not found.");
                    }
                }


            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}

// ✅ Renderer สำหรับปุ่ม
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}