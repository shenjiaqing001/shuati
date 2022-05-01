package WeeklyContest289;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/16/22
 */
public class lc2 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) return -1;
            res += map.get(key) / 3;
            if (map.get(key) % 3 != 0) res++;
        }
        return res;
    }
}
