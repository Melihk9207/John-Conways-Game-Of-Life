import java.util.Random;

public class Board {

    boolean[][] board ;
    int Row, Column ;
    Random random = new Random();

    public Board(int Row, int Column){
        this.Row = Row;
        this.Column = Column;
        this.board = new boolean[Row][Column];
    }


    public void RandomBoard(){
        for(int i = 0; i < this.Row; i++){
            for(int j = 0; j < this.Column; j++){
                board[i][j] = random.nextBoolean();
            }
        }
    }
    public void displayBoard() {
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                if (board[i][j]) {
                    System.out.print("O ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public int countAliveNeighbours(int Cell_Row, int Cell_Column) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (i == 0 && j == 0) {
                    continue; // Hücrenin kendisini atla
                }

                int neighborRow = Cell_Row + i;
                int neighborCol = Cell_Column + j;

                if (neighborRow >= 0 && neighborRow < this.Row && neighborCol >= 0 && neighborCol < this.Column) {
                    if (board[neighborRow][neighborCol]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }















}




