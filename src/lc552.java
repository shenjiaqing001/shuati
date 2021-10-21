/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/21
 */
public class lc552 {
    // 1A 3L P

    // dp[length][late][absent]
    //     n      0 1 2   0 1
    public int checkRecord(int n) {
        long[][][] dp = new long[n + 1][3][2];
        long mod = 1_000_000_007;
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            // p
            dp[i][0][0] = dp[i - 1][0][0] + dp[i - 1][1][0] + dp[i - 1][2][0];
            dp[i][0][1] += dp[i - 1][0][0] + dp[i - 1][1][0] + dp[i - 1][2][0];
            dp[i][0][1] += dp[i - 1][0][1] + dp[i - 1][1][1] + dp[i - 1][2][1];

            dp[i][0][0] %= mod;
            dp[i][0][1] %= mod;

            dp[i][1][0] = dp[i - 1][0][0];
            dp[i][2][0] = dp[i - 1][1][0];

            dp[i][1][1] = dp[i - 1][0][1];
            dp[i][2][1] = dp[i - 1][1][1];
        }
        long res = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 2; ++j) {
                res += dp[n][i][j];
            }
        }
        res %= mod;
        return (int) res;
    }
}
