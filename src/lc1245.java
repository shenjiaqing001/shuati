import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/9
 */
public class lc1245 {
    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            map.putIfAbsent(edges[i][0], new ArrayList<>());
            map.putIfAbsent(edges[i][1], new ArrayList<>());
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        int start = edges[0][0];
        Map<Integer, Integer> tmp = new HashMap<>();
        tmp.put(start, 0);
        dfs(map, tmp, start, start);
        int max = 0;
        for (Integer num : tmp.keySet()) {
            if (max < tmp.get(num)) {
                max = tmp.get(num);
                start = num;
            }
        }
        tmp = new HashMap<>();
        tmp.put(start, 0);
        dfs(map, tmp, start, start);
        max = 0;
        for (Integer num : tmp.keySet()) {
            if (max < tmp.get(num)) {
                max = tmp.get(num);
            }
        }
        return max;
    }

    public void dfs(Map<Integer, List<Integer>> map, Map<Integer, Integer> tmp, int now, int last) {
        List<Integer> canGO = map.get(now);
        for (Integer next : canGO) {
            if (next == last) continue;
            tmp.put(next, tmp.get(now) + 1);
            dfs(map, tmp, next, now);
        }
    }
}
