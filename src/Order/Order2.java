package Order;

import Employee.ExceptionClass;
import Tables.TableList;
import Login.Attempt;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.*;

public class Order2 extends ExceptionClass {

    public static void main(String[] args) {
        new Order2();
    }

    private int tableID;
    private JFrame f;

    public Order2() { // Default constructor for direct access if needed, though now routed through TableSelection
        this(0); // Call the new constructor with a default/dummy table ID
    }

    public Order2(int tableID) {
        this.tableID = tableID;
        f = new JFrame("Order - Table " + tableID);

        /**** Background ****/
        ImageIcon background_image = new ImageIcon("src\\Order\\order.jpg");
        Image img = background_image.getImage();
        Image scaledImg = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(scaledImg);
        JLabel background = new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0,0,900,600);

        /**** Header ****/
        JPanel heading = new JPanel();
        heading.setLayout(null);
        heading.setBackground(new Color(0, 0, 0, 90));
        heading.setBounds(0, 0, 900, 100);

        JLabel name = new JLabel("ORDER");
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setSize(900, 100);
        name.setForeground(Color.ORANGE);
        name.setFont(new Font("Monospaced", Font.BOLD, 40));
        heading.add(name);

        background.add(heading);

        /**** Order_page panel ****/
        JPanel Order_page = new JPanel();
        Order_page.setLayout(null);
        Order_page.setBackground(new Color(0, 0, 0, 90));
        Order_page.setBounds(35, 140, 400, 350);
        background.add(Order_page);

        /** Order heading **/
        JPanel ORDER_HEADING = new JPanel();
        ORDER_HEADING.setLayout(null);
        ORDER_HEADING.setBounds(0, 0, 400, 70);
        ORDER_HEADING.setBackground(new Color(238, 237, 237, 100));
        ORDER_HEADING.setForeground(Color.BLACK);

        JLabel name2 = new JLabel("ORDER DETAILS");
        name2.setHorizontalAlignment(JLabel.CENTER);
        name2.setVerticalAlignment(JLabel.CENTER);
        name2.setSize(400, 70);
        name2.setForeground(Color.WHITE);
        name2.setFont(new Font("Monospaced", Font.BOLD, 25));
        ORDER_HEADING.add(name2);
        Order_page.add(ORDER_HEADING);

        /** Order_page body **/
        JLabel oid = new JLabel("ENTER ORDER ID: ");
        oid.setBounds(25, 120, 150, 40);
        oid.setFont(new Font("Monospaced", Font.BOLD, 15));
        oid.setForeground(Color.WHITE);
        Order_page.add(oid);

        JTextField OrderID = new JTextField();
        OrderID.setBounds(190, 120, 180, 40);
        OrderID.setForeground(Color.white);
        OrderID.setBackground(new Color(249,204,118));
        Order_page.add(OrderID);

        JLabel quantityField = new JLabel("ENTER QUANTITY: ");
        quantityField.setBounds(25, 200, 150, 40);
        quantityField.setFont(new Font("Monospaced", Font.BOLD, 15));
        quantityField.setForeground(Color.WHITE);
        Order_page.add(quantityField);

        JTextField quantity = new JTextField("");
        quantity.setBounds(190, 200, 180, 40);
        quantity.setForeground(Color.white);
        quantity.setBackground(new Color(249,204,118));
        Order_page.add(quantity);

        JButton addItemButton = new JButton("ADD ITEM");
        addItemButton.setBounds(130, 280, 150, 40);
        addItemButton.setBackground(new Color(243,194,70));
        addItemButton.setForeground(Color.white);
        Order_page.add(addItemButton);

