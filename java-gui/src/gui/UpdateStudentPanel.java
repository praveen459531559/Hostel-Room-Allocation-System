package gui;

import javax.swing.*;
import java.awt.*;

public class UpdateStudentPanel extends JPanel {

    private JTextField idField;
    private JTextField departmentField;
    private JTextField yearField;

    private JComboBox<String> roomBox;

    public UpdateStudentPanel() {

        setLayout(new GridBagLayout());

        setBackground(new Color(245, 247, 250));

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(10, 10, 10, 10);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // ===== TITLE =====

        JLabel title =
                new JLabel("UPDATE STUDENT");

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

        add(idField, gbc);

        // ===== DEPARTMENT =====

        gbc.gridx = 0;
        gbc.gridy = 2;

        add(
                new JLabel("Department:"),
                gbc
        );

        departmentField =
                new JTextField(20);

        gbc.gridx = 1;

        add(
                departmentField,
                gbc
        );

        // ===== YEAR =====

        gbc.gridx = 0;
        gbc.gridy = 3;

        add(
                new JLabel("Year:"),
                gbc
        );

        yearField =
                new JTextField(20);

        gbc.gridx = 1;

        add(
                yearField,
                gbc
        );

        // ===== ROOM =====

        gbc.gridx = 0;
        gbc.gridy = 4;

        add(
                new JLabel("Room:"),
                gbc
        );

        String[] rooms = {

            "NOT ALLOCATED",

            "F-01", "F-02", "F-03", "F-04", "F-05",
            "F-06", "F-07", "F-08", "F-09", "F-10",

            "G-01", "G-02", "G-03", "G-04", "G-05",
            "G-06", "G-07", "G-08", "G-09", "G-10"
        };

        roomBox =
                new JComboBox<>(rooms);

        gbc.gridx = 1;

        add(
                roomBox,
                gbc
        );

        // ===== UPDATE BUTTON =====

        JButton updateButton =
                new JButton("UPDATE STUDENT");

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;

        add(
                updateButton,
                gbc
        );

        // ===== CLEAR BUTTON =====

        JButton clearButton =
                new JButton("CLEAR");

        gbc.gridy = 6;

        add(
                clearButton,
                gbc
        );

        // ===== ACTIONS =====

        updateButton.addActionListener(
                e -> updateStudent()
        );

        clearButton.addActionListener(
                e -> clearFields()
        );
    }

    private void updateStudent() {

        String id =
                idField.getText().trim();

        String department =
                departmentField.getText().trim();

        String year =
                yearField.getText().trim();

        String room =
                (String) roomBox.getSelectedItem();

        // ===== VALIDATION =====

        if (id.isEmpty()
                || department.isEmpty()
                || year.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all required fields.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            int studentID =
                    Integer.parseInt(id);

            int studentYear =
                    Integer.parseInt(year);

            if (studentYear < 1
                    || studentYear > 4) {

                JOptionPane.showMessageDialog(
                        this,
                        "Year must be between 1 and 4.",
                        "Invalid Year",
                        JOptionPane.ERROR_MESSAGE
                );

                return;
            }

            // Temporary GUI confirmation.
            // C backend connection will be added later.

            JOptionPane.showMessageDialog(
                    this,

                    "Student update request accepted!\n\n"
                    + "Student ID: "
                    + studentID
                    + "\n"
                    + "Department: "
                    + department
                    + "\n"
                    + "Year: "
                    + studentYear
                    + "\n"
                    + "Room: "
                    + room
                    + "\n\n"
                    + "C backend connection "
                    + "will be added later.",

                    "Update Student",

                    JOptionPane.INFORMATION_MESSAGE
            );

            clearFields();

        }
        catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,

                    "Student ID and Year must be numbers.",

                    "Invalid Input",

                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void clearFields() {

        idField.setText("");

        departmentField.setText("");

        yearField.setText("");

        roomBox.setSelectedIndex(0);
    }
}