/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/9
 */
public class lc276 {
    public int numWays(int n, int k) {
        int[][][] dp = new int[n][k][2];
        for (int i = 0; i < k; ++i) dp[0][i][0] = 1;
        int lastSum = k;

        for (int i = 1; i < n; ++i) {
            int nowSum = 0;
            for (int j = 0; j < k; ++j) {
                dp[i][j][1] = dp[i - 1][j][0] - dp[i - 1][j][1];
                dp[i][j][0] = lastSum - dp[i - 1][j][1];
                nowSum += dp[i][j][0];
            }
            lastSum = nowSum;
        }
        return lastSum;
    }
}
