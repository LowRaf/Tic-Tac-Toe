package dk.easv.tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;


public class StartViewController {

    public void handleMultiGame(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/TicTacView.fxml"));
        Parent scene = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene));
        stage.setResizable(false);
        stage.setTitle("Multiplayer tic tac toe");
        stage.centerOnScreen();
        stage.show();

        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();

    }

    public void handleSoloGame(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/AiTicTacView.fxml"));
        Parent scene = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene));
        stage.setResizable(false);
        stage.setTitle("Solo tic tac toe");
        stage.centerOnScreen();
        stage.show();

        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();

    }

    public void handleSoloppGame(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/HardAiTicTacView.fxml"));
        Parent scene = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene));
        stage.setResizable(false);
        stage.setTitle("Hard AI tic tac toe");
        stage.centerOnScreen();
        stage.show();

        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
}

