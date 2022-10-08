package file;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileGames {
    private File file;
    private PrintWriter fw;

    public PrintWriter getFw(){
        return fw;
    }
    public void CreateFile(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name file: ");
        String nameFile = input.nextLine();
        this.file = new File(nameFile);

        try {
            this.fw = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }
}
