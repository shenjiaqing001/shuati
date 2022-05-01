package WeeklyContest284;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/12/22
 */
public class lc3 {
    public int maximumTop(int[] nums, int k) {
        if (nums.length == 1 && k % 2 == 1) return -1;
        if (k == 1) return nums[1];
        if (nums.length < k) {
            int max = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        } else if (nums.length == k) {
            int max = 0;
            for (int i = 0; i < k - 1; ++i) {
                max = Math.max(max, nums[i]);
            }
            return max;
        } else {
            int max = 0;
            for (int i = 0; i < k - 1; ++i) {
                max = Math.max(max, nums[i]);
            }
            max = Math.max(max, nums[k]);
            return max;
        }
    }
}
