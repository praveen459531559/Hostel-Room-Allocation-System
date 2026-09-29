package gui;

import java.awt.*;
import javax.swing.*;

public class SearchStudentPanel extends JPanel {

    private JTextField idField;

    private JLabel statusLabel;

    private JLabel idValue;
    private JLabel nameValue;
    private JLabel departmentValue;
    private JLabel yearValue;
    private JLabel roomValue;


    public SearchStudentPanel() {

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
                        "SEARCH STUDENT",
                        "Find complete student information using Student ID."
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
                        700,
                        500
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


        // Search button

        gbc.gridx = 2;

        JButton searchButton =
                NeoUI.button(
                        "SEARCH",
                        NeoUI.BLUE
                );

        searchButton.setPreferredSize(
                new Dimension(
                        130,
                        45
                )
        );


        searchButton.addActionListener(
                e -> searchStudent()
        );


        card.add(
                searchButton,
                gbc
        );


        // Result title

        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.gridwidth = 3;

        JLabel resultTitle =
                new JLabel(
                        "STUDENT RECORD"
                );

        resultTitle.setForeground(
                NeoUI.TEXT
        );

        resultTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );


        card.add(
                resultTitle,
                gbc
        );


        // Details

        gbc.gridy = 2;

        gbc.gridwidth = 3;


        JPanel details =
                new JPanel(
                        new GridLayout(
                                5,
                                2,
                                10,
                                10
                        )
                );

        details.setOpaque(false);


        idValue =
                createValue("—");

        nameValue =
                createValue("—");

        departmentValue =
                createValue("—");

        yearValue =
                createValue("—");

        roomValue =
                createValue("—");


        details.add(
                createDetail(
                        "STUDENT ID",
                        idValue
                )
        );


        details.add(
                createDetail(
                        "NAME",
                        nameValue
                )
        );


        details.add(
                createDetail(
                        "DEPARTMENT",
                        departmentValue
                )
        );


        details.add(
                createDetail(
                        "YEAR",
                        yearValue
                )
        );


        details.add(
                createDetail(
                        "ROOM",
                        roomValue
                )
        );


        card.add(
                details,
                gbc
        );


        // Status

        gbc.gridy = 3;

        statusLabel =
                NeoUI.status(
                        "Enter a Student ID and click SEARCH."
                );

        card.add(
                statusLabel,
                gbc
        );


        center.add(card);


        page.add(
                center,
                BorderLayout.CENTER
        );


        add(page);


        idField.addActionListener(
                e -> searchStudent()
        );
    }


    private JPanel createDetail(
            String title,
            JLabel value
    ) {

        NeoUI.NeoCard card =
                NeoUI.card();


        card.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        14,
                        10,
                        14
                )
        );


        card.setLayout(
                new BorderLayout()
        );


        JPanel text =
                new JPanel();

        text.setOpaque(false);

        text.setLayout(
                new BoxLayout(
                        text,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel titleLabel =
                NeoUI.label(title);


        text.add(titleLabel);

        text.add(
                Box.createVerticalStrut(3)
        );

        text.add(value);


        card.add(
                text,
                BorderLayout.CENTER
        );


        return card;
    }


    private JLabel createValue(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setForeground(
                NeoUI.TEXT
        );

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );


        return label;
    }


    private void searchStudent() {

        String text =
                idField
                        .getText()
                        .trim();


        if(text.isEmpty()) {

            showStatus(
                    "Please enter a Student ID.",
                    NeoUI.RED
            );

            clear();

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

            clear();

            return;
        }


        String response =
                BackendController.searchStudent(
                        id
                );


        if(
                response != null
                &&
                response.startsWith(
                        "FOUND|"
                )
        ) {

            String data =
                    response.substring(
                            "FOUND|".length()
                    );


            String[] parts =
                    data.split(
                            "\\|",
                            -1
                    );


            if(parts.length >= 5) {

                idValue.setText(
                        parts[0]
                );

                nameValue.setText(
                        parts[1]
                );

                departmentValue.setText(
                        parts[2]
                );

                yearValue.setText(
                        parts[3]
                );

                roomValue.setText(
                        parts[4]
                );


                showStatus(
                        "✓ Student record found.",
                        NeoUI.GREEN
                );

            }

            else {

                showStatus(
                        "Invalid data received from backend.",
                        NeoUI.RED
                );
            }

        }

        else {

            clear();


            showStatus(
                    "✕ Student not found.",
                    NeoUI.RED
            );
        }
    }


    private void clear() {

        idValue.setText("—");

        nameValue.setText("—");

        departmentValue.setText("—");

        yearValue.setText("—");

        roomValue.setText("—");
    }


    private void showStatus(
            String text,
            Color color
    ) {

        statusLabel.setText(text);

        statusLabel.setForeground(color);
    }
}