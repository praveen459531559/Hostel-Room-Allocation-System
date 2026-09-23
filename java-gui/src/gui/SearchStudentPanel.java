package gui;

import java.awt.*;
import javax.swing.*;

public class SearchStudentPanel extends JPanel {

    private JTextField idField;

    public SearchStudentPanel() {

        setLayout(new GridBagLayout());

        setBackground(
                new Color(245, 247, 250)
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(12, 12, 12, 12);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // TITLE
        JLabel title =
                new JLabel("SEARCH STUDENT");

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

        // STUDENT ID LABEL
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;

        add(
                new JLabel("Student ID:"),
                gbc
        );

        // STUDENT ID FIELD
        idField =
                new JTextField(20);

        gbc.gridx = 1;

        add(
                idField,
                gbc
        );

        // SEARCH BUTTON
        JButton searchButton =
                new JButton("SEARCH");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;

        add(
                searchButton,
                gbc
        );

        // CLEAR BUTTON
        JButton clearButton =
                new JButton("CLEAR");

        gbc.gridy = 3;

        add(
                clearButton,
                gbc
        );

        // ACTIONS
        searchButton.addActionListener(
                e -> searchStudent()
        );

        clearButton.addActionListener(
                e -> clearField()
        );
    }

    private void searchStudent() {

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

            JOptionPane.showMessageDialog(
                    this,

                    "Search request accepted!\n\n"
                    + "Student ID: "
                    + studentID
                    + "\n\n"
                    + "C backend connection "
                    + "will be added next.",

                    "Search Student",

                    JOptionPane.INFORMATION_MESSAGE
            );

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