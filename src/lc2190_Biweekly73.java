import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/16/22
 */
public class lc2190_Biweekly73 {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == key) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        int max = 0;
        int res = -1;
        for (int num : map.keySet()) {
            if (map.get(num) > max) {
                res = num;
                max = map.get(num);
            }
        }
        return res;
    }
}
