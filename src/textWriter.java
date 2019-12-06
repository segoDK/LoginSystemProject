import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class textWriter {
    private String path;
    private boolean append_to_file = false;

    public textWriter(java.lang.String file_path){
        path = file_path;
    }

    public textWriter(java.lang.String file_path, boolean append_value){
        path = file_path;
        append_to_file = append_value;
    }

    public void writeToFile(java.lang.String textLine) throws IOException{
        FileWriter write = new FileWriter(java.lang.String.valueOf(path), append_to_file);
        PrintWriter print_line = new PrintWriter(write);
        print_line.printf("%s"+"%n",textLine);
        print_line.close();
    }

    public boolean checkDupe(String testFor){
        boolean dupeTest = true;
        try{

            textReader usernameRead = new textReader(path);
            String[] aryLines = usernameRead.OpenFile();
            for (String aryLine : aryLines) {
                //System.out.println(aryLine);
                if (aryLine.equals(testFor)) {
                    dupeTest = false;
                }
            }
            return dupeTest;
        } catch (IOException e) {
            System.out.println("TextReader Error");
            e.printStackTrace();
        }
        return dupeTest;

    }

}
