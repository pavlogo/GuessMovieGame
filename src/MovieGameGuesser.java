import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MovieGameGuesser {
    private static int num = 10; // mistakes allowed
    private static int wr = 0; // wrong letters

    public static String movie;
    public static String underscores;
    public static String guess;

    static ArrayList<String> wrong = new ArrayList<>();

    public static void chooseMovie() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("aaa.txt"));
            int linesQtty = 0;
            while (reader.readLine() != null) linesQtty++;
            reader.close();
            int lineNum = (int) (Math.random() * linesQtty + 1);
            movie = Files.readAllLines(Paths.get("aaa.txt")).get(lineNum - 1);
        } catch (FileNotFoundException exception) {
            System.out.println("FILE NOT FOUND");
        } catch (IOException exception) {
            System.out.println("I/O exception");
        }
    }

        public static void guessMovie () {

            underscores = movie.replaceAll("\\S", "_");
            System.out.println("You are guessing: " + underscores);

            System.out.println("Only " + num + " mistakes allowed");
            System.out.println("Guess a letter ");

            while (num != 0) {
                Scanner z = new Scanner(System.in);

                try {
                    guess = z.next("\\p{Alpha}");
                    System.out.println(guess);

                    String old = underscores;
                    underscores = MovieDisplayLetters.compareLetter();
                    System.out.println("You are guessing : " + underscores.toUpperCase(Locale.ROOT));
                    if (underscores.contains(guess)){
                        System.out.println("Name has letter " + guess);
                    }
                    else if (old.equalsIgnoreCase(underscores)) { //if guessed letter is wrong
                        if (wrong.contains(guess)) {
                            num++;
                            wr--;
                            System.out.println("YOU ALREADY TRIED LETTER " + guess);
                            wrong.remove(guess);}
                        num--;
                        wr++;
                        wrong.add(guess);
                        System.out.println("You have guessed " + wr + " (out of 10 allowed) wrong letters " + wrong + "  ");

                    }

                    if (num == 0) {
                        System.out.println("You lose.");
                        System.out.println("The movie name is " + movie.toUpperCase(Locale.ROOT));
                    }

                    if (underscores.equalsIgnoreCase(movie)) {
                        System.out.println("Congrats, you won the game!");
                        break;
                    }

                } catch (InputMismatchException exception) {
                    System.out.println("Please input a single letter");
                }
            }
        }
    }



