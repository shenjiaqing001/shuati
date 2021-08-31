package BiWeeklyContest58;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/7
 */
public class lc1959 {
    int maxValue = 200 * 1_000_000;

    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][k];
        return dfs(dp, nums, 0, k);
    }

    public int dfs(Integer[][] dp, int[] nums, int index, int k) {
        if (index == nums.length) return 0;
        if (k == -1) return maxValue;
        if (dp[index][k] != null) return dp[index][k];
        int ans = maxValue;
        int sum = 0;
        int max = 0;
        for (int i = index; i < nums.length; ++i) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
            int cost = max * (i - index + 1) - sum;
            ans = Math.min(ans, dfs(dp, nums, i + 1, k - 1) + cost);
        }
        dp[index][k] = ans;
        return ans;
    }
}
