package Hrmanage;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Menu extends JFrame {
    private JLabel lblClock;
    private JLabel lblLogo;

    public Menu() {
        setTitle("HR Management Menu");
        setSize(1024, 768);
        setLocationRelativeTo(null); // จัดให้อยู่กึ่งกลางจอ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        startClock(); // เรียกใช้งานนาฬิกา
    }

    private void initComponents() {
        JLabel titleLabel = new JLabel("HR Management", SwingConstants.CENTER);
        JLabel menutext = new JLabel("Menu");

        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        menutext.setFont(new Font("Arial", Font.BOLD, 24));

        JButton btnHome = new JButton("Home");
        JButton btnEmployee = new JButton("Employee");
        JButton btnFire = new JButton("Fire");
        JButton btnApplying = new JButton("Applying");
        JButton btnLogout = new JButton("Log out");

        Font buttonFont = new Font("Arial", Font.BOLD, 24);
        btnHome.setFont(buttonFont);
        btnEmployee.setFont(buttonFont);
        btnFire.setFont(buttonFont);
        btnApplying.setFont(buttonFont);
        btnLogout.setFont(new Font("Arial", Font.BOLD, 16));

        // ตั้งค่าการทำงานของปุ่ม
        btnHome.addActionListener(e -> goToMenu());
        //btnEmployee.addActionListener(e -> openEmployee());
        //btnFire.addActionListener(e -> openFire());
        btnApplying.addActionListener(e -> openApplying());
        btnLogout.addActionListener(e -> logout());

        lblClock = new JLabel();
        lblClock.setFont(new Font("Arial", Font.BOLD, 20));
        lblClock.setForeground(Color.BLACK); // ตั้งค่าสีตัวหนังสือ

        ImageIcon icon = new ImageIcon(getClass().getResource("/uploads/kim.jpg"));
        Image img = icon.getImage().getScaledInstance(280, 350, Image.SCALE_SMOOTH);
        lblLogo = new JLabel(new ImageIcon(img));

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // กำหนดตำแหน่งของคอมโพเนนต์
        lblClock.setBounds(20, 680, 200, 30);
        lblLogo.setBounds(530, 200, 280, 350);
        titleLabel.setBounds(630, 40, 400, 50);
        menutext.setBounds(50, 140, 100, 50);
        btnHome.setBounds(50, 200, 250, 50);
        btnEmployee.setBounds(50, 280, 250, 50);
        btnFire.setBounds(50, 360, 250, 50);
        btnApplying.setBounds(50, 440, 250, 50);
        btnLogout.setBounds(870, 680, 120, 30);

        // เพิ่ม components เข้า panel
        panel.add(lblClock);
        panel.add(titleLabel);
        panel.add(menutext);
        panel.add(btnHome);
        panel.add(btnEmployee);
        panel.add(btnFire);
        panel.add(btnApplying);
        panel.add(btnLogout);
        panel.add(lblLogo);

        add(panel);
    }

    private void startClock() {
        Timer timer = new Timer(1000, e -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            lblClock.setText("Time: " + sdf.format(new Date()));
        });
        timer.start();
    }

    private void goToMenu() {
        dispose(); // ปิดหน้าปัจจุบัน
        new Menu().setVisible(true); // เปิดหน้า Menu ใหม่
    }

//    private void openEmployee() {
  //      dispose();
   //     new Employee().setVisible(true);
   // }

    //private void openFire() {
      //  dispose();
       // new Fire().setVisible(true);
    //}

    private void openApplying() {
        dispose();
        new Applying().setVisible(true);
    }

    private void logout() {
        dispose();
        new HR1().setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu().setVisible(true));
    }
}
