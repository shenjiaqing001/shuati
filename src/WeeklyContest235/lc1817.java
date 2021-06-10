package WeeklyContest235;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/28
 */
public class lc1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.putIfAbsent(log[0], new HashSet<>());
            map.get(log[0]).add(log[1]);
        }
        for (Integer key : map.keySet()) {
            res[map.get(key).size() - 1]++;
        }
        return res;
    }
}
