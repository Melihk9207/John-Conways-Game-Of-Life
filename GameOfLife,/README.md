This is my project for the SaOOP Java course. It's a console-based simulation of Conway's Game of Life.

It's built using the three main classes required by the project spec:

Board.java: Holds the boolean[][]grid and handles data.

GameOfLife.java: Contains the main logic and rules for evolution.

Main.java: Runs the program and handles user input from the keyboard.

How to Run It (Usage Instructions)
You can compile and run this from any terminal with the JDK.

Compile all the .javafiles:
javac *.java

Run the Mainclass:java Main


The project includes Javadoc comments in all.java files.

A separate Test_Project.javafile is also included to run unit tests (for countAliveNeighbours) and an integration test (for the nextGenerationrules), as required by Stage 6.

Stage 6: Testing & Documentation

1. Test File
You can run the test file using: java Test_Project

2. Test Output
Running the test file proves that the neighbor counting (including edges) and generation rules (using a "Blinker") work correctly.

=== Starting Game of Life Tests ===

--- Test 1: Neighbor Counting (Unit Test) ---
  [PASS] Center cell (1,1) neighbor count
  [PASS] Corner cell (0,0) neighbor count
  [PASS] Empty cell (0,1) neighbor count

--- Test 2: Generation Rules (Integration Test) ---
Generation 0 (Start State):
-------------------------
. . . . .
. . . . .
. O O O .
. . . . .
. . . . .
Generation 1 (Expected Vertical):
-------------------------
. . . . .
. . O . .
. . O . .
. . O . .
. . . . .
  [PASS] Blinker pattern transition

=== Test Summary ===
All tests passed successfully!

3. Example Simulation Output

Here is an example of the main Main.javaprogram running a 5x5 board for 2 generations.

Enter board rows (e.g., 20): 5
Enter board columns (e.g., 20): 5
How many generations to run (e.g., 50): 2
--- Generation 0 (Initial) ---
-------------------------
. . . O O
. O . O O
O . O . O
. O O . O
. O . . O
--- Generation 1 ---
-------------------------
. . O O O
. O . . .
O . . . O
O . O . O
. O O O .
--- Generation 2 ---
-------------------------
. . O O .
. O O . O
O . . O .
O . O . O
. O O O .
Simulation finished.

