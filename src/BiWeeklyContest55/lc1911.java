package BiWeeklyContest55;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/26
 */
public class lc1911 {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][3];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + nums[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - nums[i]);
        }
        return dp[n - 1][1];
    }
}
