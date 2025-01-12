package com.dawidg90.array;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nSort Strings from array containing words and numbers alphabetically and in ascending order, time: O(n) space: O(n)");
        final String[] input = new String[]{"world", "4", "hello", "1"};
        System.out.println("Array before sorting: " + Arrays.toString(input));
        final List<String> output = ArrayRelated.sortStringsAlphabeticallyAndInAscendingOrder(Arrays.asList(input));
        System.out.print("After sorting: [");
        output.forEach(s -> System.out.print(s + " "));
        System.out.println("]");

        System.out.println("\nFirst and last position in array time: O(n) space: O(1)");
        int[] ints = ArrayRelated.firstAndLastPosition(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 8);
        System.out.println("First and last index of '8' are: " + Arrays.toString(ints));
        int[] ints2 = ArrayRelated.firstAndLastPosition(new int[]{1, 2, 3, 4, 5}, 6);
        System.out.println("First and last index of '6' are: " + Arrays.toString(ints2));

        System.out.println("\nFirst and last position in array (binary search) time: O(log(n)) space: O(1)");
        int[] ints3 = ArrayRelated.firstAndLastPositionUsingBinarySearch(new int[]{1, 2, 3, 4, 5}, 6);
        System.out.println("First and last index of '6' are: " + Arrays.toString(ints3));
        int[] ints4 = ArrayRelated.firstAndLastPositionUsingBinarySearch(new int[]{1, 2, 3}, 1);
        System.out.println("First and last index of '1' are" + Arrays.toString(ints4));
        int[] ints5 = ArrayRelated.firstAndLastPositionUsingBinarySearch(new int[]{1, 2, 3, 4, 4}, 4);
        System.out.println("First and last index of '4' are" + Arrays.toString(ints5));
        int[] ints7 = ArrayRelated.firstAndLastPositionUsingBinarySearch(new int[]{1, 2, 3, 4}, 4);
        System.out.println("First and last index of '4' are" + Arrays.toString(ints7));
        int[] ints6 = ArrayRelated.firstAndLastPositionUsingBinarySearch(new int[]{1, 2, 3, 3, 3, 4}, 3);
        System.out.println("First and last index of '3' are" + Arrays.toString(ints6));

        System.out.println("\nKth largest element time: O(n + k*log(n)) space: O(n)");
        int i = ArrayRelated.kthLargestElement(new int[]{4, 7, 1, 55, 23, 12, 6}, 4);//7
        System.out.println("4th largest element is: " + i);

        System.out.println("\nGas station time: O(n^2) space: O(1)");
        int gasStation = ArrayRelated.gasStation(new int[]{1, 5, 3, 3, 5, 3, 1, 3, 4, 5}, new int[]{5, 2, 2, 8, 2, 4, 2, 5, 1, 2});
        System.out.println("Station which enable to do a cycle without empty tank is: " + gasStation);

        System.out.println("\nGas station improved time: O(n) space: O(1)");
        int stationImproved = ArrayRelated.gasStationImproved(new int[]{1, 5, 3, 3, 5, 3, 1, 3, 4, 5}, new int[]{5, 2, 2, 8, 2, 4, 2, 5, 1, 2});
        System.out.println("Possible valid station is: " + stationImproved);

        System.out.println("\nArrays are equal time O(n) space O(n)");
        boolean equal = ArrayRelated.arraysAreEqual(new int[]{1, 2, 5, 4, 0}, new int[]{2, 4, 5, 0, 1});
        System.out.println("Arrays arr1[] = {1, 2, 5, 4, 0}, arr2[] = {2, 4, 5, 0, 1} are equal: " + equal);
        boolean equal2 = ArrayRelated.arraysAreEqual(new int[]{1, 2, 5, 4, 0, 2, 1}, new int[]{2, 4, 5, 0, 1, 1, 2});
        System.out.println("Arrays arr1[] = {1, 2, 5, 4, 0, 2, 1}, arr2[] = {2, 4, 5, 0, 1, 1, 2} are equal: " + equal2);
        boolean equal3 = ArrayRelated.arraysAreEqual(new int[]{1, 7, 1}, new int[]{7, 7, 1});
        System.out.println("Arrays arr1[] = {1, 7, 1}, arr2[] = {7, 7, 1} are equal: " + equal3);

        System.out.println("\nMissing element in array time O(n) space O(1)");
        int missingNumberInArray = ArrayRelated.getMissingNumberInArray(new int[]{1, 2, 4, 6, 3, 7, 8});
        System.out.println("Missing value in array arr[] = {1, 2, 4, 6, 3, 7, 8} is: " + missingNumberInArray);
        int missingNumberInArray2 = ArrayRelated.getMissingNumberInArray(new int[]{1, 2, 3, 5});
        System.out.println("Missing value in array arr[] = {1, 2, 3, 5} is: " + missingNumberInArray2);

        System.out.println("\nKth element of sorted array O(k) space O(1)");
        int kthElementOfSortedArray = ArrayRelated.findKthElementOfSortedArray(new int[]{2, 3, 5, 6, 7, 9, 11}, new int[]{1, 4, 8, 10}, 11);
        System.out.println("11th element of sorted array is: " + kthElementOfSortedArray);

        System.out.println("\n:::Hash table related:::");
        System.out.println("\nFind all pairs whose sum is x time O(max(m,n)) space O(n)");
        ArrayRelated.findAllPairsSumUpTo(new int[]{1, 0, -4, 7, 6, 4}, new int[]{0, 2, 4, -3, 2, 1}, 8);
        ArrayRelated.findAllPairsSumUpTo(new int[]{1, 2, 4, 5, 7}, new int[]{5, 6, 3, 4, 8}, 9);

        ArrayRelated.findAllPairsSumUpTo(new int[]{2, 3, 6, 7}, 7);

        System.out.println("\nFind common elements in 3 tables time O(n1*(log(n2*n3)) space O(1)");
        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println("Common elements are: ");
        ArrayRelated.findCommon(ar1, ar2, ar3);

        Map<String, Integer> evenAndOddsInArray = ArrayRelated.countEvenAndOddsInArray(new int[]{2, 4, 5, 1, 7, 14, 13, 3});
        System.out.println("\nNumber of even number is: " + evenAndOddsInArray.get("even") + ", and odd numbers is: " + evenAndOddsInArray.get("odd"));

        int[] example = {1, 5, 7, -1, 5};
        ArrayRelated.pairsWhichSumUpToGivenValue(example, 6);
    }
}
