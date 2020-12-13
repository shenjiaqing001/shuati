package BiWeeklyContest41;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/13
 */
public class lc1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 1; i < n; ++i) {
            res[0] += nums[i] - nums[0];
        }
        for (int i = 1; i < n; ++i) {
            res[i] = res[i - 1] + (nums[i] - nums[i - 1]) * (2 * i - n);
        }
        return res;
    }
}
