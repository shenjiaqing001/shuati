package WeeklyContest260;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/25
 */
public class lc2016 {
    public int maximumDifference(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] > nums[i]) {
                    max = Math.max(nums[j] - nums[i], max);
                }
            }
        }
        return max;
    }
}
