/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
//Developed by Lukas Somwang and Anil Sarvabatla

import java.util.Scanner;
  
public class PhraseSolver
{
  //The attributes for the player
  private Player player1;
  private Player player2;
  private Board board;
  private boolean solved;

  //Initalizing everything for the game
  public PhraseSolver() {
    player1 = new Player();
    player2 = new Player();
    board = new Board();
    solved = false;
  }
  //Setting up the game
  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      
      /* your code here - game logic */
      String guess = input.nextLine();
      solved = board.guessLetter(guess);
      /* your code here - determine how game ends */
      solved = true; 
    } 
   
  }
  
}
