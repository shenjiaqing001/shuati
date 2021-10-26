/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/26
 */
public class lc1866 {
    public int rearrangeSticks(int n, int k) {
        long[] dp = new long[k + 1];
        long mod = 1_000_000_007;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = k; j >= 1; --j) {
                dp[k] = dp[k] * (i - 1) + dp[k - 1];
                dp[k] %= mod;
            }
        }
        return (int) dp[k];
    }
}
