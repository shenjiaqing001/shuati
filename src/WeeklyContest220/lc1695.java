package WeeklyContest220;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/30
 */
public class lc1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int max = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int length = nums.length;

        while (right < length) {
            while (set.contains(nums[right])) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            set.add(nums[right]);
            sum += nums[right];
            right++;

            max = Math.max(max, sum);
        }
        return max;
    }
}
