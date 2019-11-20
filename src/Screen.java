import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;

public class Screen {
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JLabel startupText;
    private JPanel panelMain;
    private JButton loginButton;

    private final static String newline = "\n";
    private static String username;
    private static String password;

    public Screen() {
        userNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = userNameField.getText();
                //userNameField.selectAll();
            }
        });
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.selectAll();
                password = passwordField.getSelectedText();

            }
        });
    }

    public static void setup(){
        JFrame frame = new JFrame("FirstForm");
        frame.setSize(new Dimension(920, 540));
        frame.setContentPane(new Screen().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
    }

}
