package WeeklyContest299;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/25/22
 */
public class lc2 {
    // 1 : 2 ..2
    // 2 : __, 1_, _1..3
    // 3 : ___, 1__, _1_, __1, 1_1 .. 5
    // 4 : ____, 1___ * 4, 1__1, 1_1_, _1_1..8
    // 5 :
    public int countHousePlacements(int n) {
        long[] dp = new long[n + 1];
        long mod = 1_000_000_007;
        dp[0] = 2;
        dp[1] = 3;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= mod;
        }
        long sum = 0;
        for (int i = 0; i <= n; ++i) {
            sum += dp[i];
            sum %= mod;
        }
        return (int) (dp[n] * dp[n] % mod);
    }
}
