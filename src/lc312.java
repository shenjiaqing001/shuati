/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/29
 */
public class lc312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        return dfs(dp, nums, 0, n - 1);
    }

    public int dfs(int[][] dp, int[] nums, int lo, int hi) {
        if (lo > hi) return 0;
        if (dp[lo][hi] != 0) return dp[lo][hi];

        int max = 0;
        for (int i = lo; i <= hi; ++i) {
            int val = dfs(dp, nums, lo, i - 1) + dfs(dp, nums, i + 1, hi);
            int left = lo - 1 < 0 ? 1 : nums[lo - 1];
            int right = hi + 1 >= nums.length ? 1 : nums[hi + 1];
            val += left * right * nums[i];
            max = Math.max(max, val);
        }
        dp[lo][hi] = max;
        return max;
    }
}
