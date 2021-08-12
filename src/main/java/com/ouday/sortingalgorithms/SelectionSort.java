package com.ouday.sortingalgorithms;

public class SelectionSort {

    private final int[] array;
    private int sortingIndex = 0;
    private int searchMinimumIndex = 1;
    private int minimumIndex = sortingIndex;
    private final int size;


    public SelectionSort(int[] array) {
        this.array = array;
        size = this.array.length;
    }

    public void oneStepSortingSelectionSort() {
        if (sortingIndex < size - 1) {
            if (searchMinimumIndex < size) {
                if (array[minimumIndex] > array[searchMinimumIndex]) {
                    minimumIndex = searchMinimumIndex;
                }
                searchMinimumIndex++;
            } else if (searchMinimumIndex == size) {
                swap();
                sortingIndex++;
                searchMinimumIndex = sortingIndex + 1;
                minimumIndex = sortingIndex;
            }
        }
    }

    private void swap() {
        int temp = array[sortingIndex];
        array[sortingIndex] = array[minimumIndex];
        array[minimumIndex] = temp;
    }

    public int getSortingIndex() {
        return sortingIndex;
    }

    public int getSearchMinimumIndex() {
        return searchMinimumIndex;
    }

    public int getMinimumIndex() {
        return minimumIndex;
    }

}