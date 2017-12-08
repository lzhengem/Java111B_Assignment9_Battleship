import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

/**
    * Battleship.java represents a gameboard to play 1 player battleship
    *  @author Lena Zheng
    *  @version 1
    *  @since 2017-12-08
    * A board is initialized and it asks the user for coordinates to guess where
    * the ships on the board are.
*/

/**
    * Algorithm:
    * 1. Set up board
    * 2. Ask player for coordinates they would like to hit
    * 3. Hit the board with the coordinates
    * 4. If all ships have been hit and sunk, the game is over
*/

public class BattleShip{

	public static void main(String[] args){
		Scanner scan =new Scanner(System.in);
		String[] guess;
		int x=-1,y=-1; //initialize to -1 or else compiler complains that it is not intialized while going through the try block

		System.out.println();
		// Set up the board and display it
		Board board = new Board();
		
		System.out.println("Hello and welcome to Battleship! Please enter x and y coordinates");
		System.out.println("(max coordinate of " + (board.layout.length-1)+ ") you would like to hit!");
		board.displayBoard();
		// board.revealShips();


		System.out.println("Take a shot: (ex: 0 0)");
		while (board.continueGame()){
			boolean tryAgain = true;
			
			// If user enters characters or less than 2 numbers, let them try again
			while(tryAgain){
				System.out.print("Your next shot: ");
				try{
					guess = scan.nextLine().split(" ");
					x = Integer.parseInt(guess[0]);
					y = Integer.parseInt(guess[1]);
					// if they enter points off the grid, make them enter another guess
					if(x >= board.xLength || y >= board.yLength){
						System.out.println("Make sure your numbers are less than " +  board.xLength + " " + board.yLength);	
						System.out.println();
					}
					else
						tryAgain = false;
				}
				// if player enters less than 2 numbers, make them enter again
				catch (ArrayIndexOutOfBoundsException e){
					System.out.println("Try again, please enter 2 numbers ");
				}
				// if the player enters a string, make them try again
				catch(NumberFormatException e){
					System.out.println("Try again, please enter 2 numbers, not characters ");

				}
			}
			// hit the board with the coordinates entered and then display the new board
			board.hit(x,y);
			board.displayBoard();
		}
		// output the wining
		System.out.println("You won!");
	}
}