        JButton finalizeOrderButton = new JButton("FINALIZE ORDER & SHOW BILL");
        finalizeOrderButton.setBounds(550, 510, 280, 40);
        finalizeOrderButton.setBackground(Color.ORANGE);
        finalizeOrderButton.setForeground(Color.WHITE);
        finalizeOrderButton.setFocusPainted(false);
        finalizeOrderButton.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2, true));
        finalizeOrderButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        finalizeOrderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finalizeOrderButton.setBackground(finalizeOrderButton.getBackground().darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                finalizeOrderButton.setBackground(Color.ORANGE);
            }
        });
        background.add(finalizeOrderButton);

        /** Order_page_right panel **/
        JPanel Order_page_right = new JPanel();
        Order_page_right.setLayout(null);
        Order_page_right.setBackground(new Color(0, 0, 0, 80));
        Order_page_right.setBounds(460, 140, 400, 350);
        background.add(Order_page_right);

        /** Order_page_right body **/
        JButton show = new JButton("SHOW MENU");
        show.setBounds(590, 160, 150, 40);
        show.setBackground(Color.ORANGE);
        show.setForeground(Color.white);
        Order_page_right.add(show);
        f.add(show);

        JButton add = new JButton("ADD");
        add.setBounds(50, 290, 100, 40);
        add.setBackground(new Color(243,194,70));
        add.setForeground(Color.white);
        Order_page_right.add(add);

        JButton delete = new JButton("DELETE");
        delete.setBounds(250, 290, 100, 40);
        delete.setBackground(new Color(243,194,70));
        delete.setForeground(Color.white);
        Order_page_right.add(delete);

        JButton back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(370, 510, 150, 40);
        background.add(back);

        /**** Setting the frame ****/
        f.setSize(900, 600);
        f.setLocation(250, 40);
        f.add(background);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**** Handling the events ****/
        addItemButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String s1 = OrderID.getText();
                String s2 = quantity.getText();
                String str = "";
                int flag = 0;
                try {
                    BufferedReader b = new BufferedReader(new FileReader("src/Order/menu.txt"));
                    FileWriter w2 = new FileWriter("src/Order/latOrder.txt", true);

                    while ((str = b.readLine()) != null) {
                        if (str.trim().isEmpty() || !str.contains(" , ")) {
                            continue;
                        }

                        String[] menuParts = str.split(" , ");
                        if (menuParts.length < 3) continue;

                        if (menuParts[0].trim().equals(s1)) {
                            flag = 1;
                            w2.write(menuParts[0] + " , " + menuParts[1] + " , " + menuParts[2] + " , " + s2 + " , " + tableID + "\n");
                            break;
                        }
                    }

                    w2.close();
                    b.close();

                    if(flag == 0) {
                        throw new ExceptionClass("Item ID does not exist in menu.");
                    }
                } catch (ExceptionClass ex) {
                    ex.showMessage();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if( flag == 1) {
                    JOptionPane.showMessageDialog(f, "Item added to order successfully!");
                    OrderID.setText("");
                    quantity.setText("");
                }
            }

        });

        finalizeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedReader brLatOrder = new BufferedReader(new FileReader("src/Order/latOrder.txt"));
                    FileWriter fwOrders = new FileWriter("src/Order/Orders.txt", true);
                    String line;
                    boolean hasItems = false;
                    while ((line = brLatOrder.readLine()) != null) {
                        if (!line.trim().isEmpty()) {
                            fwOrders.write(line + "\n");
                            hasItems = true;
                        }
                    }
                    brLatOrder.close();
                    fwOrders.close();

                    if (!hasItems) {
                        JOptionPane.showMessageDialog(f, "Order is empty. Please add items before finalizing.", "Empty Order", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    new Payment.billGUI();
                    f.dispose();

                    try (FileWriter clearLatOrder = new FileWriter("src/Order/latOrder.txt", false)) {
                        clearLatOrder.write("");
                    } catch (IOException ex) {
                        System.err.println("Error clearing latOrder.txt: " + ex.getMessage());
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(f, "Error finalizing order: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                new Add_MenuItem();
                f.setVisible(false);
            }

        });

        delete.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                new Delete_MenuItem();
                f.setVisible(false);
            }

        });


        DefaultTableModel model = new DefaultTableModel();
        JTable menu = new JTable(model);
        menu.setBounds(25, 80, 350, 195);
        menu.setVisible(false);
        Order_page_right.add(menu);

        model.addColumn("Item ID");
        model.addColumn("Item Name");
        model.addColumn("Item Price");
        menu.getColumnModel().getColumn(1).setPreferredWidth(130);
        String[] tHeading = {"Item ID", "Item Name", "Item Price"};
        model.addRow(tHeading);

        show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String filepath = "src/Order/menu.txt";
                    File input = new File(filepath);
                    BufferedReader br = new BufferedReader(new FileReader(input));

                    String x;
                    while ((x = br.readLine()) != null) {
                        String[] row = x.split(" , ");

                        if(!x.equals("")) {
                            int rowCount = menu.getRowCount();
                            int count = 0;
                            if (rowCount == 0)
                                model.addRow(row);
                            else {
                                for (int i = 0; i < rowCount; i++) {
                                    String item = menu.getValueAt(i, 0).toString();
                                    if (!row[0].equals(item))
                                        count++;
                                }
                            }
                            if (count == rowCount) {
                                model.addRow(row);
                            }
                        }
                    }
                    menu.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }


    });

        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Attempt();
            }

        });
    }

}
