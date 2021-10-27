/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/26
 */
public class lc1444 {
    long mod = 1_000_000_007;

    public int ways(String[] pizza, int k) {
        int n = pizza.length;
        int m = pizza[0].length();

        // . . A _
        // . A A _
        // . A A _
        // _ _ _ _


        long[][] preSum = new long[n + 1][m + 1];
        for (int i = n - 1; i >= 0; --i) {
            char[] c = pizza[i].toCharArray();
            for (int j = m - 1; j >= 0; --j) {
                preSum[i][j] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i + 1][j + 1];
                if (c[j] == 'A') {
                    preSum[i][j]++;
                }
            }
        }

        long[][][] dp = new long[n + 1][m + 1][k];

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                for (int t = 0; t < k; ++t) {
                    dp[i][j][t] = -1;
                }
            }
        }

        return (int) dfs(dp, preSum, 0, 0, k - 1);

    }

    public long dfs(long[][][] dp, long[][] preSum, int x, int y, int k) {
        if (k == 0 && preSum[x][y] >= 1) return 1;
        if (dp[x][y][k] != -1) return dp[x][y][k];
        if (preSum[x][y] == 0) return 0;

        long sum = 0;
        for (int i = x + 1; i < dp.length - 1; ++i) {
            if (preSum[x][y] > preSum[i][y]) {
                sum += dfs(dp, preSum, i, y, k - 1);
                sum %= mod;
            }
        }
        for (int j = y + 1; j < dp[0].length - 1; ++j) {
            if (preSum[x][y] > preSum[x][j]) {
                sum += dfs(dp, preSum, x, j, k - 1);
                sum %= mod;
            }
        }
        dp[x][y][k] = sum;
        return sum;
    }

}
