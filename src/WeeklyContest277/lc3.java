package WeeklyContest277;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/22/22
 */
public class lc3 {
    public List<Integer> findLonely(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                if (!map.containsKey(key - 1) && !map.containsKey(key + 1)) {
                    res.add(key);
                }
            }
        }
        return res;
    }
}
