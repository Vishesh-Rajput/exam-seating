import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SeatingPlanFrame extends JFrame {
    public SeatingPlanFrame() {
        setTitle("Generate Seating Plan");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Main panel layout
        setLayout(new BorderLayout());

        // Heading at the top
        JLabel heading = new JLabel("Input Room Specifications", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(heading, BorderLayout.NORTH);

        // Font for labels
        Font labelFont = new Font("Arial", Font.BOLD, 20);

        // Input fields
        JLabel lblPattern = new JLabel("Select Pattern:");
        JLabel lblStudents = new JLabel("Number of Students:");
        JLabel lblRows = new JLabel("Number of Rows:");
        JLabel lblColumns = new JLabel("Number of Columns:");

        // Set font size for labels
        lblPattern.setFont(labelFont);
        lblStudents.setFont(labelFont);
        lblRows.setFont(labelFont);
        lblColumns.setFont(labelFont);

        JComboBox<String> cmbPattern = new JComboBox<>(new String[] { "Check Pattern", "Randomize", "Spiral Pattern" });
        JTextField txtStudents = new JTextField();
        JTextField txtRows = new JTextField();
        JTextField txtColumns = new JTextField();

        JButton btnGenerate = new JButton("Generate Plan");

        // Adjust sizes of input components
        Dimension inputSize = new Dimension(200, 30);
        cmbPattern.setPreferredSize(inputSize);
        txtStudents.setPreferredSize(inputSize);
        txtRows.setPreferredSize(inputSize);
        txtColumns.setPreferredSize(inputSize);

        // Add borders to input components
        LineBorder border = new LineBorder(Color.BLACK, 2, true);
        cmbPattern.setBorder(border);
        txtStudents.setBorder(border);
        txtRows.setBorder(border);
        txtColumns.setBorder(border);
        btnGenerate.setBorder(border);

        // Increase text size when input is added
        FocusListener focusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                ((JTextField) e.getSource()).setFont(new Font("Arial", Font.BOLD, 18));
            }

            @Override
            public void focusLost(FocusEvent e) {
                ((JTextField) e.getSource()).setFont(new Font("Arial", Font.PLAIN, 16));
            }
        };

        txtStudents.addFocusListener(focusListener);
        txtRows.addFocusListener(focusListener);
        txtColumns.addFocusListener(focusListener);

        // JLabel background = new JLabel(new ImageIcon("bg.jpg"));
        // background.setLayout(new BorderLayout());
        // panel.add(background);

        // Layout for input panel
        JPanel panel = new JPanel(new GridLayout(5, 2, 20, 20));
        panel.add(lblPattern);
        panel.add(cmbPattern);
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
                String pattern = (String) cmbPattern.getSelectedItem();

                if (students > rows * columns) {
                    JOptionPane.showMessageDialog(this, "Students exceed seating capacity!");
                } else {
                    JOptionPane.showMessageDialog(this, "Pattern selected: " + pattern);
                    new SeatingPlanDisplayFrame(students, rows, columns, pattern);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SeatingPlanFrame::new);
    }
}
