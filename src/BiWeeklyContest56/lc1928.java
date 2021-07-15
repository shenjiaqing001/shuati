package BiWeeklyContest56;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/10
 */
public class lc1928 {

    // int[] {}  index, cost time

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int n = passingFees.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (edge[2] > maxTime) continue;
            int a = edge[0];
            int b = edge[1];
            map.putIfAbsent(a, new HashMap<>());
            map.putIfAbsent(b, new HashMap<>());
            if (map.get(a).containsKey(b)) {
                int val = map.get(a).get(b);
                map.get(a).put(b, Math.min(val, edge[2]));
                map.get(b).put(a, Math.min(val, edge[2]));
            } else {
                map.get(a).put(b, edge[2]);
                map.get(b).put(a, edge[2]);
            }
        }

        int[] minTime = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        pq.add(new int[]{0, passingFees[0], 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[2] >= minTime[now[0]]) continue;
            if (!map.containsKey(now[0])) continue;
            Map<Integer, Integer> roads = map.get(now[0]);
            minTime[now[0]] = now[2];

            for (Integer next : roads.keySet()) {
                if (now[2] + roads.get(next) > maxTime) continue;
                if (now[2] + roads.get(next) > minTime[next]) continue;
                if (next == n - 1) {
                    return now[1] + passingFees[n - 1];
                }
                pq.add(new int[]{next, now[1] + passingFees[next], now[2] + roads.get(next)});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        lc1928 test = new lc1928();
        test.minCost(99, new int[][]{{0, 1, 100}}, new int[]{2, 5});
    }
}
