package WeeklyContest247;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/27
 */
public class lc1913 {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] * nums[n - 2]) - nums[0] * nums[1];
    }
}
