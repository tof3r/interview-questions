package com.dawidg90.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nAnagrams time: O(n) space: O(n)");
        boolean areAnagrams = StringRelated.areAnagrams("danger", "garden");
        System.out.println("'danger' and 'garden' are anagrams: " + areAnagrams);
        boolean areAnagrams1 = StringRelated.areAnagrams("nameless", "salesman");
        System.out.println("'nameless' and 'salesman' are anagrams: " + areAnagrams1);

        System.out.println("\nKthest permutation time: O(n*n!) space: O(n!)");
        String kthPermutation = StringRelated.kthPermutation(4, 12);
        System.out.println("4th permutation is: " + kthPermutation);

        System.out.println("\nRemove duplicates from String O(n) space O(n)");
        String text = StringRelated.removeDuplicates("Super duplicated text");
        System.out.println("After duplicates removal: " + text);

        System.out.println("\nFirst repeated character O(n) space O(n)");
        String toCheck = StringRelated.findFirstRepeatedLetter("Hello and whoops");
        System.out.println("First repeated letter in 'Hello and whoops' is: " + toCheck);

        System.out.println("\nConvert a sentence into its equivalent mobile numeric keypad sequence O(n) space O(n)");
        // storing the sequence in array
        String keypad[] = {
                "2", "22", "222",
                "3", "33", "333",
                "4", "44", "444",
                "5", "55", "555",
                "6", "66", "666",
                "7", "77", "777", "7777",
                "8", "88", "888",
                "9", "99", "999", "9999"
        };
        String keypadCombination = StringRelated.convertToKeyPad("HELLO WORLD", keypad);
        System.out.println("Keypad combination for 'HELLO WORLD' is: " + keypadCombination);
        System.out.println("Given combination is equal with '4433555555666096667775553': " + ("4433555555666096667775553".equals(keypadCombination)));

        System.out.println("\nFind the longest common prefix time O(n*m) space O(m) n-# of strings, m-length of shortest string");
        String[] arr = {"apple", "ape", "april"};
        String theLongestCommonPrefix = StringRelated.findTheLongestCommonPrefix(arr);
        System.out.println("The longest common prefix is: " + theLongestCommonPrefix);

        System.out.println("\nReverse words in string time O(n) space O(n)");
        String reverseWordsInString = StringRelated.reverseWordsInString(" i like this program very much");
        System.out.println("Reversed words' string of 'i like this program very much' is: '" + reverseWordsInString + "'");

        System.out.println("\nFind all duplicated characters, time: O(n), space O(n)");
        Map<Character, Integer> suppa_good_hannavald = StringRelated.findAllDuplicatedChars("Suppa good Hannavald");
        System.out.println("\nDuplicate characters in 'Suppa good Hannavald' are: " + suppa_good_hannavald);

        System.out.println("\nReplace the places of two Strings without using third variable, time O(1), space O(1)");
        StringRelated.replaceTwoStringsWithoutThirdOrTempVar("James", "Bond");

        System.out.println("\nReversing the String retaining the spaces of original String, time: O(n), space O(n)");
        StringRelated.reverseStringWithSpacesOfOriginal("I Am Not String");
        StringRelated.reverseStringWithSpacesOfOriginal("JAVA JSP ANDROID");
        StringRelated.reverseStringWithSpacesOfOriginal("1 22 333 4444 55555");

        System.out.println("\nFirst non repeated letter in word 'analogy' is: " + StringRelated.firstNonRepeatedLetter("analogy"));
        System.out.println("First non repeated letter in word 'easiest' is: " + StringRelated.firstNonRepeatedLetter("easiest"));

        System.out.println("\nAll 'JSP' permutations: ");
        StringRelated.allStringPermutation("JSP");
        List<String> permutationReturnList = StringRelated.allStringPermutationReturnList("JSP");
        System.out.println("\nNumber of 'JSP' permutations is: " + permutationReturnList.size());
        System.out.println("These permutations are:");
        for (String s : permutationReturnList) {
            System.out.print(s + " ");
        }

        System.out.println("\nLetter combinations from given numbers");
        List<String> strings = StringRelated.letterCombinations("2345");
        strings.forEach(sx -> System.out.print(sx + " "));
        System.out.println("\n");

        System.out.println("Checking palindromes:");
        System.out.println("'A man, a plan, a canal: Panama' is palindrome: " + StringRelated.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("'OP' is palindrome: " + StringRelated.isPalindrome("0P"));

        System.out.println("\nChecks the repeating pattern in given String");
        System.out.println("abab: " + StringRelated.repeatedSubstringPattern("abab"));
        System.out.println("aba: " + StringRelated.repeatedSubstringPattern("aba"));
        System.out.println("abcabcabcabc: " + StringRelated.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println("abcdabc: " + StringRelated.repeatedSubstringPattern("abcdabc"));

        String reversed = StringRelated.reverseStringUsingStack("Dawid is a good man.");
        System.out.println("\nReversed input 'Dawid is a good man.': " + reversed);
    }
}
