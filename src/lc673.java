/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/14
 */
public class lc673 {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length, res = 0, max_len = 0;
        int[] len = new int[n], cnt = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] == len[j] + 1) cnt[i] += cnt[j];
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (max_len == len[i]) res += cnt[i];
            if (max_len < len[i]) {
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }

    public int findNumberOfLIS2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (dp[j][0] >= dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if (dp[j][0] + 1 == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    }
                }
            }
            if (dp[i][0] == 0) {
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
        }

        int max = 0;
        int count = 0;

        for (int i = 0; i < n; ++i) {
            if (dp[i][0] > max) {
                max = dp[i][0];
                count = dp[i][1];
            } else if (dp[i][0] == max) {
                count += dp[i][1];
            }
        }

        return count;
    }
}
