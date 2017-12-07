import java.util.Arrays;
// And a Board class that stores the data the game in general. It will have an array of Ship objects, and an ArrayList of points that represent the player's guesses. 
// driver program
public class Board{
	int rows = 10;
	int columns = 10;
	String[][] layout = new String[columns][rows];

	public static void main(String[] args){
		Board board = new Board();
		Point origin = new Point(0,0);
		Point origin2 = new Point(2,2);
		Ship ship = new Ship(origin,true,5);
		Ship ship2 = new Ship(origin2,false,5);

		// private Point ship1_origin = new Point(1,2);
		// System.out.println(test_point);
		// System.out.println(Arrays.toString(test_point.get_coordinates()));

		// private Ship ship1 = new Ship(ship1_origin,true,3);
		board.displayBoard();
		// board.layout[0][1] = "X";
		// board.layout[1][2] = "O";
		// board.displayBoard();
		board.displayShipOnBoard(ship);
		board.displayShipOnBoard(ship2);
	}
	public Board(){
		// initialize everything on the board to '~'
		for(int column=0; column < layout.length; column++){
			for(int row=0; row < layout[column].length; row++){
				layout[column][row] = "~";
			}

		}
	}
	
	public void displayBoard(){
		// display everything on the board
		for(int row=layout.length-1; row >= 0 ; row--){
		// for(int row=0; row <layout.length ; row++){
			//displays the row numbers
			System.out.print(row + " ");
			for(int column=0; column < layout[0].length ; column++){
				//displays the coordinates
				System.out.print(layout[column][row] + " ");
			}
			System.out.println();
		}

		// display the column numbers
		System.out.print("  ");
		for(int column=0; column < layout.length ; column++){
			System.out.print(column + " ");
		}
		System.out.println();
	}
public void displayShipOnBoard(Ship ship){
		// display everything on the board
		for(int row=layout.length-1; row >= 0 ; row--){
		// for(int row=0; row <layout.length ; row++){
			//displays the row numbers
			System.out.print(row + " ");
			for(int column=0; column < layout[0].length ; column++){
				Point currentPoint = new Point(column, row);
				//displays the coordinates
				for(Point points : ship.get_coordinates()){
					if (points.equals(currentPoint))
						layout[column][row] = "X";

				}
				
					System.out.print(layout[column][row] + " ");
			}
			System.out.println();
		}

		// display the column numbers
		System.out.print("  ");
		for(int column=0; column < layout.length ; column++){
			System.out.print(column + " ");
		}
		System.out.println();
	}

}