/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
//Developed by Lukas Somwang and Anil Sarvabatla

import java.util.Scanner;
import java.io.File;

public class Board {
    // Board attributes
    private String solvedPhrase = "";
    private String phrase;
    private int currentLetterValue;

    // Board constructor
    public Board() {
        phrase = loadPhrase();
        setLetterValue();
    }

    // Accessors to private attributes

    public String getSolvedPhrase() {
        return solvedPhrase;
    }

    public int getCurrentLetterValue() {
        return currentLetterValue;
    }


    public void setLetterValue() {
        int randomInt = (int) ((Math.random() * 10) + 1) * 100;
        currentLetterValue = randomInt;
    }

    // Check if the guess is correct
    public boolean isSolved(String guess) {
        if (phrase.equals(guess)) {
            return true;
        }
        return false;
    }

    // Load a random phrase from phrases.txt
    private String loadPhrase() {
        String tempPhrase = "";

        int numOfLines = 0;
        try {
            Scanner sc = new Scanner(new File("phrases.txt"));
            while (sc.hasNextLine()) {
                tempPhrase = sc.nextLine().trim();
                numOfLines++;
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing phrases.txt");
        }

        int randomInt = (int) ((Math.random() * numOfLines) + 1);

        try {
            int count = 0;
            Scanner sc = new Scanner(new File("phrases.txt"));
            while (sc.hasNextLine()) {
                count++;
                String temp = sc.nextLine().trim();
                if (count == randomInt) {
                    tempPhrase = temp;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing phrases.txt");
        }

        for (int i = 0; i < tempPhrase.length(); i++) {
            if (tempPhrase.substring(i, i + 1).equals(" ")) {
                solvedPhrase += "  ";
            } else {
                solvedPhrase += "_ ";
            }
        }

        solvedPhrase = solvedPhrase.strip();

        return tempPhrase;
    }

    // Guess letter and return points multiplier
    public int guessLetter(String guess) {
        boolean foundLetter = false;
        String newSolvedPhrase = "";

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.substring(i, i + 1).equals(guess)) {
                newSolvedPhrase += guess + " ";
                foundLetter = true;
            } else {
                newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";
            }
        }
        solvedPhrase = newSolvedPhrase;
        return (foundLetter ? 1 : 0);
    }

    // Guess phrase and return points multiplier
    public int guessPhrase(String guess) {
        if (isSolved(guess)) {
            return 3;
        } else {
            return 0;
        }
    }

    // Check if the phrase is solved
    public boolean phraseIsSolved() {
        for (int i = 0; i < solvedPhrase.length(); i++) {
            if (solvedPhrase.substring(i, i + 1).equals("_")) {
                return false;
            }
        }
        return true;
    }
} 
