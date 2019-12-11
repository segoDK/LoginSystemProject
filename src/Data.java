import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Data {

    private String username_path ="Files/usernames.txt";
    private String password_path ="Files/passwords.txt";

    public void saveUsername(String userName) throws IOException {
        textWriter writer = new textWriter(username_path, true);
        if(writer.checkDupe(userName)){
            writer.writeToFile(userName);
        }
        else {
            System.out.println("Error - Duplicate username - No username added");
        }
    }

    public void savePassword(String newpass) throws IOException, NoSuchAlgorithmException {
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
            return -1;

        } catch (IOException e) {
            System.out.println("TextReader Error");
            e.printStackTrace();
            return -1;
        }
    }


    public boolean testForPass(String pass, int line, String file_path){
        try{
            if(line!=-1) {
                textReader usernameRead = new textReader(file_path);
                String[] aryLines = usernameRead.OpenFile();
                //System.out.println(line);
                MessageDigest md = MessageDigest.getInstance("SHA-512");
                byte[] hashedPassword = md.digest(pass.getBytes(StandardCharsets.UTF_8));
                String passHash = Base64.getEncoder().encodeToString(hashedPassword);
                return (aryLines[line]).equals(passHash);
            } else {
                return false;
            }

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

    // setters and getters
    public void setUsernamePath(String pathInput){
        username_path = pathInput;
    }
    public void setPasswordPath(String pathInput){
        password_path = pathInput;
    }
    public String getUsernamePath(){
        return(username_path);
    }
    public String getPasswordPath(){
        return(password_path);
    }

}
