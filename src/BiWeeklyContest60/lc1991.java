package BiWeeklyContest60;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/4
 */
public class lc1991 {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] presum = new int[n + 2];
        for (int i = 1; i <= n; ++i) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        presum[n + 1] = presum[n];
        for (int i = 1; i <= n; ++i) {
            if (presum[i - 1] == presum[n + 1] - presum[i]) return i - 1;
        }
        return -1;
    }
}
