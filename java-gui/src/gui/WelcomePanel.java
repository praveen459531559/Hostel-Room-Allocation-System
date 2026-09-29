package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class WelcomePanel extends JPanel {

    // =========================================================
    // COLORS
    // =========================================================

    private static final Color BACKGROUND =
            new Color(218, 223, 229);

    private static final Color SURFACE =
            new Color(218, 223, 229);

    private static final Color TEXT =
            new Color(38, 45, 54);

    private static final Color MUTED =
            new Color(105, 114, 125);

    private static final Color BLUE =
            new Color(48, 105, 170);

    private static final Color BLUE_DARK =
            new Color(38, 86, 142);

    private static final Color GREEN =
            new Color(48, 150, 105);

    private static final Color RED =
            new Color(190, 70, 70);

    private static final Color ORANGE =
            new Color(190, 125, 55);


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public WelcomePanel() {

        setBackground(BACKGROUND);

        setLayout(new GridBagLayout());

        buildUI();
    }


    // =========================================================
    // BUILD UI
    // =========================================================

    private void buildUI() {

        JPanel main =
                new JPanel();

        main.setOpaque(false);

        main.setLayout(
                new BoxLayout(
                        main,
                        BoxLayout.Y_AXIS
                )
        );

        main.setPreferredSize(
                new Dimension(
                        900,
                        650
                )
        );


        // =====================================================
        // HEADER
        // =====================================================

        JLabel icon =
                new JLabel("⌂");

        icon.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        icon.setForeground(BLUE);

        icon.setFont(
                new Font(
                        "Segoe UI Symbol",
                        Font.BOLD,
                        58
                )
        );

        main.add(icon);


        main.add(
                Box.createVerticalStrut(2)
        );


        JLabel title =
                new JLabel(
                        "HOSTEL CONTROL CENTER"
                );

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        title.setForeground(TEXT);

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        34
                )
        );

        main.add(title);


        main.add(
                Box.createVerticalStrut(5)
        );


        JLabel subtitle =
                new JLabel(
                        "ROOM ALLOCATION MANAGEMENT SYSTEM"
                );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        subtitle.setForeground(MUTED);

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        main.add(subtitle);


        main.add(
                Box.createVerticalStrut(30)
        );


        // =====================================================
        // MAIN CONSOLE
        // =====================================================

        NeoPanel console =
                new NeoPanel();

        console.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        console.setLayout(
                new GridLayout(
                        1,
                        2,
                        35,
                        0
                )
        );

        console.setBorder(
                new EmptyBorder(
                        30,
                        35,
                        30,
                        35
                )
        );

        console.setPreferredSize(
                new Dimension(
                        760,
                        290
                )
        );

        console.setMaximumSize(
                new Dimension(
                        760,
                        290
                )
        );


        // =====================================================
        // LEFT SIDE
        // =====================================================

        JPanel left =
                new JPanel();

        left.setOpaque(false);

        left.setLayout(
                new BoxLayout(
                        left,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel welcome =
                new JLabel(
                        "WELCOME, ADMIN"
                );

        welcome.setForeground(TEXT);

        welcome.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        21
                )
        );

        left.add(welcome);


        left.add(
                Box.createVerticalStrut(8)
        );


        JLabel description =
                new JLabel(
                        "<html>"
                        + "Manage students, hostel rooms,<br>"
                        + "and room allocations from one<br>"
                        + "central control system."
                        + "</html>"
                );

        description.setForeground(MUTED);

        description.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        left.add(description);


        left.add(
                Box.createVerticalStrut(25)
        );


        JLabel systemLabel =
                new JLabel(
                        "●  SYSTEM     READY"
                );

        systemLabel.setForeground(GREEN);

        systemLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        left.add(systemLabel);


        left.add(
                Box.createVerticalStrut(10)
        );


        JLabel backendLabel =
                new JLabel(
                        "●  BACKEND    CONNECTED"
                );

        backendLabel.setForeground(GREEN);

        backendLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        left.add(backendLabel);


        left.add(
                Box.createVerticalStrut(10)
        );


        JLabel storageLabel =
                new JLabel(
                        "●  STORAGE    AVAILABLE"
                );

        storageLabel.setForeground(GREEN);

        storageLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        left.add(storageLabel);


        // =====================================================
        // RIGHT SIDE
        // =====================================================

        JPanel right =
                new JPanel();

        right.setOpaque(false);

        right.setLayout(
                new BoxLayout(
                        right,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel controlLabel =
                new JLabel(
                        "CONTROL CENTER"
                );

        controlLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        controlLabel.setForeground(MUTED);

        controlLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        right.add(controlLabel);


        right.add(
                Box.createVerticalStrut(18)
        );


        NeoButton enterButton =
                new NeoButton(
                        "ENTER CONTROL CENTER"
                );

        enterButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        enterButton.setPreferredSize(
                new Dimension(
                        300,
                        58
                )
        );

        enterButton.setMaximumSize(
                new Dimension(
                        300,
                        58
                )
        );

        enterButton.addActionListener(
                e -> openDashboard()
        );

        right.add(enterButton);


        right.add(
                Box.createVerticalStrut(12)
        );


        JLabel hint =
                new JLabel(
                        "Student & Room Management"
                );

        hint.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        hint.setForeground(MUTED);

        hint.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11
                )
        );

        right.add(hint);


        console.add(left);
        console.add(right);

        main.add(console);


        main.add(
                Box.createVerticalStrut(22)
        );


        // =====================================================
        // SYSTEM SPECIFICATIONS
        // =====================================================

        JPanel specifications =
                new JPanel(
                        new GridLayout(
                                1,
                                4,
                                15,
                                0
                        )
                );

        specifications.setOpaque(false);

        specifications.setMaximumSize(
                new Dimension(
                        760,
                        90
                )
        );


        specifications.add(
                createSpecification(
                        "20",
                        "ROOMS",
                        BLUE
                )
        );


        specifications.add(
                createSpecification(
                        "40",
                        "BED CAPACITY",
                        GREEN
                )
        );


        specifications.add(
                createSpecification(
                        "LINKED",
                        "LIST",
                        ORANGE
                )
        );


        specifications.add(
                createSpecification(
                        "HASH",
                        "TABLE",
                        BLUE
                )
        );


        main.add(specifications);


        main.add(
                Box.createVerticalStrut(18)
        );


        // =====================================================
        // LOGOUT
        // =====================================================

        JButton logout =
                new JButton(
                        "LOG OUT"
                );

        logout.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        logout.setForeground(
                new Color(
                        120,
                        70,
                        70
                )
        );

        logout.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11
                )
        );

        logout.setBorder(
                new EmptyBorder(
                        8,
                        20,
                        8,
                        20
                )
        );

        logout.setContentAreaFilled(false);

        logout.setFocusPainted(false);

        logout.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        logout.addActionListener(
                e -> logout()
        );

        main.add(logout);


        // =====================================================
        // CENTER MAIN PANEL
        // =====================================================

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor =
                GridBagConstraints.CENTER;

        add(
                main,
                gbc
        );
    }


    // =========================================================
    // SPECIFICATION PANEL
    // =========================================================

    private JPanel createSpecification(
            String value,
            String label,
            Color accent
    ) {

        NeoPanel panel =
                new NeoPanel();

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        panel.setBorder(
                new EmptyBorder(
                        12,
                        10,
                        10,
                        10
                )
        );


        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        valueLabel.setForeground(accent);

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );


        JLabel labelLabel =
                new JLabel(label);

        labelLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        labelLabel.setForeground(MUTED);

        labelLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        9
                )
        );


        panel.add(valueLabel);

        panel.add(
                Box.createVerticalStrut(2)
        );

        panel.add(labelLabel);


        return panel;
    }


    // =========================================================
    // OPEN DASHBOARD
    // =========================================================

    private void openDashboard() {

    Window window =
            SwingUtilities.getWindowAncestor(
                    this
            );

    if (window != null) {

        window.dispose();
    }


    SwingUtilities.invokeLater(
            () -> {

                try {

                    Dashboard dashboard =
                            new Dashboard();

                    dashboard.setVisible(
                            true
                    );

                }

                catch (Exception exception) {

                    exception.printStackTrace();

                    JOptionPane.showMessageDialog(
                            null,
                            "Dashboard could not be opened.\n\n"
                            + exception.getMessage(),
                            "Dashboard Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
    );
}
    private void logout() {

        Window window =
                SwingUtilities.getWindowAncestor(
                        this
                );

        if(window != null) {

            window.dispose();
        }


        SwingUtilities.invokeLater(
                () -> {

                    JFrame frame =
                            new JFrame(
                                    "Hostel Control System"
                            );

                    frame.setDefaultCloseOperation(
                            JFrame.EXIT_ON_CLOSE
                    );

                    frame.setSize(
                            1100,
                            700
                    );

                    frame.setMinimumSize(
                            new Dimension(
                                    900,
                                    600
                            )
                    );

                    frame.setLocationRelativeTo(null);

                    frame.setContentPane(
                            new LoginPanel()
                    );

                    frame.setVisible(true);
                }
        );
    }


    // =========================================================
    // NEOMORPHIC PANEL
    // =========================================================

    private static class NeoPanel
            extends JPanel {

        public NeoPanel() {

            setOpaque(false);
        }


        @Override
        protected void paintComponent(
                Graphics g
        ) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );


            int width =
                    getWidth();

            int height =
                    getHeight();


            // Shadow

            g2.setColor(
                    new Color(
                            185,
                            191,
                            198,
                            130
                    )
            );

            g2.fillRoundRect(
                    6,
                    7,
                    width - 7,
                    height - 7,
                    26,
                    26
            );


            // Highlight

            g2.setColor(
                    new Color(
                            242,
                            245,
                            248,
                            190
                    )
            );

            g2.fillRoundRect(
                    0,
                    0,
                    width - 7,
                    height - 7,
                    26,
                    26
            );


            // Surface

            g2.setColor(SURFACE);

            g2.fillRoundRect(
                    3,
                    3,
                    width - 11,
                    height - 11,
                    24,
                    24
            );


            g2.dispose();

            super.paintComponent(g);
        }
    }


    // =========================================================
    // NEOMORPHIC BUTTON
    // =========================================================

    private static class NeoButton
            extends JButton {

        private boolean pressed = false;


        public NeoButton(
                String text
        ) {

            super(text);

            setForeground(Color.WHITE);

            setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            14
                    )
            );

            setFocusPainted(false);

            setBorderPainted(false);

            setContentAreaFilled(false);

            setOpaque(false);

            setCursor(
                    new Cursor(
                            Cursor.HAND_CURSOR
                    )
            );


            addMouseListener(
                    new java.awt.event.MouseAdapter() {

                        @Override
                        public void mousePressed(
                                java.awt.event.MouseEvent event
                        ) {

                            pressed = true;

                            repaint();
                        }


                        @Override
                        public void mouseReleased(
                                java.awt.event.MouseEvent event
                        ) {

                            pressed = false;

                            repaint();
                        }


                        @Override
                        public void mouseExited(
                                java.awt.event.MouseEvent event
                        ) {

                            pressed = false;

                            repaint();
                        }
                    }
            );
        }


        @Override
        protected void paintComponent(
                Graphics g
        ) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );


            int offset =
                    pressed
                    ? 3
                    : 0;


            // Shadow

            if(!pressed) {

                g2.setColor(
                        new Color(
                                175,
                                181,
                                188,
                                160
                        )
                );

                g2.fillRoundRect(
                        5,
                        7,
                        getWidth() - 10,
                        getHeight() - 8,
                        16,
                        16
                );
            }


            // Button

            g2.setColor(
                    pressed
                    ? BLUE_DARK
                    : BLUE
            );

            g2.fillRoundRect(
                    2 + offset,
                    2 + offset,
                    getWidth() - 5,
                    getHeight() - 5,
                    16,
                    16
            );


            g2.dispose();

            super.paintComponent(g);
        }
    }
}