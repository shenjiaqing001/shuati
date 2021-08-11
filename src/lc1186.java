/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/10
 */
public class lc1186 {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = -1_000_000_000;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i - 1], arr[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i - 1], dp[i - 1][0]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }
}
