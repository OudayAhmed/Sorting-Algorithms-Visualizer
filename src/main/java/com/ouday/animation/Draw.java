package com.ouday.animation;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Draw {

    private int[] array;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private double width;
    private double height;
    private int size;
    private int rectangleIndexAfterSorted = 0;

    public Draw(int[] array, Canvas canvas) {
        this.array = array;
        this.canvas = canvas;
        this.size = this.array.length;
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.height = this.canvas.getHeight();
        this.width = this.canvas.getWidth();
    }

    public void drawBeforeSorted() {
        graphicsContext.setFill(Color.valueOf("#142850"));
        graphicsContext.fillRect(0, 0, width, height);
        graphicsContext.setFill(Color.valueOf("#27496d"));
        graphicsContext.setStroke(Color.valueOf("#303841"));
        for (int i = 0; i < size; i++) {
            graphicsContext.strokeRect(i*(width / size), height-array[i], width / size, array[i]);
            graphicsContext.fillRect(i*(width / size), height-array[i], width / size, array[i]);
        }
    }

    public void drawOneRectangle (int lineIndex, Color color) {
        graphicsContext.setFill(color);
        graphicsContext.setStroke(Color.valueOf("#303841"));
        graphicsContext.strokeRect(lineIndex*(width / size), height-array[lineIndex], width / size, array[lineIndex]);
        graphicsContext.fillRect(lineIndex*(width / size), height-array[lineIndex], width / size, array[lineIndex]);
    }

    public void drawTwoRectangleAfterSorted(int firstLineIndex, int secondLineIndex, Color color) {
        graphicsContext.setFill(color);
        graphicsContext.setStroke(Color.valueOf("#303841"));
        graphicsContext.strokeRect(firstLineIndex*(width / size), height-array[secondLineIndex], width / size, array[secondLineIndex]);
        graphicsContext.fillRect(firstLineIndex*(width / size), height-array[secondLineIndex], width / size, array[secondLineIndex]);
        graphicsContext.strokeRect(secondLineIndex*(width / size), height-array[firstLineIndex], width / size, array[firstLineIndex]);
        graphicsContext.fillRect(secondLineIndex*(width / size), height-array[firstLineIndex], width / size, array[firstLineIndex]);
    }

    public void drawTwoRectangleBeforeSorted(int firstLineIndex, int secondLineIndex, Color color) {
        graphicsContext.setFill(color);
        graphicsContext.setStroke(Color.valueOf("#303841"));
        graphicsContext.strokeRect(firstLineIndex*(width / size), height-array[firstLineIndex], width / size, array[firstLineIndex]);
        graphicsContext.fillRect(firstLineIndex*(width / size), height-array[firstLineIndex], width / size, array[firstLineIndex]);
        graphicsContext.strokeRect(secondLineIndex*(width / size), height-array[secondLineIndex], width / size, array[secondLineIndex]);
        graphicsContext.fillRect(secondLineIndex*(width / size), height-array[secondLineIndex], width / size, array[secondLineIndex]);
    }

    public void drawAfterSorted() {
        if (rectangleIndexAfterSorted == 0) {
            drawBeforeSorted();
        }
        drawOneRectangle(rectangleIndexAfterSorted, Color.valueOf("#1fab89"));
        rectangleIndexAfterSorted++;
    }

    public int getRectangleIndexAfterSorted() {
        return rectangleIndexAfterSorted;
    }
}
