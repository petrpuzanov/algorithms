package coderun;

public class FiveInRow {
//7
    public static String solve(char[][] grid, int n, int m) {

        int[][] dirs = {
                {0, 1},   // →
                {1, 0},   // ↓
                {1, 1},   // ↘
                {1, -1}   // ↙
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                char c = grid[i][j];
                if (c == '.') continue;

                for (int[] d : dirs) {

                    int cnt = 0;

                    for (int k = 0; k < 5; k++) {
                        int ni = i + d[0] * k;
                        int nj = j + d[1] * k;

                        if (ni < 0 || ni >= n || nj < 0 || nj >= m) break;
                        if (grid[ni][nj] != c) break;

                        cnt++;
                    }

                    if (cnt == 5) {
                        return "Yes";
                    }
                }
            }
        }

        return "No";
    }
}