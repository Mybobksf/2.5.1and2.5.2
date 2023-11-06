/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
//Developed by Lukas Somwang and Anil Sarvabatla

import java.util.Scanner;

public class PhraseSolver {
    // Player attributes
    private Player player1;
    private Player player2;
    private Board board;
    private boolean solved = false;

    // PhraseSolver constructor
    public PhraseSolver() {
        // ask player for name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player Name: ");
        String name1 = scanner.nextLine();

        player1 = new Player(name1);

        System.out.print("Enter Player Name: ");
        String name2 = scanner.nextLine();

        player2 = new Player(name2);

        board = new Board();
        solved = false;
    }


    // Displays the scores of the players
    private void displayScores() {
        System.out.println(player1.getName() + ": " + player1.getPoints() + " points");
        System.out.println(player2.getName() + ": " + player2.getPoints() + " points");
        System.out.println(" ");
    }

    // The game logic
    public void play() {
        Player currentPlayer = player1;

        Scanner input = new Scanner(System.in);

        // Welcome message
        System.out.println(" ");
        System.out.println("Welcome to Phrase Solver!");
        System.out.println("Start guessing letters!");

        while (!solved) {
            int pointsGained = 0;

            // Display current scores
            System.out.println(" ");
            System.out.println("Current Scores:");
            displayScores();

            System.out.println("Points up for grabs: " + board.getCurrentLetterValue());
            System.out.println(currentPlayer.getName() + ", enter a letter or phrase: ");

            String guess = input.nextLine();

            // Check if the guess is a letter or phrase
            if (guess.length() == 1) {
                pointsGained = board.guessLetter(guess);
            } else {
                pointsGained = board.guessPhrase(guess);
            }

            // letter guess gets 1X points, phrase guess gets 3X points
            currentPlayer.setPoints(currentPlayer.getPoints() + pointsGained * board.getCurrentLetterValue());

            // Display the current phrase
            System.out.println(" ");
            System.out.println("Current Phrase: \n" + board.getSolvedPhrase());
            System.out.println(" ");

            // Check if the phrase is solved
            if (board.phraseIsSolved()) {
                solved = true;
                System.out.println(currentPlayer.getName() + " solved the phrase!");

                System.out.println(" ");
                System.out.println("Final Scores:");
                displayScores();
            }

            // Display gained points
            System.out.println(currentPlayer.getName() + " gained " + (pointsGained * board.getCurrentLetterValue()) + " points!");

            // Switching the player
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }

}
