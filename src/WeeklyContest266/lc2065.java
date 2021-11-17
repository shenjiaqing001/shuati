package WeeklyContest266;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/6
 */
public class lc2065 {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    int max = 0;
    int[] values;
    int[][] memo = new int[1001][101];
    int maxTime = 0;
    int[] dis = new int[1001];

    public void dfs(int node, int timeUsed, int value) {
        if (node == 0) max = Math.max(max, value);
        if (!map.containsKey(node)) return;
        if (maxTime - timeUsed < dis[node]) return;
        memo[node][timeUsed] = value;

        for (int neighbor : map.get(node).keySet()) {
            int t = map.get(node).get(neighbor);
            int v = values[neighbor];
            if (t + timeUsed <= maxTime) {
                if (memo[neighbor][t + timeUsed] >= value + v) continue;
                values[neighbor] = 0;
                dfs(neighbor, t + timeUsed, value + v);
                values[neighbor] = v;
            }
        }
    }

    public void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        Arrays.fill(dis, 200);
        // node time
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dis[cur[0]] <= cur[1]) continue;
            dis[cur[0]] = cur[1];
            if (map.containsKey(cur[0])) {
                for (int neighbor : map.get(cur[0]).keySet()) {
                    int t = map.get(cur[0]).get(neighbor);
                    if (t + cur[1] < dis[neighbor]) {
                        pq.add(new int[]{neighbor, t + cur[1]});
                    }
                }
            }
        }
    }

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.maxTime = maxTime;
        this.values = values;
        for (int[] edge : edges) {
            int e1 = edge[0];
            int e2 = edge[1];
            map.putIfAbsent(e1, new HashMap<>());
            map.putIfAbsent(e2, new HashMap<>());
            map.get(e1).put(e2, edge[2]);
            map.get(e2).put(e1, edge[2]);
        }
        dijkstra();
        int v = values[0];
        values[0] = 0;
        dfs(0, 0, v);
        return max;
    }
}
