package gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


/*
 * ============================================================
 * HOSTEL ROOM ALLOCATION SYSTEM
 * MAIN CONTROL CENTER
 * ============================================================
 */

public class Dashboard extends JFrame {

    // =========================================================
    // COLORS
    // =========================================================

    private static final Color BG =
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

    private static final Color ORANGE =
            new Color(190, 125, 55);

    private static final Color RED =
            new Color(190, 70, 70);

    private static final Color PURPLE =
            new Color(115, 90, 165);


    // =========================================================
    // MAIN COMPONENTS
    // =========================================================

    private JPanel contentPanel;

    private CardLayout cardLayout;

    private JLabel totalStudentsValue;

    private JLabel occupiedBedsValue;

    private JLabel availableBedsValue;

    private JLabel occupiedRoomsValue;

    private JLabel availableRoomsValue;


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public Dashboard() {

        setTitle(
                "Hostel Control Center"
        );

        setSize(
                1200,
                750
        );

        setMinimumSize(
                new Dimension(
                        1050,
                        650
                )
        );

        setLocationRelativeTo(
                null
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        buildUI();

        refreshStatistics();


        addWindowListener(
                new WindowAdapter() {

                    @Override
                    public void windowClosing(
                            WindowEvent event
                    ) {

                        BackendController
                                .closeBackend();
                    }
                }
        );
    }


    // =========================================================
    // BUILD UI
    // =========================================================

    private void buildUI() {

        JPanel root =
                new JPanel(
                        new BorderLayout()
                );

        root.setBackground(
                BG
        );


        root.add(
                createSidebar(),
                BorderLayout.WEST
        );


        cardLayout =
                new CardLayout();

        contentPanel =
                new JPanel(
                        cardLayout
                );

        contentPanel.setBackground(
                BG
        );


        contentPanel.add(
                createHomePage(),
                "HOME"
        );


        contentPanel.add(
                new AddStudentPanel(),
                "ADD"
        );


        contentPanel.add(
                new SearchStudentPanel(),
                "SEARCH"
        );


        contentPanel.add(
                new UpdateStudentPanel(),
                "UPDATE"
        );


        contentPanel.add(
                new DeleteStudentPanel(),
                "DELETE"
        );


        contentPanel.add(
                new RoomStatusPanel(),
                "ROOMS"
        );


        root.add(
                contentPanel,
                BorderLayout.CENTER
        );


        setContentPane(
                root
        );
    }


    // =========================================================
    // SIDEBAR
    // =========================================================

    private JPanel createSidebar() {

        JPanel sidebar =
                new JPanel(
                        new BorderLayout()
                );

        sidebar.setPreferredSize(
                new Dimension(
                        235,
                        0
                )
        );

        sidebar.setBackground(
                BG
        );


        // -----------------------------------------------------
        // HEADER
        // -----------------------------------------------------

        JPanel header =
                new JPanel();

        header.setOpaque(false);

        header.setLayout(
                new BoxLayout(
                        header,
                        BoxLayout.Y_AXIS
                )
        );

        header.setBorder(
                new EmptyBorder(
                        28,
                        22,
                        20,
                        22
                )
        );


        JLabel icon =
                new JLabel("⌂");

        icon.setForeground(
                BLUE
        );

        icon.setFont(
                new Font(
                        "Segoe UI Symbol",
                        Font.BOLD,
                        36
                )
        );

        icon.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        JLabel title =
                new JLabel(
                        "HOSTEL CONTROL"
                );

        title.setForeground(
                TEXT
        );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        19
                )
        );

        title.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        JLabel subtitle =
                new JLabel(
                        "ROOM ALLOCATION SYSTEM"
                );

