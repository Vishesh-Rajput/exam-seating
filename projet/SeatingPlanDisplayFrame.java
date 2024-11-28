import javax.swing.*;
import java.awt.*;

public class SeatingPlanDisplayFrame extends JFrame {
    public SeatingPlanDisplayFrame(int students, int rows, int columns) {
        setTitle("Seating Plan");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel gridPanel = new JPanel(new GridLayout(rows, columns, 5, 5));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        int totalBenches = rows * columns; // Total benches available
        int studentNumber = 1; // Current student number

        if (students >= 4 * totalBenches) {
            // Alternate between rows and columns
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    JLabel seatLabel;
                    if ((i + j) % 2 == 0 && studentNumber <= students) {
                        seatLabel = new JLabel("4 " + studentNumber, SwingConstants.CENTER);
                        seatLabel.setBackground(Color.LIGHT_GRAY);
                        studentNumber++;
                    } else {
                        seatLabel = new JLabel("Empty", SwingConstants.CENTER);
                        seatLabel.setBackground(Color.GRAY);
                    }
                    seatLabel.setOpaque(true);
                    seatLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    gridPanel.add(seatLabel);
                }
            }
        } else if (students >= 2 * totalBenches) {
            // Alternate benches
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    JLabel seatLabel;
                    if ((i * columns + j) % 2 == 0 && studentNumber <= students) {
                        seatLabel = new JLabel("2 " + studentNumber, SwingConstants.CENTER);
                        seatLabel.setBackground(Color.LIGHT_GRAY);
                        studentNumber++;
                    } else {
                        seatLabel = new JLabel("Empty", SwingConstants.CENTER);
                        seatLabel.setBackground(Color.GRAY);
                    }
                    seatLabel.setOpaque(true);
                    seatLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    gridPanel.add(seatLabel);
                }
            }
        } else {
            // Linear sequence
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    JLabel seatLabel;
                    if (studentNumber <= students) {
                        seatLabel = new JLabel("Roll" + studentNumber, SwingConstants.CENTER);
                        seatLabel.setBackground(Color.LIGHT_GRAY);
                        studentNumber++;
                    } else {
                        seatLabel = new JLabel("Empty", SwingConstants.CENTER);
                        seatLabel.setBackground(Color.GRAY);
                    }
                    seatLabel.setOpaque(true);
                    seatLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    gridPanel.add(seatLabel);
                }
            }
        }

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
