
package dk.easv.tictactoe.gui.controller;

// Java imports
import java.net.URL;
import java.util.ResourceBundle;

import dk.easv.tictactoe.bll.AiGameBoard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

// Project imports
import dk.easv.tictactoe.bll.GameBoard;
import dk.easv.tictactoe.bll.IGameBoard;

/**
 *
 * @author EASV
 */
public class AiTicTacViewController implements Initializable {
    @FXML
    private Label lblPlayer;

    @FXML
    private Button btnNewGame;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;

    private static final String TXT_PLAYER = "Player: ";
    private AiGameBoard aiGame;
    private boolean gameOver = false;

    /**
     * Event handler for the grid buttons
     *
     * @param event
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;
            int player = aiGame.getNextPlayer();

            if (!gameOver && aiGame.playerPlay(c, r)) {
                Button btn = (Button) event.getSource();
                String xOrO = player == 0 ? "X" : "O";
                btn.setText(xOrO);

                if (aiGame.isGameOver()) {
                    int winner = aiGame.getWinner();
                    displayWinner(winner);
                    gameOver = true;
                    return;
                }
                int [] coords = aiGame.computerPlay();
                if (coords != null) {
                    computerSymbol(coords[0],coords[1]);
                }
                if (aiGame.isGameOver()){
                    int winner = aiGame.getWinner();
                    displayWinner(winner);
                    gameOver = true;
                    return;
                }
                setPlayer();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void computerSymbol(int col, int row) {
        for (Node n : gridPane.getChildren()) {
            Integer nodeRow = GridPane.getRowIndex(n);
            Integer nodeCol = GridPane.getColumnIndex(n);
            int r = (nodeRow == null) ? 0 : nodeRow;
            int c = (nodeCol == null) ? 0 : nodeCol;

            if (r== row && c==col && n instanceof Button){
                Button btn = (Button) n;
                btn.setText("X");
                break;
            }
        }
    }
    /**
     * Event handler for starting a new game
     *
     * @param event
     */
    @FXML
    private void handleNewGame(ActionEvent event) {
        aiGame.newGame();
        setPlayer();
        clearBoard();
        gameOver = false;
    }

    /**
     * Initializes a new controller
     *
     * @param url The location used to resolve relative paths for the root object, or
     *            {@code null} if the location is not known.
     * @param rb  The resources used to localize the root object, or {@code null} if
     *            the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aiGame = new GameBoard();
        setPlayer();
    }

    /**
     * Set the next player
     */
    private void setPlayer() {
        lblPlayer.setText("Your turn!");
    }


    /**
     * Finds a winner or a draw and displays a message based
     *
     * @param winner
     */
    private void displayWinner(int winner) {
        String message = "";
        switch (winner) {
            case -1:
                message = "It's a draw :-(";
                break;
            default:
                message = "Player " + winner + " wins!!!";
                break;
        }
        lblPlayer.setText(message);
        setWinnerColor();
    }

    public void setWinnerColor() {
        GameBoard gameBoard = (GameBoard) aiGame;
        int horizontalWinner = gameBoard.getHorizontalWinner();
        int verticalWinner = gameBoard.getVerticalWinner();
        boolean diagonalWinner1 = gameBoard.isDiagonalWinner1();
        boolean diagonalWinner2 = gameBoard.isDiagonalWinner2();

        if (verticalWinner >= 0) {
            switch (verticalWinner) {
                case 0:
                    btn1.setStyle("-fx-background-color: lightgreen;");
                    btn2.setStyle("-fx-background-color: lightgreen;");
                    btn3.setStyle("-fx-background-color: lightgreen;");
                    break;
                case 1:
                    btn4.setStyle("-fx-background-color: lightgreen;");
                    btn5.setStyle("-fx-background-color: lightgreen;");
                    btn6.setStyle("-fx-background-color: lightgreen;");
                    break;
                case 2:
                    btn7.setStyle("-fx-background-color: lightgreen;");
                    btn8.setStyle("-fx-background-color: lightgreen;");
                    btn9.setStyle("-fx-background-color: lightgreen;");
                    break;
            }
        }

        if (horizontalWinner >= 0) {
            switch (horizontalWinner) {
                case 0:
                    btn1.setStyle("-fx-background-color: lightgreen;");
                    btn4.setStyle("-fx-background-color: lightgreen;");
                    btn7.setStyle("-fx-background-color: lightgreen;");
                    break;

                case 1:
                    btn2.setStyle("-fx-background-color: lightgreen;");
                    btn5.setStyle("-fx-background-color: lightgreen;");
                    btn8.setStyle("-fx-background-color: lightgreen;");
                    break;

                case 2:
                    btn3.setStyle("-fx-background-color: lightgreen;");
                    btn6.setStyle("-fx-background-color: lightgreen;");
                    btn9.setStyle("-fx-background-color: lightgreen;");
                    break;
            }
        }

        if (diagonalWinner1) {
            btn1.setStyle("-fx-background-color: lightgreen;");
            btn5.setStyle("-fx-background-color: lightgreen;");
            btn9.setStyle("-fx-background-color: lightgreen;");
        }

        if (diagonalWinner2) {
            btn3.setStyle("-fx-background-color: lightgreen;");
            btn5.setStyle("-fx-background-color: lightgreen;");
            btn7.setStyle("-fx-background-color: lightgreen;");
        }

    }

    /**
     * Clears the game board in the GUI
     */
    private void clearBoard()
    {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setText("");
            btn.setStyle(null);
        }
    }
}
