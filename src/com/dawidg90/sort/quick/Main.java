package com.dawidg90.sort.quick;

public class Main {
    public static void main(String[] args) {
        int[] inputData = {15, 2, 8, 5, 14, 8, 1, 4, 13, 9, 8, 11, 12, 3, 8, 6, 10, 7};
        System.out.println("Before sort:");
        QuickSort.display(inputData);

        //Time complexity: O(n*log(n)) average, O(n^2) worst case
        //Space complexity: O(log(n)), worst case O(n)
        QuickSort.quickSortPivotAlwaysLast(inputData, 0, inputData.length - 1);

        System.out.println("After sort:");
        QuickSort.display(inputData);
    }
}
