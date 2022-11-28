package WeeklyContest305;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/6/22
 */
public class lc1 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (map2.containsKey(nums[i] - diff)) {
                res += map2.get(nums[i] - diff);
            }
            if (map1.containsKey(nums[i] - diff)) {
                map2.put(nums[i], map2.getOrDefault(nums[i], 0) + map1.get(nums[i] - diff));
            }
            map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }
}
