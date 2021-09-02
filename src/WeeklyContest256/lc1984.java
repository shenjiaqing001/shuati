package WeeklyContest256;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/28
 */
public class lc1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = 100000;
        for (int i = 0; i + k - 1 < nums.length; ++i) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }
}
