package Order;

import Employee.ExceptionClass;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Delete_MenuItem extends ExceptionClass {

    
    Delete_MenuItem() {

        JFrame f = new JFrame("REMOVE MENU ITEM");

        /**** Background ****/
        ImageIcon background_image= new ImageIcon("src\\Order\\mon.jpg");
        Image img= background_image.getImage();
        Image im= img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
        background_image= new ImageIcon(im);

        JLabel background= new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0,0,900,600);

        /**** Header ****/
        JPanel heading= new JPanel();
        heading.setBackground(new Color(0,0,0,90));
        heading.setBounds(0,0,900,100);

        JLabel name= new JLabel("REMOVE ITEM DETAILS");
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setSize(900, 100);
        name.setForeground(Color.ORANGE);
        name.setFont(new Font("Monospaced", Font.BOLD,40));
        heading.add(name);
        background.add(heading);

        /*** panel ****/
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(250,160, 400, 300);
        panel.setBackground(new Color(0, 0, 0, 90));
        background.add(panel);

        /**** panel body ****/
        JLabel a = new JLabel("Enter ItemID : ");
        a.setBounds(20,60,200,50);
        a.setFont(new Font("Monospaced", Font.BOLD, 18));
        a.setForeground(Color.white);
        panel.add(a);

        JTextField itemID= new JTextField();
        itemID.setBounds(180,60,200,40);
        itemID.setForeground(Color.white);
        itemID.setBackground(new Color(249,204,118));
        panel.add(itemID);

        JButton del = new JButton("DELETE");
        del.setBounds(50,220,100,40);
        del.setBackground(new Color(243,194,70));
        del.setForeground(Color.WHITE);
        panel.add(del);

        JButton delAll = new JButton("DELETE ALL");
        delAll.setBounds(155,220,120,40);
        delAll.setBackground(Color.ORANGE);
        delAll.setForeground(Color.WHITE);
        panel.add(delAll);

        JButton back = new JButton("BACK");
        back.setBounds(285, 220, 100, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);


        /**** Setting the frame ****/
        f.add(background);
        f.setSize(900,600);
        f.setLocation(280, 40);
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**** Handling Events ****/
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idPrefix = itemID.getText().trim();
                java.util.List<String> matches = new java.util.ArrayList<>();
                java.util.List<String> lines = new java.util.ArrayList<>();
                try {
                    BufferedReader menuReader = new BufferedReader(new FileReader("src/Order/menu.txt"));
                    String str = "";
                    while((str=menuReader.readLine()) != null) {
                        lines.add(str);
                        String[] r = str.split(" , ");
                        if(r.length > 0 && r[0].startsWith(idPrefix)) {
                            matches.add(str);
                        }
                    }
                    menuReader.close();
                    if(matches.size() == 0) {
                        JOptionPane.showMessageDialog(null,"No item found with this ID prefix!");
                        return;
                    }
                    String toDelete = null;
                    if(matches.size() == 1) {
                        String[] r = matches.get(0).split(" , ");
                        String info = r[0] + (r.length>1 ? " - " + r[1] : "");
                        int confirm = JOptionPane.showConfirmDialog(null, "Do you want to delete this item?\n" + info, "Confirm Delete", JOptionPane.YES_NO_OPTION);
                        if(confirm == JOptionPane.YES_OPTION) {
                            toDelete = matches.get(0);
                        } else {
                            return;
                        }
                    } else {
                        String[] options = new String[matches.size()];
                        for(int i=0;i<matches.size();i++) {
                            String[] r = matches.get(i).split(" , ");
                            options[i] = r[0] + " - " + (r.length>1?r[1]:"");
                        }
                        String selected = (String) JOptionPane.showInputDialog(null, "Select item to delete:", "Multiple Items Found", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                        if(selected == null) return;
                        String selectedID = selected.split(" - ")[0].trim();
                        for(String s : matches) {
                            if(s.split(" , ")[0].equals(selectedID)) {
                                toDelete = s;
                                break;
                            }
                        }
                    }
                    if(toDelete != null) {
                        BufferedWriter menuWriter = new BufferedWriter(new FileWriter("src/Order/menu.txt"));
                        for(String line : lines) {
                            if(!line.equals(toDelete)) {
                                menuWriter.write(line+"\n");
                            }
                        }
                        menuWriter.close();
                        JOptionPane.showMessageDialog(null,"Item deleted successfully!");
                    }
                } catch(IOException io) {
                    JOptionPane.showMessageDialog(null,"IO EXCEPTION THROWN");
                }
            }
        });

        delAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete ALL menu items?", "Confirm Delete All", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION) {
                    try {
                        BufferedWriter menuWriter = new BufferedWriter(new FileWriter("src/Order/menu.txt"));
                        menuWriter.write("");
                        menuWriter.close();
                        JOptionPane.showMessageDialog(null,"All menu items deleted!");
                    } catch(IOException io) {
                        JOptionPane.showMessageDialog(null,"IO EXCEPTION THROWN");
                    }
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
