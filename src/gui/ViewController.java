package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ViewController {

    @FXML
    private Button btTest;

    @FXML
    public void onBtTestAction(){

        Alerts.showAlert("Alert title", null, "hello", Alert.AlertType.ERROR);

    }



}
