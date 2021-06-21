/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/14
 */
public class lc343 {
    public int integerBreak(int n) {
        int[] dp = new int[60];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}