        subtitle.setForeground(
                MUTED
        );

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        9
                )
        );

        subtitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        header.add(icon);

        header.add(
                Box.createVerticalStrut(2)
        );

        header.add(title);

        header.add(
                Box.createVerticalStrut(4)
        );

        header.add(subtitle);


        sidebar.add(
                header,
                BorderLayout.NORTH
        );


        // -----------------------------------------------------
        // NAVIGATION
        // -----------------------------------------------------

        JPanel navigation =
                new JPanel();

        navigation.setOpaque(false);

        navigation.setLayout(
                new BoxLayout(
                        navigation,
                        BoxLayout.Y_AXIS
                )
        );

        navigation.setBorder(
                new EmptyBorder(
                        10,
                        14,
                        10,
                        14
                )
        );


        JLabel menuLabel =
                new JLabel(
                        "  CONTROL"
                );

        menuLabel.setForeground(
                MUTED
        );

        menuLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        10
                )
        );

        menuLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        navigation.add(menuLabel);

        navigation.add(
                Box.createVerticalStrut(12)
        );


        navigation.add(
                createNavigationButton(
                        "⌂",
                        "Overview",
                        "HOME",
                        BLUE
                )
        );


        navigation.add(
                Box.createVerticalStrut(9)
        );


        navigation.add(
                createNavigationButton(
                        "+",
                        "Add Student",
                        "ADD",
                        GREEN
                )
        );


        navigation.add(
                Box.createVerticalStrut(9)
        );


        navigation.add(
                createNavigationButton(
                        "⌕",
                        "Search Student",
                        "SEARCH",
                        BLUE
                )
        );


        navigation.add(
                Box.createVerticalStrut(9)
        );


        navigation.add(
                createNavigationButton(
                        "✎",
                        "Update Student",
                        "UPDATE",
                        ORANGE
                )
        );


        navigation.add(
                Box.createVerticalStrut(9)
        );


        navigation.add(
                createNavigationButton(
                        "×",
                        "Delete Student",
                        "DELETE",
                        RED
                )
        );


        navigation.add(
                Box.createVerticalStrut(9)
        );


        navigation.add(
                createNavigationButton(
                        "▣",
                        "Room Status",
                        "ROOMS",
                        PURPLE
                )
        );


        sidebar.add(
                navigation,
                BorderLayout.CENTER
        );


        // -----------------------------------------------------
        // BOTTOM
        // -----------------------------------------------------

        JPanel bottom =
                new JPanel();

        bottom.setOpaque(false);

        bottom.setLayout(
                new BoxLayout(
                        bottom,
                        BoxLayout.Y_AXIS
                )
        );

        bottom.setBorder(
                new EmptyBorder(
                        15,
                        18,
                        20,
                        18
                )
        );


        JLabel backend =
                new JLabel(
                        "●  BACKEND ONLINE"
                );

        backend.setForeground(
                GREEN
        );

        backend.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        10
                )
        );

        backend.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        bottom.add(backend);

        bottom.add(
                Box.createVerticalStrut(12)
        );


        JButton logout =
                new JButton(
                        "LOG OUT"
                );

        logout.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        logout.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        42
                )
        );

        logout.setForeground(
                RED
        );

        logout.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11
                )
        );

        logout.setFocusPainted(false);

        logout.setContentAreaFilled(false);

        logout.setBorder(
                BorderFactory.createEmptyBorder(
                        8,
                        10,
                        8,
                        10
                )
        );

        logout.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        logout.addActionListener(
                e -> logout()
        );


        bottom.add(logout);


        sidebar.add(
                bottom,
                BorderLayout.SOUTH
        );


        return sidebar;
    }


    // =========================================================
    // NAVIGATION BUTTON
    // =========================================================

    private JButton createNavigationButton(
            String icon,
            String text,
            String page,
            Color accent
    ) {

        NeoNavigationButton button =
                new NeoNavigationButton(
                        icon,
                        text,
                        accent
                );


        button.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        button.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        56
                )
        );


        button.setPreferredSize(
                new Dimension(
                        195,
                        56
                )
        );


        button.addActionListener(
                e -> {

                    cardLayout.show(
                            contentPanel,
                            page
                    );


                    if(
                            page.equals("HOME")
                    ) {

                        refreshStatistics();
                    }
                }
        );


        return button;
    }


    // =========================================================
    // HOME PAGE
    // =========================================================

    private JPanel createHomePage() {

        JPanel page =
                new JPanel(
                        new BorderLayout()
                );

        page.setBackground(
                BG
        );

        page.setBorder(
                new EmptyBorder(
                        28,
                        30,
                        25,
                        30
                )
        );


        // -----------------------------------------------------
        // HEADER
        // -----------------------------------------------------

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setOpaque(false);


        JPanel heading =
                new JPanel();

        heading.setOpaque(false);

        heading.setLayout(
                new BoxLayout(
                        heading,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel title =
                new JLabel(
                        "CONTROL CENTER"
                );

        title.setForeground(
                TEXT
        );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );


        JLabel subtitle =
                new JLabel(
                        "Monitor and manage hostel room allocation"
                );

        subtitle.setForeground(
                MUTED
        );

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );


        heading.add(title);

        heading.add(
                Box.createVerticalStrut(4)
        );

        heading.add(subtitle);


        header.add(
                heading,
                BorderLayout.WEST
        );


        JPanel online =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                8,
                                5
                        )
                );

        online.setOpaque(false);


        JLabel dot =
                new JLabel("●");

        dot.setForeground(
                GREEN
        );

        dot.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        JLabel onlineText =
                new JLabel(
                        "SYSTEM ONLINE"
                );

        onlineText.setForeground(
                GREEN
        );

        onlineText.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11
                )
        );


        online.add(dot);

        online.add(onlineText);


        header.add(
                online,
                BorderLayout.EAST
        );


        page.add(
                header,
                BorderLayout.NORTH
        );


        // -----------------------------------------------------
        // BODY
        // -----------------------------------------------------

        JPanel body =
                new JPanel();

        body.setOpaque(false);

        body.setLayout(
                new BoxLayout(
                        body,
                        BoxLayout.Y_AXIS
                )
        );


        body.add(
                Box.createVerticalStrut(25)
        );


        // -----------------------------------------------------
        // STATISTICS
        // -----------------------------------------------------

        JPanel stats =
                new JPanel(
                        new GridLayout(
                                1,
                                3,
                                15,
                                0
                        )
                );

        stats.setOpaque(false);

        stats.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        125
                )
        );


        totalStudentsValue =
                createValueLabel();


        occupiedBedsValue =
                createValueLabel();


        availableBedsValue =
                createValueLabel();


        stats.add(
                createStatCard(
                        "TOTAL STUDENTS",
                        totalStudentsValue,
                        "Registered students",
                        BLUE
                )
        );


        stats.add(
                createStatCard(
                        "OCCUPIED BEDS",
                        occupiedBedsValue,
                        "Currently allocated",
                        GREEN
                )
        );


        stats.add(
                createStatCard(
                        "AVAILABLE BEDS",
                        availableBedsValue,
                        "Remaining capacity",
                        ORANGE
                )
        );


        body.add(stats);


        body.add(
                Box.createVerticalStrut(18)
        );


        // -----------------------------------------------------
        // ROOM + OPERATIONS
        // -----------------------------------------------------

        JPanel middle =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                15,
                                0
                        )
                );

        middle.setOpaque(false);

        middle.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        245
                )
        );


        middle.add(
                createRoomSummary()
        );


        middle.add(
                createOperationsPanel()
        );


        body.add(middle);


        body.add(
                Box.createVerticalStrut(18)
        );


        // -----------------------------------------------------
        // SYSTEM ENGINE
        // -----------------------------------------------------

        body.add(
                createSystemEngine()
        );


        page.add(
                body,
                BorderLayout.CENTER
        );


        return page;
    }


    // =========================================================
    // STAT CARD
    // =========================================================

    private JPanel createStatCard(
            String title,
            JLabel value,
            String description,
            Color accent
    ) {

        NeoPanel card =
                new NeoPanel();

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setBorder(
                new EmptyBorder(
                        18,
                        20,
                        15,
                        20
                )
        );


        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setForeground(
                MUTED
        );

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        10
                )
        );

        titleLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        value.setForeground(
                accent
        );

        value.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        JLabel descriptionLabel =
                new JLabel(
                        description
                );

        descriptionLabel.setForeground(
                MUTED
        );

        descriptionLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        10
                )
        );

        descriptionLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        card.add(titleLabel);

        card.add(
                Box.createVerticalStrut(3)
        );

        card.add(value);

        card.add(
                Box.createVerticalStrut(1)
        );

        card.add(descriptionLabel);


        return card;
    }


    // =========================================================
    // ROOM SUMMARY
    // =========================================================

    private JPanel createRoomSummary() {

        NeoPanel card =
                new NeoPanel();

        card.setLayout(
                new BorderLayout()
        );

        card.setBorder(
                new EmptyBorder(
                        18,
                        20,
                        18,
                        20
                )
        );


        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setOpaque(false);


        JLabel title =
                new JLabel(
                        "ROOM CAPACITY"
                );

        title.setForeground(
                TEXT
        );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        JLabel roomCount =
                new JLabel(
                        "20 ROOMS"
                );

        roomCount.setForeground(
                BLUE
        );

        roomCount.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11
                )
        );


        header.add(
                title,
                BorderLayout.WEST
        );

        header.add(
                roomCount,
                BorderLayout.EAST
        );


        card.add(
                header,
                BorderLayout.NORTH
        );


        JPanel center =
                new JPanel();

        center.setOpaque(false);

        center.setLayout(
                new BoxLayout(
                        center,
                        BoxLayout.Y_AXIS
                )
        );


        center.add(
                Box.createVerticalStrut(12)
        );


        JPanel roomNumbers =
                new JPanel(
                        new GridLayout(
                                2,
                                2,
                                10,
                                10
                        )
                );

        roomNumbers.setOpaque(false);


        occupiedRoomsValue =
                createRoomValue(
                        "—"
                );


        availableRoomsValue =
                createRoomValue(
                        "—"
                );


        roomNumbers.add(
                createMiniStat(
                        "OCCUPIED ROOMS",
                        occupiedRoomsValue,
                        GREEN
                )
        );


        roomNumbers.add(
                createMiniStat(
                        "AVAILABLE ROOMS",
                        availableRoomsValue,
                        BLUE
                )
        );


        center.add(roomNumbers);


        center.add(
                Box.createVerticalStrut(10)
        );


        JLabel capacity =
                new JLabel(
                        "40 total beds • 2 beds per room"
                );

        capacity.setForeground(
                MUTED
        );

        capacity.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        10
                )
        );

        capacity.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        center.add(capacity);


        card.add(
                center,
                BorderLayout.CENTER
        );


        return card;
    }


    // =========================================================
    // MINI STAT
    // =========================================================

    private JPanel createMiniStat(
            String title,
            JLabel value,
            Color accent
    ) {

        JPanel panel =
                new JPanel();

        panel.setOpaque(false);

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setForeground(
                MUTED
        );

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        9
                )
        );


        value.setForeground(
                accent
        );

        value.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );


        panel.add(titleLabel);

        panel.add(value);


        return panel;
    }


    // =========================================================
    // STUDENT OPERATIONS
    // =========================================================

    private JPanel createOperationsPanel() {

        NeoPanel card =
                new NeoPanel();

        card.setLayout(
                new BorderLayout()
        );

        card.setBorder(
                new EmptyBorder(
                        18,
                        20,
                        18,
                        20
                )
        );


        JLabel title =
                new JLabel(
                        "STUDENT OPERATIONS"
                );

        title.setForeground(
                TEXT
        );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        card.add(
                title,
                BorderLayout.NORTH
        );


        JPanel grid =
                new JPanel(
                        new GridLayout(
                                2,
                                2,
                                10,
                                10
                        )
                );

        grid.setOpaque(false);


        grid.add(
                createOperationButton(
                        "ADD",
                        "Register student",
                        GREEN,
                        "ADD"
                )
        );


        grid.add(
                createOperationButton(
                        "SEARCH",
                        "Find student",
                        BLUE,
                        "SEARCH"
                )
        );


        grid.add(
                createOperationButton(
                        "UPDATE",
                        "Modify details",
                        ORANGE,
                        "UPDATE"
                )
        );


        grid.add(
                createOperationButton(
                        "DELETE",
                        "Remove student",
                        RED,
                        "DELETE"
                )
        );


        card.add(
                grid,
                BorderLayout.CENTER
        );


        return card;
    }


    // =========================================================
    // OPERATION BUTTON
    // =========================================================

    private JButton createOperationButton(
            String title,
            String subtitle,
            Color accent,
            String page
    ) {

        JButton button =
                new JButton();


        button.setLayout(
                new BoxLayout(
                        button,
                        BoxLayout.Y_AXIS
                )
        );


        button.setBackground(
                new Color(
                        210,
                        215,
                        221
                )
        );


        button.setBorder(
                BorderFactory.createEmptyBorder(
                        8,
                        10,
                        8,
                        10
                )
        );


        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );


        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setForeground(
                accent
        );

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11
                )
        );

        titleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
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
                        8
                )
        );

        subtitleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        button.add(titleLabel);

        button.add(
                Box.createVerticalStrut(2)
        );

        button.add(subtitleLabel);


        button.addActionListener(
                e -> cardLayout.show(
                        contentPanel,
                        page
                )
        );


        return button;
    }


    // =========================================================
    // SYSTEM ENGINE
    // =========================================================

    private JPanel createSystemEngine() {

        NeoPanel engine =
                new NeoPanel();


        engine.setLayout(
                new BorderLayout()
        );


        engine.setBorder(
                new EmptyBorder(
                        15,
                        18,
                        15,
                        18
                )
        );


        // -----------------------------------------------------
        // ENGINE HEADER
        // -----------------------------------------------------

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setOpaque(false);


        JLabel title =
                new JLabel(
                        "SYSTEM ENGINE"
                );

        title.setForeground(
                TEXT
        );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );


        JLabel status =
                new JLabel(
                        "● DATA PIPELINE ACTIVE"
                );

        status.setForeground(
                GREEN
        );

        status.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        9
                )
        );


        header.add(
                title,
                BorderLayout.WEST
        );


        header.add(
                status,
                BorderLayout.EAST
        );


        engine.add(
                header,
                BorderLayout.NORTH
        );


        // -----------------------------------------------------
        // ENGINE CONTENT
        // -----------------------------------------------------

        JPanel content =
                new JPanel();

        content.setOpaque(false);

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );


        content.add(
                Box.createVerticalStrut(10)
        );


        // -----------------------------------------------------
        // PIPELINE
        // -----------------------------------------------------

        JPanel pipeline =
                new JPanel(
                        new GridLayout(
                                1,
                                5,
                                8,
                                0
                        )
                );

        pipeline.setOpaque(false);

        pipeline.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        55
                )
        );


        pipeline.add(
                createPipelineNode(
                        "JAVA SWING",
                        "USER INTERFACE",
                        BLUE
                )
        );


        pipeline.add(
                createArrow()
        );


        pipeline.add(
                createPipelineNode(
                        "PROCESS BUILDER",
                        "JAVA ↔ C",
                        ORANGE
                )
        );


        pipeline.add(
                createArrow()
        );


        pipeline.add(
                createPipelineNode(
                        "C BACKEND",
                        "CORE LOGIC",
                        GREEN
                )
        );


        content.add(pipeline);


        content.add(
                Box.createVerticalStrut(12)
        );


        // -----------------------------------------------------
        // DATA STRUCTURE MODULES
        // -----------------------------------------------------

        JPanel modules =
                new JPanel(
                        new GridLayout(
                                1,
                                4,
                                10,
                                0
                        )
                );

        modules.setOpaque(false);

        modules.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        85
                )
        );


        modules.add(
                createEngineModule(
                        "LINKED LIST",
                        "Student Records",
                        "INSERT • DELETE",
                        BLUE
                )
        );


        modules.add(
                createEngineModule(
                        "HASH TABLE",
                        "Fast Student Search",
                        "ID LOOKUP",
                        PURPLE
                )
        );


        modules.add(
                createEngineModule(
                        "ROOM MANAGER",
                        "20 Rooms • 40 Beds",
                        "ALLOCATION",
                        GREEN
                )
        );


        modules.add(
                createEngineModule(
                        "FILE STORAGE",
                        "students.txt",
                        "PERSISTENCE",
                        ORANGE
                )
        );


        content.add(modules);


        engine.add(
                content,
                BorderLayout.CENTER
        );


        return engine;
    }


    // =========================================================
    // PIPELINE NODE
    // =========================================================

    private JPanel createPipelineNode(
            String title,
            String subtitle,
            Color accent
    ) {

        JPanel panel =
                new JPanel();

        panel.setOpaque(false);

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel titleLabel =
                new JLabel(
                        title,
                        SwingConstants.CENTER
                );

        titleLabel.setForeground(
                accent
        );

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        10
                )
        );

        titleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel subtitleLabel =
                new JLabel(
                        subtitle,
                        SwingConstants.CENTER
                );

        subtitleLabel.setForeground(
                MUTED
        );

        subtitleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        8
                )
        );

        subtitleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        panel.add(titleLabel);

        panel.add(
                Box.createVerticalStrut(2)
        );

        panel.add(subtitleLabel);


        return panel;
    }


    // =========================================================
    // ENGINE MODULE
    // =========================================================

    private JPanel createEngineModule(
            String title,
            String description,
            String function,
            Color accent
    ) {

        NeoPanel module =
                new NeoPanel();


        module.setLayout(
                new BoxLayout(
                        module,
                        BoxLayout.Y_AXIS
                )
        );


        module.setBorder(
                new EmptyBorder(
                        9,
                        12,
                        8,
                        12
                )
        );


        JLabel titleLabel =
                new JLabel(
                        title
                );

        titleLabel.setForeground(
                accent
        );

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        10
                )
        );

        titleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel descriptionLabel =
                new JLabel(
                        description
                );

        descriptionLabel.setForeground(
                TEXT
        );

        descriptionLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        8
                )
        );

        descriptionLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel functionLabel =
                new JLabel(
                        function
                );

        functionLabel.setForeground(
                MUTED
        );

        functionLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        8
                )
        );

        functionLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        module.add(titleLabel);

        module.add(
                Box.createVerticalStrut(3)
        );

        module.add(descriptionLabel);

        module.add(
                Box.createVerticalStrut(2)
        );

        module.add(functionLabel);


        return module;
    }


    // =========================================================
    // ARROW
    // =========================================================

    private JLabel createArrow() {

        JLabel arrow =
                new JLabel(
                        "→",
                        SwingConstants.CENTER
                );


        arrow.setForeground(
                MUTED
        );


        arrow.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );


        return arrow;
    }


    // =========================================================
    // REFRESH STATISTICS
    // =========================================================

    private void refreshStatistics() {

        if(
                totalStudentsValue == null
        ) {

            return;
        }


        String response =
                BackendController.getStats();


        if(
                response == null
                ||
                !response.startsWith(
                        "STATS|"
                )
        ) {

            totalStudentsValue.setText(
                    "—"
            );

            occupiedBedsValue.setText(
                    "—"
            );

            availableBedsValue.setText(
                    "—"
            );

            occupiedRoomsValue.setText(
                    "—"
            );

            availableRoomsValue.setText(
                    "—"
            );

            return;
        }


        String data =
                response.substring(
                        "STATS|".length()
                );


        String[] parts =
                data.split(
                        "\\|"
                );


        if(
                parts.length < 5
        ) {

            return;
        }


        try {

            int students =
                    Integer.parseInt(
                            parts[0]
                    );


            int occupiedBeds =
                    Integer.parseInt(
                            parts[1]
                    );


            int availableBeds =
                    Integer.parseInt(
                            parts[2]
                    );


            int occupiedRooms =
                    Integer.parseInt(
                            parts[3]
                    );


            int availableRooms =
                    Integer.parseInt(
                            parts[4]
                    );


            totalStudentsValue.setText(
                    String.valueOf(
                            students
                    )
            );


            occupiedBedsValue.setText(
                    String.valueOf(
                            occupiedBeds
                    )
            );


            availableBedsValue.setText(
                    String.valueOf(
                            availableBeds
                    )
            );


            occupiedRoomsValue.setText(
                    String.valueOf(
                            occupiedRooms
                    )
            );


            availableRoomsValue.setText(
                    String.valueOf(
                            availableRooms
                    )
            );

        }

        catch(
                NumberFormatException exception
        ) {

            totalStudentsValue.setText(
                    "—"
            );

            occupiedBedsValue.setText(
                    "—"
            );

            availableBedsValue.setText(
                    "—"
            );

            occupiedRoomsValue.setText(
                    "—"
            );

            availableRoomsValue.setText(
                    "—"
            );
        }
    }


    // =========================================================
    // VALUE LABEL
    // =========================================================

    private JLabel createValueLabel() {

        JLabel label =
                new JLabel(
                        "—"
                );


        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        32
                )
        );


        return label;
    }


    // =========================================================
    // ROOM VALUE
    // =========================================================

    private JLabel createRoomValue(
            String value
    ) {

        JLabel label =
                new JLabel(
                        value
                );


        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );


        return label;
    }


    // =========================================================
    // LOGOUT
    // =========================================================

    private void logout() {

        BackendController.closeBackend();

        dispose();


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


                    frame.setLocationRelativeTo(
                            null
                    );


                    frame.setContentPane(
                            new LoginPanel()
                    );


                    frame.setVisible(
                            true
                    );
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
                            140
                    )
            );


            g2.fillRoundRect(
                    6,
                    7,
                    width - 7,
                    height - 7,
                    22,
                    22
            );


            // Highlight

            g2.setColor(
                    new Color(
                            244,
                            247,
                            250,
                            210
                    )
            );


            g2.fillRoundRect(
                    0,
                    0,
                    width - 7,
                    height - 7,
                    22,
                    22
            );


            // Main Surface

            g2.setColor(
                    SURFACE
            );


            g2.fillRoundRect(
                    3,
                    3,
                    width - 11,
                    height - 11,
                    20,
                    20
            );


            g2.dispose();


            super.paintComponent(
                    g
            );
        }
    }


    // =========================================================
    // NAVIGATION BUTTON
    // =========================================================

    private static class NeoNavigationButton
            extends JButton {

        private final Color accent;


        public NeoNavigationButton(
                String icon,
                String text,
                Color accent
        ) {

            super();


            this.accent =
                    accent;


            setLayout(
                    new BorderLayout(
                            12,
                            0
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


            JLabel iconLabel =
                    new JLabel(
                            icon,
                            SwingConstants.CENTER
                    );


            iconLabel.setForeground(
                    accent
            );


            iconLabel.setFont(
                    new Font(
                            "Segoe UI Symbol",
                            Font.BOLD,
                            20
                    )
            );


            JLabel textLabel =
                    new JLabel(
                            text
                    );


            textLabel.setForeground(
                    TEXT
            );


            textLabel.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            12
                    )
            );


            add(
                    iconLabel,
                    BorderLayout.WEST
            );


            add(
                    textLabel,
                    BorderLayout.CENTER
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


            if(
                    getModel().isPressed()
            ) {

                g2.setColor(
                        new Color(
                                198,
                                204,
                                211
                        )
                );


                g2.fillRoundRect(
                        3,
                        4,
                        getWidth() - 8,
                        getHeight() - 8,
                        16,
                        16
                );

            }

            else {

                // Shadow

                g2.setColor(
                        new Color(
                                185,
                                191,
                                198,
                                110
                        )
                );


                g2.fillRoundRect(
                        5,
                        6,
                        getWidth() - 9,
                        getHeight() - 7,
                        16,
                        16
                );


                // Surface

                g2.setColor(
                        SURFACE
                );


                g2.fillRoundRect(
                        2,
                        2,
                        getWidth() - 8,
                        getHeight() - 8,
                        16,
                        16
                );
            }


            g2.dispose();


            super.paintComponent(
                    g
            );
        }
    }
}