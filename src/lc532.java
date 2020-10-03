import java.security.Key;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/3
 */
public class lc532 {
    public int findPairs(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) >= 2) res++;
            } else {
                if (map.containsKey(key + k)) {
                    res += 1;
                }
            }
        }
        return res;
    }
}
