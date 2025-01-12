package com.dawidg90.stack;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class StackRelated {
    public static void parenthesisBalanceCheck(String inputString) {
        String[] array = inputString.split("\n");
        for (int u = 0; u < array.length; u++) {
            String input = array[u];

            if (checkBrackets(input)) {
                System.out.println((u + 1) + ": true");
            } else {
                System.out.println((u + 1) + ": false");
            }
        }
    }

    private static boolean checkBrackets(String input) {
        Stack<Character> stack = new Stack<>();
        if (input.isEmpty()) {
            return true;
        }

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (character == '[' || character == '{' || character == '(') {
                stack.push(character);
            } else if (character == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (character == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (character == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    //Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in the array. Elements for which no greater element exist, consider the next greater element as -1.
    public static int minimumCostPath(int[][] array, int xCord, int yCord) {
        Map<String, Integer> memo = new Hashtable<>();
        return minimumCostPathRecursive(array, xCord, yCord, memo);
    }

    private static int minimumCostPathRecursive(int[][] array, int xCord, int yCord, Map<String, Integer> memo) {
        var rowInBounds = 0 <= xCord && xCord < array.length;
        var colInBounds = 0 <= yCord && yCord < array[0].length;
        if (!rowInBounds || !colInBounds) return Integer.MAX_VALUE;
        if (xCord == 0 && yCord == 0) return array[xCord][yCord];

        String key = xCord + "," + yCord;
        if (memo.containsKey(key)) return memo.get(key);

        memo.put(key, array[xCord][yCord]);
        int i = array[xCord][yCord];
        int a = minimumCostPathRecursive(array, xCord-1, yCord - 1, memo);
        int a1 = minimumCostPathRecursive(array, xCord - 1, yCord, memo);
        int b = minimumCostPathRecursive(array, xCord, yCord - 1, memo);
        return i + Math.min(Math.min(a, a1), Math.min(a1, b));
    }

    public static void printNextGreaterElement(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= array[i]) {
                    stack.pop();
                }
            }
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " --> " + nge[i]);
        }
    }
}
