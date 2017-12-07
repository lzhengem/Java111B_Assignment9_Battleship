import java.util.ArrayList;
// A Ship class that stores the data for each ship. Your program will have five of these.
// This ship class should keep two ArrayLists of points: one to store the points that the ship covers, and one to store the points that have been "hit" by the player.
public class Ship{
	
	ArrayList<Point> coordinates = new ArrayList<Point>();
	ArrayList<Point> gotHit = new ArrayList<Point>();
	int shipLength;

	//Point origin, boolean isVertical, int length
	// this constructor accepts the origin or the ship (its lowest, or leftmost point), its length, and its orientation (vertical, or horizontal).
	public Ship(Point origin, boolean isVertical, int length){
		shipLength = length;
		Point newPoint;
		coordinates.add(origin);
		// if the ship is vertical, add length to y axis
		if(isVertical){
			for (int y = 1; y < length; y++){
				newPoint = new Point(origin.get_x(), origin.get_y() + y);
				coordinates.add(newPoint);
			}
		}
		// if ship is horizontal, add length to x axis
		else{
			for (int x = 1; x < length; x++){
				newPoint = new Point(origin.get_x() + x, origin.get_y());
				coordinates.add(newPoint);
			}

		}

	}

	public ArrayList<Point> get_coordinates(){
		return coordinates;

	}
	// Returns true if a Ship covers a point on the board, false if it does not.
	public boolean containsPoint(Point p){
		boolean hasPoint = false;
		for(Point point: coordinates){
			if (point.equals(p))
				hasPoint = true;
		}
		return hasPoint;

	}
	// Returns true if the receiving ship shares a point with the argument ship.
	public boolean collidesWith(Ship s){
		boolean collides = false;
		for(Point point: s.get_coordinates()){
			if (containsPoint(point))
				collides = true;
		}
		return collides;

	}
	// //When the user enters a coordinate, this method can be called on each ship. If the ship contains the point, it should remember that it has been hit at that point. It could do this with a second PointCollection, or some other data strategy.
	public void shotFiredAtPoint(Point p){
		if (containsPoint(p) && !gotHit.contains(p))
			gotHit.add(p);
	}
	// // returns true if shotFiredAtPoint has been called for this point in the ship. False if it has not, or if the point is not in the ship.
	public boolean isHitAtPoint(Point p){
		boolean hasPoint = false;
		for(Point point: gotHit){
			if (point.equals(p))
				hasPoint = true;
		}
		return hasPoint;

	}
	// //returns the number of points in the ship that have been hit. When the hitCount is equal to the length of the ship the ship is considered to be sunk.
	public int hitCount(){
		return gotHit.size();

	}

	public int get_length(){
		return shipLength;
	}

	public String toString(){
		String return_string = "";
		for(Point point: coordinates){
			return_string += (point.toString() + " ");

		}
		return return_string;

	}

}