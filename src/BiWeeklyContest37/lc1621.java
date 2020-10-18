package BiWeeklyContest37;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/17
 */
public class lc1621 {
    public int numberOfSets(int n, int k) {
        long mod = 1000000007;
        if (k == 1) {
            return n * (n - 1) / 2;
        }
        long[][] dp = new long[n][k];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + (i * (i + 1)) / 2;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i && j < k; j++) {
                dp[i][j] = dp[i - 1][j] - dp[i - 2][j] + dp[i - 1][j - 1] + mod;
                dp[i][j] %= mod;
                dp[i][j] += dp[i - 1][j];
            }
        }
        return (int) (dp[n - 1][k - 1] - dp[n - 2][k - 1]);
    }
}
