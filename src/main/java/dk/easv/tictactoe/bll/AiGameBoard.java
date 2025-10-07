package dk.easv.tictactoe.bll;

public interface AiGameBoard {
    int getNextPlayer();
    boolean playerPlay(int col, int row);
    boolean isGameOver();
    int[] computerPlay();
    int getWinner();
    void newGame();
}
