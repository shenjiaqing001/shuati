package WeeklyContest263;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/16
 */
public class lc2045 {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Map<Integer, Integer> firstTime = new HashMap<>();
    Map<Integer, Integer> secondTime = new HashMap<>();

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        firstTime.put(1, 0);
        // node, time.
        Queue<int[]> pq = new ArrayDeque<>();
        pq.add(new int[]{1, 0});
        while (true) {
            int[] now = pq.poll();
            int startTime = 0;
            int left = now[1] % (2 * change);
            if (left < change) {
                startTime = now[1] + time;
            } else {
                startTime = now[1] + (2 * change - left) + time;
            }
            for (Integer next : map.get(now[0])) {
                if (secondTime.containsKey(next)) continue;
                if (next == n && firstTime.containsKey(n)) {
                    if (startTime != firstTime.get(n)) return startTime;
                }
                if (firstTime.containsKey(next)) {
                    if (startTime != firstTime.get(next)) {
                        pq.add(new int[]{next, startTime});
                        secondTime.put(next, startTime);
                    }
                } else {
                    pq.add(new int[]{next, startTime});
                    firstTime.put(next, startTime);
                }
            }
        }
    }
}
