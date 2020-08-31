/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/31/20
 */
public class lc322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; ++i) {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.length; ++j) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
