/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/25
 */
public class lc1473 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // m = houses.length
        // target = block
        // n = color.length

        int[][][] dp = new int[m + 1][target + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= target; j++)
                for (int k = 0; k <= n; k++)
                    dp[i][j][k] = Integer.MAX_VALUE / 2;
        for (int i = 0; i <= n; ++i) {
            dp[0][0][i] = 0;
        }

        for (int i = 1; i <= m; ++i) {
            if (houses[i - 1] == 0) {
                for (int j = 1; j <= target; ++j) {
                    for (int k = 1; k <= n; ++k) {
                        for (int kk = 1; kk <= n; ++kk) {
                            if (kk == k) {
                                dp[i][j][k] = Math.min(dp[i][j][k],
                                        dp[i - 1][j][kk] + cost[i - 1][k - 1]);
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k],
                                        dp[i - 1][j - 1][kk] + cost[i - 1][k - 1]);
                            }
                        }
                    }
                }
            } else {
                for (int j = 1; j <= target; ++j) {
                    int k = houses[i - 1];
                    for (int kk = 1; kk <= n; ++kk) {
                        if (kk == k) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][kk]);
                        } else {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - 1][kk]);
                        }
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE / 2;
        for (int k = 1; k <= n; k++)
            res = Math.min(res, dp[m][target][k]);
        if (res == Integer.MAX_VALUE / 2)
            return -1;
        else
            return res;
    }
}
