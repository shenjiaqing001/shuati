package WeeklyContest300;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/2/22
 */
public class lc3 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[1005];
        long[] sum = new long[1005];
        long mod = 1_000_000_007;
        dp[1] = 1;
        sum[1] = 1;

        for (int i = 2; i <= n; ++i) {
            if (i >= delay + 1) {
                dp[i] = sum[i - delay];
                if (i >= forget + 1) {
                    dp[i] -= sum[i - forget];
                }
                dp[i] += mod;
                dp[i] %= mod;
            }
            sum[i] = sum[i - 1] + dp[i];
            sum[i] += mod;
            sum[i] %= mod;
        }
        return (int)( (sum[n] - sum[n - forget] + mod) % mod);
    }
}
