package com.ouday.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ArrayData {

    private int[] array;
    private int sizeOfTheArray;

    public ArrayData(int sizeOfTheArray) {
        this.sizeOfTheArray = sizeOfTheArray;
        this.array = new int[sizeOfTheArray];
    }

    public int[] getRandomArray() {
        Random random = new Random();
        for (int i = 0; i < sizeOfTheArray; i++) {
            array[i] = 10 + random.nextInt(605);
        }
        return array;
    }

    public int[] getDescendingOrderArray() {
        getRandomArray();
        int[] array = Arrays.stream(this.array).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        return array;
    }

    public int[] getAscendingOrderArray() {
        getRandomArray();
        Arrays.sort(array);
        return array;
    }
}
