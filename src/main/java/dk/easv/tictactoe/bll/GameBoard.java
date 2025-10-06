
package dk.easv.tictactoe.bll;

public class GameBoard implements IGameBoard
{
    /**
     /**
     *
     * @author EASV
     *

     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    private int playerId =1 ;
    public int getNextPlayer()
    {
        if (playerId==0)
            return 1;
        else
            return 0;
    }




    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    private int [][]board = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
    public boolean play(int col, int row) {
        if (board[col][row]== -1) {
            if (playerId == 0) {
                board[col][row] = playerId;
                board[col][row] = 0;
                playerId = 1;
                return true;
            }
            else if (playerId == 1) {
                board[col][row] = 1;
                playerId = 0;
                return true;
            }
            else
                return false; }

        else
            return false;
    }

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will retun false.
     */
    public boolean isGameOver()
    {
        for (int i = 0; i<3; i++)
            if (board[i][0] == 0 && board[i][1] == 0 && board[i][2] == 0 || board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1) {
                return true;
            }
        for (int i = 0; i<3; i++)
            if (board[0][i] == 0 && board[1][i] == 0 && board[2][i] == 0 || board[0][i] == 1 && board[1][i] == 1 && board[2][i] == 1) {
                return true;
            }
        if (board[0][0] == 0 && board[1][1] == 0 && board[2][2] == 0 || board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) {
            return true;
        }
        if (board[2][0] == 0 && board[1][1] == 0 && board[0][2] == 0 || board[2][0] == 1 && board[1][1] == 1 && board[0][2] == 1) {
            return true;
        }
        int counter=0;
        for (int i=0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                if (board [i][j] != -1) {
                    counter++;
                }
            }
        }
        if (counter==9) {
            return true;
        }
        return false;
    }


    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner() {
        if (isGameOver());
        {   return playerId;
        }
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                board [i][j] = -1;
            }
        }
        playerId=1;
    }
}
