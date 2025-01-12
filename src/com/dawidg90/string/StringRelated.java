package com.dawidg90.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringRelated {
    public static boolean areAnagrams(String s, String t) {
        if (s.length() != t.length()) return false;
        final Hashtable<Character, Integer> frequenciesStringOne = new Hashtable<>();
        final Hashtable<Character, Integer> frequenciesStringTwo = new Hashtable<>();
        for (int i = 0; i < s.length(); i++) {
            if (frequenciesStringOne.containsKey(s.charAt(i))) {
                frequenciesStringOne.replace(s.charAt(i), frequenciesStringOne.get(s.charAt(i)) + 1);
            } else {
                frequenciesStringOne.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (frequenciesStringTwo.containsKey(t.charAt(i))) {
                frequenciesStringTwo.replace(t.charAt(i), frequenciesStringTwo.get(t.charAt(i)) + 1);
            } else {
                frequenciesStringTwo.put(t.charAt(i), 1);
            }
        }
        return frequenciesStringOne.equals(frequenciesStringTwo);
    }

    public static String kthPermutation(int sizeOfPermutation, int permutationToReturn) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= sizeOfPermutation; i++) {//O(n)
            builder.append(i);
        }
        String toPermute = builder.toString();
        List<String> permutations = new LinkedList<>();
        permute(toPermute, "", permutations);
        return permutations.get(permutationToReturn-1);
    }

    private static void permute(String toPermute, String answer, List<String> permutations) {
        {
            // If string is empty
            if (toPermute.isEmpty()) {
                System.out.print(answer + " ");
                permutations.add(answer);
                return;
            }

            for (int i = 0; i < toPermute.length(); i++) {//O(n)
                // ith character of str
                char ch = toPermute.charAt(i);

                // Rest of the string after excluding
                // the ith character
                String substring = toPermute.substring(0, i);
                String substring1 = toPermute.substring(i + 1);
                String ros = substring + substring1;

                // Recursive call
                permute(ros, answer + ch, permutations);//O(n)
            }
        }
    }

    //Given a string S, the task is to remove all the duplicates in the given string.
    public static String removeDuplicates(String input) {
        Set<Character> withoutDuplicates = new LinkedHashSet<>();
        for (int i = 0; i < input.length(); i++) {
            withoutDuplicates.add(input.charAt(i));
        }
        return withoutDuplicates
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    //Given a string, find the first repeated character in it.
    // We need to find the character that occurs more than
    // once and whose index of second occurrence is smallest.
    //Examples:
    //
    //Input: str = “hello and whoops”
    //Output: l
    //l is the first element that repeats
    public static String findFirstRepeatedLetter(String input) {
        Map<Character, Integer> repetitionMap = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (!repetitionMap.containsKey(input.charAt(i))) {
                repetitionMap.put(input.charAt(i), 1);
            } else {
                return String.valueOf(input.charAt(i));
            }
        }
        //nothing repeated
        return null;
    }

    //Given a sentence in the form of a string, convert it into
    // its equivalent mobile numeric keypad sequence.
    //
    //For obtaining a number, we need to press a
    //number corresponding to that character for
    //number of times equal to position of the
    //character. For example, for character C,
    //we press number 2 three times and accordingly.
    //
    //Example:
    //Input : HELLO WORLD
    //Output : 4433555555666096667775553
    public static String convertToKeyPad(String input, String[] keypad) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                builder.append("0");
            } else {
                //subtract ASCII value of 'A' and obtain position in the array
                int positionInKeypadArray = input.charAt(i) - 'A';
                builder.append(keypad[positionInKeypadArray]);
            }
        }
        return builder.toString();
    }

    //Given a set of strings, find the longest common prefix.
    //Example:
    //
    //Input  : {"apple", "ape", "april"}
    //Output : "ap"
    public static String findTheLongestCommonPrefix(String[] array) {
        int arraySize = array.length;
        int minLength = 0;

        minLength = array[0].length();
        for (int i = 1; i < arraySize; i++) {
            if (array[i].length() < minLength) {
                minLength = array[i].length();
            }
        }

        String result = "";
        char currentChar;

        for (int i = 0; i < minLength; i++) {
            currentChar = array[0].charAt(i);
            for (int j = 1; j < arraySize; j++) {
                if (array[j].charAt(i) != currentChar) return result;
            }
            result += currentChar;
        }
        return result;
    }

    //Let the input string be “i like this program very much”.
    // The function should change the string to
    // “much very program this like i”
    public static String reverseWordsInString(String input) {
        boolean startedWithSpace = input.charAt(0) == ' ';
        StringBuilder builder = new StringBuilder();
        String[] words = input.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            builder.append(words[i]);
            if (i > 0 || startedWithSpace) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public static String reverseStringUsingStack(String input) {
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    public static Map<Character, Integer> findAllDuplicatedChars(final String input) {
        Map<Character, Integer> occurrences = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (occurrences.containsKey(input.charAt(i))) {
                int count = occurrences.get(input.charAt(i));
                occurrences.put(input.charAt(i), count + 1);
            } else {
                occurrences.put(input.charAt(i), 1);
            }
        }

        Map<Character, Integer> duplicates = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.put(entry.getKey(), entry.getValue());
            }
        }
        return duplicates;
    }

    public static void replaceTwoStringsWithoutThirdOrTempVar(String one, String two) {
        System.out.println("\nBefore swap: " + one + ", " + two);

        one = one + two;
        two = one.substring(0, one.length() - two.length());
        one = one.substring(two.length());

        System.out.println("\nAfter swap: " + one + ", " + two);
    }

    public static void reverseStringWithSpacesOfOriginal(String input) {
        final char[] resultArray = new char[input.length()];
        for (int i = 0; i < resultArray.length; i++) {
            if (input.charAt(i) == ' ') {
                resultArray[i] = ' ';
            }
        }
        final String inputWoSpaces = input.replaceAll(" ", "");
        final StringBuilder builder = new StringBuilder();
        builder.append(inputWoSpaces).reverse();
        final String reversed = builder.toString();

        int index = 0;
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] != ' ') {
                resultArray[i] = reversed.charAt(index);
                index++;
            }
        }
        System.out.println("Reversed '" + input + "' is: " + new String(resultArray));
    }

    public static String firstNonRepeatedLetter(String input) {
        Map<Character, Integer> charsCount = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (charsCount.containsKey(input.charAt(i))) {
                charsCount.put(input.charAt(i), charsCount.get(input.charAt(i)) + 1);
            } else {
                charsCount.put(input.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charsCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey().toString();
            }
        }
        return null;
    }

    public static void allStringPermutation(String input) {
        allStringPermutation("", input);
    }

    public static List<String> allStringPermutationReturnList(String input) {
        List<String> toReturn = new ArrayList<>();
        return allStringPermutationReturnList("", input, toReturn);
    }

    private static void allStringPermutation(String permutation, String input) {
        if (input.isEmpty()) {
            System.out.print(permutation + " ");
        } else {
            for (int i = 0; i < input.length(); i++) {
                allStringPermutation(permutation + input.charAt(i), input.substring(0, i) + input.substring(i + 1));
            }
        }
    }

    private static List<String> allStringPermutationReturnList(String permutation, String input, List<String> toReturn) {
        if (input.isEmpty()) {
            toReturn.add(permutation);
        } else {
            for (int i = 0; i < input.length(); i++) {
                allStringPermutationReturnList(permutation + input.charAt(i), input.substring(0, i) + input.substring(i + 1), toReturn);
            }
        }
        return toReturn;
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        Map<Integer, String> keypad = new HashMap<>();
        keypad.put(2, "abc");
        keypad.put(3, "def");
        keypad.put(4, "ghi");
        keypad.put(5, "jkl");
        keypad.put(6, "mno");
        keypad.put(7, "pqrs");
        keypad.put(8, "tuv");
        keypad.put(9, "wxyz");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(digits.charAt(i))));
        }

        List<String> keypadValues = new ArrayList<>();
        for (Integer number : numbers) {
            keypadValues.add(keypad.get(number));
        }

        List<String> results = new ArrayList<>();
        String letters = "";//keypadValues.get(i);
        String lettersNext = "";//keypadValues.get(i+1);
        int index = 0;
        int bbb = keypadValues.size() - 1;
        if (index == bbb) letters = keypadValues.get(index);
        while (index < bbb) {
            letters = keypadValues.get(index);
            index++;
            lettersNext = (index >= keypadValues.size()) ? "" : keypadValues.get(index);
        }
        for (int j = 0; j < letters.length(); j++) {
            String charForNumber = letters.substring(j, j + 1);
            for (int k = 0; k < lettersNext.length(); k++) {
                String charForNext = lettersNext.substring(k, k + 1);
                results.add(charForNumber + charForNext);
            }
            if (lettersNext.isEmpty()) {
                results.add(charForNumber);
            }
        }

        return results;
    }

    public static boolean isPalindrome(String s) {
        if (" ".equals(s)) return true;
        String woSpace = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder();
        String reversed = sb.append(woSpace).reverse().toString();
        return woSpace.equals(reversed);
    }

    public static boolean repeatedSubstringPattern(String s) {
        return ((s + s).indexOf(s, 1) != s.length());
    }
}
