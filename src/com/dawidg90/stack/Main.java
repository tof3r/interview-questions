package com.dawidg90.stack;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n:::::::::Print next greater element time O(n) space O(n):::::::::");
        StackRelated.printNextGreaterElement(new int[]{11, 13, 21, 3});

        System.out.println("\nParenthesis balance check");
        String input = """
                (((
                []
                ({}[])
                (({()})))
                ({(){}()})()({(){}()})(){()}
                {}()))(()()({}}{}
                }}}}
                ))))
                {{{
                (((
                []{}(){()}((())){{{}}}{()()}{{}{}}
                [[]][][]
                }{
                """;
        StackRelated.parenthesisBalanceCheck(input);

        System.out.println("\nMinimum path cost time O(m*n) space O(m*n)");
        int[][] cost = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        int costPath = StackRelated.minimumCostPath(cost, 2, 2);
        System.out.println("Minimum cost path to point 2,2  is: " + costPath);
    }
}
