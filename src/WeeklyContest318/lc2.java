package WeeklyContest318;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/5/22
 */
public class lc2 {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
            if (i >= k) {
                map.put(nums[i - k], map.get(nums[i - k]) - 1);
                sum -= nums[i - k];
                if (map.get(nums[i - k]) == 0) map.remove(nums[i - k]);
            }
            if (i >= k - 1) {
                if (map.size() == k) {
                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }
}
