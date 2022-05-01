/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/23/22
 */
public class lc1884 {
    public int twoEggDrop(int n) {
        int k = 2;
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 1; i <= k; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (j == 1) {
                    dp[i][j] = 1;
                } else if (i == 1) {
                    dp[i][j] = j;
                } else {
                    dp[i][j] = j;
                    for (int jj = 1; jj <= j; ++jj) {
                        dp[i][j] =
                                Math.min(dp[i][j], Math.max(dp[i - 1][jj - 1], dp[i][j - jj]) + 1);
                    }
                }
            }
        }
        return dp[k][n];
    }
}
