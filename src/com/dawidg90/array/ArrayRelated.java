package com.dawidg90.array;

import com.dawidg90.search.binary.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

public class ArrayRelated {
    //input:  ['world', '4', 'hello', '1']
    //output: ['hello', '1', 'world', '4']
    public static List<String> sortStringsAlphabeticallyAndInAscendingOrder(List<String> input) {
        final List<String> result = new LinkedList<>();
        final List<String> words = new LinkedList<>();
        final List<String> numbers = new LinkedList<>();

        boolean[] wordsOrder = new boolean[input.size()];

        final String onlyNumbers = "[0-9]+";
        final Pattern pattern = Pattern.compile(onlyNumbers);

        for (int i = 0; i < input.size(); i++) {//O(n)
            if (pattern.matcher(input.get(i)).matches()) {//O(n)
                numbers.add(input.get(i));
                wordsOrder[i] = false;
            } else {
                words.add(input.get(i));
                wordsOrder[i] = true;
            }
        }

        Collections.sort(numbers);//O(n*log(n))
        Collections.sort(words);

        int wordIndex = 0;
        int numberIndex = 0;
        for (boolean isWord : wordsOrder) {
            if (isWord) {
                result.add(words.get(wordIndex));
                wordIndex++;
            } else {
                result.add(numbers.get(numberIndex));
                numberIndex++;
            }
        }
        return result;
    }

