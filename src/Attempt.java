package main

import Employee.Manage_Employee;
import Order.Order2;
import Payment.billGUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Attempt {

    static JButton Order_button, emp, Payment;

    public Attempt() {
        JFrame f = new JFrame("HOME PAGE");

        /**** Background ****/
        ImageIcon background_image= new ImageIcon("src\\Login\\trangchu.jpg");
        Image img= background_image.getImage();
        Image im= img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
        background_image= new ImageIcon(im);

        JLabel background= new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0,0,900,600);
        f.add(background);

        /**** Header ****/
        JPanel heading= new JPanel();
        heading.setBackground(new Color(0,0,0,120));
        heading.setBounds(0,0,900,100);

        JLabel name= new JLabel("MACHI RESTAURANT");
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setSize(900, 100);
        name.setForeground(new Color(240,230,140));
        name.setFont(new Font("Monospaced", Font.BOLD, 60));
        heading.add(name);

        background.add(heading);

        // Slogan mới với nền và màu chữ rõ ràng
        JPanel sloganPanel = new JPanel();
        sloganPanel.setBackground(new Color(0, 0, 0, 0)); // Nền đen trong suốt
        sloganPanel.setBounds(0, 90, 900, 50);
        sloganPanel.setLayout(new GridBagLayout()); // Dùng GridBagLayout để căn giữa nội dung

        JLabel slogan = new JLabel("Please select a function below to manage employees, orders, or payments.", SwingConstants.CENTER);
        slogan.setFont(new Font("Monospaced", Font.BOLD, 18)); // Làm đậm và rõ chữ hơn
        slogan.setForeground(Color.WHITE); // Màu chữ trắng để nổi bật trên nền đen
        sloganPanel.add(slogan);
        background.add(sloganPanel);

        /**** Menu ****/
        JPanel menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setBounds(0, 200, 900, 200);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 30, 0, 30);

        emp = new JButton("Employee Management");
        Order_button = new JButton("Order Management");
        Payment = new JButton("Sales Report");
        JButton[] btns = {emp, Order_button, Payment};
        Color[] btnColors = {
            new Color(72,209,204), // pastel orange
            new Color(240,128,128), // pastel green
            new Color(240,230,140) // Changed color to purple for Sales Report
        };
        for (int i = 0; i < btns.length; i++) {
            JButton btn = btns[i];
            btn.setPreferredSize(new Dimension(220, 70));
            btn.setFont(new Font("Monospaced", Font.BOLD, 15));
            btn.setBackground(btnColors[i]);
            btn.setForeground(new Color(44, 62, 80));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(30),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setOpaque(true);
            btn.setContentAreaFilled(true);
            btn.setUI(new javax.swing.plaf.basic.BasicButtonUI());
            // Bóng đổ
            btn.setBorderPainted(false);
            btn.setMargin(new Insets(10, 20, 10, 20));
            // Hiệu ứng hover
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(btn.getBackground().darker());
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setBackground(btnColors[java.util.Arrays.asList(btns).indexOf(btn)]);
                }
            });
        }
        // Thứ tự: Employee - Order - Pay
        gbc.gridx = 0; menuPanel.add(emp, gbc);
        gbc.gridx = 1; menuPanel.add(Order_button, gbc);
        gbc.gridx = 2; menuPanel.add(Payment, gbc);
        background.add(menuPanel);

        /**** Setting the frame ****/
        f.setSize(900,600);
        f.setLocation(220, 40);
        f.setLayout(null);
        f.setVisible(true);

        /**** Handling Events ****/
        Order_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                f.setVisible(false);
                new Tables.TableSelection();
            }
        });

        emp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Manage_Employee();
                f.setVisible(false);
            }
        });

        Payment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Payment.Sales_Report();
                f.setVisible(false);
            }
        });

        JButton tableStatusButton = new JButton("Table Status Management");
        tableStatusButton.setBounds(310, 480, 280, 50);
        tableStatusButton.setFont(new Font("Monospaced", Font.BOLD, 15));
        tableStatusButton.setBackground(new Color(66,110,180)); // Orange color
        tableStatusButton.setForeground(Color.WHITE);
        tableStatusButton.setBorder(BorderFactory.createLineBorder(new Color(211, 84, 0), 2, true));
        tableStatusButton.setFocusPainted(false);
        tableStatusButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tableStatusButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableStatusButton.setBackground(tableStatusButton.getBackground().darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tableStatusButton.setBackground(new Color(230, 126, 34));
            }
        });
        tableStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Tables.Manage_Tables(); // Open new table management GUI
            }
        });
        background.add(tableStatusButton);
    }

    static class RoundedBorder extends javax.swing.border.AbstractBorder {
        private int radius;
        RoundedBorder(int radius) { this.radius = radius; }
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(44, 62, 80, 80));
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(x+2, y+2, width-5, height-5, radius, radius);
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(8,8,8,8);
        }
        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.right = insets.top = insets.bottom = 8;
            return insets;
        }
    }
}