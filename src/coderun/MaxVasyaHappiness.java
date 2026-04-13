package coderun;
//1
public class MaxVasyaHappiness {

    public static long maxHappiness(int[] a) {
        int n = a.length;

        long base = 0;

        int minPlus = Integer.MAX_VALUE;
        int maxMinus = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // i -> 0-based, значит:
            // i % 2 == 0 => позиция 1,3,5... (плюс)
            if (i % 2 == 0) {
                base += a[i];
                minPlus = Math.min(minPlus, a[i]);
            } else {
                base -= a[i];
                maxMinus = Math.max(maxMinus, a[i]);
            }
        }

        long delta = 2L * (maxMinus - minPlus);

        return Math.max(base, base + delta);
    }
}