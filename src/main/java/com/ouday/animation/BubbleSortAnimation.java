package com.ouday.animation;

import com.ouday.sortingalgorithms.BubbleSort;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.List;

public class BubbleSortAnimation extends SortingAlgorithmAnimation {

    private final BubbleSort bubbleSort;
    private final Draw draw = getDraw();
    private final int size;


    public BubbleSortAnimation(int[] array, Canvas canvas, Duration duration, List<FontIcon> fontIconList) {
        super(array, canvas, duration, fontIconList);
        this.size = array.length;
        this.bubbleSort = new BubbleSort(array);
    }

    @Override
    public void oneStepSorting() {
        int sortingIndex = bubbleSort.getSortingIndex();
        int firstSortingIndex = bubbleSort.getFirstSortingIndex();
        int secondSortingIndex = bubbleSort.getSecondSortingIndex();
        if (sortingIndex < size - 1) {
            draw.drawBeforeSorted();
            draw.drawOneRectangle(firstSortingIndex, Color.valueOf("#fa4659"));
            draw.drawOneRectangle(secondSortingIndex, Color.valueOf("#ffd460"));
            bubbleSort.oneStepSortingBubbleSort();
        } else if (draw.getRectangleIndexAfterSorted() < size) {
            if (sortingIndex == size - 1)
                draw.drawAfterSorted();
        } else if (draw.getRectangleIndexAfterSorted() == size)
            setSortingIsCompleted(true);
    }

}