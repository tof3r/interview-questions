package com.dawidg90.sort.merge;

public class MergeSort {
    private static void merge(int[] array, int left, int middle, int right) {
        int sizeOfFirstSubArray = middle - left + 1;
        int sizeofSecondSubArray = right - middle;

        int[] leftSA = new int[sizeOfFirstSubArray];
        int[] rightSA = new int[sizeofSecondSubArray];

        for (int i = 0; i < sizeOfFirstSubArray; ++i) {
            leftSA[i] = array[left + i];
        }
        for (int j = 0; j < sizeofSecondSubArray; ++j) {
            rightSA[j] = array[middle + 1 + j];
        }

        int index = 0, index2 = 0;
        int indexInMergedArray = left;

        while (index < sizeOfFirstSubArray && index2 < sizeofSecondSubArray) {
            if (leftSA[index] <= rightSA[index2]) {
                array[indexInMergedArray] = leftSA[index];
                index++;
            } else {
                array[indexInMergedArray] = rightSA[index2];
                index2++;
            }
            indexInMergedArray++;
        }

        while (index < sizeOfFirstSubArray) {
            array[indexInMergedArray] = leftSA[index];
            index++;
            indexInMergedArray++;
        }

        while (index2 < sizeofSecondSubArray) {
            array[indexInMergedArray] = rightSA[index2];
            index2++;
            indexInMergedArray++;
        }
    }

    public static void sort(int[] array, int left, int right){
        if (left < right){
            int middle = left + (right - left)/2;
            sort(array, left, middle);
            sort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    public static void display(int[] array) {
        System.out.print("[");
        for (int i : array) {
            System.out.print(" ");
            System.out.print(i);
        }
        System.out.println("]");
    }
}
