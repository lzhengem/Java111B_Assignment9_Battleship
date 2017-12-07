In this assignment, you will be writing a one player version of the Battleship game in which the computer randomly places five ships ( with random length of 2-4) and the user tries to sink the ships.

In the sample run of the program below, the grid is first displayed as empty. All of the ships are hidden. The player enters coordinates by entering two integer values separated by a space. Hits are shown on the map with an ‘X’.  Misses are shown with a ‘.’.  The ‘.’ character represents a small splash. Feel free to replace this, it is the best that I could think of.

 

Welcome to Battleship.

 

9 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

8 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

7 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

6 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

5 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

4 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

3 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

2 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

1 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

0 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

  0  1  2  3  4  5  6  7  8  9

 

Enter a coordinate: 4 7

Hit!

 

9 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

8 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

7 ~  ~  ~  ~  X  ~  ~  ~  ~  ~

6 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

5 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

4 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

3 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

2 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

1 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

0 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

  0  1  2  3  4  5  6  7  8  9

 

Enter a coordinate: 5 6

Miss.

 

9 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

8 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

7 ~  ~  ~  ~  X  ~  ~  ~  ~  ~

6 ~  ~  ~  ~  ~  .  ~  ~  ~  ~

5 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

4 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

3 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

2 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

1 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

0 ~  ~  ~  ~  ~  ~  ~  ~  ~  ~

  0  1  2  3  4  5  6  7  8  9

 

Enter a coordinate:

 

When the user sinks a ship, the game should say: “you sank a ship with length 2!” Where the 2 is replaced by the length of the ship that was sunk. When all five ships are sunk, the game should end.

 

Object Oriented Design

Your game will NOT use a two-dimensional grid. Instead, if will use ArrayList objects full of Point objects. The Point class can be a simple class that keeps track of x and y coordinates.

You will use two classes to keep track of the game data. A Ship class that stores the data for each ship. Your program will have five of these. And a Board class that stores the data the game in general. It will have an array of Ship objects, and an ArrayList of points that represent the player's guesses. 

Ship Class:  Your game should store ships in objects of type Ship. This ship class should keep two ArrayLists of points: one to store the points that the ship covers, and one to store the points that have been “hit” by the player.

The Ship class has the following constructors and methods.

Ship(Point origin, boolean isVertical, int length) - this constructor accepts the origin or the ship (its lowest, or leftmost point), its length, and its orientation (vertical, or horizontal).
boolean containsPoint(Point p) - Returns true if a Ship covers a point on the board, false if it does not.
boolean collidesWith(Ship s) - Returns true if the receiving ship shares a point with the argument ship. Collides with it, so to speak.
void shotFiredAtPoint(Point p) - This is a verb in the game. When the user enters a coordinate, this method can be called on each ship. If the ship contains the point, it should remember that it has been hit at that point. It could do this with a second PointCollection, or some other data strategy.
bool isHitAtPoint(Point p) - returns true if shotFiredAtPoint has been called for this point in the ship. False if it has not, or if the point is not in the ship.
int hitCount() - returns the number of points in the ship that have been hit. When the hitCount is equal to the length of the ship the ship is considered to be sunk.
 

Board Class: The board class has not been designed for you. Designing this class is one of the key challenges in the assignment. When you design this class think about the code that you will need for the basic game loop. It will read in a coordinate from the player, say if it is a hit or a miss, then display the board.

The Board class should not contain this game loop. It is a data object. But, if the Board class is well designed, then it should be extremely easy to write the rest of the game. 