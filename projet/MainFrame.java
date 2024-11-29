import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Exam Seating Arrangement");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel with a black border
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 40)); // 10-pixel thick black border
        mainPanel.setBackground(Color.BLACK); // Background color for better visual contrast

        // Set background
        JLabel background = new JLabel(new ImageIcon("background.jpg"));
        background.setLayout(new BorderLayout());
        mainPanel.add(background);

        // Welcome message with black border
        JLabel lblWelcome = new JLabel("<html><center>Welcome to the<br>Exam Seating Arrangement System</center></html>", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Verdana", Font.BOLD, 48)); // Larger font size
        lblWelcome.setForeground(Color.WHITE); // Assuming bg.jpg has a darker background

        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        welcomePanel.setBackground(new Color(0x000000) ); // Semi-transparent black background for contrast
        welcomePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5)); // Black border around the text
        welcomePanel.add(lblWelcome);

        background.add(welcomePanel, BorderLayout.NORTH);

        // Button
        JButton btnGeneratePlan = new JButton("Generate Exam Seating Plan");
        btnGeneratePlan.setFont(new Font("Arial", Font.BOLD, 24)); // Larger font for the button
        btnGeneratePlan.setPreferredSize(new Dimension(600, 200)); // Increased button size
        btnGeneratePlan.addActionListener(e -> new SeatingPlanFrame());

        // Center panel for the button
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false); // Transparent panel to show background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20); // Optional padding around the button
        panel.add(btnGeneratePlan, gbc);

        // Add panel to the background
        background.add(panel, BorderLayout.CENTER);

         // Footer with copyright
         JLabel lblFooter = new JLabel("© 2024 TechYogis", SwingConstants.CENTER);
         lblFooter.setFont(new Font("Arial", Font.PLAIN, 16));
         lblFooter.setForeground(Color.LIGHT_GRAY);
         lblFooter.setOpaque(false); // Transparent background for the label
         background.add(lblFooter, BorderLayout.SOUTH);

        // Add main panel to the frame
        setContentPane(mainPanel);

        // Set visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}