package com.ouday.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.FontIcon;
import java.io.IOException;


public class HomeController {

    @FXML
    private FontIcon closeIcon;

    @FXML
    private FontIcon minimizeIcon;

    @FXML
    private JFXComboBox<String> algorithmsCombobox;

    @FXML
    private JFXComboBox<Integer> sizeOfTheArrayCombobox;

    @FXML
    private JFXComboBox<String> dataTypeCombobox;

    @FXML
    private JFXComboBox<String> sortingSpeedCombobox;

    @FXML
    void switchToSorting(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/ouday/view/sorting.fxml"));
        Parent root = fxmlLoader.load();
        SortingController sortingController = fxmlLoader.getController();
        sortingController.setSortingVisualizerDetails(algorithmsCombobox.getValue(), sizeOfTheArrayCombobox.getValue(), dataTypeCombobox.getValue(), sortingSpeedCombobox.getValue());
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        sortingController.getSortingAlgorithmAnimation().getDraw().drawBeforeSorted();
    }

    @FXML
    void closeStage(MouseEvent event) {
        ((Stage) closeIcon.getScene().getWindow()).close();
    }

    @FXML
    void minimizeStage(MouseEvent event) {
        ((Stage) minimizeIcon.getScene().getWindow()).setIconified(true);
    }
}
