/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2)
            return maxProfit(prices);

        long[][][] dp = new long[n][k + 1][2];
        for (int i = 0; i < n; i++)
            for (int j = k; j >= 1; j--) {
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                    continue;
                }
                dp[i][j][0] =
                        Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] =
                        Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        return (int) dp[n - 1][k][0];
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int res = 0;
        int low = prices[0];
        int high = prices[0];


        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < high) {
                res += (high - low);
                low = high = prices[i];
            } else {
                high = prices[i];
            }
        }
        res += (high - low);
        return res;
    }

}
