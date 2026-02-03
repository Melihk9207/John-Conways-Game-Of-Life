import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter board rows (e.g., 20): ");
        int rows = scanner.nextInt();

        System.out.print("Enter board columns (e.g., 20): ");
        int columns = scanner.nextInt();

        System.out.print("How many generations to run (e.g., 50): ");
        int generations = scanner.nextInt();

        GameOfLife game = new GameOfLife(rows, columns);

        System.out.println("--- Generation 0 (Initial) ---");
        game.displayGame();

        Thread.sleep(1000);

        for (int i = 1; i <= generations; i++) {

            System.out.println("--- Generation " + i + " ---");

            game.nextGeneration();
            game.displayGame();

            Thread.sleep(500);
        }

        scanner.close();
        System.out.println("Simulation finished.");
    }
}