package Payment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Login.Attempt;

public class billGUI{

    /**** constructor ****/
    public billGUI(){
        JFrame j=new JFrame("BILL");
        j.setSize(700, 600);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        j.setLayout(new BorderLayout());

        // Header
        JPanel header=new JPanel();
        header.setBackground(new Color(44, 62, 80));
        header.setPreferredSize(new Dimension(700, 60));
        JLabel heading=new JLabel("BILL DETAILS");
        heading.setFont(new Font("Poppins", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        header.add(heading);
        j.add(header, BorderLayout.NORTH);

        // Main content area (CENTER) - this will hold tableIdLabel, scrollPane, and total
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical stacking
        centerPanel.setBackground(new Color(236, 240, 241));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        j.add(centerPanel, BorderLayout.CENTER);

        // Table ID Label
        JLabel tableIdLabel = new JLabel("", SwingConstants.CENTER);
        tableIdLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        tableIdLabel.setForeground(new Color(52, 73, 94));
        tableIdLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align in BoxLayout
        centerPanel.add(tableIdLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        // Bill Table setup (model, JTable, JScrollPane)
        String[] colNames = {"Item ID", "Item Name", "Rate", "Quantity", "Total Price"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        JTable billTable = new JTable(model);

        // Customize table appearance
        billTable.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 14));
        billTable.getTableHeader().setBackground(new Color(52, 152, 219));
        billTable.getTableHeader().setForeground(Color.WHITE);
        billTable.setRowHeight(25);
        billTable.setFont(new Font("Arial", Font.PLAIN, 12));
        billTable.setSelectionBackground(new Color(162, 155, 254));
        billTable.setGridColor(new Color(200, 200, 200));

        double grandTotal = 0; 
        int currentTableID = -1; // To store the table ID of the current bill

        try {
            // Read from latOrder.txt to build the current bill and calculate total
            BufferedReader brLatOrder = new BufferedReader(new FileReader("src/Order/latOrder.txt"));
            String line;
            while ((line = brLatOrder.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(" , "); // Split by " , "
                // Expected format: ItemID , ItemName , Price , Quantity , TableID
                if (parts.length == 5) { // Ensure all parts are present for a valid order line
                    try {
                        String itemId = parts[0].trim();
                        String itemName = parts[1].trim();
                        double rate = Double.parseDouble(parts[2].trim());
                        int quantity = Integer.parseInt(parts[3].trim());
                        // The last part is TableID, extract it
                        currentTableID = Integer.parseInt(parts[4].trim()); 

                        double itemTotalPrice = rate * quantity;
                        grandTotal += itemTotalPrice;

                        // Add to model for display
                        model.addRow(new Object[]{itemId, itemName, String.format("%.2f", rate), quantity, String.format("%.2f", itemTotalPrice)});

                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing number in latOrder.txt: " + line + " - " + e.getMessage());
                    }
                } else {
                    System.err.println("Invalid line format in latOrder.txt: " + line);
                }
            }
            brLatOrder.close();

        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "IO EXCEPTION THROWN during bill display: " + io.getMessage());
        }

        // Set table ID label
        if(currentTableID != -1) {
            tableIdLabel.setText("Table: " + currentTableID);
        } else {
            tableIdLabel.setText("Table: N/A (Error)"); // Indicate if no table ID found
        }

        JScrollPane scrollPane = new JScrollPane(billTable);
        centerPanel.add(scrollPane);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        // Add grand total label
        JLabel grandTotalLabel = new JLabel("Grand Total: " + String.format("%.2f", grandTotal));
        grandTotalLabel.setFont(new Font("Poppins", Font.BOLD, 22));
        grandTotalLabel.setForeground(new Color(44, 62, 80));
        grandTotalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(grandTotalLabel);

        // Back Button (SOUTH)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(new Color(236, 240, 241));
        JButton back=new JButton("Back");
        back.setPreferredSize(new Dimension(120, 40));
        back.setFont(new Font("Poppins", Font.BOLD, 16));
        back.setBackground(new Color(52, 152, 219));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2, true));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back.setBackground(back.getBackground().darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                back.setBackground(new Color(52, 152, 219));
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                j.dispose();
                new Attempt();
            }
        });
        footerPanel.add(back);
        j.add(footerPanel, BorderLayout.SOUTH);

        j.setVisible(true);
    }
}
