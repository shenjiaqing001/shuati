/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/20/22
 */
public class lc1388 {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length / 3;
        int max = 0;
        int[][] dp = new int[slices.length][n + 1];
        for (int i = 0; i < slices.length; ++i) {
            dp[i][1] = slices[i];
            max = Math.max(max, dp[i][1]);
        }
        for (int k = 1; k < n; ++k) {
            for (int i = 0; i < slices.length - 1; ++i) {
                for (int j = i + 2; j < slices.length - 1; ++j) {
                    dp[j][k + 1] = Math.max(dp[j][k + 1], dp[i][k] + slices[j]);
                    max = Math.max(max, dp[j][k + 1]);
                }
            }
        }

        dp = new int[slices.length][n + 1];
        for (int i = 0; i < slices.length; ++i) {
            dp[i][1] = slices[i];
        }
        for (int k = 1; k < n; ++k) {
            for (int i = 1; i < slices.length; ++i) {
                for (int j = i + 2; j < slices.length; ++j) {
                    dp[j][k + 1] = Math.max(dp[j][k + 1], dp[i][k] + slices[j]);
                    max = Math.max(max, dp[j][k + 1]);
                }
            }
        }

        return max;
    }
}
