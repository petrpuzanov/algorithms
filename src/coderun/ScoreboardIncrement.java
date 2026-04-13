package coderun;
//5
public class ScoreboardIncrement {

    public static long solve(long n, long k) {

        while (k > 0) {
            long d = n % 10;

            if (d == 0) break;

            n += d;
            k--;
        }

        return n;
    }
}