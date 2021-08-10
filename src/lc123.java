import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/29/20
 */
public class lc123 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int i = 0; i < prices.length; ++i) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) return 0;
        int n = prices.length;
        int[][] dp = new int[n + 1][4];

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j < 4; ++j) {
                dp[i][j] = -10005;
            }
        }
        for (int i = 1; i <= n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i - 1]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i - 1]);
        }

        int res = Math.max(dp[n][0], Math.max(dp[n][1], Math.max(dp[n][2], dp[n][3])));
        return Math.max(res, 0);
    }

    public int maxProfit3(int[] prices) {
        if (prices.length <= 1) return 0;
        int n = prices.length;
        int[] dp = new int[4];

        Arrays.fill(dp, -10005);

        for (int i = 0; i < n; ++i) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }

        int res = Math.max(dp[0], Math.max(dp[1], Math.max(dp[2], dp[3])));
        return Math.max(res, 0);
    }


    public static void main(String[] args) {
        lc123 t = new lc123();
        int[] nums = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(t.maxProfit(nums));
    }
}
