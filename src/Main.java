
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;


public class Main{



    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.saveUsername("test1");
        main.saveUsername("test1");
        main.printUsernames("Files/usernames.txt");
        Screen.setup();

    }

    public void saveUsername(String userName) throws IOException {

        String username_path ="Files/usernames.txt";
        textWriter writer = new textWriter(username_path, true);
        if(!writer.checkDupe(userName)){
            writer.writeToFile(userName);
        }
        else {
            System.out.println("Error - Duplicate username - No username added");
        }



    }

    public void printUsernames(String username_path){
        try{
            textReader usernameRead = new textReader(username_path);
            String[] aryLines = usernameRead.OpenFile();
            for(int i = 0; i<aryLines.length; i++){
                System.out.println(aryLines[i]);
            }
        } catch (IOException e) {
            System.out.println("TextReader Error");
            e.printStackTrace();
        }
    }
    /* Opsætning af projektet:
     *
     * Vi skal lave en class for Users
     * Der skal sættes noget algoritme op til at kryptere password
     * Passwords og burgerinfo skal kunne gemmes
     * GUI skal sættes op
    */

}
