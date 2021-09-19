package BiWeeklyContest61;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/18
 */
public class lc2009 {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int k = nums.length;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (nums[left] <= nums[i] - k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, map.size());
        }
        return nums.length - max;
    }
}
