package gui;

import java.awt.*;
import javax.swing.*;

public class RoomStatusPanel extends JPanel {

    private JTextArea roomArea;

    public RoomStatusPanel() {

        setLayout(new BorderLayout(15, 15));

        setBackground(new Color(245, 247, 250));

        setBorder(
                BorderFactory.createEmptyBorder(
                        20, 25, 20, 25
                )
        );

        // ===== TITLE =====

        JLabel title =
                new JLabel("ROOM STATUS");

        title.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        add(title, BorderLayout.NORTH);

        // ===== ROOM DISPLAY =====

        roomArea =
                new JTextArea();

        roomArea.setFont(
                new Font("Monospaced", Font.PLAIN, 15)
        );

        roomArea.setEditable(false);

        roomArea.setBackground(Color.WHITE);

        roomArea.setBorder(
                BorderFactory.createLineBorder(
                        new Color(210, 215, 220)
                )
        );

        loadRoomStatus();

        JScrollPane scrollPane =
                new JScrollPane(roomArea);

        add(
                scrollPane,
                BorderLayout.CENTER
        );

        // ===== REFRESH BUTTON =====

        JButton refreshButton =
                new JButton("REFRESH");

        refreshButton.addActionListener(
                e -> loadRoomStatus()
        );

        JPanel bottomPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER
                        )
                );

        bottomPanel.setBackground(
                new Color(245, 247, 250)
        );

        bottomPanel.add(refreshButton);

        add(
                bottomPanel,
                BorderLayout.SOUTH
        );
    }

    private void loadRoomStatus() {

        StringBuilder rooms =
                new StringBuilder();

        rooms.append(
                "              HOSTEL ROOM STATUS\n"
        );

        rooms.append(
                "============================================\n\n"
        );

        rooms.append(
                "F BLOCK\n"
        );

        rooms.append(
                "--------------------------------------------\n"
        );

        for (int i = 1; i <= 10; i++) {

            rooms.append(
                    String.format(
                            "F-%02d     Capacity: 2     Status: AVAILABLE%n",
                            i
                    )
            );
        }

        rooms.append(
                "\nG BLOCK\n"
        );

        rooms.append(
                "--------------------------------------------\n"
        );

        for (int i = 1; i <= 10; i++) {

            rooms.append(
                    String.format(
                            "G-%02d     Capacity: 2     Status: AVAILABLE%n",
                            i
                    )
            );
        }

        rooms.append(
                "\n============================================\n"
        );

        rooms.append(
                "Total Rooms : 20\n"
        );

        rooms.append(
                "Capacity    : 40 Students\n"
        );

        roomArea.setText(
                rooms.toString()
        );
    }
}