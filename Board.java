import java.util.ArrayList;
// And a Board class that stores the data the game in general. It will have an array of Ship objects, and an ArrayList of points that represent the player's guesses. 
// driver program
public class Board{
	private ArrayList<Point> layout = new ArrayList<Point>();
	

	public static void main(String[] args){
		Board board = new Board();
		Point origin = new Point(0,0);
		// Point origin2 = new Point(2,2);
		// Point origin3 = new Point(3,9);
		// Point origin4 = new Point(7,7);
		Ship ship = new Ship(origin,true,5);
		// Ship ship2 = new Ship(origin2,false,5);
		// Ship ship3 = new Ship(origin3,false,2);
		// Ship ship4 = new Ship(origin4,true,3);
		ArrayList<Ship> shipList = new ArrayList<Ship>();
		
		shipList.add(ship);
		// shipList.add(ship2);
		// shipList.add(ship3);
		// shipList.add(ship4);


		// private Point ship1_origin = new Point(1,2);
		// System.out.println(test_point);
		// System.out.println(Arrays.toString(test_point.get_coordinates()));

		// private Ship ship1 = new Ship(ship1_origin,true,3);
		// board.displayBoard();
		// board.layout[0][1] = "X";
		// board.layout[1][2] = "O";
		board.displayBoard();
		System.out.println();
		board.displayShipsOnBoard(shipList);
		// board.displayShipOnBoard(ship2);
	}
	public Board(){
		// create an arraylist of points 9x9
		for(int column = 0; column <10; column++){
			for(int row = 0; row <10; row++){
				layout.add(new Point(column,row));
			}
		}
	}
	
	public void displayBoard(){
		// get the number of columns and rows in the current board
		int total_columns = layout.get(layout.size()-1).get_x();
		int total_rows = layout.get(layout.size()-1).get_y();
		// Point currentPoint;

		for(int row = total_rows; row >= 0; row--){
			// print out the row numbers
			System.out.print(row + " ");
			for(int column = 0; column <= total_columns; column++){
				// currentPoint = layout.get(row+column);
				// printout something
				System.out.print("~ ");
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

	public void displayShipsOnBoard(ArrayList<Ship> shipList){
		// get the number of columns and rows in the current board
		int total_columns = layout.get(layout.size()-1).get_x();
		int total_rows = layout.get(layout.size()-1).get_y();
		Point currentPoint;
		String move;

		for(int row = total_rows; row >= 0; row--){
			// print out the row numbers
			System.out.print(row + " ");
			for(int column = 0; column <= total_columns; column++){
				move = "~";
				// because of the formatting of the board, row+column*(total_columns + 1) is the corresponding point of the board
				currentPoint = layout.get(row+column*(total_columns + 1));

				// check if a ship is placed on the current point
				for(Ship ship: shipList){
					if (ship.containsPoint(currentPoint))
						move = "X";
				}
				System.out.print(move + " ");
				
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

	// public void addShipToBoard(Ship ship){
	// 	shipList.add(ship);
	// 	displayShipsOnBoard(shipList);

	// }

}