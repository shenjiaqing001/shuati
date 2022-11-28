package WeeklyContest296;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/4/22
 */
public class lc2 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > last + k) {
                res++;
                last = nums[i];
            }
        }
        return res;
    }
}
