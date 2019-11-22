import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.awt.Color;

public class Screen {
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JLabel startupText;
    private JPanel panelMain;
    private JButton loginButton;
    private JLabel userNameLabel;
    private JLabel passwordLabel;

    private static JFrame frame = new JFrame("FirstForm");
    private static JFrame loginFrame = new JFrame("LoginFrame");
    private static JFrame failedLoginFrame = new JFrame("FailedLoginFrame");

    private final static String newline = "\n";
    private static String username;
    private static String password;

    private int width = panelMain.getWidth();
    private int height = panelMain.getHeight();

    public Screen() {

        //startupText.setBorder((Border) Color.BLUE);
        //userNameField.setBounds(width/2,height/4,120,60);

        startupText.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));

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
        // input information frame
        frame.setSize(new Dimension(360, 320));
        frame.setContentPane(new Screen().panelMain);
        //frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);

        // Succecful login frame
        loginFrame.setSize(new Dimension(360, 320));
        loginFrame.setContentPane(new Screen().panelMain); // CONTENT SHALL BE CHANGED
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // failed login frame
        failedLoginFrame.setSize(new Dimension(360, 320));
        failedLoginFrame.setContentPane(new Screen().panelMain); // CONTENT SHALL BE CHANGED
        failedLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void showLogin(String inputUsername){
        frame.setVisible(false);
        loginFrame.setVisible(true);
    }

    public static void showFailedLogin(){

    }


}
