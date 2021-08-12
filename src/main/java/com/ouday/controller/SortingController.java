package com.ouday.controller;

import com.ouday.animation.SortingAlgorithmAnimation;
import com.ouday.data.SortingAlgorithmsVisualizerData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortingController {

    private int[] array;
    private int[] initialArray;
    private SortingAlgorithmAnimation sortingAlgorithmAnimation;
    private SortingAlgorithmsVisualizerData sortingAlgorithmsVisualizerData;


    @FXML
    private FontIcon closeIcon;

    @FXML
    private FontIcon minimizeIcon;

    @FXML
    private FontIcon playIcon;

    @FXML
    private FontIcon stopIcon;

    @FXML
    private FontIcon oneStepIcon;

    @FXML
    private FontIcon repeatIcon;

    @FXML
    private FontIcon homeIcon;

    @FXML
    private Label algorithmNameLabel;

    @FXML
    private Label dataTypeLabel;

    @FXML
    private Label sizeOfTheArrayLabel;

    @FXML
    private Label sortingSpeedLabel;

    @FXML
    private Canvas canvas;


    @FXML
    void switchToHome(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/ouday/view/home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void closeStage(MouseEvent event) {
        ((Stage) closeIcon.getScene().getWindow()).close();
    }

    @FXML
    void minimizeStage(MouseEvent event) {
        ((Stage) minimizeIcon.getScene().getWindow()).setIconified(true);
    }

    @FXML
    void startSorting(MouseEvent event) {
        sortingAlgorithmAnimation.getAnimationPlayer().startAnimation();
    }

    @FXML
    void oneStepSorting(MouseEvent event) {
        if (playIcon.isVisible() && !sortingAlgorithmAnimation.getSortingIsCompleted())
            sortingAlgorithmAnimation.oneStepSorting();
        else {
            playIcon.setIconColor(Color.valueOf("#c1c0b9"));
            playIcon.setDisable(true);
            oneStepIcon.setIconColor(Color.valueOf("#c1c0b9"));
            oneStepIcon.setDisable(true);
        }
    }

    @FXML
    void stopSorting(MouseEvent event) {
        sortingAlgorithmAnimation.getAnimationPlayer().stopAnimation();
    }

    @FXML
    void repeatSorting(MouseEvent event) {
        int[] array = this.initialArray.clone();
        this.array = array;
        this.sortingAlgorithmAnimation = sortingAlgorithmsVisualizerData.getSortingAlgorithmAnimation(this.array);
        sortingAlgorithmAnimation.getDraw().drawBeforeSorted();
        playIcon.setIconColor(Color.valueOf("#f7e9e3"));
        playIcon.setDisable(false);
        oneStepIcon.setIconColor(Color.valueOf("#f7e9e3"));
        oneStepIcon.setDisable(false);
    }

    public void setSortingVisualizerDetails(String algorithmName, int sizeOfTheArray, String dataType, String sortingSpeed) {
        algorithmNameLabel.setText("Algorithm's name: " + algorithmName);
        sizeOfTheArrayLabel.setText("The size of the array: " + sizeOfTheArray);
        dataTypeLabel.setText("Data type is: " + dataType);
        sortingSpeedLabel.setText("The speed is: " + sortingSpeed);

        List<FontIcon> fontIconList = new ArrayList<>();
        fontIconList.add(homeIcon);
        fontIconList.add(repeatIcon);
        fontIconList.add(playIcon);
        fontIconList.add(stopIcon);
        fontIconList.add(oneStepIcon);

        this.sortingAlgorithmsVisualizerData = new SortingAlgorithmsVisualizerData(algorithmName, sizeOfTheArray, dataType, sortingSpeed, this.canvas, fontIconList);

        int[] initialArray = sortingAlgorithmsVisualizerData.getArray();
        this.array = initialArray;
        this.initialArray = initialArray.clone();

        this.sortingAlgorithmAnimation = sortingAlgorithmsVisualizerData.getSortingAlgorithmAnimation(this.array);
    }

    public SortingAlgorithmAnimation getSortingAlgorithmAnimation() {
        return sortingAlgorithmAnimation;
    }

}