    public static int[] firstAndLastPosition(int[] array, int target) {
        if (array.length == 0) return new int[]{-1, -1};
        Hashtable<String, Integer> indexes = new Hashtable<>(2);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                if (!indexes.containsKey("fI")) indexes.put("fI", i);
                if (!indexes.containsKey("lI")) {
                    indexes.put("lI", i);
                } else {
                    indexes.replace("lI", i);
                }
            }
        }
        return new int[]{indexes.getOrDefault("fI", -1),
                indexes.getOrDefault("lI", -1)};
    }

    public static int[] firstAndLastPositionUsingBinarySearch(int[] array, int target) {
        if (array.length == 0) return new int[]{-1, -1};
        if (array[0] > target) return new int[]{-1, -1};
        if (array[array.length - 1] < target) return new int[]{-1, -1};
        int startPos = findStart(array, target);
        int endPos = findEnd(array, target);
        return new int[]{startPos, endPos};
    }

    private static int findStart(int[] array, int target) {
        if (array[0] == target) return 0;

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + (right - left) / 2);
            if (array[mid] == target && array[mid - 1] < target)
                return mid;
            else if (array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    private static int findEnd(int[] array, int target) {
        if (array[array.length - 1] == target) return array.length - 1;

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + (right - left) / 2);
            if (array[mid] == target && array[mid + 1] > target)
                return mid;
            else if (array[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static int kthLargestElement(int[] array, int kthElement) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {//O(n)
            priorityQueue.add(array[i]);
        }
        for (int i = 0; i < kthElement - 1; i++) { //O(k-1)
            priorityQueue.poll();//O(log(n))
        }
        return priorityQueue.poll();//O(log(n)
    }//O(n) + O(k-1) * O(log(n)) + O(log(n)) = O(n) + O(k*log(n)) + O(log(n) = O(n + k*log(n))

    public static int gasStation(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (canTraverse(gas, cost, i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean canTraverse(int[] gas, int[] cost, int startPosition) {
        int gasInTank = 0;
        int numberOfStations = gas.length;
        int i = startPosition;
        boolean started = false;
        while (i != startPosition || !started) {
            started = true;
            gasInTank += gas[i] - cost[i];
            if (gasInTank < 0) return false;
            i = (i + 1) % numberOfStations;
        }
        return true;
    }

    public static int gasStationImproved(int[] gas, int[] cost) {
        int gasInTank = 0;
        int possibleValidStation = 0;
        int balanceForPreviousStations = 0;
        for (int i = 0; i < gas.length; i++) {
            gasInTank += gas[i] - cost[i];
            if (gasInTank < 0) {
                possibleValidStation = i + 1;
                balanceForPreviousStations += gasInTank;
                gasInTank = 0;
            }
        }

        if (possibleValidStation == gas[gas.length - 1] || gasInTank + balanceForPreviousStations < 0) return -1;
        else return possibleValidStation;
    }

    //Given two arrays, arr1 and arr2 of equal length N, the task is to find if the given arrays are equal or not.
    //
    //Two arrays are said to be equal if:
    //
    //both of them contain the same set of elements,
    //arrangements (or permutations) of elements might/might not be same.
    //If there are repetitions, then counts of repeated elements must also be the same for two arrays to be equal.

    //Examples:
    //
    //Input: arr1[] = {1, 2, 5, 4, 0}, arr2[] = {2, 4, 5, 0, 1}
    //Output: Yes
    //
    //Input: arr1[] = {1, 2, 5, 4, 0, 2, 1}, arr2[] = {2, 4, 5, 0, 1, 1, 2}
    //Output: Yes
    //
    // Input: arr1[] = {1, 7, 1}, arr2[] = {7, 7, 1}
    //Output: No
    public static boolean arraysAreEqual(int[] array1, int[] array2) {
        int sizeArr1 = array1.length;
        int sizeArr2 = array2.length;

        if (sizeArr1 != sizeArr2) return false;
        Map<Integer, Integer> arr1Content = new HashMap<>();
        for (int j : array1) {
            if (arr1Content.get(j) == null) {
                arr1Content.put(j, 1);
            } else {
                arr1Content.replace(j, arr1Content.get(j) + 1);
            }
        }

        for (int j : array2) {
            if (!arr1Content.containsKey(j)) return false;
            if (arr1Content.get(j) == 0) return false;

            arr1Content.replace(j, arr1Content.get(j) - 1);
        }
        return true;
    }

    //Find the missing number
    //Given an array arr[] of size N-1 with integers in the range of [1, N], the task is to find the missing number from the first N integers.
    //
    //Note: There are no duplicates in the list.
    //
    //Examples:
    //
    //Input: arr[] = {1, 2, 4, 6, 3, 7, 8}, N = 7
    //Output: 5
    //Explanation: The missing number between 1 to 8 is 5
    //
    //Input: arr[] = {1, 2, 3, 5}, N = 5
    //Output: 4
    //Explanation: The missing number between 1 to 5 is 4

    //Use the formula N*(N+1)/2 to get total sum of N elements
    public static int getMissingNumberInArray(int[] array) {
        int arrSize = array.length;
        int totalSum = ((arrSize + 1) * (arrSize + 2)) / 2;
        for (int i : array) {
            totalSum -= i;
        }
        return totalSum;
    }

    //Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the k’th position of the final sorted array.
    //
    //Examples:
    //
    //Input : Array 1 - 2 3 6 7 9
    //        Array 2 - 1 4 8 10
    //        k = 5
    //Output : 6
    //Explanation: The final sorted array would be -
    //1, 2, 3, 4, 6, 7, 8, 9, 10
    //The 5th element of this array is 6.
    //
    //Input : Array 1 - 100 112 256 349 770
    //        Array 2 - 72 86 113 119 265 445 892
    //        k = 7
    //Output : 256
    //Explanation: Final sorted array is -
    //72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
    //7th element of this array is 256.
    public static int findKthElementOfSortedArray(int[] array1, int[] array2, int kthElementToFind) {
        int sizeA1 = array1.length;
        int sizeA2 = array2.length;

        int k = 0, i = 0, j = 0;

        // Keep taking smaller of the current
        // elements of two sorted arrays and
        // keep incrementing k
        while (i < sizeA1 && j < sizeA2) {
            if (array1[i] < array2[j]) {
                k++;
                if (k == kthElementToFind) return array1[i];
                i++;
            } else {
                k++;
                if (k == kthElementToFind) return array2[j];
                j++;
            }
        }

        while (i < sizeA1) {
            k++;
            if (k == kthElementToFind) return array1[i];
            i++;
        }

        while (j < sizeA2) {
            k++;
            if (k == kthElementToFind) return array2[j];
            j++;
        }
        return -1;
    }

    //Given two unsorted arrays of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.
    //Examples
    //Input :  arr1[] = {-1, -2, 4, -6, 5, 7}
    //         arr2[] = {6, 3, 4, 0}
    //         x = 8
    //Output : 4 4
    //         5 3
    //
    //Input : arr1[] = {1, 2, 4, 5, 7}
    //        arr2[] = {5, 6, 3, 4, 8}
    //        x = 9
    //Output : 1 8
    //         4 5
    //         5 4
    public static void findAllPairsSumUpTo(int[] array1, int[] array2, int sumUpTo){
        Map<Integer, Integer> hashTable = new Hashtable<>();
        for (int j : array1) {
            hashTable.put(j, 0);
        }
        for (int j : array2) {
            int subtractResult = sumUpTo - j;
            if (hashTable.containsKey(subtractResult)) {
                System.out.println(subtractResult + " + " + j + " = " + sumUpTo);
            }
        }
    }

    public static void findAllPairsSumUpTo(int[] array1, int sumUpTo){
        List<List<Integer>> sum = new ArrayList<>();
        List<Integer> x = new ArrayList<>();
        for (int j : array1) {
            x.add(j);
        }
        for (int j : array1) {
            int subtractResult = sumUpTo - j;
            if (x.contains(subtractResult)) {
                System.out.println(subtractResult + " + " + j + " = " + sumUpTo);
            }
        }
    }

    //Given three arrays sorted in non-decreasing order, print all common elements in these arrays.
    //Examples
    //Input:
    //ar1[] = {1, 5, 10, 20, 40, 80}
    //ar2[] = {6, 7, 20, 80, 100}
    //ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
    //Output: 20, 80
    //
    //Input:
    //ar1[] = {1, 5, 5}
    //ar2[] = {3, 4, 5, 5, 10}
    //ar3[] = {5, 5, 10, 20}
    //Output: 5, 5
    public static void findCommon(int[] arr1, int[] arr2, int[] arr3) {
        for (int i = 0; i < arr1.length; i++) {
            if (i != 0 && arr1[i] == arr1[i - 1]) {
                continue;
            }
            if (BinarySearch.searchContains(arr2, arr1[i], 0, arr2.length) && BinarySearch.searchContains(arr3, arr1[i], 0, arr3.length)){
                System.out.print(arr1[i] + " ");
            }
        }
    }

    public static Map<String, Integer> countEvenAndOddsInArray(int[] array) {
        Map<String, Integer> occurrences = new HashMap<>();
        int odds = 0;
        int evens = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evens++;
            } else {
                odds++;
            }
        }
        occurrences.put("odd", odds);
        occurrences.put("even", evens);
        return occurrences;
    }

    public static void pairsWhichSumUpToGivenValue(int[] array, int sumUpTo) {
        Map<Integer, Integer> numbers = new LinkedHashMap<>();
        int count = 0;
        for (int j : array) {
            if (numbers.containsKey(sumUpTo - j)) {
                count += numbers.get(sumUpTo - j);
                System.out.println("Pair: " + (sumUpTo - j) + " + " + j);
            }
            if (numbers.containsKey(j)) {
                numbers.put(j, numbers.get(j) + 1);
            } else {
                numbers.put(j, 1);
            }
        }
        System.out.println("\nNumber of pairs which sum up to '" + sumUpTo + "' is: " + count);
    }
}
