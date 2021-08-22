package WeeklyContest255;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/21
 */
public class lc1982 {
    public int[] recoverArray(int n, int[] sums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int sum : sums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        Map<Integer, Integer> oriMap = new TreeMap<>(map);
        int max = map.lastKey();
        int min = map.firstKey();
        int sum = 0;
        if (min >= 0) sum = max;
        else if (max <= 0) sum = min;
        else sum = min + max;

        int[] res = new int[n];

        for (int i = 0; i < n; ++i) {
            TreeMap<Integer, Integer> newMap = new TreeMap<>();
            int max1 = map.lastKey();
            map.put(max1, map.get(max1) - 1);
            if (map.get(max1) == 0) map.remove(max1);
            int max2 = map.lastKey();
            map.put(max2, map.get(max2) - 1);
            if (map.get(max2) == 0) map.remove(max2);

            int gap = max1 - max2;
            map.put(max1, map.getOrDefault(max1, 0) + 1);
            map.put(max2, map.getOrDefault(max2, 0) + 1);
            // System.out.println(max1 + " " + max2 + " " + gap);
            if (oriMap.containsKey(gap) && map.containsKey(gap)) {
                while (!map.isEmpty()) {
                    int max3 = map.lastKey();
                    map.put(max3, map.get(max3) - 1);
                    if (map.get(max3) == 0) map.remove(max3);
                    int max4 = max3 - gap;
                    map.put(max4, map.get(max4) - 1);
                    if (map.get(max4) == 0) map.remove(max4);
                    newMap.put(max4, newMap.getOrDefault(max4, 0) + 1);
                }
                res[i] = gap;
            } else {
                // gap = -gap;
                while (!map.isEmpty()) {
                    int max3 = map.lastKey();
                    map.put(max3, map.get(max3) - 1);
                    if (map.get(max3) == 0) map.remove(max3);
                    int max4 = max3 - gap;
                    map.put(max4, map.get(max4) - 1);
                    if (map.get(max4) == 0) map.remove(max4);
                    newMap.put(max3, newMap.getOrDefault(max3, 0) + 1);
                }
                res[i] = -gap;
            }
            map = newMap;
        }

        int[] finalRes = new int[n];
        dfs(oriMap, sum, res, 0, finalRes);
        return finalRes;
    }

    boolean dfs(Map<Integer, Integer> oriMap, int sum, int[] nums, int index, int[] res) {
        if (index == nums.length) {
            if (sum == 0) return true;
            else return false;
        }

        if (oriMap.containsKey(nums[index])) {
            res[index] = nums[index];
            if (dfs(oriMap, sum - nums[index], nums, index + 1, res)) return true;
        }
        if (oriMap.containsKey(-nums[index])) {
            res[index] = -nums[index];
            return dfs(oriMap, sum + nums[index], nums, index + 1, res);
        }
        return false;
    }
}
