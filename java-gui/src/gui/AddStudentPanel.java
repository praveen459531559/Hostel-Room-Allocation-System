package gui;

import java.awt.*;
import javax.swing.*;

public class AddStudentPanel extends JPanel {

    private JTextField idField;
    private JTextField nameField;
    private JTextField departmentField;
    private JTextField yearField;

    private JComboBox<String> roomBox;

    public AddStudentPanel() {

        setLayout(new GridBagLayout());

        setBackground(
                new Color(245, 247, 250)
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(10, 10, 10, 10);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // ==========================
        // TITLE
        // ==========================

        JLabel title =
                new JLabel("ADD NEW STUDENT");

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

        gbc.gridwidth = 1;

        // ==========================
        // STUDENT ID
        // ==========================

        gbc.gridx = 0;
        gbc.gridy = 1;

        add(new JLabel("Student ID:"), gbc);

        idField =
                new JTextField(20);

        gbc.gridx = 1;

        add(idField, gbc);

        // ==========================
        // NAME
        // ==========================

        gbc.gridx = 0;
        gbc.gridy = 2;

        add(new JLabel("Name:"), gbc);

        nameField =
                new JTextField(20);

        gbc.gridx = 1;

        add(nameField, gbc);

        // ==========================
        // DEPARTMENT
        // ==========================

        gbc.gridx = 0;
        gbc.gridy = 3;

        add(new JLabel("Department:"), gbc);

        departmentField =
                new JTextField(20);

        gbc.gridx = 1;

        add(departmentField, gbc);

        // ==========================
        // YEAR
        // ==========================

        gbc.gridx = 0;
        gbc.gridy = 4;

        add(new JLabel("Year:"), gbc);

        yearField =
                new JTextField(20);

        gbc.gridx = 1;

        add(yearField, gbc);

        // ==========================
        // ROOM
        // ==========================

        gbc.gridx = 0;
        gbc.gridy = 5;

        add(new JLabel("Room:"), gbc);

        String[] rooms = {

                "NOT ALLOCATED",

                "F-01",
                "F-02",
                "F-03",
                "F-04",
                "F-05",
                "F-06",
                "F-07",
                "F-08",
                "F-09",
                "F-10",

                "G-01",
                "G-02",
                "G-03",
                "G-04",
                "G-05",
                "G-06",
                "G-07",
                "G-08",
                "G-09",
                "G-10"
        };

        roomBox =
                new JComboBox<>(rooms);

        gbc.gridx = 1;

        add(roomBox, gbc);

        // ==========================
        // ADD BUTTON
        // ==========================

        JButton addButton =
                new JButton("ADD STUDENT");

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;

        add(addButton, gbc);

        // ==========================
        // CLEAR BUTTON
        // ==========================

        JButton clearButton =
                new JButton("CLEAR");

        gbc.gridy = 7;

        add(clearButton, gbc);

        // ==========================
        // BUTTON ACTIONS
        // ==========================

        addButton.addActionListener(
                e -> addStudent()
        );

        clearButton.addActionListener(
                e -> clearFields()
        );
    }

    // ==============================
    // ADD STUDENT
    // ==============================

    private void addStudent() {

        String id =
                idField.getText().trim();

        String name =
                nameField.getText().trim();

        String department =
                departmentField.getText().trim();

        String year =
                yearField.getText().trim();

        String room =
                (String) roomBox.getSelectedItem();

        // Check empty fields

        if (id.isEmpty()
                || name.isEmpty()
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

         long studentID =
        Long.parseLong(id);

            int studentYear =
                    Integer.parseInt(year);

            // Validate year

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

            // Temporary success message

            JOptionPane.showMessageDialog(
                    this,

                    "Student details accepted!\n\n"
                            + "ID: " + studentID + "\n"
                            + "Name: " + name + "\n"
                            + "Department: " + department + "\n"
                            + "Year: " + studentYear + "\n"
                            + "Room: " + room,

                    "Success",

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

    // ==============================
    // CLEAR FIELDS
    // ==============================

    private void clearFields() {

        idField.setText("");

        nameField.setText("");

        departmentField.setText("");

        yearField.setText("");

        roomBox.setSelectedIndex(0);
    }
}