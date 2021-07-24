package WeeklyContest250;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/17
 */
public class lc1937 {
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[][] dp = new long[n][m];
        for (int i = 0; i < m; ++i) dp[0][i] = points[0][i];
        for (int i = 1; i < n; ++i) {
            long tmp = 0;
            for (int j = 0; j < m; ++j) {
                if (j != 0)
                    tmp--;
                tmp = Math.max(tmp, dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], tmp + points[i][j]);
            }
            tmp = 0;
            for (int j = m - 1; j >= 0; --j) {
                if (j != m - 1)
                    tmp--;
                tmp = Math.max(tmp, dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], tmp + points[i][j]);
            }
        }

        long max = 0;
        for (int i = 0; i < m; ++i) {
            max = Math.max(max, dp[n - 1][i]);
        }
        return max;
    }

    public static void main(String[] args) {
        lc1937 test = new lc1937();
        test.maxPoints(new int[][]{{1, 2, 3}, {1, 5, 1}, {3, 1, 1}});
    }
}
