package Tables;

import javax.swing.*;

import Login.Attempt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Manage_Tables implements ActionListener {

    JFrame f;
    JPanel mainPanel;
    TableList tableList;

    public Manage_Tables() {
        f = new JFrame("Manage Table Status");
        f.setSize(600, 450);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(44, 62, 80));
        headerPanel.setPreferredSize(new Dimension(600, 60));
        JLabel headerLabel = new JLabel("Table Status Management");
        headerLabel.setFont(new Font("Poppins", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        f.add(headerPanel, BorderLayout.NORTH);

        // Main Content Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2, 20, 20)); // Grid for tables and their status/buttons
        mainPanel.setBackground(new Color(236, 240, 241));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        f.add(mainPanel, BorderLayout.CENTER);

        tableList = new TableList(); // Initialize TableList to load data
        loadTableStatus();

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

    private void loadTableStatus() {
        mainPanel.removeAll();
        List<Table> tables = TableList.tableList;
        for (Table table : tables) {
            JPanel tableEntryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
            tableEntryPanel.setBackground(new Color(248, 248, 248));
            tableEntryPanel.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1, true));

            JLabel tableInfoLabel = new JLabel("Table " + table.getID() + ": ");
            tableInfoLabel.setFont(new Font("Poppins", Font.BOLD, 18));
            tableInfoLabel.setForeground(new Color(44, 62, 80));
            tableEntryPanel.add(tableInfoLabel);

            JLabel statusLabel;
            if (table.isOccupied()) {
                statusLabel = new JLabel("Occupied");
                statusLabel.setForeground(new Color(231, 76, 60)); // Red
            } else {
                statusLabel = new JLabel("Empty");
                statusLabel.setForeground(new Color(46, 204, 113)); // Green
            }
            statusLabel.setFont(new Font("Poppins", Font.BOLD, 18));
            tableEntryPanel.add(statusLabel);

            if (table.isOccupied()) {
                JButton clearButton = new JButton("Clear Table");
                clearButton.setFont(new Font("Poppins", Font.BOLD, 14));
                clearButton.setBackground(new Color(52, 152, 219));
                clearButton.setForeground(Color.WHITE);
                clearButton.setFocusPainted(false);
                clearButton.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2, true));
                clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                clearButton.setActionCommand(String.valueOf(table.getID())); // Store table ID
                clearButton.addActionListener(this);
                tableEntryPanel.add(clearButton);
            }
            mainPanel.add(tableEntryPanel);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int tableIDToClear = Integer.parseInt(e.getActionCommand());
        int response = JOptionPane.showConfirmDialog(f, 
            "Are you sure you want to clear Table " + tableIDToClear + "? This will mark it as empty.",
            "Confirm Clear Table", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            tableList.updateTableStatus(tableIDToClear, false); // Mark table as empty
            JOptionPane.showMessageDialog(f, "Table " + tableIDToClear + " has been cleared.");
            loadTableStatus(); // Reload to update UI
        }
    }

    public static void main(String[] args) {
        new Manage_Tables();
    }
} 