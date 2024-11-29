import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class SeatingPlanDisplayFrame extends JFrame {
    public SeatingPlanDisplayFrame(int students, int rows, int columns, String pattern) {
        setTitle("Seating Plan - " + pattern);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel gridPanel = new JPanel(new GridLayout(rows, columns, 5, 5));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        int totalSeats = rows * columns;
        ArrayList<Integer> studentList = new ArrayList<>();

        for (int i = 1; i <= students; i++) {
            studentList.add(i);
        }
        for (int i = students + 1; i <= totalSeats; i++) {
            studentList.add(0); // Empty seats represented as 0
        }

        if ("Randomize".equalsIgnoreCase(pattern)) {
            Collections.shuffle(studentList);
        }

        int[][] seatingArrangement = new int[rows][columns];
        switch (pattern) {
            case "Check Pattern":
                createCheckPattern(seatingArrangement, studentList, rows, columns);
                break;
            case "Spiral Pattern":
                createSpiralPattern(seatingArrangement, studentList, rows, columns);
                break;
            default:
                // Default: Randomize pattern
                createRandomizedPattern(seatingArrangement, studentList, rows, columns);
                break;
        }

        // Render the seating plan
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JLabel seatLabel;
                if (seatingArrangement[i][j] != 0) {
                    seatLabel = new JLabel("Roll " + seatingArrangement[i][j], SwingConstants.CENTER);
                    seatLabel.setBackground(Color.BLUE);
                } else {
                    seatLabel = new JLabel("Empty", SwingConstants.CENTER);
                    seatLabel.setBackground(Color.lightGray);
                }
                seatLabel.setFont(new Font("Arial", Font.BOLD, 18));
                seatLabel.setOpaque(true);
                seatLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridPanel.add(seatLabel);
            }
        }
        // Add heading at the top
        JLabel heading = new JLabel("Seating Plan", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(heading, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void createCheckPattern(int[][] seatingArrangement, ArrayList<Integer> studentList, int rows, int columns) {
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((i + j) % 2 == 0 && index < studentList.size()) {
                    seatingArrangement[i][j] = studentList.get(index++);
                }
            }
        }
    }

    private void createSpiralPattern(int[][] seatingArrangement, ArrayList<Integer> studentList, int rows,
            int columns) {
        int top = 0, bottom = rows - 1, left = 0, right = columns - 1;
        int index = 0;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right && index < studentList.size(); i++) {
                seatingArrangement[top][i] = studentList.get(index++);
            }
            top++;
            for (int i = top; i <= bottom && index < studentList.size(); i++) {
                seatingArrangement[i][right] = studentList.get(index++);
            }
            right--;
            for (int i = right; i >= left && index < studentList.size(); i--) {
                seatingArrangement[bottom][i] = studentList.get(index++);
            }
            bottom--;
            for (int i = bottom; i >= top && index < studentList.size(); i--) {
                seatingArrangement[i][left] = studentList.get(index++);
            }
            left++;
        }
    }

    private void createRandomizedPattern(int[][] seatingArrangement, ArrayList<Integer> studentList, int rows,
            int columns) {
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (index < studentList.size()) {
                    seatingArrangement[i][j] = studentList.get(index++);
                }
            }
        }
    }
}
