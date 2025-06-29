package Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

class View_Employee {
    JFrame f;
    JTable t;
    JButton back;

    View_Employee() {
        f = new JFrame("View Employee");
        f.setSize(1000, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(44, 62, 80));
        headerPanel.setPreferredSize(new Dimension(1000, 60));
        JLabel headerLabel = new JLabel("Employee List");
        headerLabel.setFont(new Font("Poppins", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        f.add(headerPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(236, 240, 241));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        DefaultTableModel model = new DefaultTableModel();
        t = new JTable(model);
        t.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 14));
        t.getTableHeader().setBackground(new Color(52, 152, 219));
        t.getTableHeader().setForeground(Color.WHITE);
        t.setRowHeight(25);
        t.setFont(new Font("Arial", Font.PLAIN, 12));
        t.setSelectionBackground(new Color(162, 155, 254));
        t.setGridColor(new Color(200, 200, 200));

        model.addColumn("eID");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Address");
        model.addColumn("Phone Number");
        model.addColumn("Email");
        model.addColumn("Designation");
        t.getColumnModel().getColumn(0).setPreferredWidth(50);
        t.getColumnModel().getColumn(1).setPreferredWidth(150);
        t.getColumnModel().getColumn(2).setPreferredWidth(50);
        t.getColumnModel().getColumn(3).setPreferredWidth(180);
        t.getColumnModel().getColumn(4).setPreferredWidth(120);
        t.getColumnModel().getColumn(5).setPreferredWidth(200);
        t.getColumnModel().getColumn(6).setPreferredWidth(120);

        String[] row = new String[7];
        EmployeeList list = new EmployeeList();
        list.getDataFromFile();
        for (int i = 0; i < EmployeeList.employeeList.size(); i++) {
            Employee e = list.getEmployee(i);
            if(e != null) {
                row[0] = Integer.toString(e.getID());
                row[1] = e.getName();
                row[2] = Integer.toString(e.getAge());
                row[3] = e.getAddress();
                row[4] = e.getPhoneNumber();
                row[5] = e.getEmail();
                row[6] = e.getDesignation();
                model.addRow(row);
            }
        }

        JScrollPane scrollPane = new JScrollPane(t);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(236, 240, 241));
        back = new JButton("BACK");
        back.setPreferredSize(new Dimension(120, 40));
        back.setFont(new Font("Poppins", Font.BOLD, 16));
        back.setBackground(new Color(52, 152, 219));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2, true));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back.setBackground(back.getBackground().darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back.setBackground(new Color(52, 152, 219));
            }
        });
        buttonPanel.add(back);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        f.add(contentPanel, BorderLayout.CENTER);

        back.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               f.setVisible(false);
               new Manage_Employee();
           }
       });
        f.setVisible(true);
    }

}
