package lifecoding;

import java.util.ArrayList;
import java.util.List;

class Intevals {

    public List<int[]> intersect(int[][] a, int[][] b) {
        List<int[]> res = new ArrayList<>();

        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            int start = Math.max(a[i][0], b[j][0]);
            int end = Math.min(a[i][1], b[j][1]);

            if (start <= end) {
                res.add(new int[]{start, end});
            }

            // двигаем тот интервал, который заканчивается раньше
            if (a[i][1] < b[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return res;
    }
}