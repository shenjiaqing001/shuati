package WeeklyContest260;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/25
 */
public class lc2017 {
    public long gridGame(int[][] grid) {
        if (grid[0].length == 1) return 0;
        int n = grid[0].length;
        long[] sumTop = new long[n];
        long[] sumBot = new long[n];
        sumTop[n - 1] = grid[0][n - 1];
        for (int i = n - 2; i >= 0; --i) {
            sumTop[i] = sumTop[i + 1] + grid[0][i];
        }

        sumBot[0] = grid[1][0];
        for (int i = 1; i < n; ++i) {
            sumBot[i] = sumBot[i - 1] + grid[1][i];
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if (i == 0) min = Math.min(min, sumTop[1]);
            else if (i == n - 1) min = Math.min(min, sumBot[n - 2]);
            else min = Math.min(min, Math.max(sumBot[i - 1], sumTop[i + 1]));
        }
        return min;
    }
}
