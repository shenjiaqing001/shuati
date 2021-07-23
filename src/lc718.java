/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/8
 */
public class lc718 {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        int max = 0;
        for (int i = 1; i <= n1; ++i) {
            for (int j = 1; j <= n2; ++j) {
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
