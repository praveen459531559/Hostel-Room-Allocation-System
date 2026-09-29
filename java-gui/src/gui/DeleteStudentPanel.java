package gui;

import java.awt.*;
import javax.swing.*;

public class DeleteStudentPanel extends JPanel {

    private JTextField idField;

    private JLabel statusLabel;


    public DeleteStudentPanel() {

        setBackground(
                NeoUI.BG
        );

        setLayout(
                new BorderLayout()
        );

        buildUI();
    }


    private void buildUI() {

        JPanel page =
                NeoUI.page(
                        "DELETE STUDENT",
                        "Remove a student record from the hostel system."
                );


        JPanel center =
                new JPanel(
                        new GridBagLayout()
                );

        center.setOpaque(false);


        NeoUI.NeoCard card =
                NeoUI.card();

        card.setPreferredSize(
                new Dimension(
                        600,
                        330
                )
        );


        card.setLayout(
                new GridBagLayout()
        );


        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1;

        gbc.insets =
                new Insets(
                        10,
                        10,
                        10,
                        10
                );


        // Warning

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.gridwidth = 2;


        JLabel warning =
                new JLabel(
                        "⚠  DELETE STUDENT RECORD"
                );

        warning.setForeground(
                NeoUI.RED
        );

        warning.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );


        card.add(
                warning,
                gbc
        );


        // Description

        gbc.gridy = 1;


        JLabel description =
                new JLabel(
                        "<html>This action removes the student from the "
                        + "linked list and hash table.</html>"
                );

        description.setForeground(
                NeoUI.MUTED
        );

        description.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );


        card.add(
                description,
                gbc
        );


        // ID

        gbc.gridy = 2;

        gbc.gridwidth = 1;

        gbc.gridx = 0;


        card.add(
                NeoUI.label("STUDENT ID"),
                gbc
        );


        gbc.gridx = 1;


        idField =
                NeoUI.field(18);


        card.add(
                idField,
                gbc
        );


        // Status

        gbc.gridx = 0;

        gbc.gridy = 3;

        gbc.gridwidth = 2;


        statusLabel =
                NeoUI.status(
                        "Enter the Student ID to remove."
                );


        card.add(
                statusLabel,
                gbc
        );


        // Delete

        gbc.gridy = 4;


        JButton deleteButton =
                NeoUI.button(
                        "DELETE STUDENT",
                        NeoUI.RED
                );


        deleteButton.setPreferredSize(
                new Dimension(
                        230,
                        50
                )
        );


        deleteButton.addActionListener(
                e -> deleteStudent()
        );


        card.add(
                deleteButton,
                gbc
        );


        center.add(card);


        page.add(
                center,
                BorderLayout.CENTER
        );


        add(page);
    }


    private void deleteStudent() {

        String text =
                idField
                        .getText()
                        .trim();


        if(text.isEmpty()) {

            showStatus(
                    "Please enter a Student ID.",
                    NeoUI.RED
            );

            return;
        }


        int id;


        try {

            id =
                    Integer.parseInt(
                            text
                    );

        }

        catch(
                NumberFormatException e
        ) {

            showStatus(
                    "Student ID must contain numbers only.",
                    NeoUI.RED
            );

            return;
        }


        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Delete student " + id + "?\n\n"
                        + "This action cannot be undone.",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );


        if(
                choice !=
                JOptionPane.YES_OPTION
        ) {

            return;
        }


        String response =
                BackendController.deleteStudent(
                        id
                );


        if(
                response != null
                &&
                response.startsWith(
                        "SUCCESS|"
                )
        ) {

            showStatus(
                    "✓ " +
                    response.substring(
                            "SUCCESS|".length()
                    ),
                    NeoUI.GREEN
            );


            idField.setText("");

        }

        else {

            String message =
                    response == null
                    ?
                    "No response from backend."
                    :
                    response;


            if(
                    message.startsWith(
                            "ERROR|"
                    )
            ) {

                message =
                        message.substring(
                                "ERROR|".length()
                        );
            }


            showStatus(
                    "✕ " + message,
                    NeoUI.RED
            );
        }
    }


    private void showStatus(
            String text,
            Color color
    ) {

        statusLabel.setText(text);

        statusLabel.setForeground(color);
    }
}