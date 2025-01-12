package com.dawidg90.fibonacci;

import java.math.BigInteger;

public class FibonacciRelated {
    public static boolean numberBelongsToFibonacciSeq(BigInteger input) {
        BigInteger firstTerm = BigInteger.ZERO;
        BigInteger secondTerm = BigInteger.ONE;
        BigInteger thirdTerm = BigInteger.ZERO;

        while (thirdTerm.intValue() < input.intValue()) {
            thirdTerm = firstTerm.add(secondTerm);
            firstTerm = secondTerm;
            secondTerm = thirdTerm;
        }

        return thirdTerm.equals(input);
    }

    public static BigInteger fibonacciBottomUp(int elementInSequence) {
        if (elementInSequence == 1 || elementInSequence == 2) {
            return BigInteger.valueOf(1);
        }
        BigInteger[] bottomUp = new BigInteger[elementInSequence + 1];
        bottomUp[1] = BigInteger.valueOf(1);
        bottomUp[2] = BigInteger.valueOf(1);
        for (int i = 3; i <= elementInSequence; i++) {
            bottomUp[i] = bottomUp[i - 1].add(bottomUp[i - 2]);
        }
        return bottomUp[elementInSequence];
    }
}
