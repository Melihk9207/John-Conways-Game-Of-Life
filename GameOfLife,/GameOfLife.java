public class GameOfLife {

    Board currentBoard;
    int Row, Column;

    public GameOfLife(int Row, int Column) {
        this.Row = Row;
        this.Column = Column;
        this.currentBoard = new Board(Row, Column);
        this.currentBoard.RandomBoard();

    }

    public void nextGeneration() {

        Board nextBoard = new Board(this.Row, this.Column);

        for (int i = 0; i < this.Row; i++) {
            for (int j = 0; j < this.Column; j++) {

                int neighborCount = currentBoard.countAliveNeighbours(i, j);

                boolean isAlive = currentBoard.board[i][j];
                if (isAlive) {
                    if (neighborCount < 2) {
                        nextBoard.board[i][j] = false;
                    } else if (neighborCount > 3) {
                        nextBoard.board[i][j] = false;
                    } else {
                        nextBoard.board[i][j] = true;
                    }
                }
                else {
                    if (neighborCount == 3) {
                        nextBoard.board[i][j] = true;
                    }
                }
            }
        }
        this.currentBoard = nextBoard;
    }


    public void displayGame() {
        System.out.println("-------------------------");
        this.currentBoard.displayBoard();
    }


}