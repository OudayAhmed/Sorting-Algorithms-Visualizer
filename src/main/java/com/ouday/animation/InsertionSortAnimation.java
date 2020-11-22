package com.ouday.animation;

import com.ouday.sortingalgorithms.InsertionSort;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;
import java.util.List;

public class InsertionSortAnimation extends SortingAlgorithmAnimation {

    private InsertionSort insertionSort;
    private int[] array;
    private Draw draw = getDraw();
    private int sortingIndex;
    private int searchMinimumIndex;
    private int size;

    public InsertionSortAnimation(int[] array, Canvas canvas, Duration duration, List<FontIcon> fontIconList) {
        super(array, canvas, duration, fontIconList);
        this.array = array;
        this.size = array.length;
        this.insertionSort = new InsertionSort(this.array);
    }

    @Override
    public void oneStepSorting() {
        sortingIndex = insertionSort.getSortingIndex();
        searchMinimumIndex = insertionSort.getSearchMinimumIndex();
        if (sortingIndex < size) {
            draw.drawBeforeSorted();
            draw.drawOneRectangle(sortingIndex, Color.valueOf("#fa4659"));
            draw.drawOneRectangle(searchMinimumIndex, Color.valueOf("#ffd460"));
            insertionSort.oneStepSortingInsertionSort();
        } else if (draw.getRectangleIndexAfterSorted() < size) {
            if(sortingIndex == size) {
                draw.drawAfterSorted();
            }
        } else if (draw.getRectangleIndexAfterSorted() == size) {
            setSortingIsCompleted(true);
        }
    }
}
