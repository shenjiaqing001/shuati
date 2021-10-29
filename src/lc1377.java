import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/28
 */
public class lc1377 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (edges.length == 0) return 1.0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Double> res = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        map.get(1).add(1);
        res.put(1, 1.0);
        q.add(1);
        for (int i = 0; i < t; ++i) {
            int size = q.size();
            for (int s = 0; s < size; ++s) {
                int now = q.poll();
                if (map.containsKey(now)) {
                    double p = res.get(now);
                    int pSize = map.get(now).size() - 1;
                    if (pSize == 0) continue;

                    res.put(now, 0.0);
                    for (int child : map.get(now)) {
                        if (!res.containsKey(child)) {
                            res.put(child, p / pSize);
                            q.add(child);
                        }
                    }
                }
            }
        }
        return res.containsKey(target) ? res.get(target) : 0;
    }
}
