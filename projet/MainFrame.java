import javax.swing.*;
// import projet.SeatingPlanFrame;

import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Exam Seating Arrangement");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background
        JLabel background = new JLabel(new ImageIcon("bg.jpg"));
        background.setLayout(new BorderLayout());
        setContentPane(background);

        // Buttons
        JButton btnGeneratePlan = new JButton("Generate Exam Seating Plan");
        JButton btnEnterData = new JButton("Enter Student Data");

        btnGeneratePlan.setFont(new Font("Arial", Font.BOLD, 18));
        btnEnterData.setFont(new Font("Arial", Font.BOLD, 18));

        btnGeneratePlan.addActionListener(e -> new SeatingPlanFrame());
        btnEnterData.addActionListener(e -> JOptionPane.showMessageDialog(this, "Student Data Entry Coming Soon!"));

        // Layout
        JPanel panel = new JPanel();
        panel.setOpaque(false); // Transparent panel to show background
        panel.setLayout(new GridLayout(2, 1, 20, 20));
        panel.add(btnGeneratePlan);
        panel.add(btnEnterData);

        background.add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
