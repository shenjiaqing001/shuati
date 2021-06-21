

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/19
 */
public class lc740 {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int[] count = new int[10002];
        int[][] dp = new int[10002][2];
        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i <= 10000; ++i) {
            if (count[i] == 0) {
                dp[i][0] = dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            } else if (count[i - 1] == 0 && count[i + 1] == 0) {
                dp[i][0] = dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + i * count[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = dp[i - 1][0] + i * count[i];
            }
        }

        return Math.max(1, 1);
    }
}
