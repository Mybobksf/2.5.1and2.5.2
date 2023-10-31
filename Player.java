/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int points;
  /* your code here - constructor(s) */ 
   public Player() {
    points = 0;
    Scanner scanned = new Scanner(System.in);
    System.out.print("Enter Player Name: ");
    String newName = scanned.nextLine();
    
    name = newName;
    System.out.println("Welcome to the game " + name);
  }
  /* your code here - accessor(s) */ 

  /* your code here - mutator(s) */ 
}
