
import java.util.ArrayList;
// And a Board class that stores the data the game in general. It will have an array of Ship objects, and an ArrayList of points that represent the player's guesses. 
// driver program
public class Board{
	private ArrayList<Point> layout = new ArrayList<Point>();
	private Ship[] ships;
	private ArrayList<Point> guesses = new ArrayList<Point>();

	
	// public Board(){
	// 	ships = new Ship[5];
	// }

	public Board(Ship[] shipArray){
		// create an arraylist of points 9x9
		for(int column = 0; column <10; column++){
			for(int row = 0; row <10; row++){
				layout.add(new Point(column,row));
			}
		}
		ships = shipArray;
	}
	
	// public void addShip(Ship ship){
	// 	ships.add(ship);
	// }
	public void displayBoard(){
		// get the number of columns and rows in the current board
		int total_columns = layout.get(layout.size()-1).get_x();
		int total_rows = layout.get(layout.size()-1).get_y();
		String output;
		Point currentPoint;

		for(int row = total_rows; row >= 0; row--){
			// print out the row numbers
			System.out.print(row + " ");
			for(int column = 0; column <= total_columns; column++){
				output ="~";
				currentPoint = layout.get(row+column*(total_columns+ 1));
				for (Point guess: guesses){
					if(guess.equals(currentPoint))
						output = ".";
				}
				for(Ship ship: ships){
					if (ship.isHitAtPoint(currentPoint))
						output= "X";

				}
				// printout something
				System.out.print(output +" ");
			}
			System.out.println();
		}
		// print out the column numbers
		System.out.print("  ");
		for(int column = 0; column <= total_columns; column++){
				System.out.print(column + " ");
			}
		System.out.println();
	}

	public void hit(Point p){
		// add point to guess list if it hasn't been guessed already
		if(!guesses.contains(p)){
			guesses.add(p);
			for(Ship ship: ships){
				ship.shotFiredAtPoint(p);
			}

		}

	}
	public void revealShips(){
		// get the number of columns and rows in the current board
		int total_columns = layout.get(layout.size()-1).get_x();
		int total_rows = layout.get(layout.size()-1).get_y();
		String output;
		Point currentPoint;

		for(int row = total_rows; row >= 0; row--){
			// print out the row numbers
			System.out.print(row + " ");
			for(int column = 0; column <= total_columns; column++){
				output ="~";
				currentPoint = layout.get(row+column*(total_columns+ 1));
				for(Ship ship: ships){
					if (ship.containsPoint(currentPoint))
						output= "X";

				}
				// printout something
				System.out.print(output +" ");
			}
			System.out.println();
		}
		// print out the column numbers
		System.out.print("  ");
		for(int column = 0; column <= total_columns; column++){
				System.out.print(column + " ");
			}
		System.out.println();
		for(Ship ship: ships){
			System.out.println(ship);
		}
	}

	// public void addShipToBoard(Ship ship){
	// 	shipList.add(ship);
	// 	displayShipsOnBoard(shipList);

	// }
	public boolean gameOver(){
		// if at least one ship is not tanked, the game contines
		boolean over =true;
		for (int index = 0; index < ships.length; index++){
			if(ships[index].hitCount() != ships[index].get_length()){
				System.out.print(ships[index] +"hit count "+ ships[index].hitCount() + " length " + ships[index].get_length());
				over = false;
			}
		}
		return over;

	}

}