package BiWeeklyContest50;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/17
 */
public class lc1 {
    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] <= nums[i - 1]) {
                res += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }
}
