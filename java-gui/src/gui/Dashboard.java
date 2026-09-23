package gui;

import java.awt.*;
import javax.swing.*;

public class Dashboard extends JFrame {

    public Dashboard() {

        setTitle("Hostel Room Allocation System");

        setSize(900, 600);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        // ===== MAIN PANEL =====

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(
                new Color(245, 247, 250)
        );

        // ===== TITLE =====

        JLabel title =
                new JLabel(
                        "HOSTEL ROOM ALLOCATION SYSTEM"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        26
                )
        );

        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        title.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 10, 25, 10
                )
        );

        mainPanel.add(
                title,
                BorderLayout.NORTH
        );

        // ===== BUTTON PANEL =====

        JPanel buttonPanel =
                new JPanel(
                        new GridLayout(
                                2,
                                3,
                                20,
                                20
                        )
                );

        buttonPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        50,
                        30,
                        50
                )
        );

        buttonPanel.setBackground(
                new Color(245, 247, 250)
        );

        // ===== BUTTONS =====

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

        // ===== BUTTON ACTIONS =====

        addButton.addActionListener(
                e -> openAddStudentWindow()
        );

        searchButton.addActionListener(
                e -> openSearchStudentWindow()
        );

        updateButton.addActionListener(
                e -> openUpdateStudentWindow()
        );

        deleteButton.addActionListener(
                e -> openDeleteStudentWindow()
        );

        roomButton.addActionListener(
                e -> openRoomStatusWindow()
        );

        exitButton.addActionListener(
                e -> System.exit(0)
        );

        // ===== ADD BUTTONS =====

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

    // =====================================================
    // ADD STUDENT
    // =====================================================

    private void openAddStudentWindow() {

        JFrame addFrame =
                new JFrame("Add Student");

        addFrame.setSize(
                500,
                550
        );

        addFrame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        addFrame.setLocationRelativeTo(this);

        addFrame.add(
                new AddStudentPanel()
        );

        addFrame.setVisible(true);
    }

    // =====================================================
    // SEARCH STUDENT
    // =====================================================

    private void openSearchStudentWindow() {

        JFrame searchFrame =
                new JFrame("Search Student");

        searchFrame.setSize(
                500,
                400
        );

        searchFrame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        searchFrame.setLocationRelativeTo(this);

        searchFrame.add(
                new SearchStudentPanel()
        );

        searchFrame.setVisible(true);
    }

    // =====================================================
    // UPDATE STUDENT
    // =====================================================

    private void openUpdateStudentWindow() {

        JFrame updateFrame =
                new JFrame("Update Student");

        updateFrame.setSize(
                500,
                500
        );

        updateFrame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        updateFrame.setLocationRelativeTo(this);

        updateFrame.add(
                new UpdateStudentPanel()
        );

        updateFrame.setVisible(true);
    }

    // =====================================================
    // DELETE STUDENT
    // =====================================================

    private void openDeleteStudentWindow() {

        JFrame deleteFrame =
                new JFrame("Delete Student");

        deleteFrame.setSize(
                500,
                350
        );

        deleteFrame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        deleteFrame.setLocationRelativeTo(this);

        deleteFrame.add(
                new DeleteStudentPanel()
        );

        deleteFrame.setVisible(true);
    }

    // =====================================================
    // ROOM STATUS
    // =====================================================

    private void openRoomStatusWindow() {

        JFrame roomFrame =
                new JFrame("Room Status");

        roomFrame.setSize(
                650,
                600
        );

        roomFrame.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        roomFrame.setLocationRelativeTo(this);

        roomFrame.add(
                new RoomStatusPanel()
        );

        roomFrame.setVisible(true);
    }
}