package WeeklyContest219;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/16
 */
public class lc1690 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        for (int l = 2; l <= n; l++) {
            for (int start = 0; start + l - 1 < n; start++) {
                int end = start + l - 1;
                dp[start][end] = Math.max(sum[end + 1] - sum[start + 1] - dp[start + 1][end],
                        sum[end] - sum[start] - dp[start][end - 1]);

            }
        }
        return dp[0][n - 1];
    }
}
