package com.ouday.sortingalgorithms;

public class BubbleSort {

    private final int[] array;
    private int sortingIndex = 0;
    private int firstSortingIndex = 0;
    private int secondSortingIndex = firstSortingIndex + 1;
    private int flag = 0;
    private final int size;


    public BubbleSort(int[] array) {
        this.array = array;
        size = this.array.length;
    }

    public void oneStepSortingBubbleSort() {
        if (sortingIndex < size - 1) {
            if (firstSortingIndex < size - sortingIndex - 1) {
                if (array[firstSortingIndex] > array[secondSortingIndex]) {
                    swap(firstSortingIndex, secondSortingIndex);
                    flag = 1;
                }
                firstSortingIndex++;
                secondSortingIndex++;
            }
            if (firstSortingIndex == size - sortingIndex - 1) {
                if (flag == 0)
                    sortingIndex = size - 1;
                else
                    sortingIndex++;
                firstSortingIndex = 0;
                secondSortingIndex = firstSortingIndex + 1;
                flag = 0;
            }
        }
    }

    private void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public int getSortingIndex() {
        return sortingIndex;
    }

    public int getFirstSortingIndex() {
        return firstSortingIndex;
    }

    public int getSecondSortingIndex() {
        return secondSortingIndex;
    }

}