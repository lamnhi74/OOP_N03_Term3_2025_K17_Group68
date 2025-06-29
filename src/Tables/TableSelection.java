package Tables;

import Order.Order2;
import Login.Attempt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TableSelection implements ActionListener {

    JFrame f;
    JPanel mainPanel;
    TableList tableList;

    public TableSelection() {
        f = new JFrame("Table Selection");
        f.setSize(600, 450);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(44, 62, 80));
        headerPanel.setPreferredSize(new Dimension(600, 60));
        JLabel headerLabel = new JLabel("Select a Table");
        headerLabel.setFont(new Font("Poppins", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        f.add(headerPanel, BorderLayout.NORTH);

        // Main Content Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 3, 20, 20)); // Grid for tables
        mainPanel.setBackground(new Color(236, 240, 241));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        f.add(mainPanel, BorderLayout.CENTER);

        tableList = new TableList();
        loadTables();

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

    private void loadTables() {
        mainPanel.removeAll();
        List<Table> tables = TableList.tableList;
        for (Table table : tables) {
            JButton tableButton = new JButton("Table " + table.getID());
            tableButton.setPreferredSize(new Dimension(120, 80));
            tableButton.setFont(new Font("Poppins", Font.BOLD, 18));
            tableButton.setFocusPainted(false);
            tableButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            if (table.isOccupied()) {
                tableButton.setBackground(new Color(231, 76, 60)); // Red for occupied
                tableButton.setForeground(Color.WHITE);
                tableButton.setEnabled(false); // Cannot select occupied table
                tableButton.setText("Table " + table.getID() + "\n(Occupied)");
                tableButton.setVerticalTextPosition(SwingConstants.CENTER);
                tableButton.setHorizontalTextPosition(SwingConstants.CENTER);
            } else {
                tableButton.setBackground(new Color(46, 204, 113)); // Green for empty
                tableButton.setForeground(Color.WHITE);
                tableButton.addActionListener(this);
                tableButton.setActionCommand(String.valueOf(table.getID())); // Store table ID
            }
            tableButton.setBorder(BorderFactory.createLineBorder(new Color(44, 62, 80), 2, true));
            tableButton.putClientProperty("tableID", table.getID()); // Store table ID for action listener
            mainPanel.add(tableButton);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedTableID = Integer.parseInt(e.getActionCommand());
        tableList.updateTableStatus(selectedTableID, true); // Mark table as occupied
        f.dispose(); // Close table selection frame
        new Order2(selectedTableID); // Open order GUI with selected table ID
    }

    // Main method for testing (optional)
    public static void main(String[] args) {
        new TableSelection();
    }
} 