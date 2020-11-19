/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/19
 */
public class lc1230 {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[][] dp = new double[n][n + 1];
        dp[0][0] = 1 - prob[0];
        dp[0][1] = prob[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i - 1][0] * (1 - prob[i]);
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] * (1 - prob[i]) + dp[i - 1][j - 1] * prob[i];
            }
        }
        return dp[n - 1][target];
    }
}
