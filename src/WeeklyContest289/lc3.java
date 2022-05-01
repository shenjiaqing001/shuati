package WeeklyContest289;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/16/22
 */
public class lc3 {
    public int howMany2(int num) {
        int res = 0;
        while (num % 2 == 0) {
            res++;
            num /= 2;
        }
        return res;
    }

    public int howMany5(int num) {
        int res = 0;
        while (num % 5 == 0) {
            res++;
            num /= 5;
        }
        return res;
    }

    public int maxTrailingZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] preSum2h = new int[n + 1][m + 1];
        int[][] preSum5h = new int[n + 1][m + 1];
        int[][] preSum2v = new int[n + 1][m + 1];
        int[][] preSum5v = new int[n + 1][m + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int count2 = howMany2(grid[i][j]);
                int count5 = howMany5(grid[i][j]);
                preSum2h[i + 1][j + 1] = preSum2h[i + 1][j] + count2;
                preSum5h[i + 1][j + 1] = preSum5h[i + 1][j] + count5;

                preSum2v[i + 1][j + 1] = preSum2v[i][j + 1] + count2;
                preSum5v[i + 1][j + 1] = preSum5v[i][j + 1] + count5;
            }
        }
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int sum2 = preSum2h[i + 1][j] + preSum2v[i + 1][j + 1];
                int sum5 = preSum5h[i + 1][j] + preSum5v[i + 1][j + 1];
                max = Math.max(max, Math.min(sum2, sum5));
                sum2 = preSum2h[i + 1][j] + preSum2v[n][j + 1] - preSum2v[i][j + 1];
                sum5 = preSum5h[i + 1][j] + preSum5v[n][j + 1] - preSum5v[i][j + 1];
                max = Math.max(max, Math.min(sum2, sum5));
            }
            for (int j = m - 1; j >= 0; --j) {
                int sum2 = preSum2h[i + 1][m] - preSum2h[i + 1][j + 1] + preSum2v[i + 1][j + 1];
                int sum5 = preSum5h[i + 1][m] - preSum5h[i + 1][j + 1] + preSum5v[i + 1][j + 1];
                max = Math.max(max, Math.min(sum2, sum5));
                sum2 = preSum2h[i + 1][m] - preSum2h[i + 1][j + 1] + preSum2v[n][j + 1] -
                        preSum2v[i][j + 1];
                sum5 = preSum5h[i + 1][m] - preSum5h[i + 1][j + 1] + preSum5v[n][j + 1] -
                        preSum5v[i][j + 1];
                max = Math.max(max, Math.min(sum2, sum5));
            }
        }
        return max;
    }
}
