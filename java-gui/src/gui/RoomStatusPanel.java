package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RoomStatusPanel extends JPanel {

    private JTextArea roomArea;

    private JLabel statusLabel;


    public RoomStatusPanel() {

        setBackground(
                NeoUI.BG
        );

        setLayout(
                new BorderLayout()
        );

        buildUI();

        refreshRooms();
    }


    private void buildUI() {

        JPanel page =
                NeoUI.page(
                        "ROOM STATUS",
                        "View the live allocation status of all hostel rooms."
                );


        JPanel center =
                new JPanel(
                        new BorderLayout(
                                0,
                                15
                        )
                );

        center.setOpaque(false);


        // =====================================================
        // TOP CONTROL
        // =====================================================

        NeoUI.NeoCard control =
                NeoUI.card();

        control.setLayout(
                new BorderLayout(
                        15,
                        0
                )
        );

        control.setBorder(
                new EmptyBorder(
                        14,
                        18,
                        14,
                        18
                )
        );


        JLabel title =
                new JLabel(
                        "LIVE ROOM ALLOCATION"
                );

        title.setForeground(
                NeoUI.TEXT
        );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );


        JPanel right =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        right.setOpaque(false);


        statusLabel =
                NeoUI.status(
                        "Ready"
                );


        JButton refresh =
                NeoUI.button(
                        "REFRESH ROOMS",
                        NeoUI.BLUE
                );

        refresh.setPreferredSize(
                new Dimension(
                        160,
                        42
                )
        );


        refresh.addActionListener(
                e -> refreshRooms()
        );


        right.add(statusLabel);

        right.add(refresh);


        control.add(
                title,
                BorderLayout.WEST
        );


        control.add(
                right,
                BorderLayout.EAST
        );


        center.add(
                control,
                BorderLayout.NORTH
        );


        // =====================================================
        // ROOM DISPLAY
        // =====================================================

        NeoUI.NeoCard display =
                NeoUI.card();

        display.setLayout(
                new BorderLayout()
        );


        JLabel displayTitle =
                new JLabel(
                        "ROOM MAP / BACKEND DATA"
                );

        displayTitle.setForeground(
                NeoUI.TEXT
        );

        displayTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        display.add(
                displayTitle,
                BorderLayout.NORTH
        );


        roomArea =
                new JTextArea();


        roomArea.setEditable(
                false
        );

        roomArea.setFocusable(
                false
        );

        roomArea.setBackground(
                new Color(
                        202,
                        208,
                        215
                )
        );

        roomArea.setForeground(
                NeoUI.TEXT
        );

        roomArea.setFont(
                new Font(
                        "Consolas",
                        Font.PLAIN,
                        14
                )
        );

        roomArea.setMargin(
                new Insets(
                        18,
                        18,
                        18,
                        18
                )
        );


        JScrollPane scroll =
                new JScrollPane(
                        roomArea
                );

        scroll.setBorder(
                BorderFactory.createEmptyBorder()
        );


        display.add(
                scroll,
                BorderLayout.CENTER
        );


        center.add(
                display,
                BorderLayout.CENTER
        );


        page.add(
                center,
                BorderLayout.CENTER
        );


        add(page);
    }


    private void refreshRooms() {

        statusLabel.setText(
                "Loading..."
        );

        statusLabel.setForeground(
                NeoUI.BLUE
        );


        String response =
                BackendController.getRoomStatus();


        if(
                response == null
                ||
                response.startsWith(
                        "ERROR|"
                )
        ) {

            roomArea.setText(
                    response == null
                    ?
                    "No response received from backend."
                    :
                    response.substring(
                            "ERROR|".length()
                    )
            );


            statusLabel.setText(
                    "Backend error"
            );

            statusLabel.setForeground(
                    NeoUI.RED
            );

            return;
        }


        roomArea.setText(
                formatRoomData(
                        response
                )
        );


        roomArea.setCaretPosition(
                0
        );


        statusLabel.setText(
                "● LIVE"
        );

        statusLabel.setForeground(
                NeoUI.GREEN
        );
    }


    private String formatRoomData(
            String data
    ) {

        String[] lines =
                data.split(
                        "\\R"
                );


        StringBuilder result =
                new StringBuilder();


        result.append(
                "HOSTEL ROOM STATUS\n"
        );

        result.append(
                "==============================\n\n"
        );


        for(
                String line :
                lines
        ) {

            result.append(
                    line
            );

            result.append(
                    "\n"
            );
        }


        result.append(
                "\n==============================\n"
        );

        result.append(
                "F BLOCK : F-01 to F-10\n"
        );

        result.append(
                "G BLOCK : G-01 to G-10\n"
        );

        result.append(
                "CAPACITY: 2 students per room\n"
        );


        return result.toString();
    }
}