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
		int revealShipsPass = 12345;

		System.out.println();
		// Set up the board and display it
		Board board = new Board();
		System.out.println("Hello and welcome to Battleship!");
		System.out.println("There are " + board.getNumShips() + " hidden ships.");
		System.out.println("Please enter x and y coordinates (max coordinate of " + (board.layout.length-1)+ ") you would like to hit!\n");
		board.displayBoard();
		// shows where all the ships are
		// board.revealShips();

		// ask player to input coordinates, and take a shot there
		System.out.println("Take a shot: (ex: 0 0)");
		// if the player has not won yet, keep playing
		while (board.continueGame()){
			boolean tryAgain = true;
			
			// If user enters characters or less than 2 numbers, let them try again
			while(tryAgain){
				System.out.print("Your next shot: ");
				try{
					guess = scan.nextLine().split(" ");
					x = Integer.parseInt(guess[0]);
					y = Integer.parseInt(guess[1]);


					// if they enter points off the grid, make them enter another guess, or if they entered negative numbers
					if(x >= board.xLength || y >= board.yLength){
						System.out.println("You are playing on a " +  board.xLength + " X " + board.yLength + " board!");	
						System.out.println("Only coordinates up to " + (board.xLength - 1) + " and " + (board.yLength - 1) + " are allowed.");	
						System.out.println();
					}
					else if ( x < 0 || y < 0) {
						System.out.println("Negative numbers are not allowed");	
						System.out.println();
					}
					else
						tryAgain = false;
				}
				// if player enters less than 2 numbers, make them enter again
				catch (ArrayIndexOutOfBoundsException e){
					// if user entered the passcode to reveal the ships, then show them
					// if(x == revealShipsPass)
					// 	board.revealShips();
					// else 
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