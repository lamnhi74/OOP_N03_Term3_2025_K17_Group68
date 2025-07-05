package Payment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Login.Attempt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Sales_Report implements ActionListener {

    JFrame f;
    JPanel mainPanel;
    DefaultTableModel monthlySalesModel;
    DefaultTableModel topSellingItemsModel;

    public Sales_Report() {
        f = new JFrame("Sales Report");
        f.setSize(900, 650);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(44, 62, 80));
        headerPanel.setPreferredSize(new Dimension(900, 60));
        JLabel headerLabel = new JLabel("SALES REPORT");
        headerLabel.setFont(new Font("Poppins", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        f.add(headerPanel, BorderLayout.NORTH);

        // Main Content Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Vertical stacking
        mainPanel.setBackground(new Color(236, 240, 241));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        f.add(mainPanel, BorderLayout.CENTER);

        // Monthly Sales Section
        JLabel monthlySalesLabel = new JLabel("Monthly Sales:");
        monthlySalesLabel.setFont(new Font("Poppins", Font.BOLD, 22));
        monthlySalesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        monthlySalesLabel.setForeground(new Color(52, 73, 94));
        mainPanel.add(monthlySalesLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        String[] monthlyCols = {"Month", "Total Sales"};
        monthlySalesModel = new DefaultTableModel(monthlyCols, 0);
        JTable monthlySalesTable = new JTable(monthlySalesModel);
        customizeTable(monthlySalesTable);
        mainPanel.add(new JScrollPane(monthlySalesTable));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Top Selling Items Section
        JLabel topSellingLabel = new JLabel("Top 5 Selling Items:");
        topSellingLabel.setFont(new Font("Poppins", Font.BOLD, 22));
        topSellingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topSellingLabel.setForeground(new Color(52, 73, 94));
        mainPanel.add(topSellingLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        String[] topSellingCols = {"Item Name", "Quantity Sold"};
        topSellingItemsModel = new DefaultTableModel(topSellingCols, 0);
        JTable topSellingItemsTable = new JTable(topSellingItemsModel);
        customizeTable(topSellingItemsTable);
        mainPanel.add(new JScrollPane(topSellingItemsTable));
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        loadSalesReport();

        // Back Button
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        footerPanel.setBackground(new Color(236, 240, 241));
        JButton backButton = new JButton("Back to Home");
        backButton.setPreferredSize(new Dimension(150, 40));
        backButton.setFont(new Font("Poppins", Font.BOLD, 16));
        backButton.setBackground(new Color(52, 152, 219));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2, true));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButton.setBackground(backButton.getBackground().darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButton.setBackground(new Color(52, 152, 219));
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Attempt();
            }
        });
        footerPanel.add(backButton);
        f.add(footerPanel, BorderLayout.SOUTH);

        f.setVisible(true);
    }

    private void customizeTable(JTable table) {
        table.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(52, 152, 219));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.setSelectionBackground(new Color(162, 155, 254));
        table.setGridColor(new Color(200, 200, 200));
        table.setEnabled(false); // Make table non-editable
    }

    private void loadSalesReport() {
        monthlySalesModel.setRowCount(0); // Clear existing data
        topSellingItemsModel.setRowCount(0); // Clear existing data

        Map<String, Double> monthlySales = new HashMap<>();
        Map<String, Integer> itemQuantities = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/Order/Orders.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(" , ");
                // Expected format: ItemID , ItemName , Price , Quantity , TableID
                if (parts.length >= 5) {
                    try {
                        String itemName = parts[1].trim();
                        double itemPrice = Double.parseDouble(parts[2].trim());
                        int quantity = Integer.parseInt(parts[3].trim());

                        double totalItemPrice = itemPrice * quantity;

                        // For monthly sales (assuming we can extract month from somewhere, or use dummy for now)
                        // For simplicity, let's just aggregate total sales for now.
                        // To implement monthly sales, Orders.txt needs a date/timestamp.
                        // For this iteration, I'll show total sales of all time for now.
                        // To get monthly sales, we'd need a date in Orders.txt, e.g., ItemID , ItemName , Price , Quantity , TableID , Date
                        // For now, let's just use a dummy month or skip monthly breakdown if date isn't available.
                        // Let's assume a simplified scenario for monthly sales by just showing overall total for now.
                        // Or, we can simulate months for demonstration if Orders.txt has no date info.

                        // Let's go with a simplified approach first for monthly sales: just a running total.
                        // To truly do monthly, we need a date. The current Orders.txt format doesn't include it.
                        // For now, let's just get the grand total of all sales.
                        String month = "All Time"; // Placeholder for now
                        monthlySales.put(month, monthlySales.getOrDefault(month, 0.0) + totalItemPrice);

                        // For top selling items
                        itemQuantities.put(itemName, itemQuantities.getOrDefault(itemName, 0) + quantity);

                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing number in Orders.txt for sales report: " + line + " - " + e.getMessage());
                    }
                } else {
                    System.err.println("Invalid line format in Orders.txt for sales report: " + line);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(f, "Error reading order history: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Populate Monthly Sales Table
        for (Map.Entry<String, Double> entry : monthlySales.entrySet()) {
            monthlySalesModel.addRow(new Object[]{entry.getKey(), String.format("%.2f", entry.getValue())});
        }

        // Populate Top Selling Items Table
        // Sort items by quantity sold in descending order
        LinkedHashMap<String, Integer> sortedItemQuantities = itemQuantities.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        for (Map.Entry<String, Integer> entry : sortedItemQuantities.entrySet()) {
            topSellingItemsModel.addRow(new Object[]{entry.getKey(), entry.getValue()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // No specific action listeners for buttons within this class yet
    }

    public static void main(String[] args) {
        new Sales_Report();
    }
} 