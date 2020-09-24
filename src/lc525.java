import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/23
 */
public class lc525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) count++;
            else count--;
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return max;
    }
}
