package WeeklyContest284;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/12/22
 */
public class lc4 {
    public void dijkstra(int src, Map<Integer, Map<Integer, Integer>> map,
                         Map<Integer, Long> res) {
        // now, dis
        PriorityQueue<long[]> pq = new PriorityQueue<>((Comparator.comparingLong(o -> o[1])));
        pq.add(new long[]{(long) src, 0L});
        while (!pq.isEmpty()) {
            long[] now = pq.poll();
            if (res.containsKey((int) now[0])) continue;
            res.put((int) now[0], now[1]);
            if (!map.containsKey((int) now[0])) continue;
            Map<Integer, Integer> tmp = map.get((int) now[0]);
            for (int next : tmp.keySet()) {
                if (res.containsKey(next)) continue;
                pq.add(new long[]{(long) next, now[1] + tmp.get(next)});
            }
        }
    }

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> rMap = new HashMap<>();

        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashMap<>());
            rMap.putIfAbsent(edge[1], new HashMap<>());
            map.get(edge[0]).put(edge[1],
                    Math.min(edge[2], map.get(edge[0]).getOrDefault(edge[1], 100000)));
            rMap.get(edge[1]).put(edge[0],
                    Math.min(edge[2], rMap.get(edge[1]).getOrDefault(edge[0], 100000)));
        }
        Map<Integer, Long> distance1 = new HashMap<>();
        Map<Integer, Long> distance2 = new HashMap<>();
        Map<Integer, Long> distance3 = new HashMap<>();
        dijkstra(src1, map, distance1);
        dijkstra(src2, map, distance2);
        dijkstra(dest, rMap, distance3);

        long res = Long.MAX_VALUE;
        if (!distance1.containsKey(dest)) return -1;
        if (!distance2.containsKey(dest)) return -1;
        for (int i = 0; i < n; ++i) {
            if (distance1.containsKey(i) && distance2.containsKey(i) && distance3.containsKey(i))
                res = Math.min(res, distance1.get(i) + distance2.get(i) + distance3.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        int[][] esges =
                new int[][]{{0, 2, 2}, {0, 5, 6}, {1, 0, 3}, {1, 4, 5}, {2, 1, 1}, {2, 3, 3}, {2, 3, 4}, {3, 4, 2}, {4, 5, 1}};
        test.minimumWeight(6, esges, 0, 1, 5);

    }

}
