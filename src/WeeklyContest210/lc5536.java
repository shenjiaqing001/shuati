package WeeklyContest210;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/11
 */
public class lc5536 {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < roads.length; ++i) {
            int a = roads[i][0];
            int b = roads[i][1];
            map.putIfAbsent(a, new HashSet<>());
            map.putIfAbsent(b, new HashSet<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int res = 0;
                if (map.containsKey(i)) res += map.get(i).size();
                if (map.containsKey(j)) res += map.get(j).size();
                if (map.containsKey(i) && map.get(i).contains(j)) res--;
                max = Math.max(res, max);
            }
        }
        return max;
    }
}
