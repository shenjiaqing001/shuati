package WeeklyContest296;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/4/22
 */
public class lc3 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int[] op : operations) {
            int index = map.get(op[0]);
            map.remove(op[0]);
            nums[index] = op[1];
            map.put(op[1], index);
        }
        return nums;
    }
}
