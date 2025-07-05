package Employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Remove_Employee implements ActionListener {
    JFrame f;
    JLabel lab, l, l1, l2, l3, l4, l5, l6, l7;
    JTextField t;
    JButton b, b1, b2;

    Remove_Employee() {
        /**** Frame ****/
        f = new JFrame("Remove Employee");
        f.setSize(700, 500); // Kích thước frame
        f.setLocationRelativeTo(null); // Căn giữa màn hình
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(44, 62, 80));
        headerPanel.setPreferredSize(new Dimension(700, 80));
        lab = new JLabel("Remove Employee");
        lab.setFont(new Font("Poppins", Font.BOLD, 30));
        lab.setForeground(Color.WHITE);
        headerPanel.add(lab);
        f.add(headerPanel, BorderLayout.NORTH);

        // Main Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBackground(new Color(236, 240, 241));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        f.add(contentPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Enter Employee ID
        gbc.gridx = 0; gbc.gridy = 0; l = new JLabel("Enter Employee ID :"); l.setFont(new Font("Poppins", Font.BOLD, 16)); l.setForeground(new Color(52, 73, 94)); contentPanel.add(l, gbc);
        gbc.gridx = 1; t = new JTextField(); t.setPreferredSize(new Dimension(220, 35)); t.setFont(new Font("Arial", Font.PLAIN, 14)); contentPanel.add(t, gbc);

        // Search Button
        gbc.gridx = 2; gbc.gridy = 0; b = new JButton("SEARCH");
        b.setPreferredSize(new Dimension(100, 35));
        b.setFont(new Font("Poppins", Font.BOLD, 16));
        b.setBackground(new Color(52, 152, 219));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2, true));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b.setBackground(b.getBackground().darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b.setBackground(new Color(52, 152, 219));
            }
        });
        contentPanel.add(b, gbc);

        // Employee Details (Initially hidden)
        gbc.gridwidth = 2;
        gbc.gridx = 0; gbc.gridy = 1; l1 = new JLabel("Employee Details:"); l1.setFont(new Font("Ubuntu", Font.BOLD, 17)); l1.setForeground(new Color(52, 73, 94)); l1.setVisible(false); contentPanel.add(l1, gbc);

        gbc.gridx = 0; gbc.gridy = 2; l2 = new JLabel("Name :"); l2.setFont(new Font("sans serif", Font.BOLD, 15)); l2.setForeground(new Color(52, 73, 94)); l2.setVisible(false); contentPanel.add(l2, gbc);
        gbc.gridx = 1; l3 = new JLabel("abc"); l3.setForeground(new Color(52, 73, 94)); l3.setVisible(false); contentPanel.add(l3, gbc);

        gbc.gridx = 0; gbc.gridy = 3; l4 = new JLabel("Phone :"); l4.setFont(new Font("sans serif", Font.BOLD, 15)); l4.setForeground(new Color(52, 73, 94)); l4.setVisible(false); contentPanel.add(l4, gbc);
        gbc.gridx = 1; l5 = new JLabel("def"); l5.setForeground(new Color(52, 73, 94)); l5.setVisible(false); contentPanel.add(l5, gbc);

        gbc.gridx = 0; gbc.gridy = 4; l6 = new JLabel("Email :"); l6.setFont(new Font("sans serif", Font.BOLD, 15)); l6.setForeground(new Color(52, 73, 94)); l6.setVisible(false); contentPanel.add(l6, gbc);
        gbc.gridx = 1; l7 = new JLabel("ghi"); l7.setForeground(new Color(52, 73, 94)); l7.setVisible(false); contentPanel.add(l7, gbc);

        // Buttons Panel (REMOVE, CANCEL)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(236, 240, 241));
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 3;
        b1 = new JButton("REMOVE");
        b2 = new JButton("CANCEL");

        JButton[] actionBtns = {b1, b2};
        for (JButton btn : actionBtns) {
            btn.setPreferredSize(new Dimension(120, 40));
            btn.setFont(new Font("Poppins", Font.BOLD, 16));
            btn.setBackground(new Color(231, 76, 60)); // Màu đỏ cho nút xóa
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setBorder(BorderFactory.createLineBorder(new Color(192, 57, 43), 2, true)); // Border bo tròn
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(btn.getBackground().darker());
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(231, 76, 60));
                }
            });
            buttonPanel.add(btn);
        }
        contentPanel.add(buttonPanel, gbc);

        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);

        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String idPrefix = t.getText().trim();
        EmployeeList list = new EmployeeList();
        java.util.List<Employee> matches = list.searchEmployeesByIDPrefix(idPrefix);
        Employee employee = null;
        if (e.getSource() == b) {
            if (matches.size() == 0) {
                JOptionPane.showMessageDialog(f, "No employee found with this ID prefix!", "Not Found", JOptionPane.ERROR_MESSAGE);
                f.setVisible(false);
                Manage_Employee.f.setVisible(true);
                return;
            } else if (matches.size() == 1) {
                employee = matches.get(0);
            } else {
                // Có nhiều kết quả, cho chọn
                String[] options = new String[matches.size()];
                for (int i = 0; i < matches.size(); i++) {
                    Employee ep = matches.get(i);
                    options[i] = ep.getID() + " - " + ep.getName();
                }
                String selected = (String) JOptionPane.showInputDialog(f, "Select Employee:", "Multiple Employees Found", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (selected == null) {
                    // Người dùng hủy chọn
                    return;
                }
                int selectedID = Integer.parseInt(selected.split(" - ")[0].trim());
                for (Employee ep : matches) {
                    if (ep.getID() == selectedID) {
                        employee = ep;
                        break;
                    }
                }
            }
            if (employee != null) {
                l1.setVisible(true);
                l2.setVisible(true);
                l3.setText(employee.getName());
                l3.setVisible(true);
                l4.setVisible(true);
                l5.setText(employee.getPhoneNumber());
                l5.setVisible(true);
                l6.setVisible(true);
                l7.setText(employee.getEmail());
                l7.setVisible(true);
                b1.setVisible(true);
                b2.setVisible(true);
                t.putClientProperty("selectedEmployee", employee);
            }
        }
        if (e.getSource() == b1) {
            employee = (Employee) t.getClientProperty("selectedEmployee");
            if (employee == null) return;
            list.removeEmployee(employee);
            list.dataToFile();
            f.setVisible(false);
            Manage_Employee.f.setVisible(true);
        }
        if (e.getSource() == b2) {
            f.setVisible(false);
            Manage_Employee.f.setVisible(true);
        }
    }

}
