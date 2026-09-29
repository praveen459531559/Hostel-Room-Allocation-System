package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NeoUI {

    public static final Color BG =
            new Color(218, 223, 229);

    public static final Color SURFACE =
            new Color(218, 223, 229);

    public static final Color INPUT =
            new Color(202, 208, 215);

    public static final Color TEXT =
            new Color(38, 45, 54);

    public static final Color MUTED =
            new Color(105, 114, 125);

    public static final Color BLUE =
            new Color(48, 105, 170);

    public static final Color BLUE_DARK =
            new Color(38, 86, 142);

    public static final Color GREEN =
            new Color(48, 150, 105);

    public static final Color ORANGE =
            new Color(190, 125, 55);

    public static final Color RED =
            new Color(190, 70, 70);

    public static final Color PURPLE =
            new Color(115, 90, 165);


    // =========================================================
    // PAGE
    // =========================================================

    public static JPanel page(
            String title,
            String subtitle
    ) {

        JPanel page =
                new JPanel(
                        new BorderLayout()
                );

        page.setBackground(
                BG
        );

        page.setBorder(
                new EmptyBorder(
                        30,
                        35,
                        30,
                        35
                )
        );


        JPanel header =
                new JPanel();

        header.setOpaque(false);

        header.setLayout(
                new BoxLayout(
                        header,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setForeground(
                TEXT
        );

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );


        JLabel subtitleLabel =
                new JLabel(subtitle);

        subtitleLabel.setForeground(
                MUTED
        );

        subtitleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );


        header.add(titleLabel);

        header.add(
                Box.createVerticalStrut(5)
        );

        header.add(subtitleLabel);


        page.add(
                header,
                BorderLayout.NORTH
        );


        return page;
    }


    // =========================================================
    // CARD
    // =========================================================

    public static NeoCard card() {

        return new NeoCard();
    }


    // =========================================================
    // LABEL
    // =========================================================

    public static JLabel label(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setForeground(
                MUTED
        );

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11
                )
        );


        return label;
    }


    // =========================================================
    // TEXT FIELD
    // =========================================================

    public static JTextField field(
            int columns
    ) {

        JTextField field =
                new JTextField(
                        columns
                );

        field.setBackground(
                INPUT
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
                        15
                )
        );

        field.setBorder(
                new EmptyBorder(
                        11,
                        14,
                        11,
                        14
                )
        );


        return field;
    }


    // =========================================================
    // COMBO BOX
    // =========================================================

    public static JComboBox<String> combo(
            String[] values
    ) {

        JComboBox<String> combo =
                new JComboBox<>(
                        values
                );

        combo.setBackground(
                INPUT
        );

        combo.setForeground(
                TEXT
        );

        combo.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        combo.setBorder(
                new EmptyBorder(
                        5,
                        8,
                        5,
                        8
                )
        );


        return combo;
    }


    // =========================================================
    // BUTTON
    // =========================================================

    public static JButton button(
            String text,
            Color color
    ) {

        NeoButton button =
                new NeoButton(
                        text,
                        color
                );

        return button;
    }


    // =========================================================
    // STATUS LABEL
    // =========================================================

    public static JLabel status(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setForeground(
                MUTED
        );

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );


        return label;
    }


    // =========================================================
    // NEO CARD
    // =========================================================

    public static class NeoCard
            extends JPanel {

        public NeoCard() {

            setOpaque(false);

            setBorder(
                    new EmptyBorder(
                            24,
                            25,
                            24,
                            25
                    )
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
                            145
                    )
            );

            g2.fillRoundRect(
                    6,
                    7,
                    width - 7,
                    height - 7,
                    24,
                    24
            );


            // Highlight

            g2.setColor(
                    new Color(
                            245,
                            248,
                            250,
                            210
                    )
            );

            g2.fillRoundRect(
                    0,
                    0,
                    width - 7,
                    height - 7,
                    24,
                    24
            );


            // Surface

            g2.setColor(
                    SURFACE
            );

            g2.fillRoundRect(
                    3,
                    3,
                    width - 11,
                    height - 11,
                    22,
                    22
            );


            g2.dispose();


            super.paintComponent(
                    g
            );
        }
    }


    // =========================================================
    // NEO BUTTON
    // =========================================================

    private static class NeoButton
            extends JButton {

        private final Color color;

        private boolean pressed;


        public NeoButton(
                String text,
                Color color
        ) {

            super(text);

            this.color =
                    color;


            setForeground(
                    Color.WHITE
            );

            setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            13
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
                                java.awt.event.MouseEvent e
                        ) {

                            pressed = true;

                            repaint();
                        }


                        @Override
                        public void mouseReleased(
                                java.awt.event.MouseEvent e
                        ) {

                            pressed = false;

                            repaint();
                        }


                        @Override
                        public void mouseExited(
                                java.awt.event.MouseEvent e
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


            if(!pressed) {

                g2.setColor(
                        new Color(
                                180,
                                186,
                                193,
                                150
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


            g2.setColor(
                    pressed
                    ? color.darker()
                    : color
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