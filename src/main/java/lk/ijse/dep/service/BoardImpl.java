package lk.ijse.dep.service;

public class BoardImpl implements Board {

    private final Piece[][] pieces;
    private final BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        pieces = new Piece[NUM_OF_COLS][NUM_OF_ROWS];

        for (int i = 0; i < NUM_OF_COLS; i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                pieces[i][j] = Piece.EMPTY;
            }
        }

    }


    @Override
    public BoardUI getBoardUI() {
        return this.boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {

        for (int i = 0; i < NUM_OF_ROWS; i++) {
            if (this.pieces[col][i] == Piece.EMPTY)
                return i; //found an empty space in the specified col...
        }
        return -1; //There's no Space available in the specified col...
    }

    @Override
    public boolean isLegalMove(int col) {
        return (findNextAvailableSpot(col) != -1);
    }

    @Override
    public boolean existLegalMoves() {
        for (int i = 0; i < NUM_OF_COLS; i++) {
            if (isLegalMove(i)) {
                return true; //One Legal Move Exist
            }
        }
        return false; //Out of Legal Moves
    }

    @Override
    public void updateMove(int col, Piece move) { this.pieces[col][findNextAvailableSpot(col)] = move; }

    @Override
    public void updateMove(int col, int row, Piece move) { this.pieces[col][row] = move; }

    @Override
    public Winner findWinner() {

        for (int col = 0; col < NUM_OF_COLS; col++) {
            int count = 1;
            int rows = findNextAvailableSpot(col);
            for (int i = 1; i < ((rows == -1) ? NUM_OF_ROWS : rows); i++) {
                if (this.pieces[col][i] == this.pieces[col][i - 1]) {
                    count++;
                    if (count == 4)
                        return new Winner(this.pieces[col][i], col, i - 3, col, i);
                } else {
                    count = 1;
                    if (i >= 2)
                        break;
                }
            }
        }
        for (int row = 0; row < NUM_OF_ROWS; row++) {
            int count = 1;
            for (int i = 1; i < NUM_OF_COLS; i++) {
                if (this.pieces[i][row] == this.pieces[i - 1][row] && this.pieces[i][row] != Piece.EMPTY) {
                    count++;
                    if (count == 4)
                        return new Winner(this.pieces[i][row], i - 3, row, i, row);
                } else {
                    count = 1;
                    if (i >= 3)
                        break;
                }
            }
        }
        return new Winner(Piece.EMPTY);
    }
}