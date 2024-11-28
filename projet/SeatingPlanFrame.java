import javax.swing.*;
import java.awt.*;

public class SeatingPlanFrame extends JFrame {
    public SeatingPlanFrame() {
        setTitle("Generate Seating Plan");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Input fields
        JLabel lblBranches = new JLabel("Number of Branches:");
        JLabel lblStudents = new JLabel("Number of Students:");
        JLabel lblRows = new JLabel("Number of Rows:");
        JLabel lblColumns = new JLabel("Number of Columns:");

        JTextField txtBranches = new JTextField();
        JTextField txtStudents = new JTextField();
        JTextField txtRows = new JTextField();
        JTextField txtColumns = new JTextField();

        JButton btnGenerate = new JButton("Generate Plan");

        // Layout
        JPanel panel = new JPanel(new GridLayout(5, 2, 20, 20));
        panel.setOpaque(false);
        panel.add(lblBranches);
        panel.add(txtBranches);
        panel.add(lblStudents);
        panel.add(txtStudents);
        panel.add(lblRows);
        panel.add(txtRows);
        panel.add(lblColumns);
        panel.add(txtColumns);
        panel.add(new JLabel()); // Spacer
        panel.add(btnGenerate);

        add(panel, BorderLayout.CENTER);

        // Action listener for Generate button
        btnGenerate.addActionListener(e -> {
            try {
                int students = Integer.parseInt(txtStudents.getText());
                int rows = Integer.parseInt(txtRows.getText());
                int columns = Integer.parseInt(txtColumns.getText());

                if (students > rows * columns) {
                    JOptionPane.showMessageDialog(this, "Students exceed seating capacity!");
                } else {
                    new SeatingPlanDisplayFrame(students, rows, columns);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
            }
        });

        setVisible(true);
    }
}
