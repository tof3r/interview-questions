package com.dawidg90.sort.quick;

public class QuickSort {
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int partitionWithLastElementAlways(int[] array, int beginIndex, int endIndex) {
        int pivot = array[endIndex];
        int index = (beginIndex - 1);
        for (int i = beginIndex; i <= endIndex - 1; i++) {
            if (array[i] < pivot) {
                index++;
                swap(array, index, i);
            }
        }
        swap(array, index + 1, endIndex);
        return (index + 1);
    }

    public static void quickSortPivotAlwaysLast(int[] array, int beginIndex, int endIndex) {
        if (beginIndex < endIndex) {
            int partitionIndex = partitionWithLastElementAlways(array, beginIndex, endIndex);
            quickSortPivotAlwaysLast(array, beginIndex, partitionIndex - 1);
            quickSortPivotAlwaysLast(array, partitionIndex + 1, endIndex);
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
