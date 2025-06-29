package Employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Update_Employee implements ActionListener {
    JFrame f;
    JLabel lab, l, l1, l2, l3, l4, l5, l6;
    JTextField t, t1, t2, t3, t4, t5, t6;
    JButton b, b1, b2;

    Update_Employee() {
        /** Creating Frame **/
        f = new JFrame("Update Employee");
        f.setSize(700, 700); // Kích thước frame
        f.setLocationRelativeTo(null); // Căn giữa màn hình
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(44, 62, 80)); // Màu nền đậm cho header
        headerPanel.setPreferredSize(new Dimension(700, 80));
        lab = new JLabel("Update Employee Details");
        lab.setFont(new Font("Poppins", Font.BOLD, 30));
        lab.setForeground(Color.WHITE);
        headerPanel.add(lab);
        f.add(headerPanel, BorderLayout.NORTH);

        // Main Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBackground(new Color(236, 240, 241)); // Màu nền sáng cho content
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        f.add(contentPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Enter Employee ID
        gbc.gridx = 0; gbc.gridy = 0; l = new JLabel("Enter Employee ID :"); l.setFont(new Font("Poppins", Font.BOLD, 16)); l.setForeground(new Color(52, 73, 94)); contentPanel.add(l, gbc);
        gbc.gridx = 1; t = new JTextField(); t.setPreferredSize(new Dimension(220, 35)); t.setFont(new Font("Arial", Font.PLAIN, 14)); contentPanel.add(t, gbc);

        // Search button
        gbc.gridx = 2; gbc.gridy = 0; b = new JButton("Search");
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
        gbc.gridwidth = 2; // Các trường thông tin sẽ chiếm 2 cột
        // Name
        gbc.gridx = 0; gbc.gridy = 1; l1 = new JLabel("Name:"); l1.setFont(new Font("Poppins", Font.BOLD, 15)); l1.setForeground(new Color(52, 73, 94)); l1.setVisible(false); contentPanel.add(l1, gbc);
        gbc.gridx = 1; t1 = new JTextField(); t1.setPreferredSize(new Dimension(220, 35)); t1.setFont(new Font("Arial", Font.PLAIN, 14)); t1.setVisible(false); contentPanel.add(t1, gbc);

        // Age
        gbc.gridx = 0; gbc.gridy = 2; l2 = new JLabel("Age:"); l2.setFont(new Font("Poppins", Font.BOLD, 15)); l2.setForeground(new Color(52, 73, 94)); l2.setVisible(false); contentPanel.add(l2, gbc);
        gbc.gridx = 1; t2 = new JTextField(); t2.setPreferredSize(new Dimension(220, 35)); t2.setFont(new Font("Arial", Font.PLAIN, 14)); t2.setVisible(false); contentPanel.add(t2, gbc);

        // Address
        gbc.gridx = 0; gbc.gridy = 3; l3 = new JLabel("Address:"); l3.setFont(new Font("Poppins", Font.BOLD, 15)); l3.setForeground(new Color(52, 73, 94)); l3.setVisible(false); contentPanel.add(l3, gbc);
        gbc.gridx = 1; t3 = new JTextField(); t3.setPreferredSize(new Dimension(220, 35)); t3.setFont(new Font("Arial", Font.PLAIN, 14)); t3.setVisible(false); contentPanel.add(t3, gbc);

        // Phone
        gbc.gridx = 0; gbc.gridy = 4; l4 = new JLabel("Phone:"); l4.setFont(new Font("Poppins", Font.BOLD, 15)); l4.setForeground(new Color(52, 73, 94)); l4.setVisible(false); contentPanel.add(l4, gbc);
        gbc.gridx = 1; t4 = new JTextField(); t4.setPreferredSize(new Dimension(220, 35)); t4.setFont(new Font("Arial", Font.PLAIN, 14)); t4.setVisible(false); contentPanel.add(t4, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 5; l5 = new JLabel("Email:"); l5.setFont(new Font("Poppins", Font.BOLD, 15)); l5.setForeground(new Color(52, 73, 94)); l5.setVisible(false); contentPanel.add(l5, gbc);
        gbc.gridx = 1; t5 = new JTextField(); t5.setPreferredSize(new Dimension(220, 35)); t5.setFont(new Font("Arial", Font.PLAIN, 14)); t5.setVisible(false); contentPanel.add(t5, gbc);

        // Designation
        gbc.gridx = 0; gbc.gridy = 6; l6 = new JLabel("Designation:"); l6.setFont(new Font("Poppins", Font.BOLD, 15)); l6.setForeground(new Color(52, 73, 94)); l6.setVisible(false); contentPanel.add(l6, gbc);
        gbc.gridx = 1; t6 = new JTextField(); t6.setPreferredSize(new Dimension(220, 35)); t6.setFont(new Font("Arial", Font.PLAIN, 14)); t6.setVisible(false); contentPanel.add(t6, gbc);

        // Buttons Panel (UPDATE, CANCEL)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(236, 240, 241));
        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 3; // Occupy all 3 columns for buttons
        b1 = new JButton("UPDATE");
        b2 = new JButton("CANCEL");

        JButton[] actionBtns = {b1, b2};
        for (JButton btn : actionBtns) {
            btn.setPreferredSize(new Dimension(120, 40));
            btn.setFont(new Font("Poppins", Font.BOLD, 16));
            btn.setBackground(new Color(52, 152, 219)); // Màu xanh cho nút
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btn.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2, true)); // Border bo tròn
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(btn.getBackground().darker());
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(52, 152, 219));
                }
            });
            buttonPanel.add(btn);
        }
        contentPanel.add(buttonPanel, gbc);

        // registering the buttons to the listener
        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);

        /** Setting the frame **/
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
                // Hide fields if no employee found
                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l5.setVisible(false);
                l6.setVisible(false);
                t1.setVisible(false);
                t2.setVisible(false);
                t3.setVisible(false);
                t4.setVisible(false);
                t5.setVisible(false);
                t6.setVisible(false);
                b1.setVisible(false);
                b2.setVisible(false);
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
                    // Người dùng hủy chọn, ẩn các trường thông tin
                    l1.setVisible(false);
                    l2.setVisible(false);
                    l3.setVisible(false);
                    l4.setVisible(false);
                    l5.setVisible(false);
                    l6.setVisible(false);
                    t1.setVisible(false);
                    t2.setVisible(false);
                    t3.setVisible(false);
                    t4.setVisible(false);
                    t5.setVisible(false);
                    t6.setVisible(false);
                    b1.setVisible(false);
                    b2.setVisible(false);
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
                l3.setVisible(true);
                l4.setVisible(true);
                l5.setVisible(true);
                l6.setVisible(true);
                b1.setVisible(true);
                b2.setVisible(true);

                t1.setText(employee.getName());
                t1.setVisible(true);
                t2.setText(Integer.toString(employee.getAge()));
                t2.setVisible(true);
                t3.setText(employee.getAddress());
                t3.setVisible(true);
                t4.setText(employee.getPhoneNumber());
                t4.setVisible(true);
                t5.setText(employee.getEmail());
                t5.setVisible(true);
                t6.setText(employee.getDesignation());
                t6.setVisible(true);
                // Lưu lại employee để update
                t.putClientProperty("selectedEmployee", employee);
            } else {
                // Nếu không tìm thấy nhân viên sau khi chọn (trường hợp này ít xảy ra nhưng để an toàn)
                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l5.setVisible(false);
                l6.setVisible(false);
                t1.setVisible(false);
                t2.setVisible(false);
                t3.setVisible(false);
                t4.setVisible(false);
                t5.setVisible(false);
                t6.setVisible(false);
                b1.setVisible(false);
                b2.setVisible(false);
                JOptionPane.showMessageDialog(f, "Selected employee not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == b1) {
            employee = (Employee) t.getClientProperty("selectedEmployee");
            if (employee == null) return;
            String name = t1.getText().trim();
            String ageStr = t2.getText().trim();
            String address = t3.getText().trim();
            String phone = t4.getText().trim();
            String email = t5.getText().trim();
            String designation = t6.getText().trim();
            // Kiểm tra không để trống
            if(name.isEmpty() || ageStr.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty() || designation.isEmpty()) {
                JOptionPane.showMessageDialog(f, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Kiểm tra Age là số nguyên dương
            int age = 0;
            try {
                age = Integer.parseInt(ageStr);
                if(age <= 0) throw new NumberFormatException();
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(f, "Age must be a positive integer!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Kiểm tra Name chỉ chứa chữ và khoảng trắng
            if(!name.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(f, "Name must contain only letters and spaces!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Kiểm tra Phone chỉ chứa số và độ dài hợp lý (10-12 số)
            if(!phone.matches("\\d{10,12}")) {
                JOptionPane.showMessageDialog(f, "Phone must contain 10-12 digits!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Kiểm tra định dạng Email
            if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                JOptionPane.showMessageDialog(f, "Invalid email format!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Kiểm tra Designation chỉ chứa chữ và khoảng trắng
            if(!designation.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(f, "Designation must contain only letters and spaces!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Employee newEmployee = new Employee(employee.getID(), name, age, address, phone, email, designation);
            list.updateEmployee(employee, newEmployee);
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
