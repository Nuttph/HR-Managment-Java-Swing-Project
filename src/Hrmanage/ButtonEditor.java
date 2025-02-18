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

    public ButtonEditor(JCheckBox checkBox, JTable table) {
        super(checkBox);
        this.table = table;
        button = new JButton();
        button.setOpaque(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) return; // ป้องกัน error กรณีไม่มีแถวถูกเลือก

                String name = (String) table.getValueAt(row, 0);
                String surname = (String) table.getValueAt(row, 1);

                if (label.equals("Yes")) {
                    // รับผู้สมัคร -> บันทึกลงฐานข้อมูล
                    Employees.moveToEmployeeList(name, surname);
                    JOptionPane.showMessageDialog(table, "Accepted: " + name + " " + surname);
                } else if (label.equals("No")) {
                    // ลบผู้สมัคร
                    Employees.removeApplicant(name, surname);
                    JOptionPane.showMessageDialog(table, "Rejected: " + name + " " + surname);
                } else if (label.equals("Fire")) {
                    // ไล่ออกพนักงาน
                    int confirm = JOptionPane.showConfirmDialog(table, "Are you sure you want to fire " + name + " " + surname + "?", "Confirm Fire", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        Employees.removeEmployee(name, surname); // ลบพนักงานออกจาก DB
                        JOptionPane.showMessageDialog(table, "Fired: " + name + " " + surname);
                    }
                }

                // ลบแถวออกจาก JTable
                ((DefaultTableModel) table.getModel()).removeRow(row);
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

// ✅ Renderer สำหรับปุ่ม Fire
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
