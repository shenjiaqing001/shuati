package WeeklyContest262;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class lc2035 {

    int n;

    public int minimumDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        n = nums.length / 2;
        Map<Integer, TreeSet<Integer>> map1 = getSubSet(nums, 0);
        Map<Integer, TreeSet<Integer>> map2 = getSubSet(nums, n);

        int min = 30 * 10000000;
        for (int i = 0; i <= n; ++i) {
            int last = n - i;
            for (Integer num : map1.get(i)) {
                int close = sum / 2 - num;
                TreeSet<Integer> set = map2.get(last);
                if (set.ceiling(close) != null) {
                    int total = num + set.ceiling(close);
                    min = Math.min(min, Math.abs(sum - total - total));
                }
                if (set.floor(close) != null) {
                    int total = num + set.floor(close);
                    min = Math.min(min, Math.abs(sum - total - total));
                }
            }
        }
        return min;
    }

    public Map<Integer, TreeSet<Integer>> getSubSet(int[] nums, int left) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i <= n; ++i) map.put(i, new TreeSet<>());
        for (int i = 0; i < (1 << n); ++i) {
            int count = 0;
            int sum = 0;
            for (int j = 0; j < n; ++j) {
                if (((i >> j) & 1) >= 1) {
                    count++;
                    sum += nums[j + left];
                }
            }
            map.get(count).add(sum);
        }
        return map;
    }
}
