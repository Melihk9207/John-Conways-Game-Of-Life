/**
 * This class is used for Stage 6: Testing and Documentation.
 * It runs a series of unit and integration tests to verify
 * that the Game of Life logic is implemented correctly.
 */
public class Test_Project {

    public static void main(String[] args) {

        System.out.println("=== Starting Game of Life Tests ===");

        boolean neighborTest = testNeighborCounting();
        boolean rulesTest = testGenerationRules();

        System.out.println("\n=== Test Summary ===");
        if (neighborTest && rulesTest) {
            System.out.println("All tests passed successfully!");
        } else {
            System.out.println("One or more tests FAILED.");
        }
    }

    /**
     * Stage 6, Item 1: Unit tests for neighbor counting
     * Tests the 'countAliveNeighbours' method in Board.java.
     */
    public static boolean testNeighborCounting() {
        System.out.println("\n--- Test 1: Neighbor Counting (Unit Test) ---");

        Board testBoard = new Board(3, 3);
 
        testBoard.board[0][0] = true;
        testBoard.board[0][2] = true;
        testBoard.board[1][1] = true;
        testBoard.board[2][0] = true;
        testBoard.board[2][2] = true;

        int countCenter = testBoard.countAliveNeighbours(1, 1);
        boolean centerPass = (countCenter == 4);
        printTestResult("Center cell (1,1) neighbor count", centerPass, "4", String.valueOf(countCenter));

        int countCorner = testBoard.countAliveNeighbours(0, 0);
        boolean cornerPass = (countCorner == 1);
        printTestResult("Corner cell (0,0) neighbor count", cornerPass, "1", String.valueOf(countCorner));

        int countEmpty = testBoard.countAliveNeighbours(0, 1);
        boolean emptyPass = (countEmpty == 3);
        printTestResult("Empty cell (0,1) neighbor count", emptyPass, "3", String.valueOf(countEmpty));

        return centerPass && cornerPass && emptyPass;
    }

    /**
     * Stage 6, Items 1 & 2: Test rule correctness & generation transitions
     * Tests the 'nextGeneration' method using a known oscillator (the Blinker).
     */
    public static boolean testGenerationRules() {
        System.out.println("\n--- Test 2: Generation Rules (Integration Test) ---");

        GameOfLife testGame = new GameOfLife(5, 5);

        Board blinkerStart = new Board(5, 5);

        blinkerStart.board[2][1] = true;
        blinkerStart.board[2][2] = true;
        blinkerStart.board[2][3] = true;

        testGame.currentBoard = blinkerStart;

        System.out.println("Generation 0 (Start State):");
        testGame.displayGame();

        testGame.nextGeneration();

        System.out.println("Generation 1 (Expected Vertical):");
        testGame.displayGame();

        boolean rule4_top = testGame.currentBoard.board[1][2];
        boolean rule3_mid = testGame.currentBoard.board[2][2];
        boolean rule4_bot = testGame.currentBoard.board[3][2];

        boolean rule1_left = !testGame.currentBoard.board[2][1];
        boolean rule1_right = !testGame.currentBoard.board[2][3];

        boolean allRulesPass = rule4_top && rule3_mid && rule4_bot && rule1_left && rule1_right;

        printTestResult("Blinker pattern transition", allRulesPass, "Vertical Blinker", "Result as shown");

        return allRulesPass;
    }

    /**
     * Helper method to print test results in a clean format.
     */
    private static void printTestResult(String testName, boolean pass, String expected, String actual) {
        if (pass) {
            System.out.println("  [PASS] " + testName);
        } else {
            System.out.println("  [FAIL] " + testName + " - Expected: " + expected + ", Got: " + actual);
        }
    }
}