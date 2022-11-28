package WeeklyContest304;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/30/22
 */
public class lc4 {

    public int longestCycle(int[] edges) {
        Set<Integer> set = new HashSet<>();
        int n = edges.length;
        int max = -1;
        for (int i = 0; i < n; ++i) {
            if (set.contains(i)) continue;
            Map<Integer, Integer> map = new HashMap<>();
            int step = 0;
            int index = i;
            while (true) {
                if (index == -1) break;
                if (map.containsKey(index)) {
                    max = Math.max(max, step - map.get(index));
                }
                if (set.contains(index)) break;
                set.add(index);
                map.put(index, step);
                index = edges[index];
                step++;
            }
        }
        return max;
    }
}
