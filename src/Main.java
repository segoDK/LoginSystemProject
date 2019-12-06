
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class Main{



    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Main main = new Main();

        main.savePassword("Batman");
        main.savePassword("Wulff");
        main.savePassword("M");
        main.savePassword("Hydrogen");
        main.printLinesFile("Files/usernames.txt");
        main.printLinesFile("Files/passwords.txt");
        main.testLogin("Joker","Batman","Files/usernames.txt","Files/passwords.txt");

        Screen.setup();

    }

    public void saveUsername(String userName) throws IOException {
        String username_path ="Files/usernames.txt";
        textWriter writer = new textWriter(username_path, true);
        if(writer.checkDupe(userName)){
            writer.writeToFile(userName);
        }
        else {
            System.out.println("Error - Duplicate username - No username added");
        }
    }

    public void savePassword(String newpass) throws IOException, NoSuchAlgorithmException {
        String password_path ="Files/passwords.txt";
        textWriter writer = new textWriter(password_path, true);
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        byte[] hashedPassword = md.digest(newpass.getBytes(StandardCharsets.UTF_8));
        String hashedPBase64 = Base64.getEncoder().encodeToString(hashedPassword);

        if(writer.checkDupe(hashedPBase64)){
            writer.writeToFile(hashedPBase64);
        }
        else {
            System.out.println("Error - Duplicate username - No username added");
        }
    }

    public void printLinesFile(String file_path){
        try{
            textReader usernameRead = new textReader(file_path);
            String[] aryLines = usernameRead.OpenFile();
            for(int i = 0; i<aryLines.length; i++){
                System.out.println(aryLines[i]);
            }
        } catch (IOException e) {
            System.out.println("TextReader Error");
            e.printStackTrace();
        }
    }

    public int testForUsername(String Username, String file_path){
        try{
            textReader usernameRead = new textReader(file_path);
            String[] aryLines = usernameRead.OpenFile();
            for(int i = 0; i<aryLines.length; i++){
                if((aryLines[i]).equals(Username)){
                    return i;
                }
            }
            return 0;

        } catch (IOException e) {
            System.out.println("TextReader Error");
            e.printStackTrace();
            return 0;
        }
    }


    public boolean testForPass(String pass, int line, String file_path){
        try{
            textReader usernameRead = new textReader(file_path);
            String[] aryLines = usernameRead.OpenFile();

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashedPassword = md.digest(pass.getBytes(StandardCharsets.UTF_8));
            String passHash = Base64.getEncoder().encodeToString(hashedPassword);
            return (aryLines[line]).equals(passHash);


        } catch (IOException | NoSuchAlgorithmException e) {
            System.out.println("TextReader Error");
            e.printStackTrace();
            return false;
        }
    }

    public boolean testLogin(String username, String pass, String username_path, String pass_path) throws IOException {
        int line = testForUsername(username,username_path);
        System.out.println(testForPass(pass,line,pass_path));
        return testForPass(pass,line,pass_path);
    }



}
