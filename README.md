# Introduction
Battleship is a game in which 5 ships of random length 2-4 are placed on the board and the user has to sink all of them to win.

## Installation
* In order to play the game you will need Java installed
* Game is run from command line

## Description
* When the game starts, player is asked to enter 2 coordinates to guess where the ships are in the format `x y`
* If player misses, the coordinates are replaced with an '.' 
* If player hits a ship, the coordinates are replaced with an 'x'
* When all five ships are sunk, the game ends

## Usage
Example output:

`$ java BattleShip`

Hello and welcome to Battleship!
There are 5 hidden ships.
Please enter x and y coordinates (max coordinate of 9) you would like to hit!

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

 
Take a shot: (ex: 0 0)
Your next shot: 4 7 

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
Hit!

 
Your next shot: 5 6

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
Missed.

......