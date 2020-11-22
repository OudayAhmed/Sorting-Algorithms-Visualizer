package com.ouday.sortingalgorithms;

public class InsertionSort {

    private int[] array;
    private int sortingIndex = 1;
    private int searchMinimumIndex = sortingIndex - 1;
    private int key;
    private int size;

    public InsertionSort(int[] array) {
        this.array = array;
        size = this.array.length;
        key = this.array[sortingIndex];
    }

    public void oneStepSortingInsertionSort() {
        if (sortingIndex < size) {
            int temp = sortingIndex;
            if (searchMinimumIndex >= 0 && array[searchMinimumIndex] > key) {
                array[searchMinimumIndex + 1] = array[searchMinimumIndex];
                searchMinimumIndex--;
            }
            if (searchMinimumIndex >= 0 && array[searchMinimumIndex] <= key) {
                array[searchMinimumIndex + 1] = key;
                sortingIndex++;
            }
            if (searchMinimumIndex == -1) {
                array[searchMinimumIndex + 1] = key;
                searchMinimumIndex++;
                sortingIndex++;
            }
            if (temp != sortingIndex) {
                if (sortingIndex < size) {
                    key = array[sortingIndex];
                    searchMinimumIndex = sortingIndex - 1;
                }
            }
        }
    }

    public int getSortingIndex() {
        return sortingIndex;
    }

    public int getSearchMinimumIndex() {
        return searchMinimumIndex;
    }
}
