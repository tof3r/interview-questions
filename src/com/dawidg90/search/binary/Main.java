package com.dawidg90.search.binary;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] inputData = {15, 2, 8, 5, 14, 8, 1, 4, 13, 9, 8, 11, 12, 3, 8, 6, 10, 7};
        Arrays.sort(inputData);

        int index = BinarySearch.searchIterative(inputData, 10, 0, inputData.length - 1);
        System.out.println("Found index is: " + index);

        int recursive = BinarySearch.searchRecursive(inputData, 11, 0, inputData.length - 1);
        System.out.println("Found index is: " + recursive);
    }
}
