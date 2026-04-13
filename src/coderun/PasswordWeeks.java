package coderun;

import java.math.BigInteger;
//3
public class PasswordWeeks {

    public static BigInteger countWeeks(String s) {
        int n = s.length();

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        BigInteger numerator = factorial(n);

        for (int f : freq) {
            if (f > 1) {
                numerator = numerator.divide(factorial(f));
            }
        }

        return numerator;
    }

    private static BigInteger factorial(int x) {
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= x; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}