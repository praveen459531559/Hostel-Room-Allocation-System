package gui;

import java.awt.*;
import javax.swing.*;

public class UpdateStudentPanel extends JPanel {

    private JTextField idField;
    private JTextField departmentField;

    private JComboBox<String> yearBox;
    private JComboBox<String> roomBox;

    private JLabel statusLabel;


    public UpdateStudentPanel() {

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
                        "UPDATE STUDENT",
                        "Modify department, year and room allocation."
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
                        650,
                        430
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
                        7,
                        8,
                        7,
                        8
                );


        // Student ID

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


        // Department

        gbc.gridx = 0;
        gbc.gridy = 1;

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
        gbc.gridy = 2;

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
        gbc.gridy = 3;

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
        gbc.gridy = 4;

        gbc.gridwidth = 2;

        statusLabel =
                NeoUI.status(
                        "Enter the Student ID and new details."
                );

        card.add(
                statusLabel,
                gbc
        );


        // Button

        gbc.gridy = 5;

        JButton updateButton =
                NeoUI.button(
                        "UPDATE STUDENT",
                        NeoUI.ORANGE
                );

        updateButton.setPreferredSize(
                new Dimension(
                        230,
                        50
                )
        );


        updateButton.addActionListener(
                e -> updateStudent()
        );


        card.add(
                updateButton,
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


    private void updateStudent() {

        String idText =
                idField
                        .getText()
                        .trim();


        String department =
                departmentField
                        .getText()
                        .trim();


        if(
                idText.isEmpty()
                ||
                department.isEmpty()
        ) {

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
                BackendController.updateStudent(
                        id,
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