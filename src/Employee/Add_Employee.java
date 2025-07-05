package Employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Add_Employee implements ActionListener {
    JFrame f;
    JLabel lab, l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;
    JPanel body;

    Add_Employee() {
        /**** Creating Frame ****/
        f = new JFrame("Add Employee");
        f.setSize(700, 700);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // Main Heading
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(44, 62, 80)); // Màu nền đậm cho header
        headerPanel.setPreferredSize(new Dimension(700, 80));
        lab = new JLabel("Add New Employee");
        lab.setFont(new Font("Monospaced", Font.BOLD, 30));
        lab.setForeground(Color.WHITE);
        headerPanel.add(lab);
        f.add(headerPanel, BorderLayout.NORTH);

        // Main Content Panel
        body = new JPanel();
        body.setLayout(new GridBagLayout()); // Sử dụng GridBagLayout để căn chỉnh tốt hơn
        body.setBackground(new Color(236, 240, 241)); // Màu nền sáng cho body
        body.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        f.add(body, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ID
        gbc.gridx = 0; gbc.gridy = 0; l1 = new JLabel("Employee ID:"); l1.setFont(new Font("Poppins", Font.BOLD, 15)); l1.setForeground(new Color(52, 73, 94)); body.add(l1, gbc);
        gbc.gridx = 1; t1 = new JTextField(); t1.setPreferredSize(new Dimension(220, 35)); t1.setFont(new Font("Arial", Font.PLAIN, 14)); body.add(t1, gbc);

        // Name
        gbc.gridx = 0; gbc.gridy = 1; l2 = new JLabel("Name:"); l2.setFont(new Font("Poppins", Font.BOLD, 15)); l2.setForeground(new Color(52, 73, 94)); body.add(l2, gbc);
        gbc.gridx = 1; t2 = new JTextField(); t2.setPreferredSize(new Dimension(220, 35)); t2.setFont(new Font("Arial", Font.PLAIN, 14)); body.add(t2, gbc);

        // Age
        gbc.gridx = 0; gbc.gridy = 2; l3 = new JLabel("Age:"); l3.setFont(new Font("Poppins", Font.BOLD, 15)); l3.setForeground(new Color(52, 73, 94)); body.add(l3, gbc);
        gbc.gridx = 1; t3 = new JTextField(); t3.setPreferredSize(new Dimension(220, 35)); t3.setFont(new Font("Arial", Font.PLAIN, 14)); body.add(t3, gbc);

        // Address
        gbc.gridx = 0; gbc.gridy = 3; l4 = new JLabel("Address:"); l4.setFont(new Font("Poppins", Font.BOLD, 15)); l4.setForeground(new Color(52, 73, 94)); body.add(l4, gbc);
        gbc.gridx = 1; t4 = new JTextField(); t4.setPreferredSize(new Dimension(220, 35)); t4.setFont(new Font("Arial", Font.PLAIN, 14)); body.add(t4, gbc);

        // Phone
        gbc.gridx = 0; gbc.gridy = 4; l5 = new JLabel("Phone:"); l5.setFont(new Font("Poppins", Font.BOLD, 15)); l5.setForeground(new Color(52, 73, 94)); body.add(l5, gbc);
        gbc.gridx = 1; t5 = new JTextField(); t5.setPreferredSize(new Dimension(220, 35)); t5.setFont(new Font("Arial", Font.PLAIN, 14)); body.add(t5, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 5; l6 = new JLabel("Email:"); l6.setFont(new Font("Poppins", Font.BOLD, 15)); l6.setForeground(new Color(52, 73, 94)); body.add(l6, gbc);
        gbc.gridx = 1; t6 = new JTextField(); t6.setPreferredSize(new Dimension(220, 35)); t6.setFont(new Font("Arial", Font.PLAIN, 14)); body.add(t6, gbc);

        // Designation
        gbc.gridx = 0; gbc.gridy = 6; l7 = new JLabel("Designation:"); l7.setFont(new Font("Poppins", Font.BOLD, 15)); l7.setForeground(new Color(52, 73, 94)); body.add(l7, gbc);
        gbc.gridx = 1; t7 = new JTextField(); t7.setPreferredSize(new Dimension(220, 35)); t7.setFont(new Font("Arial", Font.PLAIN, 14)); body.add(t7, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(236, 240, 241));
        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2;
        b1 = new JButton("ADD");
        b2 = new JButton("CANCEL");

        JButton[] btns = {b1, b2};
        for (JButton btn : btns) {
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
        body.add(buttonPanel, gbc);

        // Registering the buttons to the listener
        b1.addActionListener(this);
        b2.addActionListener(this);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1) {
            // Kiểm tra hợp lệ dữ liệu
            String idStr = t1.getText().trim();
            String name = t2.getText().trim();
            String ageStr = t3.getText().trim();
            String address = t4.getText().trim();
            String phone = t5.getText().trim();
            String email = t6.getText().trim();
            String designation = t7.getText().trim();

            // Kiểm tra không để trống
            if(idStr.isEmpty() || name.isEmpty() || ageStr.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty() || designation.isEmpty()) {
                JOptionPane.showMessageDialog(f, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Kiểm tra ID và Age là số nguyên dương
            int ID = 0, age = 0;
            try {
                ID = Integer.parseInt(idStr);
                age = Integer.parseInt(ageStr);
                if(ID <= 0 || age <= 0) throw new NumberFormatException();
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(f, "ID and Age must be positive integers!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Kiểm tra Name chỉ chứa chữ và khoảng trắng
            if(!name.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(f, "Name must contain only letters and spaces!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Kiểm tra Phone chỉ chứa số và độ dài hợp lý (ví dụ 10-12 số)
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
            // Nếu hợp lệ, thêm nhân viên
            EmployeeList list = new EmployeeList();
            list.addEmployee(new Employee(ID, name, age, address, phone, email, designation));
            list.dataToFile();
            f.setVisible(false);
            Manage_Employee.f.setVisible(true);
        }

        if(e.getSource() == b2) {
            f.setVisible(false);
            Manage_Employee.f.setVisible(true);
        }

    }

}