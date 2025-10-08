package dk.easv.tictactoe.bll;

public interface HardAiGameBoard {
    int getNextPlayer();
    boolean playerPlay(int col, int row);
    boolean isGameOver();
    int[] optimalMove();
    int getWinner();
    void newGame();

}
