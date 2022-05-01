/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/5/22
 */
public class lc1420 {
    // n = 50, m = 100, k <= n

    // 50 * 100 * 50
    public int numOfArrays(int n, int m, int k) {
        if (k > m) return -1;

        long[][][] dp = new long[n + 1][m + 1][k + 1];
        for (int i = 1; i <= m; ++i) {
            dp[1][i][1] = 1;
        }
        long mod = 1_000_000_007;

        for (int a = 1; a < n; ++a) {
            for (int b = 1; b <= m; ++b) {
                for (int c = 1; c <= k; ++c) {
                    dp[a][b][c] += b * dp[a - 1][b][c];
                    for (int i = 1; i < b; ++i) dp[a][b][c] += dp[a - 1][i][c - 1];
                    dp[a][b][c] %= mod;
                }
            }
        }
        long sum = 0;
        for (int i = 1; i <= m; ++i) {
            sum += dp[n][i][k];
            sum %= mod;
        }
        return (int) sum;
    }
}
