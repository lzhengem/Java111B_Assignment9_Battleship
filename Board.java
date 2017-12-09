import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
// And a Board class that stores the data the game in general. It will have an array of Ship objects, and an ArrayList of points that represent the player's guesses. 
// driver program
public class Board{
	String[][] layout;
	private Ship[] ships;
	private ArrayList<Point> guesses = new ArrayList<Point>();
	int xLength, yLength;
	private String hitOrMiss ="";

	// initializes board with 10 x 10 grid and creates 5 random ships
	public Board(){
	
		// set the board to 10 x 10
		xLength =10;
		yLength =10;
		int numShips = 5; //create 5 ships
		int shipMinLength = 2, shipMaxLength = 4; //create ships size 2-4

		// Fill up the board with '~'
		layout = new String[xLength][yLength];
		for(int index = 0; index < layout.length; index++)
			Arrays.fill(layout[index], "~");

		// generate 5 randomized ships and store it in array ships
		ships = generateShips(numShips, shipMinLength, shipMaxLength);
		}

	// randomly generates a select amount of ships and returns an array of the ships
	public Ship[] generateShips(int numShips, int minLength, int maxLength){
		Ship[] shipList = new Ship[numShips];
		Ship ship;
		boolean collidesWithOtherShip;
		// randomly generate numShips amount of ships
		for(int i = 0; i < numShips; i++){

			// create another ship if the current ship collides with any other ship
			do{
				collidesWithOtherShip =false;
				ship = generateRandomShip(minLength, maxLength, xLength, yLength);

				// check if this ship collides with any other ship on the board already
				for(int index= 0; index< i; index++)
					if (ship.collidesWith(shipList[index]))
						collidesWithOtherShip =true;

			}while(collidesWithOtherShip);
			shipList[i] = ship;
		}
		return shipList;
	}

	// randomly generates a ship with a minimun length of minLength, maximum length of maxLengthmaxX and maxY will be 10 for a board 10 x 10
	public Ship generateRandomShip(int minLength, int maxLength, int maxX, int maxY){
		// randomize boolean and length between 2-4
		boolean isVertical = Math.random() <0.5;
		int x,y,length = (int) ((Math.random()* (maxLength - minLength + 1))+ minLength);

		// if ship is vertical, make sure the y is at least length way from the top of the board so the ship dosn't fall off the board
		if(isVertical){
			x = (int) (Math.random() * maxX);
			y = (int) (Math.random() * (maxY-length));
		}

		// if ship is horizontal, make sure x coordinate is at least length away from edge of board
		else{
			x = (int) (Math.random() * (maxX-length));
			y = (int) (Math.random() * maxY);
		}
		Point origin = new Point(x,y);
		return (new Ship(origin,isVertical,length));

	}
	
	// Shows the board, hits, and misses
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
		System.out.print("  ");
		for (int x = 0; x <xLength; x++)
			System.out.print(x +" ");
		System.out.println();
		// Let the player know if they hit or missed any ships
		System.out.println(hitOrMiss);
		System.out.println();
	}

	// hit all the ships at x,y and add the guess to guess arraylist
	public void hit(int x, int y){
		Point hitPoint = new Point(x,y);
		// add point to guess list if it hasn't been guessed already
		if(!guesses.contains(hitPoint)){
			guesses.add(hitPoint);
			// if it missed, it will be ".", and display message miss
			hitOrMiss = "Missed.\n";
			layout[x][y] = ".";
			for(Ship ship: ships){
				ship.shotFiredAtPoint(hitPoint);
				if (ship.isHitAtPoint(hitPoint)){
					// If theres a ship at point x,y, then it will be "X"
					layout[x][y] = "X";
					hitOrMiss = "Hit!\n";
					// if the ship has been sunk, let the player know
					if (ship.sunk()){
						hitOrMiss += "You sunk a ship of size "+ ship.shipLength + "!\n";	
					}
				}

			}
		}else
			// if player alraedy guessed this spot, let them know
			hitOrMiss = "You already guessed that spot!\n";
	}

	// to display where all the ships are
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

		// display the coordinates for each ship
		for(int index = 0; index < ships.length; index++){
			System.out.print(ships[index]);
			System.out.println();
		}
		System.out.println();
	}

	// if there is at least one ship that hasn't sunk, then the game continues
	public boolean continueGame(){
		boolean keepPlaying = false;
		for(int index=0; index < ships.length; index++)
			if(!ships[index].sunk())
				keepPlaying = true;
		return keepPlaying;
	}

	public int getNumShips(){
		return ships.length;
	}

	// allows player to initialize any board size and number of ships they like - for future implementation
	// public Board(int boardSize, int numShips){
	// 	// initialize everything on board to "~"
	// 	xLength =boardSize;
	// 	yLength =boardSize;
	// 	ships = new Ship[numShips];
	// 	layout = new String[xLength][yLength];
	// 	for(int index = 0; index < layout.length; index++)
	// 		Arrays.fill(layout[index], "~");

	// 	// randomly generate ships and adds it to shipList
	// 	for(int i = 0; i < numShips; i++){
	// 		// randomize boolean and length between 2-4
	// 		boolean isVertical = Math.random() <0.5;
	// 		int x,y,length = (int) ((Math.random()* 3)+ 2);

	// 		// if ship is vertical, make sure the y is at least length way from the top of the board so the ship dosn't fall off the board
	// 		if(isVertical){
	// 			x = (int) (Math.random() * xLength);
	// 			y = (int) (Math.random() * (yLength-length));
	// 		}
	// 		// if ship is horizontal, make sure x coordinate is at least length away from edge of board
	// 		else{
	// 			x = (int) (Math.random() * (xLength-length));
	// 			y = (int) (Math.random() * yLength);
	// 		}
	// 		Point origin = new Point(x,y);
	// 		Ship ship = new Ship(origin,isVertical,length);
	// 		ships[i] = ship;
	// 	}
	// }
}