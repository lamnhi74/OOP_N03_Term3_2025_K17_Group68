package Order;

import Employee.ExceptionClass;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class Add_MenuItem extends ExceptionClass {

    Add_MenuItem() {

        JFrame f = new JFrame("ADD MENU ITEM");

        /**** Background ****/
        ImageIcon background_image= new ImageIcon("src\\Order\\menu0.jpg");
        Image img= background_image.getImage();
        Image im= img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
        background_image= new ImageIcon(im);
        JLabel background= new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0,0,900,600);
        f.add(background);


        /**** Header ****/
        JPanel heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));
        heading.setBounds(0,0,900,100);

        JLabel name= new JLabel("ADD ITEM DETAILS");
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment((JLabel.CENTER));
        name.setSize(900, 100);
        name.setForeground(Color.ORANGE);
        name.setFont(new Font("Monospaced", Font.BOLD,40));
        heading.add(name);
        background.add(heading);

        /**** panel ****/
        JPanel panel= new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0,0,0,60));
        panel.setBounds(240,150,400,360);

        /** panel body **/
        JLabel a = new JLabel("Enter ItemID:");
        a.setBounds(20,20,150,50);
        a.setFont(new Font("Monospaced", Font.BOLD, 15));
        a.setBackground(Color.BLACK);
        a.setForeground(Color.white);
        panel.add(a);

        JTextField itemID = new JTextField();
        itemID.setBounds(180,25,200,40);
        itemID.setForeground(Color.white);
        itemID.setBackground(new Color(249,204,118));
        panel.add(itemID);

        JLabel b = new JLabel("Enter ItemName:");
        b.setBounds(20,120,150,50);
        b.setFont(new Font("Monospaced", Font.BOLD, 15));
        b.setBackground(Color.black);
        b.setForeground(Color.white);
        panel.add(b);

        JTextField itemName = new JTextField();
        itemName.setBounds(180,120,200,40);
        itemName.setForeground(Color.white);
        itemName.setBackground(new Color(249,204,118));
        panel.add(itemName);

        JLabel c = new JLabel("Enter Price(in Rs):");
        c.setBounds(20,220,150,50);
        c.setFont(new Font("Monospaced", Font.BOLD, 15));
        c.setBackground(Color.black);
        c.setForeground(Color.white);
        panel.add(c);

        JTextField Price = new JTextField();
        Price.setBounds(180,220,200,40);
        Price.setForeground(Color.white);
        Price.setBackground(new Color(249,204,118));
        panel.add(Price);

        JButton add = new JButton("ADD");
        add.setBounds(50,300,100,40);
        add.setBackground(new Color(243,194,70));
        add.setForeground(Color.WHITE);
        panel.add(add);

        JButton back = new JButton("BACK");
        back.setBounds(250,300,100,40);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        panel.add(back);

        background.add(panel);

        /**** Setting the frame ****/
        f.setSize(900,600);
        f.setLocation(280, 40);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**** Handling Events ****/
        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String s1 = itemID.getText().trim();
                String s2 = itemName.getText().trim();
                String s3 = Price.getText().trim();
                int flag = 0;
                // Kiểm tra không để trống
                if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
                    JOptionPane.showMessageDialog(f, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Kiểm tra ItemID là số nguyên dương
                int id = 0;
                try {
                    id = Integer.parseInt(s1);
                    if(id <= 0) throw new NumberFormatException();
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "ItemID must be a positive integer!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Kiểm tra ItemName chỉ chứa chữ và khoảng trắng
                if(!s2.matches("[a-zA-Z ]+")) {
                    JOptionPane.showMessageDialog(f, "Item Name must contain only letters and spaces!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Kiểm tra Price là số thực dương
                double price = 0;
                try {
                    price = Double.parseDouble(s3);
                    if(price <= 0) throw new NumberFormatException();
                } catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Price must be a positive number!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    BufferedReader b= new BufferedReader(new FileReader("src/Order/menu.txt"));
                    FileWriter w = new FileWriter("src/Order/menu.txt", true);
                    String str;
                    while ((str = b.readLine()) != null) {
                        String[] r = str.split(" , ");
                        try {
                            if (r[0].equalsIgnoreCase(s1)||r[1].equalsIgnoreCase(s2)) {
                                flag = 1;
                                throw new ExceptionClass("Same Item Id or Name cannot be re-entered");
                            }
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            ex.printStackTrace();
                        }
                    }
                    w.write(s1 + " , " + s2 + " , " + s3 + '\n');
                    w.close();
                } catch (ExceptionClass ae) {
                    ae.showMessage();
                } catch (IOException ae) {
                    ae.printStackTrace();
                }
                if(flag == 0) {
                    JOptionPane.showMessageDialog(f, "Successfully Saved The Details");
                }
            }
        });

        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Order2();
            }
        });

    }

        
}
