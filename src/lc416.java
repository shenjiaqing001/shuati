/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/6
 */
public class lc416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }

        if (sum % 2 == 1) return false;
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = sum; j >= 0; --j) {
                if (j >= nums[i])
                    dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum / 2];
    }
}
