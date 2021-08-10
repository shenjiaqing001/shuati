/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/10
 */
public class lc309 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int n = prices.length;
        int[][] dp = new int[n + 1][3];

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j < 2; ++j) {
                dp[i][j] = -1005;
            }
        }

        for (int i = 0; i < n; ++i) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][2] - prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] + prices[i]);
            dp[i + 1][2] = Math.max(dp[i][2], dp[i][1]);
        }
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            max = Math.max(dp[n][i], max);
        }
        return max;
    }
}
