package gui;

import java.awt.*;
import javax.swing.*;

public class Dashboard extends JFrame {

    public Dashboard() {

        setTitle("Hostel Room Allocation System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 247, 250));

        // TITLE
        JLabel title = new JLabel(
                "HOSTEL ROOM ALLOCATION SYSTEM"
        );

        title.setFont(
                new Font("Arial", Font.BOLD, 26)
        );

        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        title.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 10, 25, 10
                )
        );

        mainPanel.add(title, BorderLayout.NORTH);

        // BUTTON PANEL
        JPanel buttonPanel = new JPanel(
                new GridLayout(2, 3, 20, 20)
        );

        buttonPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        30, 50, 30, 50
                )
        );

        buttonPanel.setBackground(
                new Color(245, 247, 250)
        );

        // BUTTONS
        JButton addButton =
                new JButton("Add Student");

        JButton searchButton =
                new JButton("Search Student");

        JButton updateButton =
                new JButton("Update Student");

        JButton deleteButton =
                new JButton("Delete Student");

        JButton roomButton =
                new JButton("Room Status");

        JButton exitButton =
                new JButton("Exit");

        // ADD STUDENT
        addButton.addActionListener(
                e -> openAddStudentWindow()
        );

        // SEARCH STUDENT
        searchButton.addActionListener(
                e -> openSearchStudentWindow()
        );

        // EXIT
        exitButton.addActionListener(
                e -> System.exit(0)
        );

        // ADD BUTTONS
        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(roomButton);
        buttonPanel.add(exitButton);

        mainPanel.add(
                buttonPanel,
                BorderLayout.CENTER
        );

        setContentPane(mainPanel);
    }

    // ADD STUDENT WINDOW
    private void openAddStudentWindow() {

        JFrame addFrame =
                new JFrame("Add Student");

        addFrame.setSize(500, 550);

        addFrame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        addFrame.setLocationRelativeTo(this);

        addFrame.add(
                new AddStudentPanel()
        );

        addFrame.setVisible(true);
    }

    // SEARCH STUDENT WINDOW
    private void openSearchStudentWindow() {

        JFrame searchFrame =
                new JFrame("Search Student");

        searchFrame.setSize(500, 400);

        searchFrame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        searchFrame.setLocationRelativeTo(this);

        searchFrame.add(
                new SearchStudentPanel()
        );

        searchFrame.setVisible(true);
    }
}