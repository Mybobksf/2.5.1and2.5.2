/*
 * Activity 2.5.2
 *
 * A Player class the PhraseSolverGame
 */
//Developed by Lukas SOmwang and Anil Sarvabatla

import java.util.Scanner;

public class Player {
    //Attributes for the player
    private String name;
    private int points;

    //Welcoming the player into the game
    public Player(String newName) {
        points = 0;
        name = newName;

        System.out.println("Hi " + name + " Welcome to the game!");
    }

    // Accessors to private attributes
    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    // Mutators to private attributes
    public void setPoints(int x) {
        points = x;
    }

    public void setName(String y) {
        name = y;
    }
}
