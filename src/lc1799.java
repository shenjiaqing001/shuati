import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/20/22
 */
public class lc1799 {
    public int gcd(int a, int b) {
        int tmp = 1;
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public int maxScore(int[] nums) {
        //gcd , i , j
        int n = nums.length;
        int[][] dp = new int[(1 << n) + 5][n / 2 + 1];
        dfs(nums, dp, 0, 1);
        return dp[0][1];
    }

    public int dfs(int[] nums, int[][] dp, int state, int index) {
        if (index == nums.length / 2 + 1) {
            return 0;
        }
        if (dp[state][index] != 0) return dp[state][index];
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((state & (1 << i)) > 0) continue;
            for (int j = i + 1; j < nums.length; ++j) {
                if ((state & (1 << j)) > 0) continue;
                int tmpState = state + (1 << i) + (1 << j);
                max = Math.max(max,
                        dfs(nums, dp, tmpState, index + 1) + gcd(nums[i], nums[j]) * index);
            }
        }
        dp[state][index] = max;
        return max;
    }
}
