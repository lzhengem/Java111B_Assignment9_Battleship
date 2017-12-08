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
		for(int y = layout.length -1; y >= 0;y--){
			// print out the column numbers
			System.out.print(y +" ");
			for(int x = 0; x < layout[y].length; x++){
				// print out the board
				System.out.print(layout[x][y] + " ");
			}
			System.out.println();
		}
		// print out the column numbers
		// print out the column numbers
		System.out.print("  ");
		for (int x = 0; x <xLength; x++)
			System.out.print(x +" ");
		System.out.println();
		

	}

	// hit all the ships at x,y and add the guess to guess arraylist
	public void hit(int x, int y){
		Point hitPoint = new Point(x,y);
		// add point to guess list if it hasn't been guessed already
		if(!guesses.contains(hitPoint)){
			guesses.add(hitPoint);
			// if it missed, it will be "."
			layout[x][y] = ".";
			for(Ship ship: ships){
				ship.shotFiredAtPoint(hitPoint);
				if (ship.isHitAtPoint(hitPoint))
					// If theres a ship at this point, then it will be "X"
					layout[x][y] = "X";
			}
		}
	}

	// }
	public void revealShips(){
		Point currentPoint;
		String display;
		for(int y = yLength -1; y >= 0;y--){
			// print out the column numbers
			System.out.print(y +" ");
			for(int x = 0; x < layout[y].length; x++){
				// print out the board - if a ship is on this current point, then display 'X'
				display = layout[x][y];
				currentPoint = new Point(x,y);
				for(int index = 0; index < ships.length; index++)
					if (ships[index].containsPoint(currentPoint))
						display = "X";
				System.out.print( display + " ");
			}
			System.out.println();
		}
		// print out the column numbers
		System.out.print("  ");
		for (int x = 0; x <xLength; x++)
			System.out.print(x +" ");
		System.out.println();

		// display the coordintaes for each ship
		for(int index = 0; index < ships.length; index++){
			System.out.print(ships[index]);
			System.out.println();
		}
	}

	// if there is at least one ship that hasn't sunk, then the game continues
	public boolean continueGame(){
		boolean keepPlaying = false;
		for(int index=0; index < ships.length; index++)
			if(!ships[index].sunk())
				keepPlaying = true;
		return keepPlaying;
	}
}