import java.io.File;
import java.util.Scanner;

public class WordQtty {

    public static void main(String[] args) {
        File file = new File("aa1a.txt");

        try{
            Scanner z = new Scanner(file);
            int words = 1;
            while (z.hasNextLine()) {
                String line = z.nextLine();
                words += line.split(" ").length;
            }
            System.out.println(words + " words");

        } catch (Exception exception){
            System.out.println("FILE NOT FOUND");
        }
        finally {
            System.out.println("here");

        }
    }
}

