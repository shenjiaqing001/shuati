/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/30
 */
public class lc377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; ++i) {
            for (int j = 0; j < nums.length; ++j) {
                if (i + nums[j] <= target) {
                    dp[i + nums[j]] += dp[i];
                }
            }
        }
        return dp[target];
    }
}
