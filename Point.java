// The Point class can be a simple class that keeps track of x and y coordinates.
public class Point{
	private int x,y;

	public Point(int x_coordinate, int y_coordinate){
		x = x_coordinate;
		y = y_coordinate;

	}

	public int get_x(){
		return x;
	}
	public int get_y(){
		return y;
	}
	// returns the coordinates as an array
	public int[] get_coordinates(){
		int[] coordinates = {x,y};
		return coordinates;
	}
	//returns the x,y coordinate like (x,y)
	public String toString(){
		return "(" + x +","+ y + ")";

	}

	public boolean equals(Point otherPoint){
		return (x == otherPoint.get_x() && y == otherPoint.get_y());
	}
	
}