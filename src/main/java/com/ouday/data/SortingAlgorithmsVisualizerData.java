package com.ouday.data;

import com.ouday.animation.BubbleSortAnimation;
import com.ouday.animation.InsertionSortAnimation;
import com.ouday.animation.SelectionSortAnimation;
import com.ouday.animation.SortingAlgorithmAnimation;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.List;

public class SortingAlgorithmsVisualizerData {

    private final String algorithmName;
    private final String dataType;
    private final String sortingSpeed;
    private final Canvas canvas;
    private final ArrayData arrayData;
    private final List<FontIcon> fontIconList;


    public SortingAlgorithmsVisualizerData(String algorithmName, int sizeOfTheArray, String dataType, String sortingSpeed, Canvas canvas, List<FontIcon> fontIconList) {
        this.algorithmName = algorithmName;
        this.dataType = dataType;
        this.sortingSpeed = sortingSpeed;
        this.canvas = canvas;
        this.fontIconList = fontIconList;
        this.arrayData = new ArrayData(sizeOfTheArray);
    }

    public SortingAlgorithmAnimation getSortingAlgorithmAnimation(int[] array) {
        switch (algorithmName) {
            case "Selection Sort":
                return new SelectionSortAnimation(array, canvas, Duration.millis(getSortingSpeed()), fontIconList);
            case "Insertion Sort":
                return new InsertionSortAnimation(array, canvas, Duration.millis(getSortingSpeed()), fontIconList);
            case "Bubble Sort":
                return new BubbleSortAnimation(array, canvas, Duration.millis(getSortingSpeed()), fontIconList);
        }
        return null;
    }

    public int[] getArray() {
        switch (dataType) {
            case "Random":
                return arrayData.getRandomArray();
            case "Descending Order":
                return arrayData.getDescendingOrderArray();
            case "Ascending order":
                return arrayData.getAscendingOrderArray();
        }
        return null;
    }

    public double getSortingSpeed() {
        switch (sortingSpeed) {
            case "0.1 ms":
                return 0.1;
            case "1 ms":
                return 1;
            case "10 ms":
                return 10;
            case "100 ms":
                return 100;
            case "1 s":
                return 1000;
        }
        return Double.parseDouble(null);
    }

}