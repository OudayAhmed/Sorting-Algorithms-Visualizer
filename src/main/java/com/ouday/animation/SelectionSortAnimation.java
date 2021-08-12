package com.ouday.animation;

import com.ouday.sortingalgorithms.SelectionSort;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.List;

public class SelectionSortAnimation extends SortingAlgorithmAnimation {

    private final SelectionSort selectionSort;
    private final Draw draw = getDraw();
    private final int size;


    public SelectionSortAnimation(int[] array, Canvas canvas, Duration duration, List<FontIcon> fontIconList) {
        super(array, canvas, duration, fontIconList);
        this.size = array.length;
        this.selectionSort = new SelectionSort(array);
    }

    @Override
    public void oneStepSorting() {
        int sortingIndex = selectionSort.getSortingIndex();
        int searchMinimumIndex = selectionSort.getSearchMinimumIndex();
        int minimumIndex = selectionSort.getMinimumIndex();
        if (sortingIndex < size - 1) {
            draw.drawBeforeSorted();
            draw.drawTwoRectangleBeforeSorted(sortingIndex, minimumIndex, Color.valueOf("#fa4659"));
            if (searchMinimumIndex < size) {
                draw.drawOneRectangle(searchMinimumIndex, Color.valueOf("#ffd460"));
                selectionSort.oneStepSortingSelectionSort();
            } else if (searchMinimumIndex == size) {
                selectionSort.oneStepSortingSelectionSort();
                draw.drawTwoRectangleAfterSorted(minimumIndex, sortingIndex, Color.valueOf("#ff9a3c"));
            }
        } else if (draw.getRectangleIndexAfterSorted() < size) {
            if (sortingIndex == size - 1)
                draw.drawAfterSorted();
        } else if (draw.getRectangleIndexAfterSorted() == size)
            setSortingIsCompleted(true);
    }

}