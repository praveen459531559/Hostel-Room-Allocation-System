package gui;

import javax.swing.*;
import java.awt.*;

public class AddStudentPanel extends JPanel {

    private JTextField idField;
    private JTextField nameField;
    private JTextField departmentField;

    private JComboBox<String> yearBox;
    private JComboBox<String> roomBox;

    private JLabel statusLabel;


    public AddStudentPanel() {

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
                        "ADD STUDENT",
                        "Register a new student and allocate a hostel room."
                );


        JPanel center =
                new JPanel(
                        new GridBagLayout()
                );

        center.setOpaque(false);


        NeoUI.NeoCard card =
                NeoUI.card();

        card.setLayout(
                new GridBagLayout()
        );

        card.setPreferredSize(
                new Dimension(
                        650,
                        430
                )
        );


        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1;

        gbc.insets =
                new Insets(
                        7,
                        8,
                        7,
                        8
                );


        // ID

        gbc.gridx = 0;
        gbc.gridy = 0;

        card.add(
                NeoUI.label("STUDENT ID"),
                gbc
        );


        gbc.gridx = 1;

        idField =
                NeoUI.field(20);

        card.add(
                idField,
                gbc
        );


        // Name

        gbc.gridx = 0;
        gbc.gridy = 1;

        card.add(
                NeoUI.label("FULL NAME"),
                gbc
        );


        gbc.gridx = 1;

        nameField =
                NeoUI.field(20);

        card.add(
                nameField,
                gbc
        );


        // Department

        gbc.gridx = 0;
        gbc.gridy = 2;

        card.add(
                NeoUI.label("DEPARTMENT"),
                gbc
        );


        gbc.gridx = 1;

        departmentField =
                NeoUI.field(20);

        card.add(
                departmentField,
                gbc
        );


        // Year

        gbc.gridx = 0;
        gbc.gridy = 3;

        card.add(
                NeoUI.label("YEAR"),
                gbc
        );


        gbc.gridx = 1;

        yearBox =
                NeoUI.combo(
                        new String[]{
                                "1",
                                "2",
                                "3",
                                "4"
                        }
                );

        card.add(
                yearBox,
                gbc
        );


        // Room

        gbc.gridx = 0;
        gbc.gridy = 4;

        card.add(
                NeoUI.label("ROOM NUMBER"),
                gbc
        );


        gbc.gridx = 1;

        roomBox =
                NeoUI.combo(
                        createRooms()
                );

        card.add(
                roomBox,
                gbc
        );


        // Status

        gbc.gridx = 0;
        gbc.gridy = 5;

        gbc.gridwidth = 2;

        statusLabel =
                NeoUI.status(
                        "Enter student details and click ADD STUDENT."
                );

        card.add(
                statusLabel,
                gbc
        );


        // Button

        gbc.gridy = 6;

        JButton addButton =
                NeoUI.button(
                        "ADD STUDENT",
                        NeoUI.GREEN
                );

        addButton.setPreferredSize(
                new Dimension(
                        220,
                        50
                )
        );


        addButton.addActionListener(
                e -> addStudent()
        );


        card.add(
                addButton,
                gbc
        );


        center.add(card);


        page.add(
                center,
                BorderLayout.CENTER
        );


        add(page);
    }


    private String[] createRooms() {

        String[] rooms =
                new String[21];

        rooms[0] =
                "NOT ALLOCATED";


        int index = 1;


        for(int i = 1; i <= 10; i++) {

            rooms[index++] =
                    String.format(
                            "F-%02d",
                            i
                    );
        }


        for(int i = 1; i <= 10; i++) {

            rooms[index++] =
                    String.format(
                            "G-%02d",
                            i
                    );
        }


        return rooms;
    }


    private void addStudent() {

        String idText =
                idField
                        .getText()
                        .trim();


        String name =
                nameField
                        .getText()
                        .trim();


        String department =
                departmentField
                        .getText()
                        .trim();


        if(idText.isEmpty()
                || name.isEmpty()
                || department.isEmpty()) {

            showStatus(
                    "Please fill all required fields.",
                    NeoUI.RED
            );

            return;
        }


        int id;


        try {

            id =
                    Integer.parseInt(
                            idText
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


        int year =
                Integer.parseInt(
                        (String)
                                yearBox.getSelectedItem()
                );


        String room =
                (String)
                        roomBox.getSelectedItem();


        String response =
                BackendController.addStudent(
                        id,
                        name,
                        department,
                        year,
                        room
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

            nameField.setText("");

            departmentField.setText("");

            yearBox.setSelectedIndex(0);

            roomBox.setSelectedIndex(0);

        }

        else {

            String message =
                    response == null
                    ?
                    "No response from backend."
                    :
                    response;


            if(message.startsWith("ERROR|")) {

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