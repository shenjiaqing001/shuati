package WeeklyContest299;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/25/22
 */
public class lc3 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        for (int num : nums2) {
            sum2 += num;
        }
        int n = nums1.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            dp[i] = nums1[i] - nums2[i];
        }
        int max = Math.max(sum1, sum2);
        int tmp = 0;
        for (int num : dp) {
            if (tmp + num < 0) {
                tmp = 0;
            } else {
                tmp += num;
            }
            max = Math.max(sum2 + tmp, max);
        }
        for (int i = 0; i < n; ++i) {
            dp[i] = -dp[i];
        }
        tmp = 0;
        for (int num : dp) {
            if (tmp + num < 0) {
                tmp = 0;
            } else {
                tmp += num;
            }
            max = Math.max(sum1 + tmp, max);
        }
        return max;
    }

}
