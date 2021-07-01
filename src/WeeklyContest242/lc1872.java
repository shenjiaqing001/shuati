package WeeklyContest242;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/22
 */
public class lc1872 {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + stones[i - 1];
        }

        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = sum[n];

        for (int i = 3; i <= n; ++i) {
            dp[i] = Math.max(dp[i - 1], sum[n - i + 2] - dp[i - 1]);
        }
        return dp[n];
    }

}
