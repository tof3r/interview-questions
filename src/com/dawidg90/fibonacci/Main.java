package com.dawidg90.fibonacci;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        boolean belongs = FibonacciRelated.numberBelongsToFibonacciSeq(BigInteger.valueOf(17711L));
        System.out.println("\nNumber 17711 belongs to Fibonacci series: " + belongs);
        boolean belongs1 = FibonacciRelated.numberBelongsToFibonacciSeq(BigInteger.valueOf(1456));
        System.out.println("\nNumber 1456 belongs to Fibonacci series: " + belongs1);

        BigInteger fibonacciBottomUp = FibonacciRelated.fibonacciBottomUp(10000);
        System.out.println("\nFibonacci " + 10000 + " element is: " + fibonacciBottomUp);
    }
}
