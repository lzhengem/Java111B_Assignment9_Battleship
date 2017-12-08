import java.awt.Point;
import java.util.ArrayList;
/** A Ship class that stores the data for each ship.
 This ship class keeps two ArrayLists of points: one to store the points that the ship covers, 
 and one to store the points that have been "hit" by the player.
**/
public class Ship{
	
	ArrayList<Point> coordinates = new ArrayList<Point>();
	ArrayList<Point> gotHit = new ArrayList<Point>();
	int shipLength;

	// this constructor accepts the origin or the ship (its lowest, or leftmost point), its length, and its orientation (vertical, or horizontal).
	public Ship(Point origin, boolean isVertical, int length){
		shipLength = length;
		Point newPoint;
		coordinates.add(origin);
		// if the ship is vertical, add length to y axis
		if(isVertical){
			for (int y = 1; y < length; y++){
				newPoint = new Point(origin.x, origin.y + y);
				coordinates.add(newPoint);
			}
		}
		// if ship is horizontal, add length to x axis
		else{
			for (int x = 1; x < length; x++){
				newPoint = new Point(origin.x + x, origin.y);
				coordinates.add(newPoint);
			}
		}
	}

	// Returns true if a Ship sits on Point p, false if it does not.
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
		for(Point point: coordinates){
			if (containsPoint(point))
				collides = true;
		}
		return collides;

	}
	//When the user enters a coordinate, this method can be called on each ship. If the ship contains the point, it should remember that it has been hit at that point
	public void shotFiredAtPoint(Point p){
		// only save it in gotHit arrayList if this ship contains point p and it has not already been hit there
		if (containsPoint(p) && !gotHit.contains(p))
			gotHit.add(p);
	}
	// returns true if shotFiredAtPoint gotHit at point p
	public boolean isHitAtPoint(Point p){
		boolean hasPoint = false;
		for(Point point: gotHit){
			if (point.equals(p))
				hasPoint = true;
		}
		return hasPoint;

	}
	//returns the number of points in the ship that have been hit
	public int hitCount(){
		return gotHit.size();

	}

	// override toString, so if called, it will show all Point coordinates for this ship
	public String toString(){
		String return_string = "";
		for(Point point: coordinates)
			return_string += ("("+point.x+","+point.y+") ");
		return return_string;

	}

	// true if ship has sunk
	public boolean sunk(){
		return shipLength == hitCount();
	}
}