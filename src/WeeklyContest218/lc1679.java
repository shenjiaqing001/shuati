package WeeklyContest218;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/7
 */
public class lc1679 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums.length - 1;
        int res = 0;
        while (lo < hi) {
            if (nums[lo] + nums[hi] == k) {
                res++;
                lo++;
                hi--;
            } else if (nums[lo] + nums[hi] < k) {
                lo++;
            } else {
                hi--;
            }
        }
        return res;
    }
}
