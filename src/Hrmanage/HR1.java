package Hrmanage;

import java.awt.*;
import javax.swing.*;

public class HR1 extends JFrame {
    private static final String USER_ID = "HR_1234";
    private static final String PASSWORD = "Hr1234";

    private JTextField jTextField1;
    private JPasswordField jPasswordField1;
    private JButton jButtonLogin, jButtonApply;

    public HR1() {
        setTitle("HR Login");
        setSize(1024, 768);
        setLocationRelativeTo(null); // จัดให้อยู่กึ่งกลางจอ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel("HR Management", SwingConstants.CENTER);
        jLabel1.setFont(new Font("Arial", Font.BOLD, 36));

        JLabel jLabel2 = new JLabel("Username:");
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 24));

        JLabel jLabel3 = new JLabel("Password:");
        jLabel3.setFont(new Font("Arial", Font.PLAIN, 24));

        jTextField1 = new JTextField(20);
        jTextField1.setFont(new Font("Arial", Font.PLAIN, 22));

        jPasswordField1 = new JPasswordField(20);
        jPasswordField1.setFont(new Font("Arial", Font.PLAIN, 22));

        jButtonLogin = new JButton("Log in");
        jButtonLogin.setFont(new Font("Arial", Font.BOLD, 22));
        jButtonLogin.addActionListener(evt -> loginAction());

        jButtonApply = new JButton("Apply");
        jButtonApply.setFont(new Font("Arial", Font.BOLD, 16));
//        jButtonApply.addActionListener(evt -> openApply());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        jLabel1.setBounds(350, 100, 400, 50);
        jLabel2.setBounds(320, 250, 150, 30);
        jTextField1.setBounds(450, 250, 250, 40);
        jLabel3.setBounds(320, 320, 120, 30);
        jPasswordField1.setBounds(450, 320, 250, 40);
        jButtonLogin.setBounds(450, 400, 120, 50);
        jButtonApply.setBounds(900, 680, 90, 30);

        panel.add(jLabel1);
        panel.add(jLabel2);
        panel.add(jTextField1);
        panel.add(jLabel3);
        panel.add(jPasswordField1);
        panel.add(jButtonLogin);
        panel.add(jButtonApply);

        add(panel);
    }

    private void loginAction() {
        String inputId = jTextField1.getText();
        String inputPassword = new String(jPasswordField1.getPassword());

        if (inputId.equals(USER_ID) && inputPassword.equals(PASSWORD)) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            openMenu();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid ID or Password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openMenu() {
        this.setVisible(false);
        new Menu().setVisible(true);
    }
//
//    private void openApply() {
//        this.setVisible(false);
//        new Apply().setVisible(true);
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HR1().setVisible(true));
    }
}
