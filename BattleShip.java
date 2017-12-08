import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
// driver program
public class BattleShip{

	public static void main(String[] args){
		Ship[] shipList = new Ship[5];
		// Ship[] shipList = new Ship[2];
		Scanner scan =new Scanner(System.in);
		Point shot;
		String[] guess;
		// randomly generate 5 ships and adds it to shipList
		for(int i = 0; i <= 4; i++){
		// for(int i = 0; i <= 1; i++){
			int x = (int) (Math.random() * 10);
			int y = (int) (Math.random() * 10);
			boolean isVertical = Math.random() <0.5;
			int length = (int) ((Math.random()* 3)+ 2);
			Point origin = new Point(x,y);
			Ship ship = new Ship(origin,isVertical,length);
			shipList[i] = ship;
		}
		
		
		// Point origin2 = new Point(2,2);
		// Point origin3 = new Point(3,9);
		// Point origin4 = new Point(7,7);
		// Ship ship = new Ship(origin,true,5);
		// Ship ship2 = new Ship(origin2,false,5);
		// Ship ship3 = new Ship(origin3,false,2);
		// Ship ship4 = new Ship(origin4,true,3);
		// ArrayList<Ship> shipList = new ArrayList<Ship>();
		
		
		// shipList.add(ship);
		Board board = new Board(shipList);
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
		// board.displayShipsOnBoard(shipList);
		board.revealShips();
		while (!board.gameOver()){
			
			System.out.println("Take a guess: (ex: 0 0)");
			// if the use enters wrong thing, let them retry
			// boolean retry = false;
   //      	int loopCount = 0;
			// while(!retry){
				try{
					guess = scan.nextLine().split(" ");
					// retry = true;
				}
				catch (ArrayIndexOutOfBoundsException e){
					System.out.println("Please enter correct coordinates (ex: 0 0)");
					guess = scan.nextLine().split(" ");
					// loopCount ++;
	    //        		if(loopCount == 5) retry = true;
				// }
			}

			
			shot = new Point(Integer.parseInt(guess[0]),Integer.parseInt(guess[1]));
			board.hit(shot);
			board.displayBoard();
		}

		// ship.shotFiredAtPoint(origin);
		// board.hit(origin);
		// board.displayBoard();
		// board.hit(origin2);
		// board.displayBoard();
		// System.out.println("ship got hit " + ship.hitCount() + " times");
		// //print out the coordinates for ship
		// for(Point point: ship.get_coordinates())
		// 	System.out.println(point);
		// board.displayShipOnBoard(ship2);
	}
}