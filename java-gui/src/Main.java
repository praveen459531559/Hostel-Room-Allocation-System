import gui.LoginPanel;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

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
                    new java.awt.Dimension(
                            900,
                            600
                    )
            );

            frame.setLocationRelativeTo(null);

            frame.setContentPane(
                    new LoginPanel()
            );

            frame.setVisible(true);
        });
    }
}