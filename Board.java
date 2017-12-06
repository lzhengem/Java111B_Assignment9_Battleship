import java.util.Arrays;
// And a Board class that stores the data the game in general. It will have an array of Ship objects, and an ArrayList of points that represent the player's guesses. 
// driver program
public class Board{
	public static void main(String[] args){

		Point test_point = new Point(1,2);
		System.out.println(test_point);
		System.out.println(Arrays.toString(test_point.get_coordinates()));
	}
	
}