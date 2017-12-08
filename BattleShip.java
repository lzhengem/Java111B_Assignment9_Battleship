import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
// driver program
public class BattleShip{

	public static void main(String[] args){
		Scanner scan =new Scanner(System.in);
		String[] guess;
		int x=-1,y=-1; //initialize to -1 or else compiler complains that it is not intialized while going through the try block

		Board board = new Board();
		board.displayBoard();
		board.revealShips();


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
					// if they enter points off the grid, make them enter another time
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
			board.hit(x,y);
			board.displayBoard();
		}
		System.out.println("You won!");
	}
}