import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountDesignation extends JFrame {

    private JPanel contentPanel;

    public AccountDesignation() {
        initComponents();
        customInitComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(763, 447));
        setSize(new Dimension(763, 447)); // Ensure the initial size is set
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    // Custom method to initialize components
    private void customInitComponents() {
        // Create the menu panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(new java.awt.Color(204, 0, 51)); // Dark red background
        menuPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));
        menuPanel.setPreferredSize(new Dimension(200, getHeight()));

        // Create and add the welcome label
        JLabel welcomeLabel = new JLabel("<html><div style='text-align: center;'>Welcome to MotorPH payroll system</div></html>");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setPreferredSize(new Dimension(200, 100));
        welcomeLabel.setMaximumSize(new Dimension(200, 100));

        // Create and add menu items to the panel
        JButton btnAccount = createMenuButton("Account");
        JButton btnPayroll = createMenuButton("Payroll");
        JButton btnTimekeeping = createMenuButton("Timekeeping");
        JButton btnTransaction = createMenuButton("Transaction");
        JButton btnOthers = createMenuButton("Others");

        // Add glue to evenly distribute the buttons
        menuPanel.add(Box.createVerticalStrut(20)); // Add top padding
        menuPanel.add(welcomeLabel);
        menuPanel.add(Box.createVerticalStrut(20)); // Space between the label and buttons
        menuPanel.add(btnAccount);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(btnPayroll);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(btnTimekeeping);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(btnTransaction);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(btnOthers);
        menuPanel.add(Box.createVerticalGlue());

        // Add the menu panel to the left side of the frame
        add(menuPanel, BorderLayout.WEST);

        // Initialize the content panel
        contentPanel = new JPanel();
        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        add(contentPanel, BorderLayout.CENTER);

        // Set action listeners for menu items
        btnAccount.addActionListener(new MenuActionListener("Welcome to the Account section!"));
        btnPayroll.addActionListener(new MenuActionListener("Welcome to the Payroll section!"));
        btnTimekeeping.addActionListener(new MenuActionListener("Welcome to the Timekeeping section!"));
        btnTransaction.addActionListener(new MenuActionListener("Welcome to the Transaction section!"));
        btnOthers.addActionListener(new MenuActionListener("Welcome to the Others section!"));

        // Pack the frame to ensure all components are correctly sized
        pack();
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 50));
        button.setMinimumSize(new Dimension(200, 50));
        button.setPreferredSize(new Dimension(200, 50));
        button.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 2));
        button.setBackground(Color.WHITE);
        button.setForeground(new java.awt.Color(153, 0, 0));
        button.setFocusPainted(false);
        return button;
    }

    private class MenuActionListener implements ActionListener {
        private String message;

        public MenuActionListener(String message) {
            this.message = message;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            updateContentPanel(message);
        }
    }

    private void updateContentPanel(String message) {
        contentPanel.removeAll();
        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(label, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountDesignation().setVisible(true);
            }
        });
    }
}
