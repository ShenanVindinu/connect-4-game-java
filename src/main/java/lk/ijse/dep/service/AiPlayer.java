package lk.ijse.dep.service;

public class AiPlayer extends Player {

    public AiPlayer(){}
    public AiPlayer(Board newBoard) { super(newBoard); }

    @Override
    public void movePiece(int col) {

        int randomColumn;

        do {
            randomColumn = (int) (Math.random() * Board.NUM_OF_COLS);
        } while (!board.isLegalMove(randomColumn));
        board.updateMove(randomColumn, Piece.GREEN);
        board.getBoardUI().update(randomColumn, false);

        Winner winner = board.findWinner();
        if (winner.getWinningPiece() == Piece.GREEN) {
            board.getBoardUI().notifyWinner(winner);
        } else {
            if (!board.existLegalMoves()) {
                board.getBoardUI().notifyWinner(winner);
            }
        }
    }
}