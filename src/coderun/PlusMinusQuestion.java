package coderun;

public class PlusMinusQuestion {
//6
    public static int solve(char[][] grid, int n, int m) {

        int[] rowSum = new int[n];
        int[] colSum = new int[m];
        int[] rowQ = new int[n];
        int[] colQ = new int[m];

        // считаем
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = grid[i][j];

                if (c == '+') {
                    rowSum[i]++;
                    colSum[j]++;
                } else if (c == '-') {
                    rowSum[i]--;
                    colSum[j]--;
                } else {
                    rowQ[i]++;
                    colQ[j]++;
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {

                int row = rowSum[r] + rowQ[r];
                int col = colSum[c] - colQ[c];

                // корректировка для (r,c)
                if (grid[r][c] == '?') {
                    row -= 2;
                }

                ans = Math.max(ans, row - col);
            }
        }

        return ans;
    }
}