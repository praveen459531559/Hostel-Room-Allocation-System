package gui;

import java.awt.*;
import javax.swing.*;

public class DeleteStudentPanel extends JPanel {

    private JTextField idField;

    public DeleteStudentPanel() {

        setLayout(new GridBagLayout());

        setBackground(new Color(245, 247, 250));

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(12, 12, 12, 12);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====

        JLabel title =
                new JLabel("DELETE STUDENT");

        title.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        add(title, gbc);

        // ===== STUDENT ID =====

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;

        add(
                new JLabel("Student ID:"),
                gbc
        );

        idField =
                new JTextField(20);

        gbc.gridx = 1;

        add(
                idField,
                gbc
        );

        // ===== DELETE BUTTON =====

        JButton deleteButton =
                new JButton("DELETE STUDENT");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;

        add(
                deleteButton,
                gbc
        );

        // ===== CLEAR BUTTON =====

        JButton clearButton =
                new JButton("CLEAR");

        gbc.gridy = 3;

        add(
                clearButton,
                gbc
        );

        // ===== ACTIONS =====

        deleteButton.addActionListener(
                e -> deleteStudent()
        );

        clearButton.addActionListener(
                e -> clearField()
        );
    }

    private void deleteStudent() {

        String id =
                idField.getText().trim();

        if (id.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a Student ID.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            int studentID =
                    Integer.parseInt(id);

            int choice =
                    JOptionPane.showConfirmDialog(
                            this,

                            "Are you sure you want to delete\n"
                            + "Student ID: " + studentID + "?",

                            "Confirm Delete",

                            JOptionPane.YES_NO_OPTION,

                            JOptionPane.WARNING_MESSAGE
                    );

            if (choice == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(
                        this,

                        "Delete request accepted!\n\n"
                        + "Student ID: "
                        + studentID
                        + "\n\n"
                        + "C backend connection "
                        + "will be added later.",

                        "Delete Student",

                        JOptionPane.INFORMATION_MESSAGE
                );

                clearField();
            }

        }
        catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,

                    "Student ID must be a number.",

                    "Invalid Input",

                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void clearField() {

        idField.setText("");
    }
}