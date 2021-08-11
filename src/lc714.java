/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/10
 */
public class lc714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[] dp = new int[2];
        dp[0] = -1000000;
        for (int i = 0; i < n; ++i) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i] - fee);
        }
        return dp[1];
    }
}
