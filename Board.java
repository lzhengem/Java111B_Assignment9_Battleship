import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
// And a Board class that stores the data the game in general. It will have an array of Ship objects, and an ArrayList of points that represent the player's guesses. 
// driver program
public class Board{
	private String[][] layout;
	private Ship[] ships;
	private ArrayList<Point> guesses = new ArrayList<Point>();
	private int xLength, yLength;

	// initializes board with 10 x 10 grid and creates 5 random ships
	public Board(){
		// initialize everything on board to "~"
		xLength =10;
		yLength =10;
		ships = new Ship[5];
		layout = new String[xLength][yLength];
		for(int index = 0; index < layout.length; index++)
			Arrays.fill(layout[index], "~");

		// randomly generate 5 ships and adds it to shipList
		for(int i = 0; i <= 4; i++){
			// randomize boolean and length between 2-4
			boolean isVertical = Math.random() <0.5;
			int x,y,length = (int) ((Math.random()* 3)+ 2);

			// if ship is vertical, make sure the y is at least length way from the top of the board so the ship dosn't fall off the board
			if(isVertical){
				x = (int) (Math.random() * xLength);
				y = (int) (Math.random() * (yLength-length));
			}
			// if ship is horizontal, make sure x coordinate is at least length away from edge of board
			else{
				x = (int) (Math.random() * (xLength-length));
				y = (int) (Math.random() * yLength);
			}
			Point origin = new Point(x,y);
			Ship ship = new Ship(origin,isVertical,length);
			ships[i] = ship;
		}
	}
	// public void addShip(Ship ship){
	// 	ships.add(ship);
	// }
	public void displayBoard(){
		for(int row = layout.length -1; row >= 0;row--){
			// print out the column numbers
			System.out.print(row +" ");
			for(int column = 0; column < layout[row].length; column++){
				// print out the board
				System.out.print(layout[row][column] + " ");
			}
			System.out.println();
		}
		// print out the column numbers
		System.out.print("  ");
		for (int column = 0; column <xLength; column++)
			System.out.print(column +" ");
		

	}

	// public void hit(Point p){
	// 	// add point to guess list if it hasn't been guessed already
	// 	if(!guesses.contains(p)){
	// 		guesses.add(p);
	// 		for(Ship ship: ships){
	// 			ship.shotFiredAtPoint(p);
	// 		}

	// 	}

	// }
	// public void revealShips(){
	// 	// get the number of columns and rows in the current board
	// 	int total_columns = layout.get(layout.size()-1).x;
	// 	int total_rows = layout.get(layout.size()-1).y;
	// 	String output;
	// 	Point currentPoint;

	// 	for(int row = total_rows; row >= 0; row--){
	// 		// print out the row numbers
	// 		System.out.print(row + " ");
	// 		for(int column = 0; column <= total_columns; column++){
	// 			output ="~";
	// 			currentPoint = layout.get(row+column*(total_columns+ 1));
	// 			for(Ship ship: ships){
	// 				if (ship.containsPoint(currentPoint))
	// 					output= "X";

	// 			}
	// 			// printout something
	// 			System.out.print(output +" ");
	// 		}
	// 		System.out.println();
	// 	}
	// 	// print out the column numbers
	// 	System.out.print("  ");
	// 	for(int column = 0; column <= total_columns; column++){
	// 			System.out.print(column + " ");
	// 		}
	// 	System.out.println();
	// 	for(Ship ship: ships){
	// 		System.out.println(ship);
	// 	}
	// }

	// // public void addShipToBoard(Ship ship){
	// // 	shipList.add(ship);
	// // 	displayShipsOnBoard(shipList);

	// // }
	// public boolean gameOver(){
	// 	// if at least one ship is not tanked, the game contines
	// 	boolean over =true;
	// 	for (int index = 0; index < ships.length; index++){
	// 		if(ships[index].hitCount() != ships[index].get_length()){
	// 			System.out.print(ships[index] +"hit count "+ ships[index].hitCount() + " length " + ships[index].get_length());
	// 			over = false;
	// 		}
	// 	}
	// 	return over;

	// }

}