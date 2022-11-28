package WeeklyContest314;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/8/22
 */
public class lc4 {
    public int numberOfPaths(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                grid[i][j] %= k;
            }
        }
        long[][][] dp = new long[n + 1][m + 1][k];
        long mod = 1_000_000_007;
        dp[0][1][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                for (int tmp = 0; tmp < k; ++tmp) {
                    int num = tmp - grid[i - 1][j - 1];
                    if (num < 0) {
                        num += k;
                    }
                    dp[i][j][tmp] = dp[i][j - 1][num] + dp[i - 1][j][num];
                    dp[i][j][tmp] %= mod;
                }
            }
        }
        return (int) (dp[n][m][k] % mod);
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        test.numberOfPaths(new int[][]{{5, 2, 4}, {3, 0, 5}, {0, 7, 2}}, 3);
    }
}
