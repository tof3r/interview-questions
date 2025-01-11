package com.dawidg90.search.binary;

public class BinarySearch {
    public static int searchIterative(int[] sortedArray, int key, int beginIndex, int endIndex) {
        int index = Integer.MAX_VALUE;

        while (beginIndex <= endIndex) {
            int middle = beginIndex + ((endIndex - beginIndex) / 2);
            if (sortedArray[middle] < key) {
                beginIndex = middle + 1;
            } else if(sortedArray[middle] > key){
                endIndex = middle - 1;
            } else if (sortedArray[middle] == key){
                index = middle;
                break;
            }
        }
        return index;
    }

    public static int searchRecursive(int[] sortedArray, int key, int beginIndex, int endIndex){
        int middle = beginIndex + ((endIndex - beginIndex) / 2);

        if (endIndex < beginIndex)
        {
            return -1;
        }

        if (key == sortedArray[middle]){
            return middle;
        } else if(key < sortedArray[middle]) {
            return searchRecursive(sortedArray, key, beginIndex, middle - 1);
        } else {
            return searchRecursive(sortedArray, key, middle + 1, endIndex);
        }
    }

    public static boolean searchContains(int[] sortedArray, int key, int beginIndex, int endIndex){
        int middle = beginIndex + ((endIndex - beginIndex) / 2);

        if (endIndex < beginIndex)
        {
            return false;
        }

        if (key == sortedArray[middle]){
            return true;
        } else if(key < sortedArray[middle]) {
            return searchContains(sortedArray, key, beginIndex, middle - 1);
        } else {
            return searchContains(sortedArray, key, middle + 1, endIndex);
        }
    }
}
