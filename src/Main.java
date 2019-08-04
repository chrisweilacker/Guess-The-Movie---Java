import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args ) throws Exception {
        File file = new File("/Users/chrisweilacker/Desktop/Java/Project 1/src/movies.txt");
        Scanner fileScanner = new Scanner(file);
        int pickedMovie = (int) (24 * Math.random());
        while (pickedMovie != 0) {
            fileScanner.nextLine();
            pickedMovie -= 1;
        }
        String movie = fileScanner.nextLine();
        String revealed = "";
        int wrongLetters = 0;
        String wrongLettersStr = "";

        for (int i=0; i < movie.length(); i++) {
            revealed += "_";
        }

        Scanner inputScanner = new Scanner(System.in);

        while (!revealed.equals(movie)) {
            System.out.println("You are guessing: " + revealed);
            System.out.println("You have guessed (" + wrongLetters + ") wrong letters:" + wrongLettersStr);
            System.out.println("Guess a letter:");
            String guess = inputScanner.nextLine();
            boolean correctGuess = false;

            for (int i = 0; i < movie.length(); i++) {
                if ((guess.charAt(0) == movie.charAt(i)) && (revealed.charAt(i) == '_')) {
                    correctGuess = true;
                    revealed = revealed.substring(0, i) + guess.charAt(0) + revealed.substring(i+1, revealed.length());
                }
            }

            if (!correctGuess) {
                wrongLetters += 1;
                wrongLettersStr += " " + guess.charAt(0);
            }

        }

        System.out.println("You win!");
        System.out.println("You have guessed '" + movie + "' correctly.");






    }
}
