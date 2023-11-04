/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
//Developed by Lukas SOmwang and Anil Sarvabatla
import java.util.Scanner;

public class Player
{
  //Attributes for the player
  private String name;
  private int points;
  //Welcoming the player into the game
  public Player() {
    points = 0;
    Scanner scanned = new Scanner(System.in);
    System.out.print("Enter Player Name: ");
    String Naming = scanned.nextLine();
    
    name = Naming;
    System.out.println("Hi " + name + " Welcome to the game!");
  }
  public Player(String Names) {
    points = 0;

    name = Names;
    System.out.println("Hello " + name + " Welcome to the game.");
  }
  //Setting the name of the Player and the amount of points
  public String getName(){
    return name;
  }
  public int getPoints(){
    return points;
  }  
  public void setPoints(int x){
    points = x;
  }
  public void setName(String y){
    name = y;
  } 
}
