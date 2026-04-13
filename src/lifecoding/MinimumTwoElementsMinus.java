package lifecoding;

import java.util.Arrays;

public class MinimumTwoElementsMinus {
    public int minDiff(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;

        while (i < a.length && j < b.length) {
            int diff = Math.abs(a[i] - b[j]);
            min = Math.min(min, diff);

            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        return min;
    }
}
