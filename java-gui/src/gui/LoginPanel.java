package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginPanel extends JPanel {

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


    // =========================================================
    // COMPONENTS
    // =========================================================

    private JTextField usernameField;
    private JPasswordField passwordField;

    private JCheckBox showPassword;

    private JLabel statusLabel;

    private JButton loginButton;


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public LoginPanel() {

        setBackground(
                BACKGROUND
        );

        setLayout(
                new GridBagLayout()
        );

        buildUI();
    }


    // =========================================================
    // BUILD UI
    // =========================================================

    private void buildUI() {

        JPanel mainPanel =
                new JPanel();

        mainPanel.setOpaque(false);

        mainPanel.setLayout(
                new BoxLayout(
                        mainPanel,
                        BoxLayout.Y_AXIS
                )
        );

        mainPanel.setPreferredSize(
                new Dimension(
                        520,
                        680
                )
        );


        // =====================================================
        // HOME ICON
        // =====================================================

        JLabel icon =
                new JLabel("⌂");

        icon.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        icon.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        icon.setForeground(
                BLUE
        );

        icon.setFont(
                new Font(
                        "Segoe UI Symbol",
                        Font.BOLD,
                        60
                )
        );

        mainPanel.add(icon);


        mainPanel.add(
                Box.createVerticalStrut(4)
        );


        // =====================================================
        // TITLE
        // =====================================================

        JLabel title =
                new JLabel(
                        "HOSTEL CONTROL"
                );

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        title.setForeground(
                TEXT
        );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        36
                )
        );

        mainPanel.add(title);


        mainPanel.add(
                Box.createVerticalStrut(5)
        );


        // =====================================================
        // SUBTITLE
        // =====================================================

        JLabel subtitle =
                new JLabel(
                        "ROOM ALLOCATION SYSTEM"
                );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        subtitle.setForeground(
                MUTED
        );

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        mainPanel.add(subtitle);


        mainPanel.add(
                Box.createVerticalStrut(35)
        );


        // =====================================================
        // LOGIN PANEL
        // =====================================================

        NeoPanel loginPanel =
                new NeoPanel();

        loginPanel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        loginPanel.setLayout(
                new BoxLayout(
                        loginPanel,
                        BoxLayout.Y_AXIS
                )
        );

        loginPanel.setBorder(
                new EmptyBorder(
                        30,
                        34,
                        28,
                        34
                )
        );

        loginPanel.setPreferredSize(
                new Dimension(
                        460,
                        370
                )
        );

        loginPanel.setMaximumSize(
                new Dimension(
                        460,
                        370
                )
        );


        // =====================================================
        // SYSTEM ACCESS
        // =====================================================

        JLabel loginTitle =
                new JLabel(
                        "SYSTEM ACCESS"
                );

        loginTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        loginTitle.setForeground(
                TEXT
        );

        loginTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        19
                )
        );

        loginPanel.add(loginTitle);


        loginPanel.add(
                Box.createVerticalStrut(22)
        );


        // =====================================================
        // USERNAME
        // =====================================================

        JLabel usernameLabel =
                createLabel(
                        "USERNAME"
                );

        usernameLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        loginPanel.add(usernameLabel);


        loginPanel.add(
                Box.createVerticalStrut(7)
        );


        usernameField =
                createTextField();

        usernameField.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        loginPanel.add(usernameField);


        loginPanel.add(
                Box.createVerticalStrut(18)
        );


        // =====================================================
        // PASSWORD
        // =====================================================

        JLabel passwordLabel =
                createLabel(
                        "PASSWORD"
                );

        passwordLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        loginPanel.add(passwordLabel);


        loginPanel.add(
                Box.createVerticalStrut(7)
        );


        passwordField =
                createPasswordField();

        passwordField.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        loginPanel.add(passwordField);


        loginPanel.add(
                Box.createVerticalStrut(8)
        );


        // =====================================================
        // SHOW PASSWORD
        // =====================================================

        showPassword =
                new JCheckBox(
                        "Show password"
                );

        showPassword.setOpaque(false);

        showPassword.setForeground(
                MUTED
        );

        showPassword.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        showPassword.setFocusPainted(false);

        showPassword.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        showPassword.addActionListener(
                e -> togglePassword()
        );

        loginPanel.add(showPassword);


        loginPanel.add(
                Box.createVerticalStrut(18)
        );


        // =====================================================
        // LOGIN BUTTON
        // =====================================================

        loginButton =
                new NeoButton(
                        "LOGIN"
                );

        loginButton.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        loginButton.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        54
                )
        );

        loginButton.setPreferredSize(
                new Dimension(
                        390,
                        54
                )
        );

        loginButton.addActionListener(
                this::performLogin
        );

        loginPanel.add(loginButton);


        loginPanel.add(
                Box.createVerticalStrut(13)
        );


        // =====================================================
        // STATUS
        // =====================================================

        statusLabel =
                new JLabel(
                        "Enter your credentials to continue."
                );

        statusLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        statusLabel.setForeground(
                MUTED
        );

        statusLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        loginPanel.add(statusLabel);


        mainPanel.add(loginPanel);


        mainPanel.add(
                Box.createVerticalStrut(27)
        );


        // =====================================================
        // SYSTEM STATUS
        // =====================================================

        JPanel systemStatus =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                8,
                                0
                        )
                );

        systemStatus.setOpaque(false);


        JLabel dot =
                new JLabel("●");

        dot.setForeground(
                GREEN
        );

        dot.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );


        JLabel systemText =
                new JLabel(
                        "HOSTEL MANAGEMENT SYSTEM"
                );

        systemText.setForeground(
                MUTED
        );

        systemText.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11
                )
        );


        systemStatus.add(dot);

        systemStatus.add(systemText);

        systemStatus.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        mainPanel.add(systemStatus);


        // =====================================================
        // CENTER
        // =====================================================

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.anchor =
                GridBagConstraints.CENTER;


        add(
                mainPanel,
                gbc
        );
    }


    // =========================================================
    // LOGIN
    // =========================================================

    private void performLogin(
            ActionEvent event
    ) {

        String username =
                usernameField
                        .getText()
                        .trim();


        String password =
                new String(
                        passwordField
                                .getPassword()
                );


        // -----------------------------------------------------
        // EMPTY USERNAME
        // -----------------------------------------------------

        if(username.isEmpty()) {

            showStatus(
                    "Please enter your username.",
                    RED
            );

            usernameField.requestFocus();

            return;
        }


        // -----------------------------------------------------
        // EMPTY PASSWORD
        // -----------------------------------------------------

        if(password.isEmpty()) {

            showStatus(
                    "Please enter your password.",
                    RED
            );

            passwordField.requestFocus();

            return;
        }


        // -----------------------------------------------------
        // AUTHENTICATION
        // -----------------------------------------------------

        if(
                username.equals("admin")
                &&
                password.equals("admin123")
        ) {

            showStatus(
                    "✓ Authentication successful.",
                    GREEN
            );


            loginButton.setText(
                    "ACCESS GRANTED"
            );


            loginButton.setEnabled(
                    false
            );


            /*
             * IMPORTANT:
             *
             * After successful login we DO NOT
             * open Dashboard directly.
             *
             * The flow is:
             *
             * LOGIN
             *    ↓
             * WELCOME
             *    ↓
             * DASHBOARD
             *
             */

            Timer timer =
                    new Timer(
                            600,
                            e -> openWelcome()
                    );

            timer.setRepeats(false);

            timer.start();
        }


        // -----------------------------------------------------
        // INVALID LOGIN
        // -----------------------------------------------------

        else {

            showStatus(
                    "✕ Invalid username or password.",
                    RED
            );

            passwordField.setText("");

            passwordField.requestFocus();
        }
    }


    // =========================================================
    // OPEN WELCOME SCREEN
    // =========================================================

    private void openWelcome() {

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
                                    "Hostel Control Center"
                            );


                    frame.setDefaultCloseOperation(
                            JFrame.EXIT_ON_CLOSE
                    );


                    frame.setSize(
                            1200,
                            800
                    );


                    frame.setMinimumSize(
                            new Dimension(
                                    1000,
                                    700
                            )
                    );


                    frame.setLocationRelativeTo(
                            null
                    );


                    frame.setContentPane(
                            new WelcomePanel()
                    );


                    frame.setVisible(
                            true
                    );
                }
        );
    }


    // =========================================================
    // PASSWORD VISIBILITY
    // =========================================================

    private void togglePassword() {

        if(
                showPassword.isSelected()
        ) {

            passwordField.setEchoChar(
                    (char) 0
            );
        }

        else {

            passwordField.setEchoChar(
                    '•'
            );
        }
    }


    // =========================================================
    // STATUS MESSAGE
    // =========================================================

    private void showStatus(
            String text,
            Color color
    ) {

        statusLabel.setText(
                text
        );

        statusLabel.setForeground(
                color
        );
    }


    // =========================================================
    // TEXT FIELD
    // =========================================================

    private JTextField createTextField() {

        JTextField field =
                new JTextField();


        field.setPreferredSize(
                new Dimension(
                        390,
                        50
                )
        );


        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        50
                )
        );


        field.setBackground(
                new Color(
                        202,
                        208,
                        215
                )
        );


        field.setForeground(
                TEXT
        );


        field.setCaretColor(
                BLUE
        );


        field.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );


        field.setBorder(
                new EmptyBorder(
                        9,
                        14,
                        9,
                        14
                )
        );


        return field;
    }


    // =========================================================
    // PASSWORD FIELD
    // =========================================================

    private JPasswordField createPasswordField() {

        JPasswordField field =
                new JPasswordField();


        field.setPreferredSize(
                new Dimension(
                        390,
                        50
                )
        );


        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        50
                )
        );


        field.setBackground(
                new Color(
                        202,
                        208,
                        215
                )
        );


        field.setForeground(
                TEXT
        );


        field.setCaretColor(
                BLUE
        );


        field.setEchoChar(
                '•'
        );


        field.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );


        field.setBorder(
                new EmptyBorder(
                        9,
                        14,
                        9,
                        14
                )
        );


        return field;
    }


    // =========================================================
    // LABEL
    // =========================================================

    private JLabel createLabel(
            String text
    ) {

        JLabel label =
                new JLabel(
                        text
                );


        label.setForeground(
                MUTED
        );


        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );


        return label;
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


            // -------------------------------------------------
            // SHADOW
            // -------------------------------------------------

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


            // -------------------------------------------------
            // HIGHLIGHT
            // -------------------------------------------------

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


            // -------------------------------------------------
            // SURFACE
            // -------------------------------------------------

            g2.setColor(
                    SURFACE
            );


            g2.fillRoundRect(
                    3,
                    3,
                    width - 11,
                    height - 11,
                    24,
                    24
            );


            g2.dispose();


            super.paintComponent(
                    g
            );
        }
    }


    // =========================================================
    // NEOMORPHIC BUTTON
    // =========================================================

    private static class NeoButton
            extends JButton {

        private boolean pressed =
                false;


        public NeoButton(
                String text
        ) {

            super(text);


            setForeground(
                    Color.WHITE
            );


            setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            15
                    )
            );


            setFocusPainted(
                    false
            );


            setBorderPainted(
                    false
            );


            setContentAreaFilled(
                    false
            );


            setOpaque(
                    false
            );


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

                            if(!isEnabled()) {

                                return;
                            }


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


            // -------------------------------------------------
            // BUTTON SHADOW
            // -------------------------------------------------

            if(
                    !pressed
                    &&
                    isEnabled()
            ) {

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


            // -------------------------------------------------
            // BUTTON
            // -------------------------------------------------

            g2.setColor(
                    isEnabled()
                    ?
                    (
                            pressed
                            ?
                            BLUE_DARK
                            :
                            BLUE
                    )
                    :
                    new Color(
                            120,
                            130,
                            140
                    )
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


            super.paintComponent(
                    g
            );
        }
    }
}