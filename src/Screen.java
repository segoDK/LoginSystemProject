import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.print.Book;
import java.awt.Color;
import java.io.IOException;

public class Screen {
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JLabel startupText;
    private JPanel panelMain;
    private JButton loginButton;
    private JLabel userNameLabel;
    private JLabel passwordLabel;

    private static JFrame loginFrame = new JFrame("Login Frame");
    private static JFrame nextFrame = new JFrame("Next Frame");
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
                // if 'enter' is pressed, go to passwordField
                passwordField.requestFocus();
            }
        });
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if 'enter' is pressed and both fields are filled out, test if inputs are correct
                if(!userNameField.getText().equals("") && !passwordField.getText().equals("")){
                    testInput();
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if 'enter' is pressed, test if inputs are correct
                testInput();
            }
        });
        userNameField.addKeyListener(new KeyAdapter() {
        });
    }



    public static void setup(){
        // input information loginFrame
        loginFrame.setSize(new Dimension(360, 320));
        loginFrame.setContentPane(new Screen().panelMain);
        //loginFrame.setLayout(new FlowLayout());
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //loginFrame.pack();
        loginFrame.setVisible(true);

        // Succecful login frame
        nextFrame.setSize(new Dimension(360, 320));
        nextFrame.setContentPane(new Screen().panelMain); // CONTENT SHALL BE CHANGED
        nextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // failed login frame
        failedLoginFrame.setSize(new Dimension(360, 320));
        failedLoginFrame.setContentPane(new Screen().panelMain); // CONTENT SHALL BE CHANGED
        failedLoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void testInput(){
        Data data = new Data();
        username = userNameField.getText();
        password = passwordField.getText();
        try {
            if(data.testLogin(username, password, data.getUsernamePath(), data.getPasswordPath())){
                correctLogin(username);
            }
            else{
                showFailedLogin();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void correctLogin(String inputUsername){
        loginFrame.setVisible(false);
        nextFrame.setVisible(true);
        JOptionPane.showMessageDialog(null, "Welcome " + username);
    }

    public static void showFailedLogin(){
        JOptionPane.showMessageDialog(null, "Wrong username or password \n Please try again");
    }



}
