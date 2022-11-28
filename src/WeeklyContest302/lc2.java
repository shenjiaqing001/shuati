package WeeklyContest302;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/16/22
 */
public class lc2 {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int tmp = num;
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            map.putIfAbsent(sum, new ArrayList<>());

            map.get(sum).add(tmp);
        }

        int max = -1;
        for (List<Integer> value : map.values()) {
            if (value.size() >= 2) {
                value.sort(((o1, o2) -> (o2 - o1)));
                max = Math.max(max, value.get(0) + value.get(1));
            }
        }
        return max;
    }
}
