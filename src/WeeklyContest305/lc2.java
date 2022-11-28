package WeeklyContest305;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/6/22
 */
public class lc2 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : restricted) {
            set.add(num);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited.add(0);
        res++;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : map.get(now)) {
                if (visited.contains(next)) continue;
                if (set.contains(next)) continue;
                visited.add(next);
                res++;
                q.add(next);
            }
        }
        return res;
    }
}
