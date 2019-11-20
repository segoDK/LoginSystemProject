import javax.swing.*;
import java.awt.*;

public class Screen {
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JLabel startupText;
    private JPanel panelMain;

    public static void setup(){
        JFrame frame = new JFrame("FirstForm");
        frame.setSize(new Dimension(920, 540));
        frame.setContentPane(new Screen().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
    }

}
