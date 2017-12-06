// A Ship class that stores the data for each ship. Your program will have five of these.
// This ship class should keep two ArrayLists of points: one to store the points that the ship covers, and one to store the points that have been “hit” by the player.
public class Ship{
	
	ArrayList<Point> coordinates;
	ArrayList<Point> hit;

	//Point origin, boolean isVertical, int length
	// this constructor accepts the origin or the ship (its lowest, or leftmost point), its length, and its orientation (vertical, or horizontal).
	public Ship(Point origin, boolean isVertical, int length){
		// add origin as first point
		// loop through length  to add other points - if vertical, then add coordinates
		// going up, if not vertical, add points going left

	}
	// Returns true if a Ship covers a point on the board, false if it does not.
	public boolean containsPoint(Point P){

	}
	// Returns true if the receiving ship shares a point with the argument ship.
	public boolean collidesWith(Ship s){

	}
	//When the user enters a coordinate, this method can be called on each ship. If the ship contains the point, it should remember that it has been hit at that point. It could do this with a second PointCollection, or some other data strategy.
	public void shotFiredAtPoint(Point p){

	}
	// returns true if shotFiredAtPoint has been called for this point in the ship. False if it has not, or if the point is not in the ship.
	public boolean isHitAtPoint(Point p){

	}
	//returns the number of points in the ship that have been hit. When the hitCount is equal to the length of the ship the ship is considered to be sunk.
	public int hitCount(){

	}

}