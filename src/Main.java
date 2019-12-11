
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


public class Main{

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Main main = new Main();
        Data data = new Data();

        data.savePassword("Batman");
        data.savePassword("Wulff");
        data.savePassword("M");
        data.savePassword("Hydrogen");
        data.printLinesFile("Files/usernames.txt");
        data.printLinesFile("Files/passwords.txt");
        // data.testLogin("Joker","Batman","Files/usernames.txt","Files/passwords.txt");

        Screen.setup();

    }

}
