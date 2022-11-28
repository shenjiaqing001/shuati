package WeeklyContest305;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/6/22
 */
public class lc3 {
    int n;
    boolean[] dp;

    void dfs(int[] nums, int i) {
        if (i > n) return;
        if (i != 0 && dp[i - 1]) return;
        if (i != 0)
            dp[i - 1] = true;
        if (i + 1 < n) {
            if (nums[i] == nums[i + 1]) {
                dfs(nums, i + 2);
            }
        }
        if (i + 2 < n) {
            if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
                dfs(nums, i + 3);
            }
            if (nums[i] == nums[i + 1] - 1 && nums[i + 1] == nums[i + 2] - 1) {
                dfs(nums, i + 3);
            }
        }
    }

    public boolean validPartition(int[] nums) {
        n = nums.length;
        dp = new boolean[n + 1];
        dfs(nums, 0);
        return dp[n - 1];
    }

    public static void main(String[] args) {
        lc3 test = new lc3();
        test.validPartition(new int[]{4, 4, 4, 5, 6});
    }
}
